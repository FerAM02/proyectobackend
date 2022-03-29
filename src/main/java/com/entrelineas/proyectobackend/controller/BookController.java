package com.entrelineas.proyectobackend.controller;


import com.entrelineas.proyectobackend.dao.BookDAO;
import com.entrelineas.proyectobackend.entity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @PostMapping("/guardar")
    public void guardar(@RequestBody Books books) {
        bookDAO.save(books);
    }

    @PostMapping("/listar_libros")
    public List<Books> listar() {
        return bookDAO.findAll();
    }

    @PostMapping("/eliminar/{id}")
    public void eliminar(@PathVariable("id" ) Long idBook) {
        bookDAO.deleteById(idBook);
    }

    @PostMapping("/actualizar")
    public void actualizar(@RequestBody Books books) {
        bookDAO.save(books);
    }


}
