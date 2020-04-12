package kz.iitu.library;

import kz.iitu.library.controllers.BookController;
import kz.iitu.library.controllers.GenreController;
import kz.iitu.library.controllers.UserController;
import kz.iitu.library.models.*;
import org.hibernate.engine.internal.Collections;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LibraryApplication.class);
//
//        //Controllers
//        UserController userController = context.getBean("userController", UserController.class);
//        BookController bookController = context.getBean("bookController", BookController.class);
//        GenreController genreController = context.getBean("genreController", GenreController.class);
//
//        // Authors
//        userController.addAuthor(new Author("L.Tolstoy"));
//        userController.addAuthor(new Author("M.Auezov"));
//
//        // Genres
//        genreController.addGenre(new Genre("Biography"));
//        genreController.addGenre(new Genre("Historical"));
//
//        // Books
//        Book book = new Book();
//        book.setTitle("Abay");
//        bookController.addBook(book);
//        book.setAuthors(Collections.singletonList(userController.findAuthorByName("M.Auezov")));
//        book.setGenres(Collections.singletonList(genreController.findGenreByName("Biography")));
//
//
//        Book book1 = new Book();
//        book1.setTitle("Voina");
//        bookController.addBook(book1);
//        book1.setAuthors(Collections.singletonList(userController.findAuthorByName("L.Tolstoy")));
//        book1.setGenres(Collections.singletonList(genreController.findGenreByName("Historical")));
//
//
//        // Users
//        User user = new User();
//        user.setName("Zhaskanat");
//        user.setType(Type.NEWBIE);
//        userController.addUser(user);
//
//        User user1 = new User();
//        user1.setName("Yerassyl");
//        user1.setType(Type.EXPERT); // expert can handle book 30 days
//        userController.addUser(user1);
//
//
//
//
//
//        bookController.findAllByStatus(Status.AVAILABLE);
//
//        userController.addBook(user.getId(), book.getId());
//        userController.addBook(user1.getId(), book1.getId());
//
//        bookController.findAllByStatus(Status.REQUESTED);
//
//// add books to users
//        bookController.addBookToUser(user.getId(), book.getId());
//        bookController.addBookToUser(user1.getId(), book1.getId());
//
//        bookController.findAllByStatus(Status.ISSUED);
//
////Return book
//        bookController.returnBookFromUser(user.getId(),book.getId());
//
//
//        bookController.findAllByStatus(Status.AVAILABLE);


// Clear db
//        bookController.clear();
//        genreController.clear();
//        userController.clear();

//    }
}
