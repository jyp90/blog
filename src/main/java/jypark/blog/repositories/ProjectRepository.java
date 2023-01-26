package jypark.blog.repositories;

import java.time.LocalDate;
import java.util.Optional;
import jypark.blog.entities.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, Long> {

    Optional<Projects> findByToday(@Param("today") LocalDate today);
}
