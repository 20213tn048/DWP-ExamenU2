package mx.edu.utez.examenU2.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>{
    
    List<Book> findAllByOrderByAuthorAsc();

    List<Book> findAllByOrderByPublicationDateAsc();
    
}
