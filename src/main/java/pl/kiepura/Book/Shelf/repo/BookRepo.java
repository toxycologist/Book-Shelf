package pl.kiepura.Book.Shelf.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kiepura.Book.Shelf.entity.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
}
