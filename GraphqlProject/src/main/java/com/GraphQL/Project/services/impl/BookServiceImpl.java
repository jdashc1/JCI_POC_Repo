package com.GraphQL.Project.services.impl;

import com.GraphQL.Project.entities.Book;
import com.GraphQL.Project.repositories.BookRepo;
import com.GraphQL.Project.services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

  private BookRepo bookRepo;

  @Autowired
  public BookServiceImpl(BookRepo bookRepo) {
    this.bookRepo = bookRepo;
  }

  @Override
  public Book create(Book book) {
    return this.bookRepo.save(book);
  }

  @Override
  public List<Book> getAllBooks() {
    return this.bookRepo.findAll();
  }

//  @Override
//  public Book getBook(int Book) {
//    return null;
//  }

  @Override
  public Book getBook(int bookId) {
    return this.bookRepo.findById(bookId).orElseThrow(()->new RuntimeException("Book you are looking for not found in server!!!"));
  }
}
