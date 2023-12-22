package com.ryanshores.wisdompet.config;

import com.ryanshores.wisdompet.data.entities.Account;
import com.ryanshores.wisdompet.data.entities.Authority;
import com.ryanshores.wisdompet.data.entities.Post;
import com.ryanshores.wisdompet.data.repositories.AuthorityRepository;
import com.ryanshores.wisdompet.services.AccountService;
import com.ryanshores.wisdompet.services.PostService;
import com.ryanshores.wisdompet.web.models.PostDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityRepository authorityRepository;

    private static final Logger log = LoggerFactory.getLogger(SeedData.class);

    private void logPreloading(String input) {
        log.info("[Preloading] " + input);
    }

    private String getJimmyPost() {
        var now = LocalDateTime.now();

        String[] lines = {
            "I woke up just now and thought in the year of " + now.getYear(),
            "that I should come write something here.\n",
            "Excuse me if I seem unprepared...\n",
            "You seeeee.ahhhh.^sneezes^.choooo",
            "I was born and woke up today at " + now.toLocalTime(),
            "Anyways out!"
        };

        var linesWithFaces = addFaces(lines);

        return String.join("\n", linesWithFaces);
    }

    private String[] addFaces(String[] array) {
        return Arrays.stream(array).map(str -> getRandomFace() + " " + str).toArray(String[]::new);
    }

    private String getRandomFace() {
        var rnd = new Random();
        var index = rnd.nextInt(faces.length);
        return faces[index];
    }

    private final String[] faces = {"( ͡° ͜ʖ ͡°)", "¯\\_(ツ)_/¯", "ʕ•ᴥ•ʔ", "ಠ_ಠ", "(づ｡◕‿‿◕｡)づ", "(͡ ͡° ͜ つ ͡͡°)",
            "(ง'̀-'́)ง", "(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧", "ヾ(⌐■_■)ノ♪", "~(˘▾˘~)", "⚆ _ ⚆", "(｡◕‿◕｡)", "(ʘ‿ʘ)", "◔̯◔",
            "｡゜(｀Д´)゜｡", "(^̮^)", "(▀̿Ĺ̯▀̿ ̿)"};

    @Override
    public void run(String... args) throws Exception {
        var posts = postService.getAll();

        if (posts.isEmpty()) {
            logPreloading("Starting...");

            var userAuthority = new Authority();
            userAuthority.setName("ROLE_USER");
            logPreloading(authorityRepository.save(userAuthority).toString());

            var adminAuthority = new Authority();
            adminAuthority.setName("ROLE_ADMIN");
            logPreloading(authorityRepository.save(adminAuthority).toString());

            var account1 = new Account();
            account1.setFirstName("Jimmy");
            account1.setLastName("Jones");
            account1.setEmail("jimmy@jones.com");
            account1.setPassword("password");
            var authorities1 = new HashSet<Authority>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
            account1.setAuthorities(authorities1);
            logPreloading(accountService.save(account1).toString());

            var account2 = new Account();
            account2.setFirstName("Ryan");
            account2.setLastName("Shores");
            account2.setEmail("ryan.shores@me.com");
            account2.setPassword("password");
            var authorities2 = new HashSet<Authority>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            account2.setAuthorities(authorities2);
            logPreloading(accountService.save(account2).toString());

            var post1 = new PostDto();
            post1.setTitle("My thoughts on the recent events");
            post1.setBody(getJimmyPost());
            post1.setAuthor(account1.getFullName());
            logPreloading(postService.save(post1).toString());

            var post2 = new PostDto();
            post2.setTitle("Title of Post 2");
            post2.setBody("This is the body of post 2");
            post2.setAuthor(account2.getFullName());
            logPreloading(postService.save(post2).toString());

            logPreloading("Finished!");
        }
    }
}
