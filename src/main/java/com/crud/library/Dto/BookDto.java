package com.crud.library.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long titleId;
    private String title;
    private String author;
    private LocalDate writtenIn;
    private List<SpecimenDto> specimenDtoList;
}
