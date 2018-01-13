import java.util.Calendar;
import java.text.SimpleDateFormat;
public class User{

	private String account;
	private String password;
	private String username;
	private double money;
	private StringBuffer flow = new StringBuffer();

	public User(String account, String password, String username, double money){
		this.account = account;
		this.password = password;
		this.username = username;
		this.money = money;
	}

	public String getFlow(){
		return flow.toString();
	}

	public void appendFlow(String flow){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss ");
		String time = format.format(Calendar.getInstance().getTime());
		this.flow.append("\n" + time + flow);
	}

	public String getAccount(){
		return account;
	}

	public String getPassword(){
		return password;
	}

	public double getMoney(){
		return money;
	}

	public void setMoney(double money){
		this.money = money;
	}

	public String getUsername(){
		return username;
	} 
}