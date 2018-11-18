package com.crud.library.mapper;

import com.crud.library.Dto.SpecimenDto;
import com.crud.library.domain.Book;
import com.crud.library.domain.BorrowedBook;
import com.crud.library.domain.Specimen;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SpecimenMapper {
    @Autowired
    private DbService dbService;

    public Specimen mapToSpecimen(SpecimenDto specimenDto){
        Optional<Book> book = dbService.findBookById(specimenDto.getTitleId());
        List<BorrowedBook> borrowedBookList = dbService.findBorrowedBookListBySpecimenId(specimenDto.getSpecimenId()); // czy to ok? do poprawy
        return new Specimen( specimenDto.getSpecimenId(),
                specimenDto.getTitleId(),
                specimenDto.getBookStatus(),
                book,
                borrowedBookList);
    }

    public SpecimenDto mapToSpecimenDto(Specimen specimen) {
        return new SpecimenDto(specimen.getSpecimenId(),
                specimen.getTitleId(),
                specimen.getBookStatus());
    }

    public List<SpecimenDto> mapToSpecimenDtoList (final List<Specimen> specimenList){
        return specimenList.stream()
                .map(t -> new SpecimenDto(t.getSpecimenId(),t.getTitleId(),t.getBookStatus()))
                .collect(Collectors.toList());
    }

}
