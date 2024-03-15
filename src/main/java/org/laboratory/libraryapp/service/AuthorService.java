package org.laboratory.libraryapp.service;

import org.laboratory.libraryapp.model.Author;
import org.laboratory.libraryapp.model.Country;

import java.util.List;

public interface AuthorService {

    /**
     * @return List of all authors in the database
     */
    List<Author> listAllAuthors();

    /**
     * returns the author with the given id
     *
     * @param id The id of the author that we want to obtain
     * @return
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidAuthorIdException when there is no author with the given id
     */
    Author findById(Long id);

    /**
     * This method is used to create a new Author, and save it in the database.
     *
     * @param name
     * @param surname
     * @param country
     * @return The Author that is created. The id should be generated when the Author is created.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidCountryIdException when there is no team with the given id
     */
    Author create(String name, String surname, Long country);

    /**
     * This method is used to update an Author, and save it in the database.
     *
     * @param id The id of the Author that is being edited
     * @param name
     * @param surname
     * @param country
     * @return The Author that is updated.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidAuthorIdException when there is no Author with the given id
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidCountryIdException when there is no country with the given id
     */
    Author update(Long id, String name, String surname, Long country);

    /**
     * Method that should delete an Author. If the id is invalid, it should throw InvalidAuthorIdException.
     *
     * @param id
     * @return The Author that is deleted.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidAuthorIdException when there is no Author with the given id
     */
    Author delete(Long id);
}
