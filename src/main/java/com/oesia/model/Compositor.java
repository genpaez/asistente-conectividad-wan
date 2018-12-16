package com.oesia.model;

import java.util.ArrayList;
import java.util.List;

public class Compositor {
	
	List<String> comandos = new ArrayList<String>();
	private String sap_pre;
	private String interfaz, ping, routing, puerto, detallepuerto;
	
	

	public List<String> crearComandos(String nombre_pe, String vprn, String ipwanpe, String ipwanrouter, String puertope, String enrutamiento) throws InterruptedException{
		
		
		// *Si es PE huawei*
		
		if(nombre_pe.indexOf("-H") != -1){  // Substring "-H" //if(nombre_pe.charAt(0)=='<') 
			
			
			if(puertope.contains(".")){
			String[] sap = puertope.split("\\."); 
			sap_pre = sap[0];  // Elimina VLAN de SAP, dejando solo el puerto	
			}
			else {sap_pre = puertope;} //Si no tiene el separador lo toma literal
			
		interfaz = "display interface " + puertope + "\n\n"; // display interface GigabitEthernet1/0/10.1520 // Estado de la interfaz en PE
		detallepuerto = "display interface " + sap_pre + "\n \n \n"; // display interface GigabitEthernet1/0/10  // Ver interconexión (Requiere salto línea) 
		ping = "ping -vpn-instance " + vprn +" "+ ipwanrouter + "\n\n";  // ping -vpn-instance 500100550 10.30.1.54  // Ping 
			
			
		
			if(enrutamiento.equals("BGP")) { //  Si tiene enrutamiento BGP
				routing = "display bgp vpnv4 vpn-instance " + vprn + " peer \n\n"; //display bgp vpnv4 vpn-instance 500100550 peer
			}
			else if(enrutamiento.equals("OSPF")) { //  Si tiene enrutamiento OSPF
				routing = "display ospf peer brief \n\n";
			}
			else if(enrutamiento.equals("Estatico")) { //  Si tiene enrutamiento Estático ´
				routing = "display static-route ldp-sync \n\n";
			}
			

			comandos.add("\n \n");
			comandos.add(interfaz);
			comandos.add("\n");
			comandos.add(detallepuerto);
			comandos.add("\n");
			comandos.add(routing);
			comandos.add("\n");
			comandos.add(ping);
		
			return comandos;   // retorna comandos para pe huawei
		} 
		
		
			
		else {   // *********Si No es PE huawei***********
			
			if(puertope.contains(":")){
			String[] sap = puertope.split(":"); 
			sap_pre = sap[0];  // Elimina VLAN de SAP, dejando solo el puerto	
			}
			else {sap_pre = puertope;} //Si no tiene el separador lo toma literal
			
		interfaz = "show service id " + vprn + " interface " + ipwanpe + "\n\n";
		ping = "ping " + ipwanrouter + " router " + vprn + "\n\n";
		puerto = "show port " + sap_pre + " detail \n\n";  
		
		
			if(enrutamiento.equals("BGP")) { //  Si tiene enrutamiento BGP
				routing = "show router " + vprn + " bgp summary neighbor " + ipwanrouter + "\n\n";
			}
			else if(enrutamiento.equals("OSPF")) { //  Si tiene enrutamiento OSPF
				routing = "show router " + vprn + " ospf neighbor " + ipwanpe + "\n\n";
			}
			else if(enrutamiento.equals("Estático")) { //  Si tiene enrutamiento Estático
				routing = "show router " + vprn + " static next-hop " + ipwanrouter + "\n\n";
			}
		}
		
		
		comandos.add(interfaz);
		comandos.add(routing);
		comandos.add(puerto);
		comandos.add("x \n \n");
		comandos.add(ping);
		comandos.add("\n \n");

		return comandos; // retorna comandos para pe 
	}



	public List<String> comandosRouter(String enrutamiento) throws InterruptedException {
		
		String routing = null;
		if(enrutamiento.equals("BGP")) {routing = "show bgp summary | exclude BGP";}
		if(enrutamiento.equals("OSPF")) {routing = "show ip route ospf";}
		if(enrutamiento.equals("Estatico")) {routing = "show ip route static";}
		
		String uptime = "sh version | include uptime"; 
		String restartCause = "sh ver | include System re";
		String intTraffic = "sh int sum | exclude :";
		String intBrief = "show ip int brief";
		

		comandos.add("\n");
		comandos.add(uptime);
		comandos.add("\n \n");
		comandos.add(restartCause);
		comandos.add("\n \n");
		comandos.add(routing);
		comandos.add("\n \n");
		comandos.add(intTraffic);
		comandos.add(" ");
		comandos.add("\n \n");
		comandos.add(intBrief);
		comandos.add(" ");
		comandos.add("\n \n \n \n");
		
		return comandos;
	}
	
}
