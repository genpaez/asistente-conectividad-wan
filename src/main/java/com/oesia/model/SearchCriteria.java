package com.oesia.model;

import org.hibernate.validator.constraints.NotBlank;

public class SearchCriteria {

    @NotBlank(message = "username can't empty!")
    String cliente;

    public String getNombre() {
        return cliente;
    }

    public void setNombre(String cliente) {
        this.cliente = cliente;
    }
}