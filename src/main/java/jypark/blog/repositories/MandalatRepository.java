package jypark.blog.repositories;

import java.util.List;
import jypark.blog.entities.Mandalat;
import org.springframework.data.repository.CrudRepository;

public interface MandalatRepository extends CrudRepository<Mandalat, Long> {

    List<Mandalat> findByUserId(long userId);
}
