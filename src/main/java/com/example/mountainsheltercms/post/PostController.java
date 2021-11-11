package com.example.mountainsheltercms.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<?> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @PostMapping
    public ResponseEntity<?> postPost(@Valid @RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.postPost(postDto));
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable long id){
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable long id){
        return ResponseEntity.ok(postService.updatePost(postDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable long id){
         return ResponseEntity.ok(postService.deletePost(id));
    }

}
