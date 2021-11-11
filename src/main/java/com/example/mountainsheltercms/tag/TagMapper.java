package com.example.mountainsheltercms.tag;

import com.example.mountainsheltercms.post.PostMapper;

public class TagMapper {

    public static TagDto toDto(Tag tag) {
        TagDto tagDto = new TagDto();
        tagDto.setContent(tag.getContent());
        return tagDto;
    }

    public static Tag toEntity(TagDto tagDto) {
        Tag tag = new Tag();
        tag.setContent(tagDto.getContent());
        return tag;
    }
}
