package org.laboratory.libraryapp.service.implementation;

import org.laboratory.libraryapp.model.Book;
import org.laboratory.libraryapp.model.Category;
import org.laboratory.libraryapp.model.events.BookCreatedEvent;
import org.laboratory.libraryapp.model.events.BookDeletedEvent;
import org.laboratory.libraryapp.model.events.BookUpdatedEvent;
import org.laboratory.libraryapp.model.exceptions.InvalidAuthorIdException;
import org.laboratory.libraryapp.model.exceptions.InvalidBookIdException;
import org.laboratory.libraryapp.model.exceptions.InvalidCountryIdException;
import org.laboratory.libraryapp.model.exceptions.NotEnoughNumberOfCopiesException;
import org.laboratory.libraryapp.repository.AuthorRepository;
import org.laboratory.libraryapp.repository.BookRepository;
import org.laboratory.libraryapp.service.BookService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public BookServiceImplementation(BookRepository bookRepository, AuthorRepository authorRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
    }

    @Override
    public Book create(String name, Category category, Long author, int availableCopies) {
        Book book = new Book(name, category, authorRepository.findById(author).orElseThrow(InvalidAuthorIdException::new), availableCopies);

        bookRepository.save(book);

        this.applicationEventPublisher.publishEvent(new BookCreatedEvent(book));

        return book;
    }

    @Override
    public Book update(Long id, String name, Category category, Long author, int availableCopies) {
        Book book = bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(authorRepository.findById(author).orElseThrow(InvalidAuthorIdException::new));
        book.setAvailableCopies(availableCopies);

        bookRepository.save(book);

        this.applicationEventPublisher.publishEvent(new BookUpdatedEvent(book));

        return book;
    }

    @Override
    public Book delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);

        this.applicationEventPublisher.publishEvent(new BookDeletedEvent(book));

        bookRepository.delete(book);

        return book;
    }

    @Override
    public Book changeRentedStatus(Long bookId, boolean status) {
        Book book = bookRepository.findById(bookId).orElseThrow(InvalidBookIdException::new);

        book.setRented(status);

        bookRepository.save(book);

        return book;
    }

    @Override
    public Book rentCopiesFromBook(Long bookId, int numberOfCopies) {
        Book book = bookRepository.findById(bookId).orElseThrow(InvalidBookIdException::new);


        if(book.getAvailableCopies() - numberOfCopies >= 0)
        {
            book.setAvailableCopies(book.getAvailableCopies()-numberOfCopies);
            bookRepository.save(book);
        }
        else
        {
            throw new NotEnoughNumberOfCopiesException();
        }
        return book;
    }

    @Override
    public Book rentCopyFromBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
        if(book.getAvailableCopies() - 1 >= 0)
        {
            book.setAvailableCopies(book.getAvailableCopies()-1);
            bookRepository.save(book);
        }
        else
        {
            throw new NotEnoughNumberOfCopiesException();
        }
        return book;
    }
}
