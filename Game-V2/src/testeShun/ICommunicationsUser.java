package testeShun;


/**
 * 
 */
public interface ICommunicationsUser {

	/**
	 * 
	 */
	void setCommunicationsReady();

	/**
	 * 
	 */
	Communication getCommunications();

	/**
	 *
	 * 
	 */
	void received(String text);

	/**
	 * 
	 */
	void receivedEndOfCommunicationsFromOtherUser();

	/**
	 * 
	 */
	String getName();
}
