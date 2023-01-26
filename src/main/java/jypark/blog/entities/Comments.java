package jypark.blog.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@NoArgsConstructor
@SQLDelete(sql = "UPDATE comments SET deleted_at IS NOW() WHERE comments_id = ?")
@Where(clause = "deleted_at is null")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comments_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "documents_id")
    private Documents documents;

    private String author;

    private String comment;

    private int depth;

    private Long parentId;

    private LocalDateTime deletedAt;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
