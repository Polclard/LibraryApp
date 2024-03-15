package org.laboratory.libraryapp.service.implementation;

import org.laboratory.libraryapp.model.Country;
import org.laboratory.libraryapp.model.exceptions.InvalidCountryIdException;
import org.laboratory.libraryapp.repository.CountryRepository;
import org.laboratory.libraryapp.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImplementation implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImplementation(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
    }

    @Override
    public Country create(String name, String continent) {
        Country country = new Country(name, continent);

        countryRepository.save(country);

        return country;
    }

    @Override
    public Country update(Long id, String name, String continent) {
        Country country = countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);

        countryRepository.save(country);

        return country;
    }

    @Override
    public Country delete(Long id) {
        Country country = countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);

        countryRepository.delete(country);

        return country;
    }
}
