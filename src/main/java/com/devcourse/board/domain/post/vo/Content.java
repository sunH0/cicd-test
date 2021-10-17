package com.devcourse.board.domain.post.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Content {

    @Column(name = "post_content")
    private String content;

    public Content(String content) {
        if(!validate(content));
            // throw new InvalidArgumentException(ErrorMessage.INVALID_POST_CONTENT);
        this.content = content;
    }

    public static boolean validate(String content) {
        return content.length() > 0 && content.length() <= 2500;
    }

    public String getContent() {
        return content;
    }
}
