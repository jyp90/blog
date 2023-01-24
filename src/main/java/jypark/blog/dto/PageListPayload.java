package jypark.blog.dto;

import java.util.List;
import jypark.blog.entities.Documents;
import jypark.blog.utils.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageListPayload {

    private String detail;

    private String author;
    private String title;
    private String content;

    private int likeCount;
    private int viewCount;
    private int commentCount;

    public PageListPayload(Documents doc) {
        this.detail = "/" + doc.getId();
        this.author = doc.getAuthor();
        this.title = doc.getTitle();
        this.content = StringUtils.summarize(doc.getContent());
        this.likeCount = doc.getLikeCount();
        this.viewCount = doc.getViewCount();
        this.commentCount = doc.getComments().size();
    }

    @Data
    @NoArgsConstructor
    public static class PageListWrapperDTO {
        private List<PageListPayload> list;
        private int totalCount;

        public PageListWrapperDTO(List<Documents> documents, int totalCount) {
            this.list = documents.stream().map(doc -> new PageListPayload(doc)).toList();
            this.totalCount = totalCount;
        }

        public static PageListWrapperDTO of(Page<Documents> documents) {
            PageListWrapperDTO dto = new PageListWrapperDTO(documents.getContent(), documents.getTotalPages());
            return dto;
        }
    }
}
