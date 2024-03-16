package org.laboratory.libraryapp.web.rest;

import org.laboratory.libraryapp.model.Book;
import org.laboratory.libraryapp.service.AuthorService;
import org.laboratory.libraryapp.service.BookService;
import org.laboratory.libraryapp.service.CountryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksRestController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public BooksRestController(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }

    /**
     * This returns the list (JSON format) of all the books in the database
     * @return bookService.listAllBooks().
     */
    @CrossOrigin()
    @GetMapping({"/", "/books"})
    public List<Book> showAllBooks()
    {
        List<Book> allBooks = bookService.listAllBooks();
        return allBooks;
    }

}
