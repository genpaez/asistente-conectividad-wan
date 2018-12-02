package com.oesia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "tb_nodo_pe")
public class Pe {
	
	@Id
 //   @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "pe_id", unique = true, nullable = false)
	int pe_id;
	@Column(name = "pe_ip")
    String pe_ip;
	
	@Column(name = "pe_nombre")
    String pe_nombre;
	
	
	public int getPe_id() {
		return pe_id;
	}

	public void setPe_id(int pe_id) {
		this.pe_id = pe_id;
	}
	
	public String getIp_pe() {
		return pe_ip;
	}

	public void setIp_pe(String ip_pe) {
		this.pe_ip = ip_pe;
	}

	public String getNombre_pe() {
		return pe_nombre;
	}

	public void setNombre_pe(String nombre_pe) {
		this.pe_nombre = nombre_pe;
	}

}
