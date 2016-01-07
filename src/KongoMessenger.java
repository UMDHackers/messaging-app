import java.util.Hashtable;
import java.util.Scanner;

public class KongoMessenger extends Thread{
	private Server server = new Server();
	
	public void run() {
		server.listen_messages();
	}
	
	public static void main(String args[]) throws InterruptedException {
		Client client = new Client();
		Thread serverThread = (new Thread(new KongoMessenger()));
		serverThread.start();
		String userInput;
		Hashtable<String, String> namesToIps = new Hashtable <String, String>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		String[] userArray ;
		do {
			System.out.print("kongo>");
			userInput = scan.nextLine();
			
			if (userInput.equals("help")) {
				System.out.println("Send 'message' name");
				continue;
			} else if (userInput.equals("who")) {
				
				System.out.println("Under construction");
				continue;
			}
			else if ((userArray = userInput.split(" "))[0].equals("send")) {
				client.send_message(userArray[1], userArray[2]);
				continue;
			} else if (userInput.equals("quit")) {
				System.out.println("");
				break;
			}else {
				System.out.println("Unkown Command! " + userInput);
				continue;
			} 
			
			
		}
		while(!userInput.equals("quit"));
		serverThread.join();
	}
}
