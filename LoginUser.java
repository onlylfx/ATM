import java.util.Scanner;
public class LoginUser{
	private User user;
	private UserList userLists;
	/*public LoginUser(User user){
		this.user = user;
	}*/

	public LoginUser(UserList userLists){
		this.userLists = userLists;
	}

	public void sign(){
		// 账号登录验证
		//Method method = new Method(user);
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("欢迎使用ATM自动取款机！");
			System.out.println("请输入账户：");
			String account = scanner.nextLine();
			if (account.length() != 4) {
				System.out.println("账号长度不符合，请重新输入：");
				sign();
				break;
			}else if (-1 == userLists.contains(account)) {
				System.out.println("账号不存在，请重新输入：");
				sign();
				break;
			}
			System.out.println("请输入密码：");
			String password = scanner.nextLine();
			user = userLists.login(account,password);
			if (user != null) {
				System.out.println("登录成功！");
				break;
			}else{
				System.out.println("账户或密码错误，请重新输入！");
				sign();
				break;
			}
		}
	}
}