
public class KongoMessenger {
	public static void main(String args[]) {
		Client client = new Client();
		Server server = new Server();
		server.listen_messages();
		
	}
}
