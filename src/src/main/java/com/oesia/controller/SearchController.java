package com.oesia.controller;


import com.oesia.model.User;
import com.oesia.model.UserRepository;
import com.oesia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class SearchController {
	
	@Autowired
	private UserRepository userRepository;
    //UserService userService;
    

    /*
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
	*/
	
    @PostMapping(path = "/api/search")
   // public @ResponseBody List<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search, Errors errors) 
    public @ResponseBody List<?> getSearchResultViaAjax() {

       // AjaxResponseBody result = new AjaxResponseBody(); //// Devuelve un objeto result con [atributos] 

        //If error, just return a 400 bad request, along with the error message
       /*if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(result);

        }*/ 

       // List<User> users = userService.findByUserNameOrEmail(search.getNombre());
       // List<User> users = (List<User>) userService.cargarUsuario();
    	List<User> users = (List<User>) userRepository.findAll();
        
     //   result.setResult(users);  // AjaxResponseBody Devuelve un objeto result con [atributos] 
    //    return ResponseEntity.ok(result); 

        return users;

    }

}
