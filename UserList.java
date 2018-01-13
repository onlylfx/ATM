public class UserList{

	private User user;

	public User getUser(){
		return user;
	}

	public UserList(){}

	public UserList(User[] userLists){
		this.userLists = userLists;
	}

	private User[] userLists = new User[]{
		new User("7410","101010","张海洋",1000.0), 
		new User("8520","202020","小老郭",1000.0),
		new User("9630","410410","国二子",1000.0),
		new User("3210","520520","国务院",1000.0)
	};

	// 判断数组中是否存在这个账号
	public int contains(String account){
		for (int i = 0; i < userLists.length; i++) {
			if ((userLists[i].getAccount()).equals(account)) {

				return i;
			}
		}
		return -1;
	}

	public User queryUser(String account){
		for (int i = 0; i < userLists.length; i++) {
			if ((userLists[i].getAccount()).equals(account)) {
				return userLists[i];
			}
		}
		return null;
	}

	public User login(String account, String password){
		user = null;
		int index = contains(account);
		if (index == -1) {
			// 没有找到这个账号
			return null;
		}
		if (!password.equals(userLists[index].getPassword())) {
			return null;
		}
		user =  userLists[index];
		return user;
	}

}