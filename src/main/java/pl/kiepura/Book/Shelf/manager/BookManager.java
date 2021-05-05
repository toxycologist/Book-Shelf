package pl.kiepura.Book.Shelf.manager;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kiepura.Book.Shelf.dto.AuthorDTO;
import pl.kiepura.Book.Shelf.entity.Book;
import pl.kiepura.Book.Shelf.repo.BookRepo;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookManager {

    private final BookRepo bookRepo;


    public Optional<Book> findById(Long id) {
        return bookRepo.findById(id);
    }

    public Iterable<Book> findAll(){
        return bookRepo.findAll();
    }

    public Book saveBook(Book book){
        return bookRepo.save(book);
    }

    public void deleteById(Long id){
        bookRepo.deleteById(id);
    }

    public List<AuthorDTO> getAuthors(){
        return bookRepo.getAuthors();
    }



}
