package org.maid.maid_library_management_system.controllers.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDTO {
    public String title;
    public String isbn;
    public String publicationYear;
@NotNull
    public String author;
}
