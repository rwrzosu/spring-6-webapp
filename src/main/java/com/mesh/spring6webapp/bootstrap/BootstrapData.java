package com.mesh.spring6webapp.bootstrap;

import com.mesh.spring6webapp.domain.Author;
import com.mesh.spring6webapp.domain.Book;
import com.mesh.spring6webapp.domain.Publisher;
import com.mesh.spring6webapp.repositories.AuthorRepository;
import com.mesh.spring6webapp.repositories.BookRepository;
import com.mesh.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setPublisherName("Publisher 1");
        publisher = publisherRepository.save(publisher);

        Book book1 = new Book();
        book1.setTitle("title1");
        book1.setIsbn("isbn1");
        book1.setPublisher(publisher);
        book1 = bookRepository.save(book1);
        Book book2 = new Book();
        book2.setTitle("title2");
        book2.setIsbn("isbn2");
        book2.setPublisher(publisher);
        book2 = bookRepository.save(book2);

        Author author1 = new Author();
        author1.setFirstName("autror1");
        author1.setLastName("autror11");
        author1.getBooks().add(book1);
        author1 = authorRepository.save(author1);
        Author author2 = new Author();
        author2.setFirstName("autror2");
        author2.setLastName("autror22");
        author2.getBooks().add(book2);
        author2 = authorRepository.save(author2);

        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());

    }
}
