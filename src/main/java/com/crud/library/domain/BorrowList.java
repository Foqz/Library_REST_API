package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "borrow_list")
public class BorrowList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "specimen_id")
    private Long specimenId;
    @Column(name = "user_id")
    private Long userId;
    @Column (name = "borrow_date")
    private Date borrowDate;
    @Column (name = "return_date")
    private Date returnDate;
}
