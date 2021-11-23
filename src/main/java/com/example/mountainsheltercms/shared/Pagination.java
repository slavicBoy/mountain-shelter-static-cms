package com.example.mountainsheltercms.shared;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pagination {

    private Integer size;
    private Integer totalElements;
    private Integer totalPages;
    private Integer number;

}