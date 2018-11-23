package com.oesia.controller;


import com.jcraft.jsch.JSchException;
import com.oesia.model.Canal;
import com.oesia.model.Cliente;
import com.oesia.model.ClienteRepository;
import com.oesia.model.Compositor;
import com.oesia.model.Executor;
import com.oesia.model.MyRepository;
import com.oesia.model.Pe;
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
	private CiudadRepository ciudadRepository;
	@Autowired
	private ServiciosRepository serviciosRepository;

	
	
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
    public @ResponseBody List<?> findCanal(@RequestBody Servicio servicio){   // @RequestBody Servicio_vpnip servicio
		
  
    	List<?> servicios = serviciosRepository.findServicioSede(servicio.getServicio_sede());  //
    	return servicios;
    }
    
    @PostMapping(path = "/api/vias")
    public Canal findVias(@RequestBody Canal canal){
		
    	Canal vias = myRepository.findVias(canal.getId());
    	return vias;
    }
    
    @PostMapping(path = "/api/pe")
    public Canal findPe(@RequestBody Pe pe){
		
    	Canal vias = myRepository.findPe(pe.getPe_id());
    	return vias;
    }
    
    
    
    
    @PostMapping(path = "/api/pruebasmpls")
    public List<String> pruebasMpls(@RequestBody Canal canal) throws IOException, JSchException, InterruptedException{
    	
    	PortFR man = new PortFR(canal.getIppe()); // prueba, no está mapeado a la tabla
        Compositor myComposer = new Compositor();  
        man.conectar();

    	List<String> comandos = myComposer.crearComandos(canal.getNombrepe(), canal.getVprn(), canal.getIpwan_pe(), canal.getIpwan_router(), canal.getPuertope(), canal.getEnrutamiento());
    	List<String> respuestape = man.execute(comandos);	
    	man.close();
    	return respuestape;
    }
    
    @PostMapping(path = "/api/pruebasrouter")
    public List<String> pruebasRouter(@RequestBody Canal canal) throws IOException, JSchException, InterruptedException{
    	
    	PortRadius man = new PortRadius(canal.getLoopback()); 
    	Compositor myComposer = new Compositor(); 
    	man.conectar();
    	
    	List<String> comandos = myComposer.comandosRouter(canal.getEnrutamiento());
        List<String> respuestarouter = man.execute(comandos);
    	man.close();
    	return respuestarouter; 
    }
}