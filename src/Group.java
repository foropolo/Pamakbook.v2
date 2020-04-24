import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Group implements Serializable{
	
	protected String name;
	protected String description;
	protected ArrayList<User> EnrolledUsers ;
	
	public Group(String aName, String aDescription, ArrayList<Group> groups) {
		
		name = aName;
		description = aDescription;
		EnrolledUsers = new ArrayList<User>();
		groups.add(this);
	}
	
	public void addUser(User aUser){
		
		if(EnrolledUsers.contains(aUser)){
			System.out.println(aUser.getName()+" has already written");
			JOptionPane.showMessageDialog(null,aUser.getName()+" has already written");

			
		}
		else{
			EnrolledUsers.add(aUser);
			aUser.EnrolledAdd(this);
			System.out.println(aUser.getName()+" has been successfully enrolled in group "+this.getName());
			JOptionPane.showMessageDialog(null,aUser.getName()+" has been successfully enrolled in group "+this.getName());
		}
	}
	
	public boolean iswritten(User aUser){
		
		return EnrolledUsers.contains(aUser);
		
	}
	
	public void printdata(){
		
		int i=1;
		System.out.println("****************************");
		System.out.println("Members of group "+this.getName());
		System.out.println("****************************");

		for(User user:EnrolledUsers){
			
			System.out.println(i+": "+user.getName());
			i++;
		}
		System.out.println("-----------------------------");

	}
	
	public String getName(){
		
		return name;
		
	}
	

}
