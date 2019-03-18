package Graphics.scenes;

import javax.swing.JLabel;

import Graphics.SceneManager;

public class Dungeon extends JLabel{
	
	SceneManager sm = new SceneManager();
	
	public Dungeon(SceneManager sm) {
		this.sm = sm;
		initialize();
	}
	
	private void initialize() {
		initializeImages();
		
		
		
	}
	
	private void initializeImages() {
		
	}

}