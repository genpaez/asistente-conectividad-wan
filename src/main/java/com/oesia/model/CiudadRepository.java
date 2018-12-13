package com.oesia.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Integer>{

	@Query(value ="SELECT * FROM tb_ciudades WHERE ciudad_id = ?1 GROUP BY ciudad_nombre", nativeQuery = true)
	Ciudad findCiudadesCliente(String ciudad);
}

