package jypark.blog.services;

import java.util.Optional;
import jypark.blog.dto.PageDetailPayload;
import jypark.blog.dto.PageListPayload.PageListWrapperDTO;
import jypark.blog.dto.RecentPagePayload.RecentPageListPayload;
import jypark.blog.entities.Documents;
import jypark.blog.repositories.PageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageService {

    private final PageRepository pageRepository;
    private final PageCUDService pageCUDService;


    public PageDetailPayload getPageById(Long pageId) {
        final Optional<Documents> optionalDocuments = pageRepository.findById(pageId);
        pageCUDService.addViewCount(pageId);
        return PageDetailPayload.of(optionalDocuments);
    }

    public PageListWrapperDTO getPages(Pageable pageable) {
        final Page<Documents> documents = pageRepository.findAll(pageable);
        return PageListWrapperDTO.of(documents);
    }

    public RecentPageListPayload getRecentPages(Long pageId) {
        Pageable pageable = PageRequest.of(0, 5, Direction.DESC, "createdAt");
        final Page<Documents> recentPages = pageRepository.findAll(pageable);
        return RecentPageListPayload.of(recentPages, pageId);
    }
}
