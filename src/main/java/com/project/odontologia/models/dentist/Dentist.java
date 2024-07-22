package com.project.odontologia.models.dentist;

import jakarta.persistence.*;

@Entity
public class Dentist {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String specialty;

    private String cro;

    private String name;

    private String email;

    private String password;

    public Dentist() {
    }

    public Dentist(Integer id, String specialty, String cro, String name, String email, String password) {
        this.id = id;
        this.specialty = specialty;
        this.cro = cro;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Dentist(RequestDentist request) {
        this.name = request.name();
        this.specialty = request.specialty();
        this.cro = request.cro();
        this.email = request.email();
        this.password = request.password();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
