package jypark.blog.pages;

import static jypark.blog.utils.BlogVariables.*;
import static jypark.blog.utils.StringUtils.isFavicon;

import jypark.blog.dto.PageListPayload.PageListWrapperDTO;
import jypark.blog.exceptions.PageNotFoundException;
import jypark.blog.services.CategoryService;
import jypark.blog.services.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainMVController {

    @Value("${insert.key}")
    private String insertKey;

    private final PageService pageService;

    private final CategoryService categoryService;

    @GetMapping({"/", "/list", "/index"})
    public ModelAndView getMainList(Pageable pageable) {
        final ModelAndView mv = new ModelAndView("list");
        final PageListWrapperDTO wrapper = pageService.getPages(pageable);
        mv.addObject("wrapper", wrapper);
        mv.addObject("title", TITLE);
        mv.addObject("rss", RSS_URL);
        return mv;
    }

    @GetMapping("/{pageIdStr}")
    public ModelAndView getPages(@PathVariable String pageIdStr) {
        if(isFavicon(pageIdStr)) {
            return null;
        }
        Long pageId = Long.parseLong(pageIdStr);
        final ModelAndView mv = new ModelAndView("details/page2");
        mv.addObject("title", TITLE);
        mv.addObject("detail", pageService.getPageById(pageId));
        mv.addObject("recents", pageService.getRecentPages(pageId));
        return mv;
    }

    @GetMapping("/template")
    public ModelAndView getTemplates()  {
        return new ModelAndView("details/template");
    }

    @GetMapping("/insert/{key}")
    public ModelAndView insertPages(@PathVariable String key)  {
        if(key.equals(insertKey)) {
            final ModelAndView mv = new ModelAndView("details/insert");
            mv.addObject("categories", categoryService.getCategories());
            return mv;
        }
        throw new PageNotFoundException("페이지를 찾을 수 없습니다.");
    }
}
