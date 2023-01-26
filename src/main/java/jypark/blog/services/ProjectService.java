package jypark.blog.services;

import java.time.LocalDate;
import java.util.Optional;
import javax.transaction.Transactional;
import jypark.blog.dto.ProjectPayload;
import jypark.blog.entities.Projects;
import jypark.blog.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    protected Projects init() {
        Optional<Projects> optionalProjects = projectRepository.findByToday(LocalDate.now());
        if(optionalProjects.isEmpty()) {
            final Optional<Projects> yesterday = projectRepository.findByToday(LocalDate.now().minusDays(1L));
            long yesterdayCount = 0;
            long totalCount = 0;
            if(yesterday.isPresent()) {
                yesterdayCount = yesterday.get().getTodayViewCount();
                totalCount = yesterday.get().getTotalViewCount();
            }
            Projects todayProject = Projects.of(yesterdayCount, totalCount);
            return projectRepository.save(todayProject);
        }
        return optionalProjects.get();
    }

    public ProjectPayload getPayloadByCondition(int page) {
        return page == 0 ? incrementAndGet() : get();
    }

    @Transactional
    public ProjectPayload incrementAndGet() {
        Projects today = init();
        today.increaseViewCount();
        return ProjectPayload.of(today);
    }

    public ProjectPayload get() {
        Projects today = init();
        return ProjectPayload.of(today);
    }
}
