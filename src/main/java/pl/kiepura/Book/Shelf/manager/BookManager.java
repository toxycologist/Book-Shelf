package pl.kiepura.Book.Shelf.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.kiepura.Book.Shelf.entity.Book;
import pl.kiepura.Book.Shelf.entity.Genre;
import pl.kiepura.Book.Shelf.repo.BookRepo;

import java.util.Optional;

@Service
public class BookManager {

    private final BookRepo bookRepo;

    @Autowired
    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

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

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        saveBook(new Book(1L, "Metro 2033", "Dmitrij Głuchowski", Genre.POSTAPO));
        saveBook(new Book(2L, "Metro 2034", "Dmitrij Głuchowski", Genre.POSTAPO));
        saveBook(new Book(3L, "Metro 2035", "Dmitrij Głuchowski", Genre.POSTAPO));
        saveBook(new Book(4L, "Droga Szamana: Początek", "Wasilij Machanienko", Genre.LitRPG));
        saveBook(new Book(5L, "Droga Szamana: Gambit Kartosa", "Wasilij Machanienko", Genre.LitRPG));
        saveBook(new Book(6L, "Droga Szamana: Tajemnica Mrocznego Lasu", "Wasilij Machanienko", Genre.LitRPG));
        saveBook(new Book(7L, "Droga Szamana: Zamek Widmo", "Wasilij Machanienko", Genre.LitRPG));
    }

}
