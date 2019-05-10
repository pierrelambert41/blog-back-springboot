package com.bludentelle.blogbludentelle.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @CrossOrigin
    @GetMapping("/users")
    public List<UserModel> findAll() {
        return repository.findAll();
    }
}
