package org.maid.maid_library_management_system.service;


import lombok.RequiredArgsConstructor;
import org.maid.maid_library_management_system.controllers.DTO.BookDTO;
import org.maid.maid_library_management_system.controllers.DTO.response.OutputStringDTO;
import org.maid.maid_library_management_system.entity.Book;
import org.maid.maid_library_management_system.repository.BookRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> fetchAllBooks() {
        return bookRepository.findAll();
    }

    public Book fetchById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    public Book updateBook(BookDTO bookDTO, Integer bookId) {
        Book bookToUpdate = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + bookId));

        bookToUpdate.setTitle(bookDTO.getTitle());
        bookToUpdate.setAuthor(bookDTO.getAuthor());
        bookToUpdate.setIsbn(bookDTO.getIsbn());
        bookToUpdate.setPublicationYear(bookDTO.getPublicationYear());
        bookToUpdate.setUpdatedAt(LocalDateTime.now());

        return bookRepository.save(bookToUpdate);
    }


    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setDateCreated(LocalDateTime.now());
        book.setUpdatedAt(LocalDateTime.now());
        return bookRepository.save(book);
    }

    public OutputStringDTO deleteBook(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book id not found - " + id));
        bookRepository.delete(book);
        OutputStringDTO outputStringDTO = new OutputStringDTO();
        outputStringDTO.setMessage("Book Deleted with id: " + id);
        return outputStringDTO;
    }
}
