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
public class Age {

    @Column(name = "user_age", nullable = false)
    private int age;

    public Age(String age) {
        if (!validate(age)) ;
            // throw new InvalidArgumentException(ErrorMessage.INVALID_USER_AGE);
        this.age = Integer.parseInt(age);
    }

    public static boolean validate(String age) {
        return Pattern.matches("^100|[1-9]?\\d$", age);
    }

    public int getAge() {
        return age;
    }

}
