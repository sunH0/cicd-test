package com.devcourse.board.domain.user;


import com.devcourse.board.common.BaseEntity;
import com.devcourse.board.domain.post.Post;
import com.devcourse.board.domain.user.vo.Age;
import com.devcourse.board.domain.user.vo.Email;
import com.devcourse.board.domain.user.vo.Hobby;
import com.devcourse.board.domain.user.vo.Name;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseEntity {
    @Id @GeneratedValue
    private Long id;
    @Embedded
    private Name name;
    @Embedded
    private Email email;
    @Embedded
    private Age age;
    @Embedded
    private Hobby hobby;
    
    // Note : 유저 삭제시 게시글까지 삭제
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        post.setUser(this);
    }

}
