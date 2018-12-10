package com.oesia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ciudades")
public class Ciudad {
    @Id
	@Column(name = "ciudad_id")
	private String id;
    @Column(name = "ciudad_nombre")
	private String nombre;
	
	
	public String getCiudad_id() {
		return id;
	}
	public void setCiudad_id(String ciudad_id) {
		this.id = ciudad_id;
	}
	public String getCiudad_nombre() {
		return nombre;
	}
	public void setCiudad_nombre(String ciudad_nombre) {
		this.nombre = ciudad_nombre;
	}


}
