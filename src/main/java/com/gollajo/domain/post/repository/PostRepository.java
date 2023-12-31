package com.gollajo.domain.post.repository;

import com.gollajo.domain.post.entity.Post;
import com.gollajo.domain.post.entity.enums.PostState;
import com.gollajo.domain.post.entity.enums.PostType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}
