package org.maid.maid_library_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.maid.maid_library_management_system.controllers.DTO.BookDTO;

import java.time.LocalDateTime;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_seq", allocationSize = 1)
    private Integer id;
    private String title;

    private String author;

    private String isbn;

    private String publicationYear;

    private LocalDateTime dateCreated;

    private LocalDateTime updatedAt;


}
