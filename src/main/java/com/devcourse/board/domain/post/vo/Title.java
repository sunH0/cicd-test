package com.devcourse.board.domain.post.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Title {
    @Transient
    private static final String TITLE_REGEX = "^.{1,25}$";

    @Column(name = "post_title")
    private String title;

    public Title(String title) {
        validate(title);
        this.title = title;
    }

    public void validate(String title) {
//        if (!Pattern.matches(TITLE_REGEX, title)) {
//            throw new InvalidArgumentException(ErrorMessage.INVALID_POST_TITLE);
//        }
    }

    public String getTitle() {
        return title;
    }
}
