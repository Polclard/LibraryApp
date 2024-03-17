package org.laboratory.libraryapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.laboratory.libraryapp.model.Country;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private String name;
    private String surname;
    private Long countryId;
}
