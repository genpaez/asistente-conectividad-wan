package com.oesia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Servicio_vpnip")
public class Servicio_vpnip {

		@Id  
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "servpnip_id") //unique = true, nullable = false
		int servpnip_id;
		@Column(name = "servpnip_tipo_enlace")
	    String servpnip_tipo_enlace;
		
		public int getServpnip_id() {
			return servpnip_id;
		}
		public void setServpnip_id(int servpnip_id) {
			this.servpnip_id = servpnip_id;
		}
		public String getServpnip_tipo_enlace() {
			return servpnip_tipo_enlace;
		}
		public void setServpnip_tipo_enlace(String servpnip_tipo_enlace) {
			this.servpnip_tipo_enlace = servpnip_tipo_enlace;
		}

}
