package testeShun;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/** 
 * 
 */
public abstract class GameSupporter extends JFrame implements ICommunicationsUser {
	private static final long serialVersionUID = 1L;

	private Communication comm;

	/**
	 * constructor red
	 */
	public GameSupporter() {
		comm = new Server(this);
		setCloseActions();
		
	}

	/**
	 * constructor blue
	 */
	public GameSupporter(String address, int port) {
		comm = new Client(address, port, this);
		setCloseActions();
	}
	
	/**
	 * 
	 */
	private void setCloseActions() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				comm.closeConnection();
			}
		});
	}


	/**
	 * 
	 */
	public void setCommunications(Communication comm) {
		this.comm = comm;
	}

	/**
	 * 
	 */
	public Communication getCommunications() {
		return comm;
	}

	/**
	 * send
	 */
	public void send(String text) {
		comm.send(text);
	}


}
