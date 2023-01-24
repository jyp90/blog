package jypark.blog.dto;

import jypark.blog.entities.Documents;
import jypark.blog.entities.enumerates.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentInsertRequest {

    private String title;
    private CategoryType category;
    private String content;
    private String author;
    private String password;

    public Documents toEntity() {
        Documents doc = Documents.builder()
            .author(author)
            .title(title)
            .content(content)
            .categoryType(category)
            .build();
        return doc;
    }
}
