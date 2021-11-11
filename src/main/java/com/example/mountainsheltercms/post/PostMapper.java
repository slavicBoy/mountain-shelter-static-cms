package com.example.mountainsheltercms.post;

import com.example.mountainsheltercms.tag.TagDto;
import com.example.mountainsheltercms.tag.TagMapper;
import com.example.mountainsheltercms.user.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostDto toDto(Post post) {
        PostDto postDto = new PostDto();

        List<TagDto> tagDtoList = post.getTags().stream()
                .map(TagMapper::toDto)
                .collect(Collectors.toList());

        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setImg(post.getImg());
        postDto.setUserDto(UserMapper.toDto(post.getUser()));
        postDto.setTagsDto(tagDtoList);

        return postDto;
    }

    public static Post toEntity(PostDto postDto) {
        Post post = new Post();

        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setImg(postDto.getImg());

        return post;
    }

}
