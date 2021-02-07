package net.toregard.reactiverjdbcbackend.resource;

/*import hello.A;*/

import net.toregard.reactiverjdbcbackend.domain.Book;
import net.toregard.reactiverjdbcbackend.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

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

    final String urlServer = "http://localhost:8081";

    @GetMapping("/{param}")
    public Mono<ResponseEntity<Mono<String>>> testGet(@PathVariable String param) {
        final long dateStarted = System.currentTimeMillis();

        WebClient webClient = WebClient.create(urlServer + "/server/");
        Mono<ClientResponse> respuesta = webClient.get().uri("?queryParam={name}", param).exchange();
        Mono<ClientResponse> respuesta1 = webClient.get().uri("?queryParam={name}", "SPEED".equals(param) ? "SPEED" : "STOP").exchange();

        Mono<ResponseEntity<Mono<String>>> f1 = Mono.zip(respuesta, respuesta1)
                .map(t -> {
                    if (!t.getT1().statusCode().is2xxSuccessful()) {
                        return ResponseEntity.status(t.getT1().statusCode()).body(t.getT1().bodyToMono(String.class));
                    }
                    if (!t.getT2().statusCode().is2xxSuccessful()) {
                        return ResponseEntity.status(t.getT2().statusCode()).body(t.getT2().bodyToMono(String.class));
                    }
                    return ResponseEntity.ok().body(Mono.just(
                            "All OK. Seconds elapsed: " + (((double) (System.currentTimeMillis() - dateStarted) / 1000))));
                });
        return f1;
    }

    @GetMapping(value = "/gammel", produces = "application/json")
    public List<Book> getallOld() {
        return getData();
    }

   /* @GetMapping(value = "/ping", produces = "application/json")
    public ResponseEntity<String> ping() {
        A a = new A("Hello");
        return ResponseEntity.ok("OK");
    }*/


    private ArrayList<Book> getData() {
        ArrayList<Book> data = new ArrayList<>();
        data.add(new Book(1L, "name1", "auth1"));
        data.add(new Book(1L, "name1", "auth1"));
        data.add(new Book(1L, "name1", "auth1"));
        return data;
    }


}
