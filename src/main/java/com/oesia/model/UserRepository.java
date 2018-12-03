package com.oesia.model;

import com.oesia.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



	@Repository("userRepository")
	public interface UserRepository extends CrudRepository<User, Integer> {
		
	    User findByEmail(String email);
	    
	//    @Query(value ="DELETE FROM user WHERE user_id = ?1", nativeQuery = true) // Elimina usuario
	//    User deleteById(int user_id);
	    
	    List<User> findAll();
	}