package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


//At runtime when Spring get a request to the URL (/booksChecking), it will execute the getBooks() method
//Spring will then provide a Model object to the getBooks() method
//getBooks() method then add attribute "books" to the model which has a list of books given by bookRepository
// this model returns back to the view layer called "booksList/list"

@Controller //make this class to Spring MVC controller
public class BookController {

    //Inject a bookRepository object into this controller
    private final BookRepository bookRepository;
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    //FROM CLIENT (REQUEST) TO CONTROLLER
    //Map this method to a specific URL
    //When we do an action against the URL (/booksChecking), this method is invoked by Spring MVC framework
    @RequestMapping("/booksChecking")
    //FROM CONTROLLER TO MODEL
    public String getBooks(Model model){ //Spring will provide a Model object and view will receive this model

        model.addAttribute("books", bookRepository.findAll());//Transfer the data by adding as a attribute in the model that will return to view

        //FROM CONTROLLER TO VIEW
        return "booksList/list"; //Here to tell Spring MVC where in VIEW should the method return to
        // In Thymeleaf root = src/resources/templates =>
        // e.g. return "booksList/list" =>
        // Spring MVC to return the model to the view in src/resources/templates/booksList/list.html
    }
}
