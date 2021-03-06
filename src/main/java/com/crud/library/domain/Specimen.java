package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books_specimen")
public class Specimen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "specimen_id")
    private Long specimenId;
    @Column(name = "title_id")
    private Long titleId;
    @Column(name = "book_status")
    private String bookStatus;
    @ManyToOne
    @JoinColumn(name = "book")
    private Book book;
    @OneToMany(targetEntity = BorrowedBook.class,mappedBy = "specimen")
    private List<BorrowedBook> borrowedBook;

}
