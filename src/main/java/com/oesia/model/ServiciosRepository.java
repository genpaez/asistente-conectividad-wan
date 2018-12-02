package com.oesia.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

	
@Repository
public interface ServiciosRepository extends CrudRepository<Servicio, Integer>{
	//servicio_ds, servicio_sede, servicio_tipo
//	SELECT ciudad_id, ciudad_nombre FROM tb_ciudades JOIN tb_sedes WHERE tb_sedes.sede_cliente = ?1 GROUP BY ciudad_nombre
	@Query(value ="SELECT servpnip_id, servpnip_tipo_enlace FROM tb_servicio_vpnip JOIN tb_servicios WHERE servicio_sede = ?1 GROUP BY servpnip_tipo_enlace", nativeQuery = true)
	List<?> findServicioSede(@Param("servicio_sede") int servicio_sede); 
}

