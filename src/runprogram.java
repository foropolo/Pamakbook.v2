
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class runprogram {
	
	private ArrayList<User> u = new ArrayList<User>();
	private ArrayList<Group> g = new ArrayList<Group>();
	
	public runprogram(){
		
		/*Εβαλα σε σχολια τα δεδομενα που υπαρχουν ηδη στο δυαδικο αρχειο
		 
				User u1 = new User("Makis", "it1698@uom.edu.gr",u);
				User u2 = new User("Petros", "it1624@uom.edu.gr",u);
				User u3 = new User("Maria", "it16112@uom.edu.gr",u);
				User u4 = new User("Gianna", "it16133@uom.edu.gr",u);
				User u5 = new User("Nikos", "it1658@uom.edu.gr",u);
				User u6 = new User("Babis", "it16104@uom.edu.gr",u);
				User u7 = new User("Eleni", "eleni1986@gmail.com",u);
				

				u1.addpost("Paok kai as mhn gamhsw pote!!");
				u2.addpost("den eimai kala, den exei nohma h zoh");
				u3.addpost("pizza mpyra k malamatina");
				
				Group g1 = new Group("WebGurus","A group for web passionates",g); 
				CloseGroup g2 = new CloseGroup("ExamSolutions","Solutions to common exam questions",g);
				
				u1.addfriend(u2);
				u1.addfriend(u5);
				u5.addfriend(u6);
				u3.addfriend(u4);
				u3.addfriend(u2);
				u4.addfriend(u6);
				u5.addfriend(u3);
				u1.addfriend(u6);
				u5.addfriend(u2);
				
			
				
			
				u5.commonFriends(u4);
				u1.commonFriends(u5);
				
				u1.printallfriends();
				u3.printallfriends();
				
				u4.addGroup(g1);
				u3.addGroup(g1);
				u2.addGroup(g1);
				
				u4.addGroup(g2);
				u5.addGroup(g2);
				u6.addGroup(g2);
				u5.addGroup(g2);

				
				u4.printallgroup();
				g1.printdata();
				g2.printdata();
				
				
				u4.addpost("h Java einai oti kalytero");
				u5.addpost("Poios tha parei 10?");
				u6.addpost("shmera exw agwna elate!!");
			
				
			*/
		
		ArrayList<Group> gro = deserializing2();
		ArrayList<User> use = deserializing1();
	
		Central_page po = new Central_page(use,gro);
		use = deserializing1();
		
		
	}
	
	public ArrayList<User> deserializing1() {
		try {
			FileInputStream fileIn = new FileInputStream("users.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			
			u = (ArrayList<User>) in.readObject();
			in.close();
			fileIn.close();
			
		}
		catch(EOFException e){
			e.printStackTrace();
		}
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			
			System.out.println("De-Serialization Attempted...");
			return u;
		}
		
	}
	
	public ArrayList<Group> deserializing2() {
		try {
			FileInputStream fileIn = new FileInputStream("groups.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			g = (ArrayList<Group>) in.readObject();
			in.close();
			fileIn.close();		
		}
		
		catch(IOException i) {
			i.printStackTrace();
		}
		catch(ClassNotFoundException c) {
			c.printStackTrace();
		}
		finally {
			System.out.println("De-Serialization Attempted...");
			return g;
		}
		
	}

}
