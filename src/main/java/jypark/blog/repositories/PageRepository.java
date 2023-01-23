package jypark.blog.repositories;

import jypark.blog.entities.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<Documents, Long> {

}
