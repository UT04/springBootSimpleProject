package com.example.demo.dto;

public class PersonRequestDto {
    private String name;
    private String email;

    // Standard-Konstruktor
    public PersonRequestDto() {
    }

    // Konstruktor mit Parametern
    public PersonRequestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter und Setter
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
}
