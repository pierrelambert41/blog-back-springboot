package com.bludentelle.blogbludentelle.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    ArticleRepository arp;

    @GetMapping("/articles")
    public List<ArticleModel> findAll() {
        return arp.findAll();
    }

    @PostMapping("/posts")
    public ArticleModel createArticle(@Valid @RequestBody ArticleModel article) {
        return arp.save(article);
    }

    @PutMapping("/posts/{id}")
    public ArticleModel updateArticle(@PathVariable int articleId, @Valid @RequestBody ArticleModel articleRequest) {
        return arp.findById(articleId).map(articleModel -> {
            articleModel.setTitle(articleRequest.getTitle());
            articleModel.setDescription(articleRequest.getDescription());
            articleModel.setCategory(articleRequest.getCategory());
            articleModel.setUser(articleRequest.getUser());
            articleModel.setModifiedDatetime(articleRequest.getModifiedDatetime());
            return arp.save(articleRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("ArticleId" + articleId + "not found"));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable int articleId) {
        return arp.findById(articleId).map(post -> {
            arp.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("ArticleId " + articleId + " not found"));
    }
}
