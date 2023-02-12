package jypark.blog.pages;

import jypark.blog.dto.DocumentInsertRequest;
import jypark.blog.entities.Documents;
import jypark.blog.services.MandalatService;
import jypark.blog.services.PageCUDService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pages")
public class PagesMVController {

    private final PageCUDService pageCUDService;
    private final MandalatService mandalatService;

    @PostMapping
    public ModelAndView save(@ModelAttribute DocumentInsertRequest request) {
        final Documents result = pageCUDService.insert(request);
        return new ModelAndView("details/success");
    }

    @GetMapping("/mandalat")
    public ModelAndView getMandalatView() {
        final ModelAndView modelAndView = new ModelAndView("details/mandalat");
        modelAndView.addObject("detail", mandalatService.getManadalt(1l));
        return modelAndView;
    }
}
