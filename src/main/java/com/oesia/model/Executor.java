package com.oesia.model;

import java.util.ArrayList;
import java.util.List;

public class Executor {

	List<String> respuesta = new ArrayList<String>();
	
	public Executor(String ip_pe) {     //  
		// aqui recibe ip pe para conexión ssh
		String a;
		// puerto random de un pool o try next
	}

	public List<String> Execute(List<String> comandos) {
		
		this.respuesta = comandos;
		
		return respuesta;
	}
	
}
