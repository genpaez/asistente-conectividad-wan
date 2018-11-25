package com.oesia.model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

import com.jcraft.jsch.*;


public class PortFR {  // conexión mpls y ejecución.
	
	private  String username = "opegpae1";
	private  String passwordA = "Baudelaire18*", passwordB = "FN5ihAJo";
	private  String hostA = "10.30.4.165", hostB;
	private  JSch jSch = new JSch();
	private  int forwardedPort;
	private  Session sessionA;
	private  Session sessionB;

		
	 
	 public PortFR(String hostB) {
		 this.hostB = hostB;
	}

	public void conectar() throws IOException, InterruptedException, JSchException{
		 sesionA();
		 sesionB();
	 }
	
	 public void sesionA(){

		 try {
			sessionA = jSch.getSession(username, hostA, 22);  
			Properties config = new Properties(); 
	        config.put("StrictHostKeyChecking", "no");
	        sessionA.setConfig(config);
	        sessionA.setPassword(passwordA);
	        forwardedPort = 2222;                //  **** Puerto local ! ****
        	sessionA.setPortForwardingL(forwardedPort, hostB, 22);	// puerto para tunel hacia hostB
	        sessionA.connect(10000);
	        sessionA.openChannel("direct-tcpip"); //***************** // Shell/Exc/TCP 
	        
	        
	        if(sessionA.isConnected()) { 
	        	System.out.println("Connected host A!");
	        		
	        }
			
		} catch (JSchException e) {
			e.printStackTrace();
		}
	 }
	 
	 
	 
	 public void sesionB() throws IOException, InterruptedException {
		
			try {
				sessionB = jSch.getSession(username, "localhost", forwardedPort);
				Properties config = new Properties(); 
		        config.put("StrictHostKeyChecking", "no");
		        sessionB.setConfig(config);
		        sessionB.setPassword(passwordB);
				sessionB.connect(10000);
				
			      if(sessionB.isConnected()) {
			         System.out.println("Connected host B!"); 		            
				  }
			      
			    } catch (JSchException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
     	        
	 }
	 
	
	public List<String> execute(List<String> comandos) throws IOException, InterruptedException{
		
		  List<String> respuesta = new ArrayList<String>();
		  
		  Channel channel = null;
				try {
					channel = sessionB.openChannel("shell");   // obtener canal
					} catch (JSchException e1) {
						e1.printStackTrace();
						respuesta.add("Error de conexión con PE: " + e1.getMessage());
						return respuesta;
					}
		  InputStream in = channel.getInputStream();
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  OutputStream out = channel.getOutputStream();
		  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		  
		        try {
					channel.connect();    // conectar canal
					} catch (JSchException e1) {
						e1.printStackTrace();
			    	    respuesta.add("Error al ejecutar comandos en PE: " + e1.getMessage());
						return respuesta;
					}
				  		  
		  if(channel.isConnected()) { 

			  for(String comando : comandos) {         // recorre los comandos
				  bw.write(comando + "\n \n \n");      // escribe
				  Thread.sleep(200);
			  }
			  bw.flush();
			  
			  
		      new Timer().schedule(new TimerTask() {    // 5 segundos, previene lentitud de pe y respuesta ping
		    	    @Override
		    	    public void run() {
		    	    	try {
							bw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    	    }
		    	}, 6000);
			  
		  }
		  

	      String received = null;
	     

	             
		  for(int x=0;x<250;x++)
	      {
	    	  received=br.readLine();
	    	    
	          if(received.contains("logout")) {break;}
	          
	          if(received.equals(null)) {break;}
	          
	          if (channel.isClosed()) {
	              System.out.println("exit-status: " + channel.getExitStatus());
	              break;
	          }
	          try{Thread.sleep(10);}catch(Exception ee){}
	          
	    	    respuesta.add(received+"\n");

	      }
			return respuesta;
	}
	
	

	public void close() {
	      sessionA.disconnect();    // libera recursos
	      sessionB.disconnect();
	}

}

