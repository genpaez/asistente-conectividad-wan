package com.oesia.services;

import com.oesia.model.Conexion;
import com.oesia.model.ConexionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("conexionService")
public class ConexionService {
		
		@Autowired
	  	private ConexionRepository conexionRepository;
	  	
	  	
	    public Conexion saveConexion(Conexion conexion) {
	    		
	//    	int id=1;
	  //      conexionRepository.deleteById(id);   // Registro de configuración, elimina el existente y crea con id 1
	    //    conexionRepository.flush();
	    //	 conexion.setId(1);
	        return conexionRepository.save(conexion);
	    }
	    
	    public void findUserByEmail(int id) {
	        conexionRepository.findById(id);
	    }
}