package com.GraphQL.Project;

import com.GraphQL.Project.entities.Book;
import com.GraphQL.Project.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlProjectApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(GraphqlProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book = new Book();
		book.setId(1);
		book.setTitle("complete reference");
		book.setDescription("find the books");
		book.setAuthor("Sudha Murthy");
		book.setPrice(1000);

		Book book1 = new Book();
		book1.setId(2);
		book1.setTitle("complete reference");
		book1.setDescription("get the books");
		book1.setAuthor("abbb");
		book1.setPrice(2000);

		Book book2 = new Book();
		book2.setId(3);
		book2.setTitle("complete reference");
		book2.setDescription("get the books");
		book2.setAuthor("abbb");
		book2.setPrice(2000);

		this.bookService.create(book);
		this.bookService.create(book1);
		this.bookService.create(book2);

	}
}
