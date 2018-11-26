package com.oesia.model;

import com.oesia.model.Conexion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



	@Repository("conexionRepository")
	public interface ConexionRepository extends JpaRepository<Conexion, Integer> {
		  
		  Conexion findById(int id);

	}

