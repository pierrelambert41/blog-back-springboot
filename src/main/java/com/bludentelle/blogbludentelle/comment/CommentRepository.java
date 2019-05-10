package com.bludentelle.blogbludentelle.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface  CommentRepository extends JpaRepository<CommentModel, Integer> {
}
