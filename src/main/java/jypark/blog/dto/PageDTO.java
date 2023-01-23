package jypark.blog.dto;

import java.util.List;
import java.util.Optional;
import jypark.blog.entities.Documents;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDTO {

    private Long pageId;
    private String title;
    private String content;

    private int likeCount;
    private int viewCount;
    private List<CommentDTO> comments;


    public static PageDTO of(Optional<Documents> optionalDocuments) {
        if(optionalDocuments.isEmpty()) {
            return null;
        }

        Documents doc = optionalDocuments.get();
        PageDTO dto = PageDTO.builder()
            .pageId(doc.getId())
            .title(doc.getTitle())
            .content(doc.getContent())
            .likeCount(doc.getLikeCount())
            .viewCount(doc.getViewCount())
            .comments(CommentDTO.of(doc.getComments()))
            .build();
        return dto;
    }

}
