package com.oesia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_asistenteconectividad_conexion")
public class Conexion {
	
	 	@Id
	    @Column(name = "conexion_id")
	    private int id;
	    @Column(name = "ip_servidor_mpls")
	    @NotEmpty(message = "*Por favor ingrese IP de servidor MPLS")
	    private String ip_servidor_mpls;
	    @Column(name = "usuario_mpls")
	    @NotEmpty(message = "*Por favor ingrese usuario de MPLS")
	    private String usuario_mpls;
	    @Column(name = "clave_1_mpls")
	    @NotEmpty(message = "*Por favor ingrese clave 1 MPLS")
	    private String clave_1_mpls;
	    @Column(name = "clave_2_mpls")
	    @NotEmpty(message = "*Por favor ingrese clave 2 MPLS")
	    private String clave_2_mpls;
	    
	    
	    
		public String getClave_1_mpls() {
			return clave_1_mpls;
		}
		public void setClave_1_mpls(String clave_1_mpls) {
			this.clave_1_mpls = clave_1_mpls;
		}
		public String getClave_2_mpls() {
			return clave_2_mpls;
		}
		public void setClave_2_mpls(String clave_2_mpls) {
			this.clave_2_mpls = clave_2_mpls;
		}
		public String getUsuario_mpls() {
			return usuario_mpls;
		}
		public void setUsuario_mpls(String usuario_mpls) {
			this.usuario_mpls = usuario_mpls;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getIp_servidor_mpls() {
			return ip_servidor_mpls;
		}
		public void setIp_servidor_mpls(String ip_servidor_mpls) {
			this.ip_servidor_mpls = ip_servidor_mpls;
		}
	    
	    

}