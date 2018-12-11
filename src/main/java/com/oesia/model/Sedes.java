package com.oesia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


	
	@Entity
	@Table(name = "tb_sedes")
	public class Sedes {
		
	    @Id
		@Column(name = "sede_id")
		private int sede_id;
		@Column(name = "sede_cliente")
		private String sede_cliente;
		@Column(name = "sede_ciudad")
		private String sede_ciudad;
		@Column(name = "sede_nombre")
		private String sede_nombre;
		
		
		public int getSede_id() {
			return sede_id;
		}
		public void setSede_id(int sede_id) {
			this.sede_id = sede_id;
		}
		public String getSede_cliente() {
			return sede_cliente;
		}
		public void setSede_cliente(String sede_cliente) {
			this.sede_cliente = sede_cliente;
		}
		public String getSede_ciudad() {
			return sede_ciudad;
		}
		public void setSede_ciudad(String sede_ciudad) {
			this.sede_ciudad = sede_ciudad;
		}
		public String getSede_nombre() {
			return sede_nombre;
		}
		public void setSede_nombre(String sede_nombre) {
			this.sede_nombre = sede_nombre;
		}
		
}

