package jypark.blog.pages;

import jypark.blog.dto.DocumentInsertRequest;
import jypark.blog.entities.Documents;
import jypark.blog.services.PageCUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pages")
public class PagesMVController {

    private final PageCUDService pageCUDService;

    @PostMapping
    public ModelAndView save(@ModelAttribute DocumentInsertRequest request) {
        final Documents result = pageCUDService.insert(request);
        return new ModelAndView("details/success");
    }
}
