package Graphics;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class FancyTextField extends JTextField{

	public FancyTextField(String placeholder) {
		setBorder(BorderFactory.createEmptyBorder());
		
		
		
		
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
