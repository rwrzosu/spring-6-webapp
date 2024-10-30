package com.mesh.spring6webapp.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String publisherName;
    private String address;
    private String city;
    private String state;
    private String zipCode;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;
}
