package jypark.blog.entities.enumerates;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CategoryType {

    GIT("Git"),
    BACKEND("Back-end"),
    FRONTEND("Front-end"),
    SELF_STUDY("Self Study"),
    ARCHIVE("Archive"),

    ;

    private String view;

    public static String ifNullThen() {
        return "카테고리 없음";
    }
}
