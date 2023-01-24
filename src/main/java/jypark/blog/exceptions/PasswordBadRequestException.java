package jypark.blog.exceptions;

public class PasswordBadRequestException extends RuntimeException {

    public PasswordBadRequestException() {
        super("비밀번호가 잘못되었어요");
    }
}
