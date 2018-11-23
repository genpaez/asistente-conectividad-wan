package com.oesia.services;

import com.oesia.model.User;
import com.oesia.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    
//	@Autowired
//    private UserRepository userRepository;
    private Iterable<User> users;
    


    /*
    // Love Java 8
    public List<User> findByUserNameOrEmail(String nombre) {

        List<User> result = users.stream().filter(x -> x.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());

        return result;

    }*/
    /*public List<User> findByUserNameOrEmail(String username, String email) {

        List<User> result = new ArrayList<User>();

        for (User user : users) {

            if ((!StringUtils.isEmpty(username)) && (!StringUtils.isEmpty(email))) {

                if (username.equals(user.getUsername()) && email.equals(user.getEmail())) {
                    result.add(user);
                    continue;
                } else {
                    continue;
                }

            }
            if (!StringUtils.isEmpty(username)) {
                if (username.equals(user.getUsername())) {
                    result.add(user);
                    continue;
                }
            }

            if (!StringUtils.isEmpty(email)) {
                if (email.equals(user.getEmail())) {
                    result.add(user);
                    continue;
                }
            }

        }

        return result;

    }*/

    // Init some users for testing
    // @PostConstruct
    public Iterable<User> cargarUsuario(){
    	
  //  	users = (List<User>) userRepository.findAll();
    	return users;
    	
    }
    
    
    /*
    // Init some users for testing
    @PostConstruct
    private void iniDataForTesting() {

        users = new ArrayList<User>();

        User user1 = new User("mkyong", "mkyong@yahoo.com");
        User user2 = new User("mkyong", "mkyong@666.com");
        User user3 = new User("foo", "fooo@yahoo.com");
        User user4 = new User("foo", "foog@666.com");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }  */

}
