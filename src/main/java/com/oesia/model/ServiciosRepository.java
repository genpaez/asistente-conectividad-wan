package com.oesia.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

	
@Repository
public interface ServiciosRepository extends CrudRepository<Servicio, String>{

	@Query(value = "SELECT servicio_ds FROM tb_servicios WHERE servicio_sede = ?1", nativeQuery = true)
	List<String> findServicioSede(@Param("servicio_sede") int servicio_sede);  // Extrae identificadores de servicio por sede
}

