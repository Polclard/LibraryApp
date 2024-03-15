package org.laboratory.libraryapp.service;

import org.laboratory.libraryapp.model.Country;
import org.laboratory.libraryapp.model.Category;

import java.util.List;

public interface CountryService {

    /**
     * @return List of all countries in the database
     */
    List<Country> listAllCountries();

    /**
     * returns the Country with the given id
     *
     * @param id The id of the Country that we want to obtain
     * @return
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidCountryIdException when there is no Country with the given id
     */
    Country findById(Long id);

    /**
     * This method is used to create a new Country, and save it in the database.
     *
     * @param name - The name of the Country
     * @param continent - The continent on which it belongs
     * @return The Country that is created. The id should be generated when the Country is created.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidCountryIdException when there is no country with the given id
     */
    Country create(String name, String continent);

    /**
     * This method is used to update a Country, and save it in the database.
     *
     * @param id The id of the Country that is being edited
     * @param name - The name of the Country
     * @param continent - The continent on which it belongs
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidCountryIdException when there is no Country with the given id
     */
    Country update(Long id, String name, String continent);

    /**
     * Method that should delete a Country. If the id is invalid, it should throw InvalidCountryException.
     *
     * @param id - Id of the Country
     * @return The Country that is deleted.
     * @throws org.laboratory.libraryapp.model.exceptions.InvalidCountryIdException when there is no Country with the given id
     */
    Country delete(Long id);
}
