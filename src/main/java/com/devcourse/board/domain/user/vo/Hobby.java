package com.devcourse.board.domain.user.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hobby {
    @Transient
    private static final String HOBBY_VALIDATOR = "^.{1,50}$";

    @Column(name = "member_hobby", nullable = false)
    private String hobby;

    public Hobby(String hobby) {
        validate(hobby);
        this.hobby = hobby;
    }

    private void validate(String name) {
//        if (!Pattern.matches(HOBBY_VALIDATOR, name)) {
//            throw new InvalidArgumentException(ErrorMessage.INVALID_MEMBER_HOBBY);
//        }
    }

    public String getHobby() {
        return hobby;
    }
}
