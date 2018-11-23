package com.oesia.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// AUTO IMPLEMENTED by Spring into a Bean called userRepository@
@Repository
public interface SedeRepository extends CrudRepository<Sedes, Integer>{


	@Query(value ="SELECT * FROM tb_sedes WHERE sede_cliente = ?1 AND sede_ciudad = ?2 GROUP BY sede_nombre", nativeQuery = true)
	List<Sedes> findSedesCliente(String sede_cliente, String sede_ciudad);
}