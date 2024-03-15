package org.laboratory.libraryapp.config;

import jakarta.annotation.PostConstruct;
import org.laboratory.libraryapp.model.Category;
import org.laboratory.libraryapp.service.AuthorService;
import org.laboratory.libraryapp.service.BookService;
import org.laboratory.libraryapp.service.CountryService;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public DataInitializer(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    private Category randomizePosition(int i) {
        if(i % 7 == 0) return Category.NOVEL;
        else if(i % 7 == 1) return Category.THRILLER;
        else if(i % 7 == 2) return Category.HISTORY;
        else if(i % 7 == 3) return Category.FANTASY;
        else if(i % 7 == 4) return Category.BIOGRAPHY;
        else if(i % 7 == 5) return Category.CLASSICS;
        return Category.DRAMA;
    }

    @PostConstruct
    public void initData() {
        for (int i = 1; i < 6; i++) {
            this.countryService.create("Country: " + i, "Continent: " + i);
        }

        for (int i = 1; i < 11; i++) {
            this.authorService.create("Author: " + i, "Surname: " + i , this.countryService.listAllCountries().get((i-1)%5).getId());
        }

        for (int i = 1; i < 11; i++) {
            this.bookService.create("Book: " + i, this.randomizePosition(i) , this.authorService.listAllAuthors().get((i-1)%10).getId(), i);
        }
    }
}
