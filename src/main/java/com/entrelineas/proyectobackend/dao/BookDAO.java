package com.entrelineas.proyectobackend.dao;

import com.entrelineas.proyectobackend.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDAO extends JpaRepository<Books, Long> {

}
