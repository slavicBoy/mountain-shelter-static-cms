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
    public ResponseEntity<?> getPosts(){
        return ResponseEntity.ok(postService.getPosts());
    }


    @GetMapping("/getWithPagination")
    public ResponseEntity<?> getPostsWithPagination( @RequestParam(defaultValue = "0") Integer page,
                                       @RequestParam(defaultValue = "5") Integer size) {
        return ResponseEntity.ok(postService.getPostsWithPagination(page, size));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> postPost(@Valid @RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.postPost(postDto));
    }

    @GetMapping("/get/{id}")
    public PostDto findById(@PathVariable long id) {
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable long id) {
        return ResponseEntity.ok(postService.updatePost(postDto, id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> deletePost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.deletePost(id));
    }

}
