package com.oesia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User{
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "iduser", unique = true, nullable = false)
	int id;
	@Column(name = "nombre")
    String nombre;
	@Column(name = "correo")
    String correo;

	/*
	public User(String nombre, String correo) {
		this.nombre = nombre;
		this. correo = correo;
	}
	*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
