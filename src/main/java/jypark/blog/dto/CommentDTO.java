package jypark.blog.dto;

import java.util.List;
import java.util.stream.Collectors;
import jypark.blog.entities.Comments;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDTO {

    private String comment;
    private String author;

    public CommentDTO(Comments comments) {
        this.comment = comments.getComment();
        this.author = comments.getAuthor();
    }

    public static List<CommentDTO> of(List<Comments> list) {
        return list.stream().map(o -> new CommentDTO(o)).collect(Collectors.toList());
    }
}
