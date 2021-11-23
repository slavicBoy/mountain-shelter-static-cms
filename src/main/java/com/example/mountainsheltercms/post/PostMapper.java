package com.example.mountainsheltercms.post;

import com.example.mountainsheltercms.shared.Pagination;
import com.example.mountainsheltercms.tag.TagDto;
import com.example.mountainsheltercms.tag.TagMapper;
import com.example.mountainsheltercms.user.UserMapper;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostDto toDto(Post post) {
        PostDto postDto = new PostDto();

        List<TagDto> tagDtoList = post.getTags().stream()
                .map(TagMapper::toDto)
                .collect(Collectors.toList());

        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setImg(post.getImg());
        postDto.setPostDate(post.getPostDate());
        postDto.setUserDto(UserMapper.toDto(post.getUser()));
        postDto.setTagsDto(tagDtoList);

        return postDto;
    }

    public static PostPaginationDto toDtoWithPagination(Page<Post> postsFromDataBase) {
        PostPaginationDto postPaginationDto = new PostPaginationDto();
        postPaginationDto.setPagination(new Pagination());
        //set postDto list
        List<PostDto> postDtoList = postsFromDataBase.getContent().stream()
                .map(PostMapper::toDto)
                .collect(Collectors.toList());
        postPaginationDto.setPostDtoList(postDtoList);

        //set pagination
        postPaginationDto.getPagination().setNumber(postsFromDataBase.getNumber());
        postPaginationDto.getPagination().setSize(postsFromDataBase.getSize());
        postPaginationDto.getPagination().setTotalElements((int) postsFromDataBase.getTotalElements());
        postPaginationDto.getPagination().setTotalPages(postsFromDataBase.getTotalPages());

        return postPaginationDto;
    }


    public static Post toEntity(PostDto postDto) {
        Post post = new Post();

        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setImg(postDto.getImg());
        post.setPostDate(LocalDate.now());

        return post;
    }

}
