package com.bludentelle.blogbludentelle.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface  CommentRepository extends JpaRepository<CommentModel, Integer> {

    Page<CommentModel> findByArticleId(int postId, Pageable pageable);
    Optional<CommentModel> findByIdAndArticleId(int id, int articleId);
}
