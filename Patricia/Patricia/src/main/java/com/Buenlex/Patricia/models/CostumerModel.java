package com.Buenlex.Patricia.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "costumers")
public class CostumerModel {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String files;
    private String name;
    private String company;
    private String cellphone;
    private LocalDate dateActivate;
    private String audiences;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public LocalDate getDateActivate() {
        return dateActivate;
    }

    public void setDateActivate(LocalDate dateActivate) {
        this.dateActivate = dateActivate;
    }

    public String getAudiences() {
        return audiences;
    }

    public void setAudiences(String audiences) {
        this.audiences = audiences;
    }
}
