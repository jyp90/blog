package jypark.blog.services;

import java.util.List;
import jypark.blog.dto.MandalatWrapper;
import jypark.blog.entities.Mandalat;
import jypark.blog.repositories.MandalatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MandalatService {

    private final MandalatRepository mandalatRepository;

    public MandalatWrapper getManadalt(Long userId) {
        List<Mandalat> entities = mandalatRepository.findByUserId(userId);
        return MandalatWrapper.of(entities);
    }

    public void saveMandalat(List<String> list) {

    }

}
