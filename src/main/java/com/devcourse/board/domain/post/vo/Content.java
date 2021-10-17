package com.devcourse.board.domain.post.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content {
    @Transient
    private static final String CONTENT_REGEX = "^.{5,2000}$";

    @Column(name = "post_content")
    private String content;

    public Content(String content) {
        validate(content);
        this.content = content;
    }

    public void validate(String content) {
//        if (!Pattern.matches(CONTENT_REGEX, content)) {
//            throw new InvalidArgumentException(ErrorMessage.INVALID_POST_CONTENT);
//        }
    }

    public String getContent() {
        return content;
    }
}
