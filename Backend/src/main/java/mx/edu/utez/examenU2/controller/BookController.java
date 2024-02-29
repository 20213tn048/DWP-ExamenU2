package mx.edu.utez.examenU2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mx.edu.utez.examenU2.model.Book;
import mx.edu.utez.examenU2.service.BookService;
import mx.edu.utez.examenU2.utils.CustomResponse;

@RestController @RequestMapping("/api/books") @CrossOrigin(origins = {"*"})
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public CustomResponse<List<Book>> getAll(){
        return this.service.getAllBooks();
    }

    @GetMapping("/author")
    public CustomResponse<List<Book>> getByAuthor(){
        return this.service.getAllBooksByAuthor();
    }

    @GetMapping("/date")
    public CustomResponse<List<Book>> getByPublicationDate(){
        return this.service.getAllBooksByPublicationDate();
    }

    @PostMapping("/")
    public CustomResponse<Book> insert(@RequestBody Book book){
        return this.service.addNewBook(book);
    }

    @PutMapping("/{id}")
    public CustomResponse<Book> update(@PathVariable("id") Long id, @RequestBody Book book){
        return this.service.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public CustomResponse<String> delete(@PathVariable("id") Long id){
        return this.service.deleteBook(id);
    }
}
