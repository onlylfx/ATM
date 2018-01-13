import java.util.Scanner;
public class Navigation{
	private User user;
	private UserList userLists;
	private LoginUser loginUser;
	public Navigation(UserList userLists){
		this.userLists = userLists;
		loginUser = new LoginUser(userLists);
	}
	public void naviga(){
		System.out.println("菜单-选择业务办理");
		System.out.println("1、查询");
		System.out.println("2、转账");
		System.out.println("3、取款");
		System.out.println("4、存款");
		System.out.println("5、交易流水");
		System.out.println("6、退卡");
		Scanner scanner = new Scanner(System.in);
		LoginUser loginUser = new LoginUser(userLists);
		Update update = new Update(userLists);
		Query query = new Query(userLists);
		String number = scanner.nextLine();
		if (number.equals("1")) {
			query.queryBusiness();
		}else if (number.equals("2")) {
			update.updateTransfer();
		}
		else if (number.equals("3")) {
			update.updateDraw();
		}else if (number.equals("4")) {
			update.updateAdd();
		}else if (number.equals("5")) {
			String str = userLists.getUser().getFlow();
			System.out.println(str);
			naviga();
		}else if (number.equals("6")) {
			loginUser.sign();
			naviga();
		}else{
			System.out.println("输入不合法。请重新输入！");
			naviga();
		}
	}
}