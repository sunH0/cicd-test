package com.devcourse.board.service;

import com.devcourse.board.converter.PostConverter;
import com.devcourse.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostConverter postConverter;

}
