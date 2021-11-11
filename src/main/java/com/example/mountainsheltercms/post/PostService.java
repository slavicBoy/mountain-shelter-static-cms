package com.example.mountainsheltercms.post;

import com.example.mountainsheltercms.post.exception.PostError;
import com.example.mountainsheltercms.post.exception.PostException;
import com.example.mountainsheltercms.post.repository.PostRepository;
import com.example.mountainsheltercms.tag.Tag;
import com.example.mountainsheltercms.tag.TagDto;
import com.example.mountainsheltercms.tag.TagMapper;
import com.example.mountainsheltercms.user.User;
import com.example.mountainsheltercms.user.exception.UserError;
import com.example.mountainsheltercms.user.exception.UserException;
import com.example.mountainsheltercms.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    PostRepository postRepository;
    UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostDto> getPosts() {
        return postRepository.findAll()
                .stream()
                .map(PostMapper::toDto)
                .collect(Collectors.toList());
    }

    public Post findById(long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostException(PostError.POST_NOT_FOUND));
    }

    public PostDto postPost(PostDto postDto) {
        Post post = PostMapper.toEntity(postDto);
        //assign tags
        List<Tag> tags = postDto.getTagsDto().stream().map(TagMapper::toEntity).collect(Collectors.toList());
        tags.forEach(tag -> tag.setPost(post));
        post.setTags(tags);
        //assign user
        User userToAssign = getUserToAssign(postDto);
        userToAssign.getPostList().add(post);
        post.setUser(userToAssign);

        postRepository.save(post);
        return PostMapper.toDto(post);
    }

    private User getUserToAssign(PostDto postDto) {
        return userRepository.findById(postDto.getUserDto()
                        .getId())
                        .orElseThrow(() -> new UserException(UserError.USER_NOT_FOUND));

    }

    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new PostException(PostError.POST_NOT_FOUND));
        post.setImg(postDto.getImg());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        postRepository.save(post);
        return PostMapper.toDto(post);
    }

    public PostDto deletePost(long id) {
        Post postToDelete = postRepository.findById(id)
                .orElseThrow(() -> new PostException(PostError.POST_NOT_FOUND));
        postRepository.delete(postToDelete);
        return PostMapper.toDto(postToDelete);
    }
}
