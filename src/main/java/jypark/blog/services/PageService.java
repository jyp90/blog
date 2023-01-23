package jypark.blog.services;

import java.util.Optional;
import jypark.blog.dto.PageDetailDTO;
import jypark.blog.dto.PageListDTO.PageListWrapperDTO;
import jypark.blog.entities.Documents;
import jypark.blog.repositories.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageService {

    private final PageRepository pageRepository;

    public PageDetailDTO getPageById(Long pageId) {
        final Optional<Documents> optionalDocuments = pageRepository.findById(pageId);
        return PageDetailDTO.of(optionalDocuments);
    }

    public PageListWrapperDTO getPages(Pageable pageable) {
        final Page<Documents> documents = pageRepository.findAll(pageable);
        return PageListWrapperDTO.of(documents);
    }
}
