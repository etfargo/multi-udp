package csci455_project2;

import java.net.*;

/**
 * UDP server that implements multithreading via ServerWorker
 * Server/ServerWorker based off of Dr Liu server code
 * @author elliotx250
 *
 */
public class UDPServer {

	public static void main(String args[]) throws Exception {
		// setup resources
		DatagramSocket serverSocket = new DatagramSocket(6789);
		System.out.println("The UDP Server is on.");
		Counter counter 	= new Counter();
		byte[]  receiveData = new byte[1024];
		byte[]  sendData	= new byte[1024];

		while (true) {
			// get ready to receive packet (store var, size)
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			// receive connection
			serverSocket.receive(receivePacket);
			
			// create the runnable server worker thread and start
			Runnable serverWorker = new ServerWorker(serverSocket, receivePacket, sendData, counter);
			Thread worker = new Thread(serverWorker);
			worker.start();
			
			// flush buffer (send never written to here so no need to flush)
			receiveData= new byte[1024];
		}
	}
}
