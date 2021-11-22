package com.example.mountainsheltercms.post;

import com.example.mountainsheltercms.tag.Tag;
import com.example.mountainsheltercms.tag.TagDto;
import com.example.mountainsheltercms.user.User;
import com.example.mountainsheltercms.user.UserDto;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String img;
    private LocalDate postDate;
    private List<TagDto> tagsDto;
    private UserDto userDto;
}
