import java.util.Scanner;
public class Query{
	private UserList userLists;
	public Query(UserList userLists){
		this.userLists = userLists;
	}
	public void queryBusiness(){
		Navigation navi = new Navigation(userLists);
		Scanner scanner = new Scanner(System.in);
		System.out.println("查询业务");
		System.out.println("账户姓名：" + userLists.getUser().getUsername());
		System.out.println("余额：" + userLists.getUser().getMoney());
		System.out.println("1、返回上一级");
		String str = scanner.nextLine();
		if (str.equals("1")) {
			navi.naviga();
		}else{
			System.out.println("输入错误。返回菜单!");
			navi.naviga();
		}
	}
}