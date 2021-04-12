package pl.kiepura.Book.Shelf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookShelfApi {

    private BookManager bookManager;

    @Autowired
    public BookShelfApi(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @GetMapping("/all")
    public Iterable<Book> getAll(){
        return bookManager.findAll();
    }

    @GetMapping
    public Optional<Book> getById(@RequestParam Long index){
        return bookManager.findById(index);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookManager.saveBook(book);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return bookManager.saveBook(book);
    }

    @DeleteMapping
    public void deleteBook(@RequestParam Long index) {
        bookManager.deleteById(index);
    }

}
