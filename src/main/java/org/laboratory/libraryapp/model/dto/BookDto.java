package org.laboratory.libraryapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.laboratory.libraryapp.model.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String name;
    private Category category;
    private long authorId;
    private int availableCopies;
}
