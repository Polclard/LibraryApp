package org.laboratory.libraryapp.service.implementation;

import lombok.RequiredArgsConstructor;
import org.laboratory.libraryapp.model.Author;
import org.laboratory.libraryapp.model.Country;
import org.laboratory.libraryapp.model.exceptions.InvalidAuthorIdException;
import org.laboratory.libraryapp.model.exceptions.InvalidCountryIdException;
import org.laboratory.libraryapp.repository.AuthorRepository;
import org.laboratory.libraryapp.repository.CountryRepository;
import org.laboratory.libraryapp.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImplementation implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    @Override
    public List<Author> listAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
    }

    @Override
    public Author create(String name, String surname, Long country) {
        Author author = new Author(name, surname, countryRepository.findById(country).orElseThrow(InvalidCountryIdException::new));

        authorRepository.save(author);

        return author;
    }

    @Override
    public Author update(Long id, String name, String surname, Long country) {
        Author author = authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);

        author.setName(name);
        author.setSurname(name);
        author.setCountry(countryRepository.findById(country).orElseThrow(InvalidCountryIdException::new));

        authorRepository.save(author);
        return author;
    }

    @Override
    public Author delete(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);

        authorRepository.delete(author);

        return author;
    }
}
