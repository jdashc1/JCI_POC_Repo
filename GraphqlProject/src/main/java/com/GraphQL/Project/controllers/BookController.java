package com.GraphQL.Project.controllers;

import com.GraphQL.Project.entities.Book;
import com.GraphQL.Project.services.BookService;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@RestController
//@RequestMapping("/Book")
@Controller
public class BookController {
  @Autowired
  private BookService bookService;
  //@PostMapping

  @MutationMapping("createBook")
  public Book create(@Argument BookInput book){
    Book b = new Book();
    b.setAuthor(book.getAuthor());
    b.setTitle(book.getTitle());
    b.setDescription(book.getDescription());
    b.setPrice(book.getPrice());
    return this.bookService.create(b);
  }
  @QueryMapping("allBooks")
  public List<Book> getAllBooks(){
    return this.bookService.getAllBooks();
  }
  //@GetMapping("/{bookId}")
  @QueryMapping("getBook")
  public Book get(@Argument int bookId){
    return this.bookService.getBook(bookId);
  }
}

@Setter
@Getter
class BookInput{
  private String title;
  private String description;
  private String author;
  private double price;
}