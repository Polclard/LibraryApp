package org.laboratory.libraryapp.web.rest;

import lombok.RequiredArgsConstructor;
import org.laboratory.libraryapp.model.Author;
import org.laboratory.libraryapp.model.Country;
import org.laboratory.libraryapp.model.dto.AuthorDto;
import org.laboratory.libraryapp.model.dto.CountryDto;
import org.laboratory.libraryapp.service.CountryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryRestController {

    private final CountryService countryService;

    @CrossOrigin()
    @GetMapping("/countries")
    public List<Country> showAllCountries()
    {
        return this.countryService.listAllCountries();
    }

    @CrossOrigin()
    @PostMapping(value = "/addCountry", consumes = MediaType.APPLICATION_JSON_VALUE )
    public void addCountry(@RequestBody CountryDto countryDto)
    {
        this.countryService.create(countryDto.getName(), countryDto.getContinent());
    }

    @CrossOrigin
    @PostMapping(value = "/deleteCountry/{id}")
    public void deleteCountry(@PathVariable Long id)
    {
        this.countryService.delete(id);
    }


    @CrossOrigin
    @PostMapping(value = "/editCountry/{id}")
    public void editCountry(@PathVariable Long id, @RequestBody CountryDto country)
    {
        this.countryService.update(id, country.getName(), country.getContinent());
    }

}
