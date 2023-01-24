package jypark.blog.entities;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import jypark.blog.entities.enumerates.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documents_id")
    private Long id;

    private String author;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private int likeCount;
    private int viewCount;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comments> comments;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
