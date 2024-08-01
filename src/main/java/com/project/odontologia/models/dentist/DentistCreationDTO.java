package com.project.odontologia.models.dentist;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class DentistCreationDTO {
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
}
