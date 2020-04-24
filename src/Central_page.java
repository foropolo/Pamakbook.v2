import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Central_page extends JFrame{

	private JTextField inputname  = new JTextField("ονομα χρηστη",7);
	private JTextField inputemail  = new JTextField("email χρηστη",7);

	private JButton createbutton = new JButton("Δημιουργια Χρηστη");
	private JPanel panel = new JPanel();
	private ArrayList<User> users;
	private ArrayList<Group> groups;
	private JButton entrybutton = new JButton("Εισοδος Χρηστη");
	private JButton savebutton = new JButton("Αποθηκευση PamakBook");
	
	
	public Central_page(ArrayList<User> us,ArrayList<Group> gr){
		
		users=us;
		groups=gr;
		
		panel.add(createbutton);
		panel.add(inputname);
		panel.add(inputemail);
		panel.add(entrybutton);
		panel.add(savebutton);
		
		entrybutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				EntryFrame p = new EntryFrame(users,gr);
			}
		});
		
		savebutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				serializing1();
				serializing2();
			}
		});
		
		createbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				int i=7;
				boolean flag=false;
				boolean creation=false;
				for(User a:us){
					if(a.getName().equals(inputname.getText())== true || a.getEmail().equals(inputemail.getText())==true){
						flag=true;
					}	
				}
				
				if(flag==false){
					User newuser=new User(inputname.getText(),inputemail.getText(),us);
					creation = newuser.exist( users);
				}
				if(creation==true){
					JOptionPane.showMessageDialog(null,"                Congratulations!!! \n User:"+inputname.getText()+" was creating succesfully!!!");
				}
				if(flag==true){
					JOptionPane.showMessageDialog(null,"The name or email has already existed!!");
				}
				if(flag==false && creation==false){
					JOptionPane.showMessageDialog(null,"This email is not acceptable!!");
				}
				
			}
		});
		
		this.setVisible(true);
		this.setSize(400, 150);
		this.setContentPane(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Κεντρικη Σελιδα");
		
		users=us;
		
	}
	
	
	public void serializing1() {
		try {
			FileOutputStream fileOut = new FileOutputStream("users.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(users);
			
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		finally {
			System.out.println("Serialization Attempted...");
		}
		
	}
	
	public void serializing2() {
		try {
			FileOutputStream fileOut = new FileOutputStream("groups.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(groups);
			
			out.close();
			fileOut.close();		
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		finally {
			System.out.println("Serialization Attempted...");
		}
		
	}
	
	
}
