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
	
	private  String usernameradius = "gics", userrouter = "ivbohorquezro";
	private  String passwordradius = "t3l3c0m", passwordrouter = "2W24K7XY";
	private  String hostA = "10.201.136.103", loopback;
	private  Session sessionA;
	private  Session sessionB;
	private  int forwardedPort;
	private  JSch jSch = new JSch();


	

	public PortRadius(String loopback) {
		// TODO Auto-generated constructor stub
		this.loopback = loopback;
	}

	public void conectar() throws IOException, InterruptedException{
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
	        forwardedPort = 23;                     //  **** Puerto local ! ****
        	sessionA.setPortForwardingL(forwardedPort, loopback, 22);	// puerto para tunel hacia hostB
	        sessionA.connect();
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
				sessionB.connect();
				
		      if(sessionB.isConnected()) {
		         System.out.println("Connected host B!"); 
		            
			  }
		    } catch (JSchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        	        
	 }
	
	

	
	 public List<String> execute(List<String> comandos) throws IOException, JSchException, InterruptedException{
			
			  List<String> respuesta = new ArrayList<String>();
			  
			  Channel channel = sessionB.openChannel("shell");
			  InputStream in = channel.getInputStream();
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  OutputStream out = channel.getOutputStream();
			  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));

			  
			  
			  channel.connect();
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
		     

		             
			  for(int x=0;x<60;x++)
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
	}

}
