import java.util.Scanner;
public class Update{
	private UserList userLists;
	private LoginUser loginUser;
	private Scanner scanner = new Scanner(System.in);
	private Navigation navi;
	public Update(UserList userLists){
		this.userLists = userLists;
		navi = new Navigation(userLists);
		loginUser = new LoginUser(userLists);
	}


	// 转账
	public void updateTransfer(){
		System.out.println("转账业务：");
		System.out.println("请输入对方银行卡号：");
		String transfer = scanner.nextLine();
		System.out.println("请输入转账金额：");
		double othermoney = Double.valueOf(scanner.nextLine());
		System.out.println("1、确认");
		System.out.println("2、重新输入");
		System.out.println("3、返回菜单");
		String number1 = scanner.nextLine();
		if (number1.equals("1")) {
			User user = userLists.queryUser(transfer);
			if (user != null) {
				System.out.println("对方卡号：" + transfer);
				System.out.println("对方姓名：" + user.getUsername());
				System.out.println("转账金额：" + othermoney);
				System.out.println("1、确认转账");
				System.out.println("2、返回上一级");
				System.out.println("3、退卡");
				String number2 = scanner.nextLine();
				if (number2.equals("1")) {
					double lmoney = (user.getMoney()) + othermoney;
					user.setMoney(lmoney);
					double reallymoney = (userLists.getUser().getMoney()) - othermoney;
					userLists.getUser().setMoney(reallymoney);
					userLists.getUser().appendFlow("给：" + user.getUsername() + "转了" + othermoney +"元钱");
					user.appendFlow(userLists.getUser().getUsername() + "给您转了" + othermoney + "元钱");
					System.out.println("转账成功！返回菜单！");
					navi.naviga();
				}else if (number2.equals("2")) {
					updateTransfer();
				}else if (number2.equals("3")) {
					loginUser.sign();
					navi.naviga();
				}else{
					System.out.println("输入错误，返回菜单！");
					navi.naviga();
				}
			}else{
				System.out.println("卡号输入错误，返回菜单！");
				navi.naviga();
			}

		}else if (number1.equals("2")) {
			updateTransfer();
		}else if (number1.equals("3")) {
			navi.naviga();
		}else{
			System.out.println("输入不合法，返回菜单业务！");
			navi.naviga();
		}
	}
	// 存款
	public void updateAdd(){
		System.out.println("存款业务");
		System.out.println("请输入存款金额：");
		double index = Double.valueOf(scanner.nextLine());
		System.out.println("1、确认");
		System.out.println("2、重新输入");
		System.out.println("3、返回菜单");
		String number = scanner.nextLine();
		if (number.equals("1")) {
			System.out.println("账户姓名：" + userLists.getUser().getUsername());
			double balances = index + userLists.getUser().getMoney();
			System.out.println("余额：" + balances);
			System.out.println("存款成功！");
			userLists.getUser().appendFlow("给您自己存入了：" + index +"元钱");
			userLists.getUser().setMoney(balances);
			navi.naviga();
			
		}else if (number.equals("2")) {
			System.out.println("请输入存款金额：");
			double index1 = Double.valueOf(scanner.nextLine());
			double balance = index1 + userLists.getUser().getMoney();
			System.out.println("账户姓名：" + userLists.getUser().getUsername());
			System.out.println("余额：" + balance);
			System.out.println("存款成功！返回菜单！");
			userLists.getUser().appendFlow("给您自己存入了：" + index1 +"元钱");
			userLists.getUser().setMoney(balance);
			navi.naviga();
		}else if (number.equals("3")) {
			navi.naviga();
		}else{
			System.out.println("输入不合法，返回菜单业务！");
			navi.naviga();
		}
	}

	// 取款
	public void updateDraw(){
		System.out.println("取款业务");
		System.out.println("请输入取款金额：");
		double index = Double.valueOf(scanner.nextLine());
		System.out.println("1、确认");
		System.out.println("2、重新输入");
		System.out.println("3、返回菜单");
		String number = scanner.nextLine();
		if (number.equals("1")) {
			if (index < userLists.getUser().getMoney()) {
				//System.out.println("请输入取款金额");
				System.out.println("账户姓名：" + userLists.getUser().getUsername());
				double balance1 = userLists.getUser().getMoney() - index;
				System.out.println("余额：" + balance1);
				System.out.println("取款成功");
				userLists.getUser().appendFlow("您取出了：" + index +"元钱");
				userLists.getUser().setMoney(balance1);
				navi.naviga();
			}else if (index > userLists.getUser().getMoney()) {
				System.out.println("输入金额大于卡中金额，无法取出！返回菜单！");
				navi.naviga();
			}else{
				System.out.println("输入金额大于卡中金额，无法取出！返回菜单！");
				navi.naviga();
			}
		}else if (number.equals("2")) {
			System.out.println("请重新输入取款金额：");
			double index1 = Double.valueOf(scanner.nextLine());
			if (index1 < userLists.getUser().getMoney()) {
				//System.out.println("请输入取款金额");
				System.out.println("账户姓名：" + userLists.getUser().getUsername());
				double balance2 = userLists.getUser().getMoney() - index;
				System.out.println("余额：" + balance2);
				System.out.println("取款成功");
				userLists.getUser().appendFlow("您取出了：" + index1 +"元钱");
				userLists.getUser().setMoney(balance2);
				navi.naviga();
			}else if (index > userLists.getUser().getMoney()) {
				System.out.println("输入金额大于卡中金额，无法取出！返回菜单！");
				navi.naviga();
			}else{
				System.out.println("输入金额大于卡中金额，无法取出！返回菜单！");
				navi.naviga();
			}
		}else if (number.equals("3")) {
			navi.naviga();
		}else{
			System.out.println("输入不合法，返回菜单业务！");
			navi.naviga();
		}
	}
}