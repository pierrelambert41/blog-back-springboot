package com.bludentelle.blogbludentelle.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import com.bludentelle.blogbludentelle.article.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/{articleId}/comments")
    public Page<CommentModel> getAllCommentsByArticleId(@PathVariable(value = "articleId") int postId,
                                                     Pageable pageable) {
        return commentRepository.findByArticleId(postId, pageable);
    }

    @PostMapping("/articles/{articleId}/comments")
    public CommentModel createComment(@PathVariable (value = "articleId") int articleId,
                                 @Valid @RequestBody CommentModel comment) {
        return articleRepository.findById(articleId).map(article -> {
            comment.setArticle(article);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("Article " + articleId + " not found"));
    }

    @PutMapping("/articles/{articleId}/comments/{commentId}")
    public CommentModel updateComment(@PathVariable (value = "articleId") int articleId,
                                 @PathVariable (value = "commentId") int commentId,
                                 @Valid @RequestBody CommentModel commentRequest) {
        if(!articleRepository.existsById(articleId)) {
            throw new ResourceNotFoundException("ArticleId " + articleId + " not found");
        }

        return commentRepository.findById(commentId).map(comment -> {
            comment.setContent(commentRequest.getContent());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "articleId") int articleId,
                                           @PathVariable (value = "commentId") int commentId) {
        return commentRepository.findByIdAndArticleId(commentId, articleId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id " + commentId + " and articleId " + articleId));
    }
}
