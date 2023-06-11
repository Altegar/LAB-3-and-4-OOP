package com.lab3.LAB3.repos;

import com.lab3.LAB3.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}