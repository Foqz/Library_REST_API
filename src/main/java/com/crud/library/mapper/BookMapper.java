package com.crud.library.mapper;

import com.crud.library.Dto.BookDto;
import com.crud.library.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class BookMapper {
    public Book mapToBook(BookDto bookDto){
        return new Book(
                bookDto.getTitleId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getWrittenIn(),
                new ArrayList<>()
        );
    }
}
