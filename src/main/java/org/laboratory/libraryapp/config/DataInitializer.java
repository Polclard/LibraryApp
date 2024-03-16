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

    // region Data
    private final String[] bookTitles = {
            "To Kill a Mockingbird",
            "1984",
            "The Great Gatsby",
            "Pride and Prejudice",
            "The Catcher in the Rye",
            "The Hobbit",
            "Fahrenheit 451",
            "Moby-Dick",
            "Brave New World",
            "The Lord of the Rings"
    };

    private final String[] authorFirstNames = {
            "Harper",
            "George",
            "F. Scott",
            "Jane",
            "J.D.",
            "J.R.R.",
            "Ray",
            "Herman",
            "Aldous",
            "J.R.R."
    };

    private final String[] authorLastNames = {
            "Lee",
            "Orwell",
            "Fitzgerald",
            "Austen",
            "Salinger",
            "Tolkien",
            "Bradbury",
            "Melville",
            "Huxley",
            "Tolkien"
    };

    private final String[] authorCountries = {
            "United States",
            "United Kingdom",
            "United States",
            "United Kingdom",
            "United States",
            "United Kingdom",
            "United States",
            "United States",
            "United Kingdom",
            "United Kingdom"
    };

    private final String[] authorContinents = {
            "North America",
            "Europe",
            "North America",
            "Europe",
            "North America",
            "Europe",
            "North America",
            "North America",
            "Europe",
            "Europe"
    };
    //endregion
    @PostConstruct
    public void initData() {
        for (int i = 1; i < authorCountries.length; i++) {
            this.countryService.create(authorCountries[i], authorContinents[i]);
        }

        for (int i = 1; i < authorFirstNames.length; i++) {
            this.authorService.create(authorFirstNames[i], authorLastNames[i], this.countryService.listAllCountries().get((i-1)%5).getId());
        }

        for (int i = 1; i < bookTitles.length; i++) {
            this.bookService.create(bookTitles[i], this.randomizePosition(i) , this.authorService.listAllAuthors().get((i-1)%10).getId(), i);
        }
    }
}
