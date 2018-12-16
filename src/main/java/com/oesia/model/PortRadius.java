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

public class PortRadius {
	
	private  String usernameradius = null, userrouter = null;
	private  String passwordradius = null, passwordrouter = null;
	private  String hostA =  null, loopback = null;
	private  int forwardedPort;
	private  Session sessionA;
	private  Session sessionB;
	private  JSch jSch;


	//[$('#loopback').text(), $('#ipserverradius').text(), $('#userradius').text(), $('#claveradius').text(), $('#puertolocalradius').text(), $('#userrouter').text(), $('#claverouter').text()];
	public PortRadius(String loopback, String hostA, String usernameradius, String passwordradius, String forwardedPort, String userrouter, String passwordrouter) {

		this.hostA = hostA;
		this.loopback = loopback;
		this.forwardedPort = Integer.parseInt(forwardedPort);
		this.usernameradius = usernameradius;
		this.passwordradius = passwordradius;
		this.userrouter = userrouter;
		this.passwordrouter = passwordrouter;	
		jSch = new JSch();
	}

	public void conectar() throws IOException, InterruptedException, JSchException{
		 sesionA();
		 sesionB();
	 }
	
	
	 public void sesionA(){

		 try {
			sessionA = jSch.getSession(usernameradius, hostA, 2224);  
			Properties config = new Properties(); 
	        config.put("StrictHostKeyChecking", "no");
	        sessionA.setConfig(config);
	        sessionA.setPassword(passwordradius);
        	sessionA.setPortForwardingL(forwardedPort, loopback, 22);	// puerto para tunel hacia hostB
	        sessionA.connect(25000);
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
				sessionB = jSch.getSession(userrouter, "localhost", forwardedPort);

				Properties config = new Properties(); 
		        config.put("StrictHostKeyChecking", "no");
		        sessionB.setConfig(config);
		        sessionB.setPassword(passwordrouter);
				sessionB.connect(60000);
				
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
						channel = sessionB.openChannel("shell");
					} catch (JSchException e1) {
						respuesta.add("Error de conexión con Router Cliente: " + e1.getMessage());
						return respuesta;
					}
			  InputStream in = channel.getInputStream();
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  OutputStream out = channel.getOutputStream();
			  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

			  
			  
					try {
						channel.connect();
					} catch (JSchException e1) {
						respuesta.add("Error para ejecutar comandos en Router: " + e1.getMessage());
						return respuesta;
					}
			  
			  if(channel.isConnected()) { 

				  for(String comando : comandos) {         // recorre los comandos
					  bw.write(comando + "\n");      // escribe
					  Thread.sleep(400);
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
			    	}, 4000);
			  }
			  

		      String received = null;
		     

		             
			  for(int x=0;x<75;x++)
		      {
		    	  received=br.readLine();

		          try{Thread.sleep(10);}catch(Exception ee){}
		          	
		    	    respuesta.add(received+"\n");
		      }
			  	
				return respuesta;
		}
		
	
	
	public void close() {
	      sessionA.disconnect();    // libera recursos
	      sessionB.disconnect();
	      jSch = null;
	}

}
