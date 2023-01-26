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
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE documents SET deleted_at IS NOW() WHERE documents_id = ?")
@Where(clause = "deleted_at is null")
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

    private String description;
    private int likeCount;
    private int viewCount;

    private String thumbnail;

    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comments> comments;

    private LocalDateTime publishAt;

    private LocalDateTime deletedAt;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
