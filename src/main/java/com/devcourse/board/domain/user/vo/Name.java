package com.devcourse.board.domain.user.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Name {
    @Transient
    private static final String NAME_VALIDATOR = "^[가-힣]{2,10}$";

    @Column(name = "member_name", nullable = false)
    private String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
//        if (!Pattern.matches(NAME_VALIDATOR, name)) {
//            throw new InvalidArgumentException(ErrorMessage.INVALID_MEMBER_NAME);
//        }
    }

    public String getName() {
        return name;
    }
}
