package com.oesia.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// AUTO IMPLEMENTED by Spring into a Bean called userRepository@
@Repository
public interface CiudadRepository extends CrudRepository<Sedes, Integer>{

	@Query(value ="SELECT ciudad_id, ciudad_nombre FROM tb_ciudades JOIN tb_sedes WHERE tb_sedes.sede_cliente = ?1 GROUP BY ciudad_nombre", nativeQuery = true)
	List<?> findCiudadesCliente(String sede_cliente);
}

