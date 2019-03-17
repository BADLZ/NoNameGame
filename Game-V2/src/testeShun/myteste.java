package testeShun;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class myteste {
	CardLayout cl;
	JFrame j;
	JPanel cards;
	m1 m;
	m2 mm;
	public myteste() {
		m = new m1(this);
		mm = new m2(this);
		j = new JFrame();
		cl = new CardLayout();
		cards = new JPanel(cl);
		j.add(cards);
		
		
		cards.add(m, "game");
        cards.add(mm, "scores");
        j.setVisible(true);
        j.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
	}
	
	public void mudaCards() {
		if(m.isShowing()) {
			System.out.println("asd");
			cl.show(cards, "scores");
		}
		else
			cl.show(cards, "game");
		
	}
	public static void main(String args[]) {
		myteste m = new myteste();
	}

}
