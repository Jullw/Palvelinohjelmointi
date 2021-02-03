package fi.js.BookStore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jsaja
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
