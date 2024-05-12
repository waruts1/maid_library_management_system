package org.maid.maid_library_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Data
@DynamicUpdate
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
