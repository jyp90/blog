package jypark.blog.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projects_id")
    private Long id;

    @Setter
    private long totalViewCount;

    @Setter
    private long todayViewCount;

    private long yesterdayViewCount;

    @CreatedDate
    private LocalDate today;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public static Projects of(long yesterdayCount, long totalCount) {
        return Projects.builder()
            .today(LocalDate.now())
            .totalViewCount(totalCount)
            .yesterdayViewCount(yesterdayCount)
            .build();
    }

    public void increaseViewCount() {
        this.todayViewCount += 1;
        this.totalViewCount += 1;
    }
}
