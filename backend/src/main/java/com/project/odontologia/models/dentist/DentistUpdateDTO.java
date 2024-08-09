package com.project.odontologia.models.dentist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class DentistUpdateDTO {
    private String specialty;
    @Pattern(regexp = "^[A-Z0-9]{6,10}$", message = "CRO must be between 6 and 10 alphanumeric characters")
    private String cro;
    private String name;
    private String email;
    //@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private String password;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public @Pattern(regexp = "^[A-Z0-9]{6,10}$", message = "CRO must be between 6 and 10 alphanumeric characters") String getCro() {
        return cro;
    }

    public void setCro(@Pattern(regexp = "^[A-Z0-9]{6,10}$", message = "CRO must be between 6 and 10 alphanumeric characters") String cro) {
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
