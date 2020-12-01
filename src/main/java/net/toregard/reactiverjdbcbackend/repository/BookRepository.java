package net.toregard.reactiverjdbcbackend.repository;

import net.toregard.reactiverjdbcbackend.domain.Book;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface BookRepository extends R2dbcRepository<Book,Long> {
}
