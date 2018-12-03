package com.oesia.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.oesia.model.Cliente;
import com.oesia.model.Conexion;
import com.oesia.model.Role;
import com.oesia.model.User;
import com.oesia.model.UserRepository;
import com.oesia.services.ConexionService;
import com.oesia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private ConexionService conexionService;
    @Autowired
    private UserRepository userRepository;
    

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
        
    }


    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Usuario creado con éxito");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    
    @RequestMapping(value="/configuracion", method = RequestMethod.GET)
    public ModelAndView configuracion(){
        ModelAndView modelAndView = new ModelAndView();
        Conexion conexion = new Conexion();
        modelAndView.addObject("conexion", conexion);
        modelAndView.setViewName("configuracion"); 
        return modelAndView;
    }
    
    @RequestMapping(value = "/configuracion", method = RequestMethod.POST)
    public ModelAndView updateConexion(@Valid Conexion conexion, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("configuracion");
        } else{
            conexionService.saveConexion(conexion);
            modelAndView.addObject("successMessage", "Configuración actualizada con éxito");
            modelAndView.addObject("conexion", new Conexion());
            modelAndView.setViewName("configuracion");

        }
        return modelAndView;
    }
      
    
    
    @PostMapping(path = "/registration/usuarios")
    public @ResponseBody List<User> getUsers() {
    	
    	List<User> usuarios = userRepository.findAll();
        return usuarios;

    }
    
    
    @PostMapping(path = "/registration/eliminarUsuario")
    public void deleteUser(@RequestBody User user) {

    	userRepository.deleteById(user.getId());


    }
    
    
    
    @RequestMapping(value="/access-denied", method = RequestMethod.GET)
    public ModelAndView denegado(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("access-denied");
        return modelAndView;
    }
    
    
    @RequestMapping(value="/error", method = RequestMethod.GET)
    public ModelAndView error(){
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
    
    

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
    	
    	String tipoUsuario = null;
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findUserByEmail(auth.getName());
    	Set<Role> role = user.getRoles();
    	for (Role rol : role) {tipoUsuario = rol.getRole();}

       //  if (request.isUserInRole("USUARIO")) 
        	 
    	if (tipoUsuario.contentEquals("USUARIO")){
    		
             return "redirect:/index";
         }
         return "redirect:/registration";
     }
    
    
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public ModelAndView inicio(){
    	ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    
    
    
}
