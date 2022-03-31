package com.entrelineas.proyectobackend.controller;


import com.entrelineas.proyectobackend.dto.BookDTO;
import com.entrelineas.proyectobackend.dto.Message;
import com.entrelineas.proyectobackend.entity.Books;
import com.entrelineas.proyectobackend.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public ResponseEntity<List<Books>> list(){
        List<Books> list = bookService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/search/{nombre}")
    public ResponseEntity<Books> getByNameB(@PathVariable("nombre") String nameB){
        if(!bookService.existsByNameB(nameB))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        Books books = bookService.getByNameB(nameB).get();
        return new ResponseEntity(books, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody BookDTO bookDTO){
        if(StringUtils.isBlank(bookDTO.getNameB()))
            return new ResponseEntity(new Message("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(bookDTO.getCategory()))
            return new ResponseEntity(new Message("la  categoria es obligatoria"), HttpStatus.BAD_REQUEST);
        if(bookService.existsByNameB(bookDTO.getNameB()))
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Books books = new Books(bookDTO.getNameB(), bookDTO.getCategory(), bookDTO.getFileLocation());
        bookService.save(books);
        return new ResponseEntity(new Message("libro agregado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody BookDTO bookDTO){
        if(!bookService.existsById(id))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        if(bookService.existsByNameB(bookDTO.getNameB()) && bookService.getByNameB(bookDTO.getNameB()).get().getId() != id)
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(bookDTO.getNameB()))
            return new ResponseEntity(new Message("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(bookDTO.getCategory()))
            return new ResponseEntity(new Message("la categoria es obligatoria"), HttpStatus.BAD_REQUEST);

        Books books = bookService.getOne(id).get();
        books.setNameB(bookDTO.getNameB());
        books.setCategory(bookDTO.getCategory());
        books.setFileLocation(bookDTO.getFileLocation());
        bookService.save(books);
        return new ResponseEntity(new Message("libro actualizado"), HttpStatus.OK);
    }


}
