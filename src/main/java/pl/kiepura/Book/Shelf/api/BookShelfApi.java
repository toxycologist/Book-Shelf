package pl.kiepura.Book.Shelf.api;


import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kiepura.Book.Shelf.dto.AuthorDTO;
import pl.kiepura.Book.Shelf.entity.Book;
import pl.kiepura.Book.Shelf.manager.BookManager;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookShelfApi {

    private final BookManager bookManager;



    @ApiOperation(value = "Shows all books added to virutal book shelf")
    @GetMapping("/all")
    public Iterable<Book> getAll(){
        return bookManager.findAll();
    }

    @ApiOperation(value = "Shows all authors of added collection of books")
    @GetMapping("/authors")
    public List<AuthorDTO> getAuthors(){
        return bookManager.getAuthors();
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
    public void deleteBook(@RequestParam Long index)
    {
        bookManager.deleteById(index);
    }





}
