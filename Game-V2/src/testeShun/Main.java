package testeShun;

import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Main {

	private static String address;

	public static void main(String[] args) throws UnknownHostException, SocketException {
		
		
		GameSupporter server = new GameSupporter() {
			
			@Override
			public void setCommunicationsReady() {
				System.out.println("Conection ready");
				
			}
			
			@Override
			public void receivedEndOfCommunicationsFromOtherUser() {
				System.out.println("Conection ended");
				
			}
			
			@Override
			public void received(String text) {
				System.out.println("Server Received:" + text);
				
			}
			
		
		};
		server.setSize(500, 500);
		server.setVisible(true);
		JTextField text = new JTextField();
		text.setBounds(100,50,300,50);
		JTextField text1 = new JTextField();
		text1.setBounds(100,100,300,50);
		server.add(text1);
		server.add(text);

		Communication c = server.getCommunications();
		
		try {
			address = Server.getHostAddress();
		} catch (SocketException | UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		text.setText("IP: " + address);
		text1.setText("Port: " + Server.getServerSocketLocalPort());
		
//		Client client = new Client(address, Server.getServerSocketLocalPort(), server);

	}

}
