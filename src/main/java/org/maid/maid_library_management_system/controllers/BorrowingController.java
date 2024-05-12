package org.maid.maid_library_management_system.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.maid.maid_library_management_system.entity.BorrowingRecord;
import org.maid.maid_library_management_system.service.BorrowService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Tag(name = "Borrowing endpoint", description = "GET/POST/PUT methods of APIs")
public class BorrowingController {

    private final BorrowService borrowService;

    @Operation(summary = "Borrow Book",
            description = "Borrowing date is set to current time, return date null")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = BorrowingRecord.class)) }),
            @ApiResponse(responseCode = "404", description = "Process Failed",
                    content = @Content) })
    @PostMapping("borrow/{bookId}/patron/{patronId}")
    public BorrowingRecord borrowBook(@Parameter(
            description = "ID of the book",
            required = true)@PathVariable Integer bookId, @Parameter(
            description = "ID of the Patron",
            required = true)@PathVariable Integer patronId){
        return borrowService.borrow(bookId,patronId);
    }

    @Operation(summary = "Return Book",
            description = "Return date is populated while borrowed date is set to null")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = BorrowingRecord.class)) }),
            @ApiResponse(responseCode = "404", description = "Process Failed",
                    content = @Content) })
    @PutMapping("return/{bookId}/patron/{patronId}")
    public BorrowingRecord returnBook(@Parameter(
            description = "ID of the book",
            required = true)@PathVariable Integer bookId, @Parameter(
            description = "ID of the Patron",
            required = true)@PathVariable Integer patronId){
        return borrowService.returnBook(bookId,patronId);
    }
}
