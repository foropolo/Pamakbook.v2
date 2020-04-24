import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CloseGroup extends Group implements Serializable{


	private int counterUser ;
	
	public CloseGroup(String aName,String aDescription,ArrayList<Group> g ){
		
		super(aName,aDescription,g);
		counterUser = 0;
		
	}
	
	public void addUser(User aUser){
		
		boolean flag = false;
		
		
		if(this.counterUser >= 1 ){
			for(User user:super.EnrolledUsers){
				if(user.isaFriend(aUser)){
					this.EnrolledUsers.add(aUser);
					aUser.EnrolledAdd(this);
					JOptionPane.showMessageDialog(null,aUser.getName()+" has been successfully enrolled in group "+this.getName());
					System.out.println(aUser.getName()+" has been successfully enrolled in group "+this.getName());
					flag = true;
					break;
				}
				
				if(user.equals(aUser)){
					System.out.println(aUser.getName()+" it's already written");
					JOptionPane.showMessageDialog(null,"This user has already written!!");
					flag=true;
					break;
				}
			}
			if(flag == false){
				JOptionPane.showMessageDialog(null,"FAILED: "+aUser.getName()+ " cannot be enrolled in group "+name);
				System.out.println("FAILED: "+aUser.getName()+ " cannot be enrolled in group "+name);
			}
		}
		if(this.EnrolledUsers.isEmpty()){
			counterUser++;
			this.EnrolledUsers.add(aUser);
			aUser.EnrolledAdd(this);
			JOptionPane.showMessageDialog(null,aUser.getName()+" has been successfully enrolled in group "+this.getName());
			System.out.println(aUser.getName()+" has been successfully enrolled in group "+this.getName());


		}

	}
	
}
