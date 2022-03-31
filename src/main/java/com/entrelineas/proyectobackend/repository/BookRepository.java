package com.entrelineas.proyectobackend.repository;

import com.entrelineas.proyectobackend.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
    Optional<Books> findByNameB(String nameB);
    boolean existsByNameB(String nameB);
}