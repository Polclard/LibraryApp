package org.laboratory.libraryapp.model.dto;

import lombok.Data;
import org.laboratory.libraryapp.model.Author;
import org.laboratory.libraryapp.model.Category;

@Data
public class BookDto {
    private Long id;
    private String name;
    private Category category;
    private Author author;
    private int availableCopies;

    public BookDto(Long id, String name, Category category, Author author, int availableCopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
