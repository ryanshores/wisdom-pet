package com.ryanshores.wisdompet;

import com.ryanshores.wisdompet.services.PostService;
import com.ryanshores.wisdompet.web.rest.PostController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class WisdomPetApplicationTests {

    @Autowired
    private PostController postController;


    @Autowired
    private PostService postService;

    @Test
    void contextLoads() {
        assertThat(postController).isNotNull();
    }

    @Test
    void postsLoad() {
        var posts = postService.getAll();
        assertThat(posts).isNotNull();
        assertTrue(posts.stream().count() >= 2);
    }

}
