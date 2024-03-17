package org.laboratory.libraryapp.web.rest;

import org.laboratory.libraryapp.model.Book;
import org.laboratory.libraryapp.model.dto.BookDto;
import org.laboratory.libraryapp.service.AuthorService;
import org.laboratory.libraryapp.service.BookService;
import org.laboratory.libraryapp.service.CountryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin()
    @PostMapping(value = "/addBook", consumes = MediaType.APPLICATION_JSON_VALUE )
    public String addBook(@RequestBody BookDto book)
    {
        this.bookService.create(book.getName(), book.getCategory(), book.getAuthorId(), book.getAvailableCopies());
        return "redirect:/books";
    }

    @CrossOrigin
    @PostMapping(value = "/deleteBook/{id}")
    public String deleteBook(@PathVariable Long id)
    {
        this.bookService.delete(id);
        return "redirect:/books";
    }

    @CrossOrigin
    @PostMapping(value = "/changeRentedStatus/{id}")
    public String changeRentedStatus(@PathVariable Long id, @RequestParam boolean status)
    {
        this.bookService.changeRentedStatus(id, status);
        return "redirect:/books";
    }

    @CrossOrigin
    @PostMapping(value = "/editBook/{id}")
    public String editBook(@PathVariable Long id, @RequestBody BookDto book)
    {
        this.bookService.update(id, book.getName(), book.getCategory(), book.getAuthorId(), book.getAvailableCopies());
        return "redirect:/books";
    }

}
