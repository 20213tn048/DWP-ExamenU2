package mx.edu.utez.examenU2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mx.edu.utez.examenU2.model.Book;
import mx.edu.utez.examenU2.model.BookRepository;
import mx.edu.utez.examenU2.utils.CustomResponse;

@Service
public class BookService {
    
    @Autowired
    private BookRepository repository;


    /*
     *   METODO GET: http://localhost:8080/api/books/ 
    */

    public CustomResponse<List<Book>> getAllBooks(){
        try{
            List<Book> books = repository.findAll();

            if(books.isEmpty()){
                return new CustomResponse<>(null, true, HttpStatus.NOT_FOUND.value(),"No se encontraron registros en la base de datos");
            }

            return new CustomResponse<>(books, true, HttpStatus.OK.value(),"Lista de libros");
        }catch(Exception e){
            return new CustomResponse<>(null, true, HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error");
        }
    }


    /*
     *  METODO GET: http://localhost:8080/api/books/author
     */
    public CustomResponse<List<Book>> getAllBooksByAuthor(){
        try{
            List<Book> bookList = repository.findAllByOrderByAuthorAsc();

            if(bookList.isEmpty()){
                return new CustomResponse<>(null, true, HttpStatus.NOT_FOUND.value(),"No se encontraron registros en la base de datos");
            }
            return new CustomResponse<>(bookList, true, HttpStatus.OK.value(),"Lista de libros");
        }catch(Exception e){
            return new CustomResponse<>(null, true, HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error");
        }
    }

    /*
     * METODO GET: http://localhost:8080/api/books/date
     */

    public CustomResponse<List<Book>> getAllBooksByPublicationDate(){
        try{
            List<Book> listBook = repository.findAllByOrderByPublicationDateAsc();
            if(listBook.isEmpty()){
                return new CustomResponse<>(null, true, HttpStatus.NOT_FOUND.value(),"No se encontraron registros en la base de datos");
            }
            return new CustomResponse<>(listBook, false, HttpStatus.OK.value(),"Lista de libros");
        }catch(Exception e){
            return new CustomResponse<>(null, true, HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error");
        }
    }

    /*
     *  METODO POST: http://localhost:8080/api/books/
     *  REQUEST BODY:{
     *      'title': '', <-- String
     *      'author': '', <-- String
     *      'publicationDate':'', <-- Date
     *      'image': '', <-- String (Optional to upload)
     *  } 
     */
    
    //TODO: Implementar lo de las imágenes
    public CustomResponse<Book> addNewBook(Book book){
        try{
            return new CustomResponse<>(repository.saveAndFlush(book), false, HttpStatus.OK.value(), "Libro registrado correctamente");
        }catch(Exception e){    
            return new CustomResponse<>(null, true, HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error");
        }
    }


        /*
     *  METODO PUT: http://localhost:8080/api/books/{id}
     *  PATH VARIABLE: id <-- Long
     *  REQUEST BODY:{
     *      'title': '', <-- String
     *      'author': '', <-- String
     *      'publicationDate':'', <-- Date
     *      'image': '', <-- String (Optional to upload)
     *  } 
     */
    //TODO: Implementar lo de las imágenes
    public CustomResponse<Book> updateBook(Long id, Book book){
        try{
            Optional<Book> findBook = repository.findById(id);

            if(findBook.isPresent()){
                Book existBook = findBook.get();
                existBook.setTitle(book.getTitle());
                existBook.setAuthor(book.getAuthor());
                existBook.setPublicationDate(book.getPublicationDate());
                existBook.setImage(book.getImage());
                return new CustomResponse<>(repository.saveAndFlush(existBook),false, HttpStatus.OK.value(),"Libro actualizado correctamente");
            }

            return new CustomResponse<>(null, true, HttpStatus.NOT_FOUND.value(),"Libro no encontrado");
        }catch(Exception e){
            return new CustomResponse<>(null, true, HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error");
        }
    }

    /*
     * METODO DELETE: http://localhost:8080/api/books/{id}
     * PATH VARIABLE: id <-- Long
     */
    public CustomResponse<String> deleteBook(Long id){
        try{
            Optional<Book> existBook = repository.findById(id);

            if(existBook.isPresent()){
                repository.deleteById(id);
                return new CustomResponse<>(null,false, HttpStatus.OK.value(),"Libro eliminado correctamente");
            }

            return new CustomResponse<>(null, true, HttpStatus.NOT_FOUND.value(),"Libro no encontrado");
        }catch(Exception e){
            return new CustomResponse<>(null, true, HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server Error");
        }
    }
}
