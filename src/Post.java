import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Post implements Serializable{

	private String Text;
	private Date time;
	private User owner;
	
	public Post(String aText , User u){
		
		owner = u;
		this.Text=aText;
		time = new Date();
		

		
	}

	public User getOwner() {
		return owner;
	}

	public String getText() {
		return Text;
	}

	public Date getTime() {
		return time;
		
	}
	
	public String printData(){
		SimpleDateFormat ft = new SimpleDateFormat ("E yyyy/MM/dd hh:mm:ss a ");
	      
		return (owner.getName()+","+ft.format(time)+",\n"+this.getText()+"\n\n");
	}
	
	
}
