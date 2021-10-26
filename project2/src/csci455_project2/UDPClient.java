package csci455_project2;

import java.net.*;
import java.io.*;
/**
 * UDP Client implemented to communicate with server on local host
 * Based on code same from Dr Liu
 * @author elliotx250
 *
 */
public class UDPClient {

	public static void main(String[] args) {
		
		String sentence = "";
		
		try {
			// set up
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			InetAddress IPAddress = InetAddress.getByName("localhost");
			DatagramSocket clientSocket = new DatagramSocket();
			
			System.out.print("The UDP client is on. ");
			
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			
			// stay on until user enters exit
			while (!"exit".equalsIgnoreCase(sentence)) {
				
				System.out.print("Please enter your input: ");
				
				sentence = inFromUser.readLine();
				sendData = sentence.getBytes();
				// create packet to send
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 6789);
				clientSocket.send(sendPacket);
				
				// create packet to receive reply from server
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
				clientSocket.receive(receivePacket);

				String modifiedSentence = new String(receivePacket.getData());

				System.out.println("Total messages:" + modifiedSentence);
				
				//flush buffers just in case
				sendData = new byte[1024];
				receiveData = new byte[1024];
			}
			// user wishes to exit, tear down client
			System.out.println("Disassembling airplane");
			Thread.sleep(2000);
			System.out.println("Closing connection");
			// clear read in and send data and end while
			
			clientSocket.close();
			
		} catch( Exception ex) {
			System.out.println(ex.getMessage());
		} 
	}
}
