package pl.kiepura.Book.Shelf;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kiepura.Book.Shelf.entity.Book;
import pl.kiepura.Book.Shelf.manager.BookManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookShelfApi {

    private final BookManager bookManager;

    @Autowired
    public BookShelfApi(BookManager bookManager) {
        this.bookManager = bookManager;
    }


    @ApiOperation(value = "Shows all books added to virutal book shelf")
    @GetMapping("/all")
    public Iterable<Book> getAll(){
        return bookManager.findAll();
    }

    @ApiOperation(value = "Shows selected book on virutal book shelf by provided ID")
    @GetMapping
    public Optional<Book> getById(@RequestParam Long index){
        return bookManager.findById(index);
    }

    @ApiOperation(value = "Add a new book to virutal book shelf")
    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookManager.saveBook(book);
    }

    @ApiOperation(value = "Update book on virutal book shelf")
    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return bookManager.saveBook(book);
    }

    @ApiOperation(value = "Delete one book from virutal book shelf by provided ID")
    @DeleteMapping
    public void deleteBook(@RequestParam Long index) {
        bookManager.deleteById(index);
    }

}
