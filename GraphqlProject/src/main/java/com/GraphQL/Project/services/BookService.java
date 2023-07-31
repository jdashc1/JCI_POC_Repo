package com.GraphQL.Project.services;

import com.GraphQL.Project.entities.Book;
import java.util.List;

public interface BookService {

  //create book
  Book create(Book book);
  //Get all Books
  List<Book> getAllBooks();
  //get a single book
  Book getBook(int Book);

}
