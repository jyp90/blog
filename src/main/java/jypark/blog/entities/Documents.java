package jypark.blog.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documents_id")
    private Long id;

    private String title;
    private String content;
    private int likeCount;
    private int viewCount;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comments> comments;
}
