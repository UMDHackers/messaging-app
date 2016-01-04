import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket; 
public class Server {
	private final  int PORT_NUM= 3030;
	public Server() {
	}
	public void listen_messages() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT_NUM);
	
			while(true) {
				try (
					Socket clientSocket = serverSocket.accept();  
					PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);                   
			        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		        ) {
					String inputLine;
		            while ((inputLine = in.readLine()) != null) {
		                out.println(inputLine);
		            }
				}
				catch(IOException e) {
					System.out.println("Exception");
					System.out.println(e.getMessage());
					serverSocket.close();
					break;
				}
			}
			serverSocket.close();
		}
		catch(Exception e) {
			 System.out.println("Exception caught when trying to listen on port " + PORT_NUM + " or listening for a connection");
		     System.out.println(e.getMessage());
			 return;
		}
	}
	
}
