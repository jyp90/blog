package jypark.blog.controllers.documents;

import jypark.blog.controllers.common.ApiPayload;
import jypark.blog.dto.DocumentInsertRequest;
import jypark.blog.entities.Documents;
import jypark.blog.services.PageCUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pages")
@RequiredArgsConstructor
public class PageRestController {

    private final PageCUDService pageCUDService;

    @PostMapping
    public ApiPayload<Documents> post(@ModelAttribute DocumentInsertRequest request) {
        return pageCUDService.insert(request);
    }
}
