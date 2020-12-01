package net.toregard.reactiverjdbcbackend.resource;

import net.toregard.reactiverjdbcbackend.domain.Book;
import net.toregard.reactiverjdbcbackend.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

    private final BookRepository bookRepository;

    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    /*@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Book> findById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Book> save(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return bookRepository.deleteById(id);
    }*/

    @GetMapping(value = "/gammel", produces = "application/json")
    public List<Book> getallOld() {
        return getData();
    }

    @GetMapping(value = "/ping", produces = "application/json")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("OK");
    }


    private ArrayList<Book> getData() {
        ArrayList<Book> data = new ArrayList<>();
        data.add(new Book(1L, "name1", "auth1"));
        data.add(new Book(1L, "name1", "auth1"));
        data.add(new Book(1L, "name1", "auth1"));
        return data;
    }

}
