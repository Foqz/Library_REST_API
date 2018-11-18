package com.crud.library.repository;

import com.crud.library.domain.BorrowedBook;
import com.crud.library.domain.Specimen;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BorrowedBookRepository extends CrudRepository<BorrowedBook,Long> {
    List<BorrowedBook> findAllBySpecimenOrderByBorrowDate(Specimen specimen);
}
