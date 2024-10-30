package com.mesh.spring6webapp.services;

import com.mesh.spring6webapp.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
