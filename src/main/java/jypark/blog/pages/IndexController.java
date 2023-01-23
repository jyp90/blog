package jypark.blog.pages;

import static jypark.blog.BlogVariables.*;

import jypark.blog.dto.PageListDTO.PageListWrapperDTO;
import jypark.blog.services.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class IndexController {

    private final PageService pageService;

    @GetMapping({"/", "/list", "/index"})
    public ModelAndView getMainList(Pageable pageable) {
        final ModelAndView mv = new ModelAndView("/list");
        final PageListWrapperDTO wrapper = pageService.getPages(pageable);
        mv.addObject("wrapper", wrapper);
        mv.addObject("title", TITLE);
        mv.addObject("rss", RSS_URL);
        return mv;
    }

    @GetMapping("/{pageId}")
    public ModelAndView getPages(@PathVariable Long pageId) {
        final ModelAndView mv = new ModelAndView("/page2");
        mv.addObject("title", TITLE);
        mv.addObject("detail", pageService.getPageById(pageId));
        return mv;
    }

    @GetMapping("/template")
    public ModelAndView getTemplates()  {
        return new ModelAndView("/template");
    }
}
