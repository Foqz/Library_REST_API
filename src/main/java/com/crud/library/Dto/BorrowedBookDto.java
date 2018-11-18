package com.crud.library.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowedBookDto {
    private Long id;
    private Long specimenId;
    private Long userId;
    private Date borrowDate;
    private Date returnDate;
}
