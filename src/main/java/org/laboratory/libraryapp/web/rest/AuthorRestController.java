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
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping(value = {"/api/authors"})
public class AuthorRestController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> showAllAuthors()
    {
        return this.authorService.listAllAuthors();
    }

    @PostMapping(value = "/addAuthor", consumes = MediaType.APPLICATION_JSON_VALUE )
    public void addAuthor(@RequestBody AuthorDto author)
    {
        this.authorService.create(author.getName(), author.getSurname(), author.getCountryId());
    }

    @PostMapping(value = "/deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable Long id)
    {
        this.authorService.delete(id);
    }


    @PostMapping(value = "/editAuthor/{id}")
    public void editAuthor(@PathVariable Long id, @RequestBody AuthorDto author)
    {
        this.authorService.update(id, author.getName(), author.getSurname(), author.getCountryId());
    }
}
