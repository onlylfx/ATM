import java.util.Scanner;
public class Query{
	private UserList userLists;
	public Query(UserList userLists){
		this.userLists = userLists;
	}
	public void queryBusiness(){
		Navigation navi = new Navigation(userLists);
		Scanner scanner = new Scanner(System.in);
		System.out.println("��ѯҵ��");
		System.out.println("�˻�������" + userLists.getUser().getUsername());
		System.out.println("��" + userLists.getUser().getMoney());
		System.out.println("1��������һ��");
		String str = scanner.nextLine();
		if (str.equals("1")) {
			navi.naviga();
		}else{
			System.out.println("������󡣷��ز˵�!");
			navi.naviga();
		}
	}
}