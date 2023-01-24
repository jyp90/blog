package jypark.blog.dto;

import java.util.List;
import java.util.stream.Collectors;
import jypark.blog.entities.Comments;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyPayload {

    private String comment;
    private String author;

    public ReplyPayload(Comments comments) {
        this.comment = comments.getComment();
        this.author = comments.getAuthor();
    }

    public static List<ReplyPayload> of(List<Comments> list) {
        return list.stream().map(o -> new ReplyPayload(o)).collect(Collectors.toList());
    }
}
