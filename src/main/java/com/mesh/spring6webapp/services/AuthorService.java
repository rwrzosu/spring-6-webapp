package com.mesh.spring6webapp.services;

import com.mesh.spring6webapp.domain.Author;

public interface AuthorService {
    Iterable<Author> findAll();
}
