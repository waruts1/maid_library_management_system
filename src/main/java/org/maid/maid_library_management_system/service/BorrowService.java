package org.maid.maid_library_management_system.service;


import lombok.RequiredArgsConstructor;
import org.maid.maid_library_management_system.entity.Book;
import org.maid.maid_library_management_system.entity.BorrowingRecord;
import org.maid.maid_library_management_system.entity.Patron;
import org.maid.maid_library_management_system.repository.BookRepository;
import org.maid.maid_library_management_system.repository.BorrowRepository;
import org.maid.maid_library_management_system.repository.PatronRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;
    private final PatronRepository patronRepository;

    public BorrowingRecord returnBook(Integer bookId, Integer patronId) {
        BorrowingRecord borrowingRecord = borrowRepository.findTopByBook_IdAndPatron_Id(bookId, patronId);
        if (!borrowingRecord.toString().isEmpty()) {
            borrowingRecord.setBorrowingDate(null);
            borrowingRecord.setReturnDate(LocalDateTime.now());
            return borrowRepository.save(borrowingRecord);
        } else {
            throw new ResourceNotFoundException("No Record Found");
        }

    }

    public BorrowingRecord borrow(Integer bookId, Integer patronId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));
        Patron patron = patronRepository.findById(patronId)
                .orElseThrow(() -> new ResourceNotFoundException("Patron not found with id: " + patronId));

        if (borrowRepository.findTopByBook_IdAndPatron_Id(bookId, patronId) != null) {
            throw new RuntimeException("Patron already Borrowed Book");
        }
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowingDate(LocalDateTime.now());
        borrowingRecord.setReturnDate(null);

        return borrowRepository.save(borrowingRecord);
    }

}
