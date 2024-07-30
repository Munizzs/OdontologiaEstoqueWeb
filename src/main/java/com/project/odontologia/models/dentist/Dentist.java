package com.project.odontologia.models.dentist;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Dentist {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Speciality is mandatory")
    private String specialty;
    @NotBlank(message = "CRO is mandatory")
    @Pattern(regexp = "^[A-Z0-9]{6,10}$", message = "CRO must be between 6 and 10 alphanumeric characters")
    private String cro;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
    //@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
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

    public @NotBlank(message = "Speciality is mandatory") String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(@NotBlank(message = "Speciality is mandatory") String specialty) {
        this.specialty = specialty;
    }

    public @NotBlank(message = "CRO is mandatory") @Pattern(regexp = "^[A-Z0-9]{6,10}$", message = "CRO must be between 6 and 10 alphanumeric characters") String getCro() {
        return cro;
    }

    public void setCro(@NotBlank(message = "CRO is mandatory") @Pattern(regexp = "^[A-Z0-9]{6,10}$", message = "CRO must be between 6 and 10 alphanumeric characters") String cro) {
        this.cro = cro;
    }

    public @NotBlank(message = "Name is mandatory") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name is mandatory") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Email is mandatory") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is mandatory") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Password is mandatory") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password is mandatory") String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", specialty='" + specialty + '\'' +
                ", cro='" + cro + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
