package jypark.blog.repositories;

import javax.transaction.Transactional;
import jypark.blog.entities.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Documents, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Documents d SET d.viewCount = d.viewCount + 1 WHERE d.id = :id")
    int addViewCount(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Documents d SET d.likeCount = d.likeCount + 1 WHERE d.id = :id")
    int addLikeCount(@Param("id") Long id);
}
