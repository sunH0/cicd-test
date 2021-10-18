package com.devcourse.board.service;

import com.devcourse.board.converter.PostConverter;
import com.devcourse.board.domain.post.Post;
import com.devcourse.board.domain.post.vo.Content;
import com.devcourse.board.domain.post.vo.Title;
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
        post.setInfo(user.getId());
        post.setUser(user);
        postRepository.save(post);
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
        return postRepository.findAllByUser(user, pageable)
            .map(postConverter::convertToPostResponse);
    }

    @Transactional
    public PostResponse update(PostUpdateRequest dto) throws NotFoundException {
        Post post = postRepository.findById(dto.getId())
            .orElseThrow(() -> new NotFoundException("업데이트할 게시글을 찾을 수 없습니다."));
        post.update(new Title(dto.getTitle()), new Content(dto.getContent()));
        postRepository.save(post); // Todo : save 해야함 ? 변경감지 확인하기
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
