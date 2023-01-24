package jypark.blog.dto;

import static jypark.blog.utils.StringUtils.abbreviate;

import java.util.List;
import jypark.blog.entities.Documents;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@NoArgsConstructor
public class RecentPagePayload {

    private String href;
    private String title;

    public RecentPagePayload(Documents doc) {
        this.href = "/" + doc.getId();
        this.title = abbreviate(doc.getTitle());
    }

    @AllArgsConstructor
    public static class RecentPageListPayload {
        public List<RecentPagePayload> list;

        public static RecentPageListPayload of(Page<Documents> recentPages, Long thisPageId) {
            final List<RecentPagePayload> list = recentPages.getContent()
                .stream()
                .filter(doc -> doc.getId().longValue() != thisPageId.longValue())
                .map(doc -> new RecentPagePayload(doc))
                .toList();
            return new RecentPageListPayload(list);
        }
    }
}
