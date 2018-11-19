package com.crud.library.repository;

import com.crud.library.domain.BorrowedBook;
import com.crud.library.domain.Specimen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BorrowedBookRepository extends CrudRepository<BorrowedBook,Long> {
    List<BorrowedBook> findAllBySpecimenOrderByBorrowDate(Specimen specimen);

    BorrowedBook findBySpecimenId(Long specimenId);
}
