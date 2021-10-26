How to run the project:

unzip the downloaded project and navigate to it

RAW FILES: (easier to use jar)
		
	Server:
	- open a terminal
	- navigate to [...downloadDir]/project2/src/csci455_project2
	- run `javac UDPServer.java` to compile
	- navigate back one folder
	- run `java csci455_project2.UDPServer.java` to start the server
	- to kill, press ctrl+c in the terminal and then type y for yes
	
	Client:
	- open as many terminals as you want 1/client
	- navigate to [...downloadDir]/project2/src/csci455_project2
	- run `javac UDPClient.java` to compile
	- navigate back one folder
	- run `java csci455_project2.UDPClient.java` to start the client
	- type your messages as prompted.
	- to kill, type "exit" and send. The client will close after 2 seconds.
	
FROM .JAR: 
		
	Server:
		- open a terminal
		- navigate to wherever you extracted the files
		- run `java -jar start_server.jar` to start the server
		- to kill, press ctrl+c in the terminal and then type y for yes
		
		Client:
		- open as many terminals as you want 1/client
		- navigate to wherever you extracted the files
		- run `java -jar start_client.jar` to start the client
		- type your messages as prompted.
		- to kill, type "exit" and send. The client will close after 2 seconds.
		
		