public class Method{
	private User user;
	public Method(User user){
		this.user = user;
	}
	public boolean verification(String account, String password){
		if (account.equals(user.getAccount()) && password.equals(user.getPassword())) {
			return true;
		}else{
			return false;
		}
	}
	
}