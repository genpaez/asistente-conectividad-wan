package com.oesia.model;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// AUTO IMPLEMENTED by Spring into a Bean called userRepository@
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

	@Query(value ="SELECT * FROM tb_clientes GROUP BY cliente_razon_social", nativeQuery = true)
	List<Cliente> findById();
}