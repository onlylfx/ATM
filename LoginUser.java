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
		// �˺ŵ�¼��֤
		//Method method = new Method(user);
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("��ӭʹ��ATM�Զ�ȡ�����");
			System.out.println("�������˻���");
			String account = scanner.nextLine();
			if (account.length() != 4) {
				System.out.println("�˺ų��Ȳ����ϣ����������룺");
				sign();
				break;
			}else if (-1 == userLists.contains(account)) {
				System.out.println("�˺Ų����ڣ����������룺");
				sign();
				break;
			}
			System.out.println("���������룺");
			String password = scanner.nextLine();
			user = userLists.login(account,password);
			if (user != null) {
				System.out.println("��¼�ɹ���");
				break;
			}else{
				System.out.println("�˻�������������������룡");
				sign();
				break;
			}
		}
	}
}