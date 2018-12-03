package com.oesia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_servicios")
public class Servicio {
		
		@Id
		@Column(name = "servicio_ds")
		int servicio_ds;
		@Column(name = "servicio_tipo")
	    String servicio_tipo;
		@Column(name = "servicio_sede")
	    int servicio_sede;

		public int getServicio_ds() {
			return servicio_ds;
		}
		public void setServicio_ds(int servicio_ds) {
			this.servicio_ds = servicio_ds;
		}
		public String getServicio_tipo() {
			return servicio_tipo;
		}
		public void setServicio_tipo(String servicio_tipo) {
			this.servicio_tipo = servicio_tipo;
		}
		public int getServicio_sede() {
			return servicio_sede;
		}
		public void setServicio_sede(int servicio_sede) {
			this.servicio_sede = servicio_sede;
		}

	

}
