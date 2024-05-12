package org.maid.maid_library_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@DynamicUpdate
public class BorrowingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "borrowing_record_generator")
    @SequenceGenerator(name = "borrowing_record_generator", sequenceName = "borrowing_record_seq", allocationSize = 1)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "patron_id")
    private Patron patron;
    private LocalDateTime borrowingDate;
    private LocalDateTime returnDate;

}
