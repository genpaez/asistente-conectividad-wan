package com.oesia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_servicio_vpnip")
public class Canal { //Serializable*
	
	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "servpnip_id", unique = true, nullable = false)
	int id;
	@Column(name = "servpnip_pe")
    int pe;
	@Column(name = "servpnip_servicio") // Llave foranea
    String servicio;
	@Column(name = "servpnip_tipo_enlace")
    String tipo_enlace;
	@Column(name= "servpnip_vprn")
	String vprn;
	@Column(name = "servpnip_interface_ip")
    String ipwan_pe;
	@Column(name = "servpnip_interface")
    String nombreInterface;
	@Column(name="servpnip_sap")
	String puertope;
	@Column(name = "servpnip_wan")
    String ipwan_router;
	@Column(name = "servpnip_enrutamiento")
    String enrutamiento;
	@Column(name= "servpnip_loopback")
	String loopback;
	
	@Column(name = "servpnip_id_tx")
	String idTransmision;
	@Column(name = "servpnip_nombre_dslam")
	String nombreDslam;
	@Column(name = "servpnip_ip_dslam")
	String ipDslam;
    @Column(name = "servpnip_puerto_dslam")
    String puertoDslam;
    
    

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPe() {
		return pe;
	}
	public void setPe(int pe) {
		this.pe = pe;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getTipo_enlace() {
		return tipo_enlace;
	}
	public void setTipo_enlace(String tipo_enlace) {
		this.tipo_enlace = tipo_enlace;
	}
	public String getVprn() {
		return vprn;
	}
	public void setVprn(String vprn) {
		this.vprn = vprn;
	}
	public String getIpwan_pe() {
		return ipwan_pe;
	}
	public void setIpwan_pe(String ipwan_pe) {
		this.ipwan_pe = ipwan_pe;
	}
	public String getNombreInterface() {
		return nombreInterface;
	}
	public void setNombreInterface(String nombreInterface) {
		this.nombreInterface = nombreInterface;
	}
	public String getPuertope() {
		return puertope;
	}
	public void setPuerto(String puertope) {
		this.puertope = puertope;
	}
	public String getIpwan_router() {
		return ipwan_router;
	}
	public void setIpwan_router(String ipwan_router) {
		this.ipwan_router = ipwan_router;
	}
	public String getEnrutamiento() {
		return enrutamiento;
	}
	public void setEnrutamiento(String enrutamiento) {
		this.enrutamiento = enrutamiento;
	}
	public String getLoopback() {
		return loopback;
	}
	public void setLoopback(String loopback) {
		this.loopback = loopback;
	}
	public String getIdTransmision() {
		return idTransmision;
	}
	public void setIdTransmision(String idTransmision) {
		this.idTransmision = idTransmision;
	}
	public String getNombreDslam() {
		return nombreDslam;
	}
	public void setNombreDslam(String nombreDslam) {
		this.nombreDslam = nombreDslam;
	}
	public String getIpDslam() {
		return ipDslam;
	}
	public void setIpDslam(String ipDslam) {
		this.ipDslam = ipDslam;
	}
	public String getPuertoDslam() {
		return puertoDslam;
	}
	public void setPuertoDslam(String puertoDslam) {
		this.puertoDslam = puertoDslam;
	}

}
