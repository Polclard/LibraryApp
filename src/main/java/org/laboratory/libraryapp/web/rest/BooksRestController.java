package org.laboratory.libraryapp.web.rest;

import org.laboratory.libraryapp.model.Book;
import org.laboratory.libraryapp.model.Category;
import org.laboratory.libraryapp.model.dto.BookDto;
import org.laboratory.libraryapp.service.AuthorService;
import org.laboratory.libraryapp.service.BookService;
import org.laboratory.libraryapp.service.CountryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping(value = {"/api/books", "/api"})
public class BooksRestController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CountryService countryService;

    public BooksRestController(AuthorService authorService, BookService bookService, CountryService countryService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.countryService = countryService;
    }


    @GetMapping
    public List<Book> showAllBooks()
    {
        return bookService.listAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id)
    {
        return bookService.findById(id);
    }

    @PostMapping(value = "/addBook")
    public void addBook(@RequestBody BookDto book)
    {
        this.bookService.create(book.getName(), book.getCategory(), book.getAuthorId(), book.getAvailableCopies());
    }

    @PostMapping(value = "/deleteBook/{id}")
    public void deleteBook(@PathVariable Long id)
    {
        this.bookService.delete(id);
    }

    @PostMapping(value = "/changeRentedStatus/{id}")
    public void changeRentedStatus(@PathVariable Long id, @RequestParam boolean status)
    {
        this.bookService.changeRentedStatus(id, status);
    }

    @PostMapping(value = "/rentCopiesFromBook/{id}")
    public void rentCopiesFromBook(@PathVariable Long id, @RequestParam int numberOfCopiesToRent)
    {
        this.bookService.rentCopiesFromBook(id, numberOfCopiesToRent);
    }

    @PostMapping(value = "/rentCopyFromBook/{id}")
    public void rentCopiesFromBook(@PathVariable Long id)
    {
        this.bookService.rentCopyFromBook(id);
    }

    @PostMapping(value = "/editBook/{id}")
    public void editBook(@PathVariable Long id, @RequestBody BookDto book)
    {
        this.bookService.update(id, book.getName(), book.getCategory(), book.getAuthorId(), book.getAvailableCopies());
    }

    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories()
    {
        return Arrays.stream(Category.values()).toList();
    }

}
