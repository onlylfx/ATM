import java.util.Scanner;
public class Menu{
	private User user;
	public Menu(User user){
		this.user = user;

	}

	public void sign(){
		// 账号登录验证
		//Method method = new Method(user);
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("欢迎使用ATM自动取款机！");
			System.out.println("请输入账户：");
			String account = scanner.nextLine();
			if (account.length() != 12) {
				System.out.println("账号长度不符合，请重新输入：");
				sign();
				break;
			}else if (!account.equals(user.getAccount())) {
				System.out.println("账号不存在，请重新输入：");
				sign();
				break;
			}
			System.out.println("请输入密码：");
			String password = scanner.nextLine();
			if (password.equals(user.getPassword())) {
				System.out.println("登录成功！");
				break;
			}else{
				System.out.println("账户或密码错误，请重新输入！");
			}
		}
	}
}