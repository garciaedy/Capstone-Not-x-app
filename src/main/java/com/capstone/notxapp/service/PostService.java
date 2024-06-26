package com.capstone.notxapp.service;

import com.capstone.notxapp.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAllPosts();

    List<PostDto> findPostsByUser();

    void createPost(PostDto postDto);

    PostDto findPostById(Long postId);

    void updatePost(PostDto postDto);

    void deletePost(Long postId);

    PostDto findPostByUrl(String postUrl);

    List<PostDto> searchPosts(String query);
}
