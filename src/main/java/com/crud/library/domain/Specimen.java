package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

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
    private Enum bookStatus;
    @ManyToOne
    @JoinColumn(name = "title_id")
    private Optional<Book> book;
    @OneToMany(targetEntity = BorrowedBook.class,mappedBy = "specimen")
    private List<BorrowedBook> borrowedBook;

}
