package fi.js.BookStore.web;

import fi.js.BookStore.domain.Book;
import fi.js.BookStore.domain.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jsaja
 */
@Controller
public class BookController {

    @Autowired
    private BookRepository repository;

    @GetMapping("/index")
    public String handleRequests(@RequestParam(name = "author", defaultValue = "") String author, Model model) {
        Book book = new Book();
        book.setAuthor(author);
        model.addAttribute("book", book);
        return "/index";
    }

    @GetMapping("")
    public String defaultSivu() {
        return "Hi";
    }

    public void searchByTitle(String title) {
        List<Book> books = repository.findByTitle(title);
    }

    @RequestMapping(value = {"/", "/booklist"})
    public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long bookId) {
        repository.deleteById(bookId);
        return "redirect:../booklist";
    }
    
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", repository.findById(bookId));
        return "editbook";
    }

}
