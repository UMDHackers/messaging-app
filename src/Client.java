import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class Client {
	private final  int PORT_NUM= 3030;
	public Client() {
	}
	public boolean send_message(String message, String host_name) {
		try (
			//Establish connection
			Socket socket = new Socket(host_name, PORT_NUM);
			//Output to socket
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		) {		
			System.out.println("Message send");
			out.println(message);
		} catch(UnknownHostException e) {
			System.err.println("Unknown host");
			return false;
			
		} catch(IOException e) {
			 System.err.println("Couldn't get I/O for the connection to " +
					 host_name);
			 return false;
		} 
		return true;
	}
	
	
	
	
	
	
}
