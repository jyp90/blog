package jypark.blog.pages;

import static jypark.blog.BlogVariables.TITLE;

import jypark.blog.services.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pages")
public class PagesController {

    private final PageService pageService;

    @GetMapping("/{pageId}")
    public ModelAndView getPages(@PathVariable Long pageId) {
        final ModelAndView mv = new ModelAndView("/page");
        mv.addObject("title", TITLE);
        mv.addObject("detail", pageService.getPageById(pageId));
        return mv;
    }

}
