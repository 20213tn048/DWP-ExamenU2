package mx.edu.utez.examenU2.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Table( name = "books" ) @Data
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "book_id")
    private Long id;

    private String title;
    private String author;
    
    @Column( name = "publication_date")
    private Date publicationDate;

    private String image;
}
