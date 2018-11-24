package com.oesia.model;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.oesia.model.Canal;

// AUTO IMPLEMENTED by Spring into a Bean called userRepository@
@Repository
public interface MyRepository extends CrudRepository<Canal, Integer>{
	
	@Query(value ="SELECT * FROM tb_sedes WHERE sede_cliente = ?1 GROUP BY sede_ciudad", nativeQuery = true)
	List<Canal> findBySede(String cliente);
	
	@Query(value ="SELECT * FROM canal WHERE cliente = ?1 AND ciudad = ?2 GROUP BY sede", nativeQuery = true)
	List<Sedes> findBySedeCliente(String cliente, String ciudad);
	
	@Query(value ="SELECT * FROM canal WHERE cliente = ?1 AND ciudad = ?2 AND sede = ?3 GROUP BY canal", nativeQuery = true)
	List<Canal> findBySedeClienteCanal(String cliente, String ciudad, String sede);
	
	@Query(value ="SELECT * FROM tb_servicio_vpnip WHERE servpnip_id = ?1 GROUP BY servpnip_id", nativeQuery = true)
	Canal findVias(int servpnip_id);
	
	@Query(value ="SELECT * FROM tb_servicio_vpnip WHERE servpnip_id = ?1 GROUP BY servpnip_id", nativeQuery = true)
	Canal findViasS(String servpnip_id);
}

