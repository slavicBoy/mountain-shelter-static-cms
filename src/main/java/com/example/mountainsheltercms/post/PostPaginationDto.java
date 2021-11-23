package com.example.mountainsheltercms.post;

import com.example.mountainsheltercms.shared.Pagination;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostPaginationDto {

    private List<PostDto> postDtoList;
    private Pagination pagination;

}
