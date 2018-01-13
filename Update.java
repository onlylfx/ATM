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


	// ת��
	public void updateTransfer(){
		System.out.println("ת��ҵ��");
		System.out.println("������Է����п��ţ�");
		String transfer = scanner.nextLine();
		System.out.println("������ת�˽�");
		double othermoney = Double.valueOf(scanner.nextLine());
		System.out.println("1��ȷ��");
		System.out.println("2����������");
		System.out.println("3�����ز˵�");
		String number1 = scanner.nextLine();
		if (number1.equals("1")) {
			User user = userLists.queryUser(transfer);
			if (user != null) {
				System.out.println("�Է����ţ�" + transfer);
				System.out.println("�Է�������" + user.getUsername());
				System.out.println("ת�˽�" + othermoney);
				System.out.println("1��ȷ��ת��");
				System.out.println("2��������һ��");
				System.out.println("3���˿�");
				String number2 = scanner.nextLine();
				if (number2.equals("1")) {
					double lmoney = (user.getMoney()) + othermoney;
					user.setMoney(lmoney);
					double reallymoney = (userLists.getUser().getMoney()) - othermoney;
					userLists.getUser().setMoney(reallymoney);
					userLists.getUser().appendFlow("����" + user.getUsername() + "ת��" + othermoney +"ԪǮ");
					user.appendFlow(userLists.getUser().getUsername() + "����ת��" + othermoney + "ԪǮ");
					System.out.println("ת�˳ɹ������ز˵���");
					navi.naviga();
				}else if (number2.equals("2")) {
					updateTransfer();
				}else if (number2.equals("3")) {
					loginUser.sign();
					navi.naviga();
				}else{
					System.out.println("������󣬷��ز˵���");
					navi.naviga();
				}
			}else{
				System.out.println("����������󣬷��ز˵���");
				navi.naviga();
			}

		}else if (number1.equals("2")) {
			updateTransfer();
		}else if (number1.equals("3")) {
			navi.naviga();
		}else{
			System.out.println("���벻�Ϸ������ز˵�ҵ��");
			navi.naviga();
		}
	}
	// ���
	public void updateAdd(){
		System.out.println("���ҵ��");
		System.out.println("���������");
		double index = Double.valueOf(scanner.nextLine());
		System.out.println("1��ȷ��");
		System.out.println("2����������");
		System.out.println("3�����ز˵�");
		String number = scanner.nextLine();
		if (number.equals("1")) {
			System.out.println("�˻�������" + userLists.getUser().getUsername());
			double balances = index + userLists.getUser().getMoney();
			System.out.println("��" + balances);
			System.out.println("���ɹ���");
			userLists.getUser().appendFlow("�����Լ������ˣ�" + index +"ԪǮ");
			userLists.getUser().setMoney(balances);
			navi.naviga();
			
		}else if (number.equals("2")) {
			System.out.println("���������");
			double index1 = Double.valueOf(scanner.nextLine());
			double balance = index1 + userLists.getUser().getMoney();
			System.out.println("�˻�������" + userLists.getUser().getUsername());
			System.out.println("��" + balance);
			System.out.println("���ɹ������ز˵���");
			userLists.getUser().appendFlow("�����Լ������ˣ�" + index1 +"ԪǮ");
			userLists.getUser().setMoney(balance);
			navi.naviga();
		}else if (number.equals("3")) {
			navi.naviga();
		}else{
			System.out.println("���벻�Ϸ������ز˵�ҵ��");
			navi.naviga();
		}
	}

	// ȡ��
	public void updateDraw(){
		System.out.println("ȡ��ҵ��");
		System.out.println("������ȡ���");
		double index = Double.valueOf(scanner.nextLine());
		System.out.println("1��ȷ��");
		System.out.println("2����������");
		System.out.println("3�����ز˵�");
		String number = scanner.nextLine();
		if (number.equals("1")) {
			if (index < userLists.getUser().getMoney()) {
				//System.out.println("������ȡ����");
				System.out.println("�˻�������" + userLists.getUser().getUsername());
				double balance1 = userLists.getUser().getMoney() - index;
				System.out.println("��" + balance1);
				System.out.println("ȡ��ɹ�");
				userLists.getUser().appendFlow("��ȡ���ˣ�" + index +"ԪǮ");
				userLists.getUser().setMoney(balance1);
				navi.naviga();
			}else if (index > userLists.getUser().getMoney()) {
				System.out.println("��������ڿ��н��޷�ȡ�������ز˵���");
				navi.naviga();
			}else{
				System.out.println("��������ڿ��н��޷�ȡ�������ز˵���");
				navi.naviga();
			}
		}else if (number.equals("2")) {
			System.out.println("����������ȡ���");
			double index1 = Double.valueOf(scanner.nextLine());
			if (index1 < userLists.getUser().getMoney()) {
				//System.out.println("������ȡ����");
				System.out.println("�˻�������" + userLists.getUser().getUsername());
				double balance2 = userLists.getUser().getMoney() - index;
				System.out.println("��" + balance2);
				System.out.println("ȡ��ɹ�");
				userLists.getUser().appendFlow("��ȡ���ˣ�" + index1 +"ԪǮ");
				userLists.getUser().setMoney(balance2);
				navi.naviga();
			}else if (index > userLists.getUser().getMoney()) {
				System.out.println("��������ڿ��н��޷�ȡ�������ز˵���");
				navi.naviga();
			}else{
				System.out.println("��������ڿ��н��޷�ȡ�������ز˵���");
				navi.naviga();
			}
		}else if (number.equals("3")) {
			navi.naviga();
		}else{
			System.out.println("���벻�Ϸ������ز˵�ҵ��");
			navi.naviga();
		}
	}
}