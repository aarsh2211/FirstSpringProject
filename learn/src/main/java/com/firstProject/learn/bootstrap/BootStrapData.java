package com.firstProject.learn.bootstrap;

import com.firstProject.learn.domain.Author;
import com.firstProject.learn.domain.Book;
import com.firstProject.learn.domain.Publisher;
import com.firstProject.learn.repository.AuthorRepository;
import com.firstProject.learn.repository.BookRepository;
import com.firstProject.learn.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("First Book", "123123");
        Publisher publisher = new Publisher();
        publisher.setName("Aarsh Verdhan");
        publisher.setCity("Delhi");
        publisher.setAddressLine1("Rohini");
        publisher.setZip("110042");
        publisher.setState("New Delhi");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisherRepository.save(publisher);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        System.out.println("Count of Publisher -" + publisherRepository.count());
        Author rod = new Author("Rod", "Jackson");
        Book noEJB = new Book("J2EE Development without EJB", "3829938498");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Count of Books - " + bookRepository.count());

    }
}
