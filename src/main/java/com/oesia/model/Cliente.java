package com.oesia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
	
@Entity
@Table(name = "tb_clientes")
public class Cliente {
	
    @Id
	@Column(name = "cliente_nit")
	private String cliente_nit;
	@Column(name = "cliente_razon_social")
	private String cliente_razon_social;
	@Column(name = "cliente_atencion")
	private String cliente_atencion;
	@Column(name = "cliente_segmento")
	private String cliente_segmento;
	@Column(name = "cliente_cluster")
	private int cliente_cluster;
	@Column(name = "cliente_cuadrilla")
	private int cliente_cuadrilla;
	@Column(name = "cliente_aliado")
	private String  cliente_aliado;
	@Column(name = "cliente_cnoc")
	private String  cliente_cnoc;
	@Column(name = "cliente_cgp")
	private String  cliente_cgp;
	@Column(name = "cliente_observaciones")
	private String  cliente_observaciones;
	 
	public String getCliente_nit() {
		return cliente_nit;
	}

	public void setCliente_nit(String cliente_nit) {
		this.cliente_nit = cliente_nit;
	}

	public String getCliente_atencion() {
		return cliente_atencion;
	}

	public void setCliente_atencion(String cliente_atencion) {
		this.cliente_atencion = cliente_atencion;
	}

	public String getCliente_segmento() {
		return cliente_segmento;
	}

	public void setCliente_segmento(String cliente_segmento) {
		this.cliente_segmento = cliente_segmento;
	}

	public int getCliente_cluster() {
		return cliente_cluster;
	}

	public void setCliente_cluster(int cliente_cluster) {
		this.cliente_cluster = cliente_cluster;
	}

	public int getCliente_cuadrilla() {
		return cliente_cuadrilla;
	}

	public void setCliente_cuadrilla(int cliente_cuadrilla) {
		this.cliente_cuadrilla = cliente_cuadrilla;
	}

	public String getCliente_aliado() {
		return cliente_aliado;
	}

	public void setCliente_aliado(String cliente_aliado) {
		this.cliente_aliado = cliente_aliado;
	}

	public String getCliente_cnoc() {
		return cliente_cnoc;
	}

	public void setCliente_cnoc(String cliente_cnoc) {
		this.cliente_cnoc = cliente_cnoc;
	}

	public String getCliente_cgp() {
		return cliente_cgp;
	}

	public void setCliente_cgp(String cliente_cgp) {
		this.cliente_cgp = cliente_cgp;
	}

	public String getCliente_observaciones() {
		return cliente_observaciones;
	}

	public void setCliente_observaciones(String cliente_observaciones) {
		this.cliente_observaciones = cliente_observaciones;
	}

	public String getCliente_razonsocial() {
		return cliente_razon_social;
	}

	public void setCliente_razonsocial(String cliente_razonsocial) {
		this.cliente_razon_social = cliente_razonsocial;
	}

	public String getCliente() {
	    return cliente_nit;
	}

	public void setCliente(String cliente) {
	    this.cliente_nit = cliente;
	}
}
