package com.ryanshores.wisdompet.web.rest;

import com.ryanshores.wisdompet.services.PostService;
import com.ryanshores.wisdompet.web.models.PostDto;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDto> all() {
        return postService.getAll();
    }

    @GetMapping("{id}")
    public PostDto one(@PathVariable Long id) {
        return postService.getById(id);
    }

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    public PostDto newPost(@RequestBody PostDto postDto) { return postService.save(postDto); }

    @PutMapping("{id}")
    @PreAuthorize("isAuthenticated()")
    public PostDto replacePost(@RequestBody PostDto postDto, @PathVariable Long id) {
        postDto.setId(id);
        return postService.save(postDto);
    }
    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deletePost(@PathVariable Long id) {
        postService.deleteById(id);
    }
}
