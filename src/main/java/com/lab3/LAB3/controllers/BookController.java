package com.lab3.LAB3.controllers;

import com.lab3.LAB3.models.Book;
import com.lab3.LAB3.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookRepository bookRepo;

    @GetMapping("")
    public List<Book> listAll(Model model, @RequestParam(required = false) Integer year) {
        List<Book> listBooks = bookRepo.findAll();
        model.addAttribute("listBooks", listBooks);

        return listBooks;
    }

    @GetMapping("/{id}")
    public Optional<Book> one(Model model, @PathVariable(value = "id") Integer id) {
        Integer[] ids = {id};

        List<Integer> list = Arrays.asList(ids);

        return bookRepo.findById(id);
    }

    @PostMapping("")
    public String create(@RequestBody() Book book) {
        System.out.println("title: " + book.getTitle());
        bookRepo.save(book);

        return "Create was successful";
    }

    @PutMapping("/{id}")
    public String update(@RequestBody() Book book, @PathVariable(value = "id") Integer id) {
        book.setId(id);
        System.out.println("title: " + book.getTitle());
        bookRepo.save(book);

        return "Update was successful";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(value = "id") Integer id) {
        Book book = new Book();
        book.setId(id);
        bookRepo.delete(book);

        return "Delete was successful";
    }
}