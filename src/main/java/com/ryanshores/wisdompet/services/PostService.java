package com.ryanshores.wisdompet.services;

import com.ryanshores.wisdompet.data.entities.Account;
import com.ryanshores.wisdompet.data.entities.Post;
import com.ryanshores.wisdompet.data.repositories.PostRepository;
import com.ryanshores.wisdompet.web.errors.NotFoundException;
import com.ryanshores.wisdompet.web.models.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDto getById(Long id){

        var postEntity = postRepository.findById(id);
        if (postEntity.isEmpty()) throw new NotFoundException("post not found with id " + id);
        return translateDbToWeb(postEntity.get());
    }

    public List<PostDto> getAll(){
        return postRepository.findAll().stream().map(this::translateDbToWeb).toList();
    }

    public PostDto save(PostDto postDto) {
        var post = translateWebToDb(postDto);

        if (post.getId() == null) {
            post.setCreatedAt(LocalDateTime.now());
        }

        post.setModifiedAt(LocalDateTime.now());

        return translateDbToWeb(postRepository.save(post));
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    private PostDto translateDbToWeb(Post postEntity) {
        var post = new PostDto();
        post.setId(postEntity.getId());
        post.setTitle(postEntity.getTitle());
        post.setBody(postEntity.getBody());
        post.setCreatedAt(postEntity.getCreatedAt());
        post.setModifiedAt(postEntity.getModifiedAt());
        post.setAuthor(postEntity.getAuthor());
        return post;
    }

    private Post translateWebToDb(PostDto postDtoObject) {
        var post = new Post();
        post.setId(postDtoObject.getId());
        post.setTitle(postDtoObject.getTitle());
        post.setBody(postDtoObject.getBody());
        post.setCreatedAt(postDtoObject.getCreatedAt());
        post.setModifiedAt(postDtoObject.getModifiedAt());
        post.setAuthor(postDtoObject.getAuthor());

        return post;
    }
}
