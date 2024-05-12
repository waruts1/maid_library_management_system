package org.maid.maid_library_management_system.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.maid.maid_library_management_system.controllers.DTO.response.OutputStringDTO;
import org.maid.maid_library_management_system.entity.Book;
import org.maid.maid_library_management_system.entity.Patron;
import org.maid.maid_library_management_system.service.PatronService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
@Tag(name = "Patron", description = "GET/POST/PUT methods of APIs")
public class PatronController {

    private final PatronService patronService;

    @Operation(summary = "Fetch Patrons",
            description = "Fetch All Patron")
    @GetMapping("/patrons")
    public List<Patron> fetchPatrons(){
        return patronService.fetchAllPatrons();
    }

    @Operation(summary = "Fetch Patrons",
            description = "Fetch Patron Using Specific Id.")
    @GetMapping("/patron/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Patron.class)) }),
            @ApiResponse(responseCode = "404", description = "Patron not found",
                    content = @Content) })
    public Patron fetchPatronById(@PathVariable Integer id){
        return patronService.fetchById(id);
    }

    @Operation(summary = "Alter Patron",
            description = "Add Patron.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Validation Failed",
                    content = @Content) })
    @PostMapping("patron")
    public Patron addPatron(@RequestBody @Valid Patron addPatron){
        return patronService.addPatron(addPatron);
    }

    @Operation(summary = "Alter Patron",
            description = "Update Patron.")
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "Dynamic Update Enabled", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Patron not found / Validation Failed",
                    content = @Content) })
    @PutMapping("patron/{id}")
    public Patron updatePatron(@RequestBody @Valid Patron patron, @PathVariable Integer id){
        return patronService.updatePatron(patron, id);
    }
    @Operation(summary = "Alter Patron",
            description = "Delete Patron.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "404", description = "Patron not found",
                    content = @Content) })
    @DeleteMapping("/patron/{id}")
    public OutputStringDTO deletePatron(@Parameter(
            description = "ID of Patron to be deleted",
            required = true)@PathVariable int id) {
        return patronService.deletePatron(id);
    }

}
