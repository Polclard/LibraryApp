package org.laboratory.libraryapp.model.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
