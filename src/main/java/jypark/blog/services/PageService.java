package jypark.blog.services;

import java.util.Optional;
import jypark.blog.dto.PageDetailPayload;
import jypark.blog.dto.PageListPayload.PageListWrapperDTO;
import jypark.blog.dto.RecentPagePayload.RecentPageListPayload;
import jypark.blog.entities.Documents;
import jypark.blog.repositories.PageRepository;
import jypark.blog.utils.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PageService {

    private final PageRepository pageRepository;
    private final PageCUDService pageCUDService;


    public PageDetailPayload getPageById(Long pageId) {
        final Optional<Documents> optionalDocuments = pageRepository.findById(pageId);
        final PageDetailPayload response = PageDetailPayload.of(optionalDocuments);
        if(response.isNotEmpty()) {
            pageCUDService.addViewCount(pageId);
        }
        return response;
    }

    public PageListWrapperDTO getPages(int page) {
        int pageSize = PageUtils.DEFAULT_PAGE_SIZE;
        final Page<Documents> documents = pageRepository.findAll(
            PageUtils.pageOf(page - 1, pageSize));
        int currentPage = page == 0 ? 1 : page;
        return PageListWrapperDTO.of(documents, currentPage, pageSize);
    }

    public RecentPageListPayload getDetailRecentPagesExceptId(Long pageId) {
        Pageable pageable = PageUtils.getRecentPageable();
        final Page<Documents> recentPages = pageRepository.findAll(pageable);
        return RecentPageListPayload.of(recentPages, pageId);
    }

    public RecentPageListPayload getListRecentPages() {
        Pageable pageable = PageUtils.getRecentPageable();
        final Page<Documents> recentPages = pageRepository.findAll(pageable);
        return RecentPageListPayload.of(recentPages, 0L);
    }
}
