package com.entrelineas.proyectobackend.dto;


public class BookDTO {

    private String nameB;
    private String category;
    private String fileLocation;

    public BookDTO() {
    }

    public BookDTO(String nameB, String category, String fileLocation) {
        this.nameB = nameB;
        this.category = category;
        this.fileLocation = fileLocation;
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