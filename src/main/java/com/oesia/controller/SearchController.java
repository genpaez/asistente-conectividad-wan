package com.oesia.controller;


import com.jcraft.jsch.JSchException;
import com.oesia.model.Canal;
import com.oesia.model.Cliente;
import com.oesia.model.ClienteRepository;
import com.oesia.model.Compositor;
import com.oesia.model.Conexion;
import com.oesia.model.ConexionRepository;
import com.oesia.model.Executor;
import com.oesia.model.MyRepository;
import com.oesia.model.Pe;
import com.oesia.model.PeRepository;
import com.oesia.model.PortFR;
import com.oesia.model.PortRadius;
import com.oesia.model.SearchCriteria;
import com.oesia.model.SedeRepository;
import com.oesia.model.Sedes;
import com.oesia.model.Servicio;
import com.oesia.model.Servicio_vpnip;
import com.oesia.model.ServiciosRepository;
import com.oesia.model.Ciudad;
import com.oesia.model.CiudadRepository;
import com.oesia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class SearchController {
	
	@Autowired
	private SedeRepository sedeRepository; 
	@Autowired
	private ClienteRepository clienteRepository; 
	@Autowired
	private MyRepository myRepository; 
	@Autowired
	private PeRepository peRepository;
	@Autowired
	private CiudadRepository ciudadRepository;
	@Autowired
	private ServiciosRepository serviciosRepository;
	@Autowired
  	private ConexionRepository conexionRepository;

	
	
    @PostMapping(path = "/api/clientes")

    public @ResponseBody List<Cliente> getClientes() {

    	List<Cliente> clientes = clienteRepository.findById();
        return clientes;

    }

    @PostMapping(path = "/api/ciudades")
    public @ResponseBody List<?> getCiudades(@RequestBody Cliente cliente){
		
    	List<?> ciudades = ciudadRepository.findCiudadesCliente(cliente.getCliente_nit());
    	return ciudades;
    }
    
    @PostMapping(path = "/api/sedes")
    public @ResponseBody List<Sedes> findSedes(@RequestBody Sedes sede){
		
    	List<Sedes> sedes = sedeRepository.findSedesCliente(sede.getSede_cliente(), sede.getSede_ciudad());
    	return sedes;
    }
     
    @PostMapping(path = "/api/canales")
    public @ResponseBody List<?> findCanal(@RequestBody Servicio servicio){  // @RequestBody Servicio_vpnip servicio
    	
    	List<?> servicios = serviciosRepository.findServicioSede(servicio.getServicio_sede());  //
    	return servicios;
    }
    
    @PostMapping(path = "/api/vias")
    public  @ResponseBody List<Object> findVias(@RequestBody Canal canal){
		
    	List<Object> respuesta =  new ArrayList<Object>();
    	Canal vias = myRepository.findVias(canal.getId());
    	Pe pe = peRepository.findPe(vias.getPe());


        	respuesta.add(vias);
        	respuesta.add(pe);
    		return respuesta;	
    }
    
    
    @PostMapping(path = "/api/pruebasmpls")
    public List<String> pruebasMpls(@RequestBody String[] vias1) throws IOException, InterruptedException{
    	
    	List<String> respuesta = new ArrayList<String>();
    	Canal vias = myRepository.findViasS(vias1[0]);    // RECIBE ARREGLO DE STRING {Canal, Pe, String, String...}
    	Pe pe = peRepository.findByIP(vias1[1]); 
    	  	
    	String nodo = pe.getIp_pe();
    						 // String hostA, String forwardedPort, String username, String passwordA, String passwordB 
    	PortFR man = new PortFR(nodo, vias1[2], vias1[3], vias1[4], vias1[5], vias1[6]); 
    	Compositor myComposer = new Compositor(); 
    	
    	try {
			man.conectar();
		} catch (JSchException e) {
			respuesta.add("Error de conexión con MPLS: " + e.getMessage());
			return respuesta;
		}
    	
    	List<String> comandos = myComposer.crearComandos(pe.getNombre_pe(), vias.getVprn(), vias.getIpwan_pe(), vias.getIpwan_router(), vias.getPuertope(), vias.getEnrutamiento());
        respuesta = man.execute(comandos);
    	man.close();
    	
    	return respuesta;
    	
    }
    
    @PostMapping(path = "/api/pruebasrouter")
    public List<String> pruebasRouter(@RequestBody String[] vias) throws IOException, InterruptedException{
    	//[$('#loopback').text(),  $('#enrutamiento').text(), $('#ipserverradius').text(), $('#userradius').text(), $('#claveradius').text(), $('#puertolocalradius').text(), $('#userrouter').text(), $('#claverouter').text()];
    	
    	List<String> respuesta = new ArrayList<String>(); 	
    	
    	if(vias[0].equals("")) {	
    		respuesta.add("Error al procesar su solicitud, verifique la información del canal y puertos configurados en la aplicación");  // error sin viene sin parametro loopback
    		return respuesta;
    		}   	

    	PortRadius man = new PortRadius(vias[0], vias[2], vias[3], vias[4], vias[5], vias[6], vias[7]); 
    	Compositor myComposer = new Compositor(); 
    	
    	try {
			man.conectar();
		} catch (JSchException e) {
			respuesta.add("Error de conexión con Servidor Radius: " + e.getMessage());
			return respuesta;
		}
    	
    	List<String> comandos = myComposer.comandosRouter(vias[1]); // Argumento = Enrutamiento
        List<String> respuestarouter = man.execute(comandos);
    	man.close();
    	return respuestarouter; 
    }
    
    
    @PostMapping(path = "/api/conexion")
    public @ResponseBody List<?> getConexion(){
		
    	List<Conexion> conexion = conexionRepository.findAll();
    	return conexion;
    }
    
}