package com.crud.library.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long titleId;
    private String title;
    private String author;
    private Date writtenIn;
}
