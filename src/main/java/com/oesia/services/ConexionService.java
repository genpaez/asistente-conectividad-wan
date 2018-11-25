package com.oesia.services;

import com.oesia.model.Conexion;
import com.oesia.model.ConexionRepository;
import com.oesia.model.Role;
import com.oesia.model.User;
import com.oesia.model.RoleRepository;
import com.oesia.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

import javax.validation.Valid;

@Service("conexionService")
public class ConexionService {

    private ConexionRepository conexionRepository;

    public Conexion saveConexion(Conexion conexion) {
		return conexionRepository.save(conexion);
	}

}