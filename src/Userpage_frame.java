import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Userpage_frame extends JFrame {

	private JLabel steady = new JLabel("Recent Posts by Friends ");
	private JTextArea status  = new JTextArea(10,30);
	private JScrollPane statusPane = new JScrollPane(status);
	private JScrollPane scrollPane ;
	private JTextField name ;
	private JTextField email ;
	private JPanel userpage = new JPanel();
	private JButton postbutton = new JButton("Post");
	private JButton backtologinbutton = new JButton("Back to login screen");
	private JList<Post> postList = new JList<Post>();
	private ArrayList<User> users;
	private User auser;
	private JTextArea posttext = new JTextArea(10,30);
	private JList<String> suggest = new JList<String>();
	private DefaultListModel<String> model = new DefaultListModel<String>();
	private JLabel steady2= new JLabel("Suggest friends");
	private DefaultListModel<Post> model2 = new DefaultListModel<Post>();
	private ArrayList<Post> posts= new ArrayList<Post>();
	private JTextField makefriend = new JTextField("Add a new friend!!",15);
	private JButton addfriend= new JButton("Add a friend");
	private JTextField addgroups = new JTextField("Write in new group!!",15);
	private JButton addgroup= new JButton("Write in group");
	
	public Userpage_frame(ArrayList<User> u , User au,ArrayList<Group> gr){
		
		
		au.getallPost(posts);

		postList.setModel(model2);
		for(Post p:posts){
				posttext.setText(posttext.getText()+p.printData());
				model2.addElement(p);
				
		}
		ArrayList<User> sug = new ArrayList<User>();
		au.suggested(sug);
		suggest.setModel(model);
		for(User a:sug ){
			model.addElement(a.getName());
		}
		
		
		users=u;
		auser=au;
		au.addpost(status.getText());
		name = new JTextField(auser.getName());
		email = new JTextField(auser.getEmail());
		status.setText("Write what you are thinking and share it to your friends!!");	
		scrollPane = new JScrollPane(posttext);
		
		
		userpage.add(name);
		userpage.add(email);
		userpage.add(backtologinbutton);
		userpage.add(statusPane);
		userpage.add(postbutton);
		userpage.add(steady);
		userpage.add(scrollPane);
		userpage.add(steady2);
		userpage.add(suggest);
		userpage.add(makefriend);
		userpage.add(addfriend);
		userpage.add(addgroups);
		userpage.add(addgroup);
		
		addfriend.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean flag=false;
				for(User a: u){
					if(a.getName().equals(makefriend.getText())){
						au.addfriend(a);
						flag=true;
						break;
					}
				}
				if(flag==false){
					JOptionPane.showMessageDialog(null,"This user:"+makefriend.getText()+" doesn't exist!!");
				}
				
			}
		});
		
		addgroup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean flag=false;
				for(Group g:gr){
					if(g.getName().equals(addgroups.getText())){
						flag=true;
						au.addGroup(g);
						break;
					}
				}
				if(flag==false){
					JOptionPane.showMessageDialog(null,"This group:"+addgroups.getText()+" doesn't exist!!");
				}
			}
		});
		
		
		Userpage_frame pl=this; //anafora sto idio to frame gia na mporw na to xeirizomai k sta symbanta
		this.setContentPane(userpage);
		
		
		backtologinbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				pl.dispose();
			}
		});
		
		postbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String text = status.getText();

				posttext.setText(null);
				
				au.addpost(text);
				Post p =auser.getPost();
				//model2.addElement(p);
				posts.add(p);
				
				for(Post a:posts){
					posttext.setText(a.printData()+posttext.getText());
				}
			}
		});

		
		

		
		this.setVisible(true);
		this.setSize(550, 550);
		this.setTitle("User Page");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		
		
	}
	
	
}
