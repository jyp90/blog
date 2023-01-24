package jypark.blog.aops;

import jypark.blog.exceptions.PageNotFoundException;
import jypark.blog.exceptions.PasswordBadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
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
        e.printStackTrace();
        return null;
    }
}
