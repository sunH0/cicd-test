package com.devcourse.board.dto.post;

import com.devcourse.board.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto {
    private Long id;
    private String title;
    private String content;

    private User user;

}
