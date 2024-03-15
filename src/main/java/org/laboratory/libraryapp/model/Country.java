package org.laboratory.libraryapp.model;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

@Table(name="author_country")
@Data
@Entity
public class Country {
    // id (Long),
    // name (String),
    // continent (String)

    public Country()
    {

    }

    public Country(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String continent;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
