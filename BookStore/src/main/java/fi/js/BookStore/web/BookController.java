package fi.js.BookStore.web;

import fi.js.BookStore.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jsaja
 */
@Controller
public class BookController {

    @GetMapping("/index")
    public String handleRequests(@RequestParam(name = "author" , defaultValue = "") String author, Model model) {
        Book book = new Book();
        book.setAuthor(author);
        model.addAttribute("book", book);
        return "/index";
    }
}