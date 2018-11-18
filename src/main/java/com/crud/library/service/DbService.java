package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.BorrowedBook;
import com.crud.library.domain.Specimen;
import com.crud.library.domain.User;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.BorrowedBookRepository;
import com.crud.library.repository.SpecimenRepository;
import com.crud.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;
    @Autowired
    private SpecimenRepository specimenRepository;

    public User saveUser(final User user){
        return userRepository.save(user);
    }
    public Book saveBook(final Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> findBookById(Long titleId) {
        return bookRepository.findById(titleId);
    }

    public Specimen saveSpecimen(final Specimen specimen) {
        return specimenRepository.save(specimen);
    }

    public List<Specimen> getSpecimenListById(Long titleId) {
        return specimenRepository.findAllById(titleId);
    }

    public boolean borrowBook(Long userId, Long specimenId) {
        Specimen specimen = specimenRepository.findById(specimenId).orElse(null);
        List<BorrowedBook> borrowedBookList = borrowedBookRepository.findAllBySpecimenOrderByBorrowDate(specimen);
        User user = userRepository.findById(userId).orElse(null);
        boolean canBorrow = true;
        if (borrowedBookList.size() > 0) {
            if (borrowedBookList.get(borrowedBookList.size() - 1 ).getReturnDate() == null) {
                canBorrow = false;
            }
        }
        if (canBorrow) {
            BorrowedBook borrowedBook = new BorrowedBook(null,specimen,user, LocalDate.now(),null);
            borrowedBookRepository.save(borrowedBook);
            return true;
        } else {
            return false;
        }
    }

    public List<BorrowedBook> findBorrowedBookListBySpecimenId(Long specimenId) {
        Specimen specimen = specimenRepository.findById(specimenId).orElse(null);
        return borrowedBookRepository.findAllBySpecimenOrderByBorrowDate(specimen);
    }
}
