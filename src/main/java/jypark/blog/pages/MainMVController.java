package jypark.blog.pages;

import static jypark.blog.utils.BlogVariables.RSS_URL;
import static jypark.blog.utils.BlogVariables.TITLE;
import static jypark.blog.utils.StringUtils.isFavicon;

import jypark.blog.dto.PageListPayload.PageListWrapperDTO;
import jypark.blog.exceptions.PageNotFoundException;
import jypark.blog.services.CategoryService;
import jypark.blog.services.PageService;
import jypark.blog.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class MainMVController {

    @Value("${insert.key}")
    private String insertKey;

    @Value("${domain}")
    private String domain;

    private final PageService pageService;

    private final ProjectService projectService;

    private final CategoryService categoryService;

    @GetMapping({"/", "/list", "/index"})
    public ModelAndView getPaginationMainList(@RequestParam(value = "page", defaultValue = "0", required = false) int page) {
        final ModelAndView mv = new ModelAndView("lists/list-pagination");
        final PageListWrapperDTO wrapper = pageService.getPages(page);
        mv.addObject("domain", domain);
        mv.addObject("key", insertKey);
        mv.addObject("wrapper", wrapper);
        mv.addObject("title", TITLE);
        mv.addObject("rss", RSS_URL);
        mv.addObject("project", projectService.getPayloadByCondition(page));
        mv.addObject("recents", pageService.getListRecentPages());
        return mv;
    }

    @GetMapping("/{pageIdStr}")
    public ModelAndView getPages(@PathVariable String pageIdStr) {
        if(isFavicon(pageIdStr)) {
            return null;
        }

        Long pageId = Long.parseLong(pageIdStr);
        final ModelAndView mv = new ModelAndView("details/detail");
        mv.addObject("title", TITLE);
        mv.addObject("project", projectService.get());
        mv.addObject("detail", pageService.getPageById(pageId));
        mv.addObject("recents", pageService.getDetailRecentPagesExceptId(pageId));
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
