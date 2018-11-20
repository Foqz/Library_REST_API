package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "borrow_list")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "specimen")
    private Specimen specimen;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column (name = "borrow_date")
    private LocalDate borrowDate;
    @Column (name = "return_date")
    private LocalDate returnDate;


}
