package com.entrelineas.proyectobackend.service;

import com.entrelineas.proyectobackend.entity.Books;
import com.entrelineas.proyectobackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Books> list(){
        return bookRepository.findAll();
    }

    public Optional<Books> getOne(int id){
        return bookRepository.findById(id);
    }

    public Optional<Books> getByNameB(String nameB){
        return bookRepository.findByNameB(nameB);
    }

    public void  save(Books books){
        bookRepository.save(books);
    }

    public boolean existsById(int id){
        return bookRepository.existsById(id);
    }

    public boolean existsByNameB(String nameB){
        return bookRepository.existsByNameB(nameB);
    }
}
