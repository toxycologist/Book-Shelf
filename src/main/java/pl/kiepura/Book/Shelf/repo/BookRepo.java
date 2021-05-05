package pl.kiepura.Book.Shelf.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kiepura.Book.Shelf.dto.AuthorDTO;
import pl.kiepura.Book.Shelf.entity.Book;

import java.util.List;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {


    @Query(value = "SELECT DISTINCT author FROM book", nativeQuery = true)
    List<AuthorDTO> getAuthors();


}
