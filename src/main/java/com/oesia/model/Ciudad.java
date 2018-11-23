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
	private String ciudad_id;
    @Column(name = "ciudad_nombre")
	private String ciudad_nombre;
	
	
	public String getCiudad_id() {
		return ciudad_id;
	}
	public void setCiudad_id(String ciudad_id) {
		this.ciudad_id = ciudad_id;
	}
	public String getCiudad_nombre() {
		return ciudad_nombre;
	}
	public void setCiudad_nombre(String ciudad_nombre) {
		this.ciudad_nombre = ciudad_nombre;
	}


}
