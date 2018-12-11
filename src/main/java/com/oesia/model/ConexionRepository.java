package com.oesia.model;

import com.oesia.model.Conexion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



	@Repository("conexionRepository")
	public interface ConexionRepository extends JpaRepository<Conexion, Integer> {
		  
		  Conexion findById(int id);

	}

