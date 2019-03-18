package Graphics;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class FancyPasswordField extends JPasswordField{

	public FancyPasswordField(String placeholder, int posX, int posY, int width, int height) {
		setEchoChar('*');
		setBorder(BorderFactory.createEmptyBorder());
		setBounds(posX, posY, width, height);
		setForeground(new Color(255,255,255));
		setFont(new Font("Consolas", 0, 20));
		setOpaque(false);
		
	}

}
