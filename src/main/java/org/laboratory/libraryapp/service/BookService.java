package org.laboratory.libraryapp.service;

import org.laboratory.libraryapp.model.Author;
import org.laboratory.libraryapp.model.Book;
import org.laboratory.libraryapp.model.Category;
import org.laboratory.libraryapp.model.Country;

import java.util.List;

public interface BookService {

    /**
     * @return List of all books in the database
     */
    List<Book> listAllBooks();

    /**
     * returns the Book with the given id
     *
     * @param id The id of the Book that we want to obtain
     * @return
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidBookIdException when there is no Book with the given id
     */
    Book findById(Long id);

    /**
     * This method is used to create a new Book, and save it in the database.
     *
     * @param name
     * @param category
     * @param author
     * @param availableCopies
     * @return The Book that is created. The id should be generated when the Book is created.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidBookIdException when there is no book with the given id
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidAuthorIdException when there is no author with the given id
     */
    Book create(String name, Category category, Long author, int availableCopies);
    /**
     * This method is used to update a Book, and save it in the database.
     *
     * @param id The id of the Book that is being edited
     * @param name Name of the book
     * @param category Category of the book
     * @param author Id of the author of the book
     * @param availableCopies Available Copies
     * @return The Book that is updated.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidBookIdException when there is no Book with the given id
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidAuthorIdException when there is no author with the given id
     */
    Book update(Long id, String name, Category category, Long author, int availableCopies);

    /**
     * Method that should delete a Book. If the id is invalid, it should throw InvalidBookIdException.
     *
     * @param id - Id of the Book
     * @return The Book that is deleted.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidBookIdException when there is no Book with the given id
     */
    Book delete(Long id);

    /**
     * Method that should change the parameter rented for a Book. If the id is invalid, it should throw InvalidBookIdException.
     *
     * @param bookId Id of the Book
     * @param status status (True/False) whether the book is rented or not
     * @return The Book that is deleted.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidBookIdException when there is no Book with the given id
     */
    Book changeRentedStatus(Long bookId, boolean status);

    /**
     * Method that should change the number of available copies from certain book. If the id is invalid, it should throw InvalidBookIdException.
     *
     * @param bookId Id of the Book
     * @param numberOfCopies Number of copies to rent
     * @return The Book that is changed.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidBookIdException when there is no Book with the given id
     */
    Book rentCopiesFromBook(Long bookId, int numberOfCopies);

    /**
     * Method that should change the number of available copies from certain book. If the id is invalid, it should throw InvalidBookIdException.
     *
     * @param id Id of the Book
     * @return The Book that is changed.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidBookIdException when there is no Book with the given id
     */
    Book rentCopyFromBook(Long id);
}
