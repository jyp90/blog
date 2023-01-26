package jypark.blog.dto;

import static jypark.blog.utils.DecimalFormatUtils.toDecimalFormat;

import jypark.blog.entities.Projects;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectPayload {

    private String total;
    private String today;
    private String yesterday;

    public ProjectPayload(long total, long today, long yesterday) {
        this.total = toDecimalFormat(total);
        this.today = toDecimalFormat(today);
        this.yesterday = toDecimalFormat(yesterday);
    }

    public static ProjectPayload of(Projects project) {
        return new ProjectPayload(project.getTotalViewCount(), project.getTodayViewCount(), project.getYesterdayViewCount());
    }
}
