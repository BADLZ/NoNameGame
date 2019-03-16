package Graphics;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class FancyTextField extends JTextField{

	public FancyTextField(String placeholder, int posX, int posY, int width, int height) {
		setBorder(BorderFactory.createEmptyBorder());
		setBounds(posX, posY, width, height);
		setText(placeholder);
		setOpaque(false);

		addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (getText().equals(placeholder)) {
		            setText("");
		            setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (getText().isEmpty()) {
		            setForeground(Color.GRAY);
		            setText(placeholder);
		        }
		    }
		    });
	}

	

}
