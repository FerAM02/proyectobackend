package com.entrelineas.proyectobackend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Books {

    @Id
    private Long idBook;

    private String nameB;
    private String category;
    private String fileLocation;

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }
}
