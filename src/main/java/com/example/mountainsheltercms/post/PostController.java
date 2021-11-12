package com.example.mountainsheltercms.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public ResponseEntity<?> postPost(@Valid @RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.postPost(postDto));
    }

    @GetMapping("/get/{id}")
    public Post findById(@PathVariable long id){
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public ResponseEntity<?> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable long id){
        return ResponseEntity.ok(postService.updatePost(postDto, id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    public ResponseEntity<?> deletePost(@PathVariable long id){
         return ResponseEntity.ok(postService.deletePost(id));
    }

}
