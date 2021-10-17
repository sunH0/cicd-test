package com.devcourse.board.domain.user.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Age {
    @Transient
    private static final String AGE_VALIDATOR = "^100|[1-9]?\\d$";

    @Column(name = "member_age", nullable = false)
    private int age;

    public Age(String age) {
        validate(age);
        this.age = parsingAge(age);
    }

    private void validate(String age) {
//        if (!Pattern.matches(AGE_VALIDATOR, age)) {
//            throw new InvalidArgumentException(ErrorMessage.INVALID_MEMBER_AGE);
//        }
    }

    private int parsingAge(String age) {
        return Integer.parseInt(age);
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.valueOf(age);
    }
}
