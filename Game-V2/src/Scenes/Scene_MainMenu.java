package Scenes;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Scene_MainMenu extends Scenes{

	
	public Scene_MainMenu() {
		JPanel j = new JPanel();
		JButton h = new JButton();
		h.setBounds(100,100,100,100);
		j.add(h);
		super.addScene(this);
	}

}
