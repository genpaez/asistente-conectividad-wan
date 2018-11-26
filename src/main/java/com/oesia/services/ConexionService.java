package com.oesia.services;

import com.oesia.model.Conexion;
import com.oesia.model.ConexionRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("conexionService")
public class ConexionService {
		
		@Autowired
	  	private ConexionRepository conexionRepository;
	  	
	  	
	    public Conexion saveConexion(Conexion conexion) {
	    		
	        conexionRepository.deleteAll();   // Registro de configuración, elimina el existente 
	        conexionRepository.flush();
	        return conexionRepository.save(conexion); // Agrega nuevo registro (unico)
	    }
	    
}