package csci455_project2;

import java.io.*;
import java.net.*;

/**
 * This class is a connection based worker thread to display
 * the messages from the client and to tell the client a 
 * thread safe total of messages received.
 * @author elliotx250
 *
 */
public class ServerWorker implements Runnable{
	// private fields for finishing communications with the client
	private String 			 sentence = "";
	private DatagramSocket   serverSocket;
	private DatagramPacket   receivePacket;
	private Counter 		 messages;
	private byte[]    		 sendData;
	
	public ServerWorker(DatagramSocket serverSocket, 
						DatagramPacket   receivePacket, 
						byte[] sendData,
						Counter messages) {
		
		// instantiate the private fields
		this.serverSocket 	= serverSocket;
		this.receivePacket 	= receivePacket;
		this.sendData 		= sendData;
		this.messages 		= messages;
		
	}
	
	@Override
	public void run() {
		try {
			// setup resources
			InetAddress IPAddress = receivePacket.getAddress();
			int 		port 	  = receivePacket.getPort();
			     		sentence  = new String(receivePacket.getData(), 
										receivePacket.getOffset(), 
										receivePacket.getLength()); // to properly create the string to compare
			
			// client addy and port
			System.out.println("message from " + IPAddress + "@" + port +": " + sentence);
			
			// dont count messages "exit" to total
			if ( !"exit".equalsIgnoreCase(sentence) ) {
				messages.increment();
			}

			// need to send num messages
			sendData = ("" + messages.getTotal()).getBytes();

			// reply to client the number of total messages
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
