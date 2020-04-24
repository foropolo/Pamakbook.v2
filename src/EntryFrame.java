import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntryFrame extends JFrame{

	private JTextField inputname  = new JTextField("Put the name of user",12);
	private JButton checknamebutton = new JButton("Enter");
	private JPanel entrypanel = new JPanel();
	private ArrayList<User> users;
	
	
	public EntryFrame(ArrayList<User> u,ArrayList<Group> gr){ 
		
		users=u;
		
		entrypanel.add(inputname);
		entrypanel.add(checknamebutton);
		
		
		
		checknamebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text = inputname.getText();
				boolean flag = false;
				if(e.getSource() == checknamebutton){
					
					for(User a:users){
						if(a.getName().equals(text)){
							Userpage_frame uf = new Userpage_frame( u  ,a,gr);
							flag = true;
						}
						
					}
					if(flag == false){
						Not_Entry ne= new Not_Entry(text);
					}
				}
			}
		});
		
		this.setContentPane(entrypanel);
		this.setTitle("Εισοδος Χρηστη");
		this.setVisible(true);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	
		
	}
	
	
	
}
