package org.maid.maid_library_management_system.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.maid.maid_library_management_system.controllers.DTO.BookDTO;
import org.maid.maid_library_management_system.entity.Book;
import org.maid.maid_library_management_system.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Tag(name = "get", description = "GET methods of Books APIs")
public class BookController {

    private final BookService bookService;

    @Operation(summary = "Fetch Books",
            description = "Fetch All Books")
    @GetMapping("/books")
    public List<Book> fetchBooks(){
        return bookService.fetchAllBooks();
    }

    @Operation(summary = "Fetch Books",
            description = "Fetch Book Using Specific Id.")
    @GetMapping("/book/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Book not found",
                    content = @Content) })
    public Book fetchBooksById(@PathVariable Integer id){
        return bookService.fetchById(id);
    }

    @PostMapping("book")
    public Book addBook(@RequestBody @Valid BookDTO bookDTO){
        return bookService.addBook(bookDTO);
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content) })
    @DeleteMapping("/employees/{employeeId}")
    public String deleteBook(@Parameter(
            description = "ID of book to be retrieved",
            required = true)@PathVariable int bookId) {
        return "Deleted book with id: " + bookService.deleteBook(bookId);
    }

}
