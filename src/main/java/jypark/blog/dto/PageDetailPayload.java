package jypark.blog.dto;

import static jypark.blog.utils.DateFormatterUtils.toCreatedAt;

import java.util.List;
import java.util.Optional;
import jypark.blog.entities.Documents;
import jypark.blog.entities.enumerates.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDetailPayload {

    private String pageUrl;
    private String author;
    private String title;
    private String content;
    private String category;

    private int likeCount;
    private int viewCount;
    private List<ReplyPayload> comments;

    private List<RecentPagePayload> recentPagePayloads;

    private String createdAt;


    public static PageDetailPayload of(Optional<Documents> optionalDocuments) {
        if(optionalDocuments.isEmpty()) {
            return null;
        }

        Documents doc = optionalDocuments.get();
        PageDetailPayload dto = PageDetailPayload.builder()
            .pageUrl("/" + doc.getId())
            .author(doc.getAuthor())
            .title(doc.getTitle())
            .content(doc.getContent())
            .category(doc.getCategoryType() == null ? CategoryType.ifNullThen() : doc.getCategoryType().getView())
            .likeCount(doc.getLikeCount())
            .viewCount(doc.getViewCount())
            .comments(ReplyPayload.of(doc.getComments()))
            .createdAt(toCreatedAt(doc.getCreatedAt()))
            .build();
        return dto;
    }

}
