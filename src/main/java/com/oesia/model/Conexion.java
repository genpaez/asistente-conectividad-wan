package com.oesia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

	    
	    @Column(name = "ip_servidor_radius")
	    @NotEmpty(message = "*Por favor ingrese IP de servidor Radius")
	    private String ip_servidor_radius;
	    @Column(name = "usuario_radius")
	    @NotEmpty(message = "*Por favor ingrese usuario de servidor Radius")
	    private String usuario_radius;
	    @Column(name = "clave_radius")
	    @NotEmpty(message = "*Por favor ingrese clave de radius")
	    private String clave_radius;
	    @Column(name = "usuario_router")
	    @NotEmpty(message = "*Por favor ingrese usuario de Router")
	    private String usuario_router;
	    @Column(name = "clave_router")
	    @NotEmpty(message = "*Por favor ingrese clave de Router")
	    private String clave_router;
	    
	    
	    
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
	        
		
		public String getIp_servidor_radius() {
			return ip_servidor_radius;
		}
		public void setIp_servidor_radius(String ip_servidor_radius) {
			this.ip_servidor_radius = ip_servidor_radius;
		}
		public String getUsuario_radius() {
			return usuario_radius;
		}
		public void setUsuario_radius(String usuario_radius) {
			this.usuario_radius = usuario_radius;
		}
		public String getClave_radius() {
			return clave_radius;
		}
		public void setClave_radius(String clave_radius) {
			this.clave_radius = clave_radius;
		}
		public String getUsuario_router() {
			return usuario_router;
		}
		public void setUsuario_router(String usuario_router) {
			this.usuario_router = usuario_router;
		}
		public String getClave_router() {
			return clave_router;
		}
		public void setClave_router(String clave_router) {
			this.clave_router = clave_router;
		}

}