package com.crud.library.Dto;
import com.crud.library.domain.Specimen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowedBookDto {
    private Long id;
    private Specimen specimen;
    private Long userId;
    private Date borrowDate;
    private Date returnDate;
}
