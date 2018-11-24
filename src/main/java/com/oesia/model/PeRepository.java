package com.oesia.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.oesia.model.Pe;

// AUTO IMPLEMENTED by Spring into a Bean called userRepository@
@Repository
public interface PeRepository extends CrudRepository<Pe, Integer>{

	@Query(value ="SELECT * FROM tb_nodo_pe WHERE pe_id = ?1 GROUP BY pe_id", nativeQuery = true)	
	Pe findPe(int pe_id);
	
	@Query(value ="SELECT * FROM tb_nodo_pe WHERE pe_ip = ?1 GROUP BY pe_ip", nativeQuery = true)	
	Pe findByIP(String pe_ip);

}