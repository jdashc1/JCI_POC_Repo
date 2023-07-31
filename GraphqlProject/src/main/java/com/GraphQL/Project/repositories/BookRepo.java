package com.GraphQL.Project.repositories;

import com.GraphQL.Project.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
