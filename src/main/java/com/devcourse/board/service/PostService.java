package com.devcourse.board.service;

import com.devcourse.board.converter.PostConverter;
import com.devcourse.board.domain.post.Post;
import com.devcourse.board.domain.user.User;
import com.devcourse.board.dto.post.PostCreateRequest;
import com.devcourse.board.dto.post.PostResponse;
import com.devcourse.board.dto.post.PostUpdateRequest;
import com.devcourse.board.repository.PostRepository;
import com.devcourse.board.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository; // Todo : PostService에 UserRepository가 오게 되는데 좋은 방법이 있을까?
    private final PostConverter postConverter;

    @Transactional
    public Long insert(PostCreateRequest dto) throws NotFoundException {
        User user = userRepository.findById(dto.getUserId())
            .orElseThrow(() -> new NotFoundException("게시글을 작성할 유저를 찾을 수 없습니다."));
        Post post = postConverter.convertToPost(dto, user);
        postRepository.save(post);
        post.setInfo(user.getId());
        user.addPost(post);
        return post.getId();
    }

    public PostResponse findById(Long id) throws NotFoundException {
        return postRepository.findById(id)
            .map(postConverter::convertToPostResponse)
            .orElseThrow(() -> new NotFoundException("게시글을 찾을 수 없습니다."));
    }

    public Page<PostResponse> findAll(Pageable pageable) {
        return postRepository.findAll(pageable)
            .map(postConverter::convertToPostResponse);
    }

    public Page<PostResponse> findAllByUser(Long userId, Pageable pageable) throws NotFoundException {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new NotFoundException("유저를 찾을 수 없습니다."));
        return postRepository.findAllByUserOrderByCreatedAt(user, pageable)
            .map(postConverter::convertToPostResponse);
    }

    @Transactional
    public PostResponse update(PostUpdateRequest dto) throws NotFoundException {
        Post foundPost = postRepository.findById(dto.getId())
            .orElseThrow(() -> new NotFoundException("업데이트할 게시글을 찾을 수 없습니다."));
        Post post = postConverter.convertToPost(dto);
        // Todo : 연관관계 메서드에 의해 user의 posts에 같은 아이디를 가진 새로운 post가 추가되는데
        //      - 아래의 save에 의해 post가 업데이트 되면 posts에 저장된 고아객체는 어떻게 됨?
        post.setUser(foundPost.getUser());
        postRepository.save(post);
        return postConverter.convertToPostResponse(post);
    }

    @Transactional
    public Long delete(Long id) throws NotFoundException {
        postRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("삭제할 게시글을 찾을 수 없습니다."));
        postRepository.deleteById(id);
        return id;
    }

}
