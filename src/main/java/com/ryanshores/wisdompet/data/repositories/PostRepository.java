package com.ryanshores.wisdompet.data.repositories;

import com.ryanshores.wisdompet.data.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
