package com.devcourse.board.domain.user.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Email {
    @Transient
    private static final String EMAIL_VALIDATOR = "^[_a-zA-Z0-9-\\+]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,3})$";

    @Column(name = "member_email", nullable = false)
    private String email;

    public Email(String email) {
        validate(email);
        this.email = email;
    }

    public void validate(String email) {
//        if (!Pattern.matches(EMAIL_VALIDATOR, email)) {
//            throw new InvalidArgumentException(ErrorMessage.INVALID_MEMBER_EMAIL);
//        }
    }

    public String getEmail() {
        return email;
    }
}
