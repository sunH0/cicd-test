package com.devcourse.board.converter;

import com.devcourse.board.domain.post.Post;
import com.devcourse.board.domain.user.User;
import com.devcourse.board.domain.user.vo.Age;
import com.devcourse.board.domain.user.vo.Email;
import com.devcourse.board.domain.user.vo.Hobby;
import com.devcourse.board.domain.user.vo.Name;
import com.devcourse.board.dto.user.UserCreateRequest;
import com.devcourse.board.dto.user.UserResponse;
import com.devcourse.board.dto.user.UserUpdateRequest;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    // Todo : 모든 Dto와 Vo 그리고 Converter클래스에서 어색하거나 효율적이지 못한 부분?

    public User convertToUser(UserCreateRequest dto) {
        return User.builder()
            .name(new Name(dto.getName()))
            .email(new Email(dto.getEmail()))
            .age(new Age(dto.getAge()))
            .hobby(new Hobby(dto.getHobby()))
            .build();
    }

    public User convertToUser(UserUpdateRequest dto, List<Post> posts) { // 오버로딩
        return User.builder()
            .id(dto.getId())
            .name(new Name(dto.getName()))
            .email(new Email(dto.getEmail()))
            .age(new Age(dto.getAge()))
            .hobby(new Hobby(dto.getHobby()))
            .posts(posts)
            .build();
    }

    public UserResponse convertToUserResponse(User user) { // Todo : Api마다 다른 Response dto를 만들어 줘야 함?
        return UserResponse.builder()
            .id(user.getId())
            .name(user.getName().getName())
            .email(user.getEmail().getEmail())
            .age(user.getAge().getAge())
            .hobby(user.getHobby().getHobby())
            .build();
    }
}
