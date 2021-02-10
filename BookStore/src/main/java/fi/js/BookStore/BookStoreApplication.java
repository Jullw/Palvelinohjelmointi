package fi.js.BookStore;

import fi.js.BookStore.domain.Book;
import fi.js.BookStore.domain.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fi.js.BookStore.domain.Category;
import fi.js.BookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    public class ComandLineRunner {

        @Bean
        public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
            return (args) -> {

                crepository.save(new Category("Horror"));
                crepository.save(new Category("Triller"));
                crepository.save(new Category("Novel"));
                crepository.save(new Category("Haiku"));
                

                repository.save(new Book("Hello", "Hello", "Hello", 10, 10, crepository.findByName("Horror").get(0)));
                repository.save(new Book("Hellodsa", "Helladso", "Hesdallo", 110, 10, crepository.findByName("Horror").get(0)));
                for (Book book : repository.findAll()) {
                    System.out.println(book.toString());
                }
            };
        }

    }
}
