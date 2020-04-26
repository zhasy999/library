package kz.iitu.library.controllers;

import kz.iitu.library.models.*;
import kz.iitu.library.services.BookService;
import kz.iitu.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @PostMapping("")
    public void addBook(@RequestBody Book book) {
        if (bookService.addBook(book)) {
            System.out.println("Book: " + book + " added");
            return;
        }
        System.out.println(book + " Book already exist");
    }

    @PatchMapping("/add/")
    public void addBookToUser(@RequestParam("userId") Long userId, @RequestParam("bookId") Long bookId) {
        if (bookService.addBookToUser(userId, bookId)) {
            System.out.println("Book added to " + userId);
        }
        System.out.println("Book already owned");
    }

    @PatchMapping("/return/")
    public void returnBookFromUser(@RequestParam("userId") Long userId, @RequestParam("bookId") Long bookId){
        bookService.returnBookFromUser(userId, bookId) ;
        System.out.println("Book returned");
        }

    @GetMapping("/{status}")
    public void findAllByStatus(@PathVariable("status")  Status status){
        System.out.println(bookService.findAllByStatus(status));
    }

    @GetMapping("/{title}")
    public Book findBookByName(@PathVariable("title")String title) {
        return bookService.findBookByName(title);
    }

    @GetMapping("/{author}")
    public Book findBookByAuthor(@PathVariable("author")String authorname){
        return bookService.findBookByAuthor(userService.findAuthorByName(authorname));
    }

    @DeleteMapping("/del")
    public void clear() {
        bookService.clear();
    }
}
