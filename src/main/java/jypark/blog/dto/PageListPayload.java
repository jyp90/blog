package jypark.blog.dto;

import static jypark.blog.utils.DateFormatterUtils.toCreatedAt;

import java.util.List;
import jypark.blog.entities.Documents;
import jypark.blog.entities.enumerates.CategoryType;
import jypark.blog.utils.PageUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageListPayload {

    private String detail;

    private String author;
    private String title;
    private String description;

    private String thumbnail;

    private String category;

    private int likeCount;
    private int viewCount;
    private int commentCount;
    private String created;

    public PageListPayload(Documents doc) {
        this.detail = "/" + doc.getId();
        this.author = doc.getAuthor();
        this.title = doc.getTitle();
        this.thumbnail = doc.getThumbnail();
        this.description = doc.getDescription();
        this.category = doc.getCategoryType() == null ? CategoryType.ifNullThen() : doc.getCategoryType().getView();
        this.likeCount = doc.getLikeCount();
        this.viewCount = doc.getViewCount();
        this.commentCount = doc.getComments().size();
        this.created = toCreatedAt(doc.getCreatedAt());
    }

    @Data
    @NoArgsConstructor
    public static class PageListWrapperDTO {
        private List<PageListPayload> list;
        private long totalCount;

        private int currentPage;

        private long pageTotalSize;

        private List<Long> pageNumbers;

        public PageListWrapperDTO(List<Documents> documents, long totalCount, int currentPage, int pageSize) {
            this.list = documents.stream().map(PageListPayload::new).toList();
            this.totalCount = totalCount;
            this.currentPage = currentPage;
            this.pageTotalSize = PageUtils.getPageTotalSize(totalCount);
            this.pageNumbers = PageUtils.getPageNumbers(currentPage, totalCount);
        }

        public static PageListWrapperDTO of(Page<Documents> documents, Pageable pageable) {
            PageListWrapperDTO dto = new PageListWrapperDTO(documents.getContent(), documents.getTotalElements(), pageable.getPageNumber(), pageable.getPageSize());
            return dto;
        }

        public static PageListWrapperDTO of(Page<Documents> documents, int currentPage, int pageSize) {
            PageListWrapperDTO dto = new PageListWrapperDTO(documents.getContent(), documents.getTotalElements(), currentPage, pageSize);
            return dto;
        }
    }
}
