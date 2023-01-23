package jypark.blog.dto;

import java.util.List;
import jypark.blog.entities.Documents;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageListDTO {


    private Long pageId;
    private String title;
    private String content;

    private int likeCount;
    private int viewCount;
    private int commentCount;

    public PageListDTO(Documents doc) {
        this.pageId = doc.getId();
        this.title = doc.getTitle();
        this.content = doc.getContent() == null ? ""
            : doc.getContent().length() > 100 ? doc.getContent().substring(0, 100) + "..."
                : doc.getContent();
        this.likeCount = doc.getLikeCount();
        this.viewCount = doc.getViewCount();
        this.commentCount = doc.getComments().size();
    }

    @Data
    @NoArgsConstructor
    public static class PageListWrapperDTO {
        private List<PageListDTO> list;
        private int totalCount;

        public PageListWrapperDTO(List<Documents> documents, int totalCount) {
            this.list = documents.stream().map(doc -> new PageListDTO(doc)).toList();
            this.totalCount = totalCount;
        }

        public static PageListWrapperDTO of(Page<Documents> documents) {
            PageListWrapperDTO dto = new PageListWrapperDTO(documents.getContent(), documents.getTotalPages());
            return dto;
        }
    }
}
