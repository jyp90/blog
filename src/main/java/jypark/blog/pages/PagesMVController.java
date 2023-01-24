package jypark.blog.pages;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pages")
public class PagesMVController {

    @GetMapping
    public ModelAndView ok() {
        return new ModelAndView("details/success");
    }
}
