package com.crud.library.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SpecimenDto {
    private Long specimenId;
    private Long titleId;
    private String bookStatus;
}
