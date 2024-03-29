package org.laboratory.libraryapp.web.rest;

import lombok.RequiredArgsConstructor;
import org.laboratory.libraryapp.model.Author;
import org.laboratory.libraryapp.model.dto.AuthorDto;
import org.laboratory.libraryapp.service.AuthorService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorRestController {

    private final AuthorService authorService;

    @CrossOrigin()
    @GetMapping("/authors")
    public List<Author> showAllAuthors()
    {
        return this.authorService.listAllAuthors();
    }

    @CrossOrigin()
    @PostMapping(value = "/addAuthor", consumes = MediaType.APPLICATION_JSON_VALUE )
    public void addAuthor(@RequestBody AuthorDto author)
    {
        this.authorService.create(author.getName(), author.getSurname(), author.getCountryId());
    }

    @CrossOrigin
    @PostMapping(value = "/deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable Long id)
    {
        this.authorService.delete(id);
    }


    @CrossOrigin
    @PostMapping(value = "/editAuthor/{id}")
    public void editAuthor(@PathVariable Long id, @RequestBody AuthorDto author)
    {
        this.authorService.update(id, author.getName(), author.getSurname(), author.getCountryId());
    }
}
