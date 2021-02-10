package fi.js.BookStore.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jsaja
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByName(String name);

}
