package jypark.blog.dto;

import static jypark.blog.utils.BlogVariables.AUTHOR_DEFAULT;
import static jypark.blog.utils.StringUtils.isBlankOrElse;

import jypark.blog.entities.Documents;
import jypark.blog.entities.enumerates.CategoryType;
import jypark.blog.utils.DOMParseUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jsoup.nodes.Document;

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
            .author(isBlankOrElse(author, AUTHOR_DEFAULT))
            .title(title)
            .content(DocumentContentBuilder.of(content))
            .categoryType(category)
            .build();
        return doc;
    }

    public static class DocumentContentBuilder {
        private String className = "tt_article_useless_p_margin contents_style";
        public String build;
        public DocumentContentBuilder(String content) {
            final Document document = DOMParseUtils.of(content);

            this.build = content;
        }

        public static String of(String content) {
            return new DocumentContentBuilder(content).build;
        }

    }
}
