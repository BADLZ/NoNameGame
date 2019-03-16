package testeShun;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class myteste {

	public myteste() {

		JFrame j = new JFrame();
		CardLayout cl = new CardLayout();
		JPanel cards = new JPanel(cl);
		j.add(cards);
		JButton button = new JButton("asd");
		button.setBounds(1, 1, 1, 1);
		
		
		cards.add(new m1(), "game");
        cards.add(new m2(), "scores");
        j.setVisible(true);
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
	}
	public static void main(String args[]) {
		myteste m = new myteste();
	}

}
