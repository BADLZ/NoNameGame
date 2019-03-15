package Scenes;

import java.util.ArrayList;

import javax.swing.JPanel;

public class Scenes extends JPanel{

	ArrayList<JPanel> jpanels;
	public Scenes() {
		
		jpanels = new ArrayList<JPanel>();
		
		for(JPanel j : jpanels)
			j.setVisible(false);
	}
	
	public int getNextnonVisible() {
		for(int i = 0 ; i < jpanels.size() ; i++) {
			if(jpanels.get(i).isVisible()) {
				return i+1;
			}
		}
		return 0;
	}
	
	public void changeScenes() {
		jpanels.get(getNextnonVisible()).setVisible(true);
	}

	public void addScene(JPanel jpanel) {
		jpanels.add(jpanel);
	}

}
