import java.util.Scanner;
public class Menu{
	private User user;
	public Menu(User user){
		this.user = user;

	}

	public void sign(){
		// �˺ŵ�¼��֤
		//Method method = new Method(user);
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("��ӭʹ��ATM�Զ�ȡ�����");
			System.out.println("�������˻���");
			String account = scanner.nextLine();
			if (account.length() != 12) {
				System.out.println("�˺ų��Ȳ����ϣ����������룺");
				sign();
				break;
			}else if (!account.equals(user.getAccount())) {
				System.out.println("�˺Ų����ڣ����������룺");
				sign();
				break;
			}
			System.out.println("���������룺");
			String password = scanner.nextLine();
			if (password.equals(user.getPassword())) {
				System.out.println("��¼�ɹ���");
				break;
			}else{
				System.out.println("�˻�������������������룡");
			}
		}
	}
}