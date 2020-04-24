import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Not_Entry extends JFrame{
	
	
	private JLabel label; 
	private JPanel panel = new JPanel();
	
	public Not_Entry(String name){
		
		label = new JLabel("User "+name+" cannot found");

		panel.add(label);	
		
		JOptionPane.showMessageDialog(null, panel);
		
	}

}
