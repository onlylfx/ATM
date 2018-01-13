public class Test1{
	public static void main(String[] args) {
		UserList userLists = new UserList();
		LoginUser loginUser = new LoginUser(userLists);
		loginUser.sign();
		Navigation navi = new Navigation(userLists);
		navi.naviga();
	}
}