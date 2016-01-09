import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class KongoMessenger extends Thread{
	private Server server = new Server();
	private static Hashtable<String, String> namesToIps = new Hashtable <String, String>();
	public void run() {
		server.listen_messages();
	}
	public static void chatWith(String name) {
		
	}
	public static void main(String args[]) throws InterruptedException {
		Client client = new Client();
		Thread serverThread = (new Thread(new KongoMessenger()));
		serverThread.start();
		String userInput;
	
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		String[] userArray ;
		do {
			System.out.print("kongo> ");
			userInput = scan.nextLine();
			
			if (userInput.equals("help")) {
				System.out.println("Send 'message' name, with the quotes around it");
				continue;
			} else if (userInput.equals("who")) {
				Enumeration<String> names = namesToIps.keys();
				System.out.println("Online");
				while(names.hasMoreElements()) {
					System.out.println(names.nextElement());
				}
				continue;
			} else if ((userArray = userInput.split("'"))[0].trim().equals("send")) {
				String message = userArray[1];
				String name = userArray[2].trim();
				String ip_address = namesToIps.get(name);
				client.send_message(message, ip_address);
				continue;
			} else if (userInput.equals("quit")) {
				System.out.println("");
				break;
			} else if (userInput.equals("")) {
				continue;
			} else if ((userArray = userInput.split(" "))[0].equals("chat")){
				chatWith(userArray[1]);
				
			} else {
				System.out.println("Unknown Command! " + userInput);
				continue;
			} 
		}
		while(!userInput.equals("quit"));
		serverThread.join();
	}
}
