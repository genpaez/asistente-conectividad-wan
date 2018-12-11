package com.oesia.model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.oesia.model.Canal;

// Spring implementa un Bean llamado myRepository@
@Repository
public interface MyRepository extends CrudRepository<Canal, Integer>{
	
	@Query(value ="SELECT * FROM tb_servicio_vpnip WHERE servpnip_id = ?1 GROUP BY servpnip_id", nativeQuery = true)
	Canal findVias(int servpnip_id);
	
	@Query(value ="SELECT * FROM tb_servicio_vpnip WHERE servpnip_id = ?1 GROUP BY servpnip_id", nativeQuery = true)
	Canal findViasS(String servpnip_id);
					   
	@Query(value ="SELECT * FROM tb_servicio_vpnip WHERE servpnip_servicio = ?1", nativeQuery = true) // Busca canal por DS
	Canal findServicioBySede(@Param("servpnip_servicio") String servpnip_servicio);
}

