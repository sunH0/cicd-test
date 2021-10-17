package com.devcourse.board.domain.user.vo;

import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Hobby {

    @Column(name = "user_hobby", nullable = false)
    private String hobby;

    public Hobby(String hobby) {
        if (!validate(hobby)) ;
            // throw new InvalidArgumentException(ErrorMessage.INVALID_USER_HOBBY);
        this.hobby = hobby;
    }

    public static boolean validate(String hobby) {
        return hobby.length() > 0 && hobby.length() <= 30;
    }

    public String getHobby() {
        return hobby;
    }
}
