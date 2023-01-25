package jypark.blog.aops;

import jypark.blog.exceptions.PageNotFoundException;
import jypark.blog.exceptions.PasswordBadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class AppControllerAdvice {

    @ExceptionHandler(PageNotFoundException.class)
    public ModelAndView pageNotFoundExceptionHandler(PageNotFoundException e) {
        return new ModelAndView("errors/404");
    }

    @ExceptionHandler(PasswordBadRequestException.class)
    public ModelAndView PasswordBadRequestExceptionHandler(PasswordBadRequestException e) {
        return new ModelAndView("errors/400");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity allExceptionHandler(Exception e) {
        log.error(ExceptionUtils.getStackTrace(e));
        return null;
    }
}
