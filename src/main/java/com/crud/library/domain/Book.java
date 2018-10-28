package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "title_id")
    private Long titleId;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "written_in")
    private Date writtenIn;
}
