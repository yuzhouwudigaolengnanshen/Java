/*���̽ṹ��ϰ*/
import java.util.Scanner;	
class BranchSentence{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("�����������ж��ܼ���");
		System.out.println("********************");
		System.out.println("������ݣ�");
		int year = sc.nextInt();
		System.out.println("�����·ݣ�");
		int month = sc.nextInt();
		System.out.println("�������ӣ�");
		int day = sc.nextInt();
		if(month == 1 ||month ==2)
		{
			month+=12;
			year--;
		}
		int week = (day + 2*month + 3*(month+1)/5+year+year/4-year/100+year/400)%7;
		switch(week)
		{
			case 0:System.out.println("��һ��");break;
			case 1:System.out.println("�ܶ���");break;
			case 2:System.out.println("������");break;
			case 3:System.out.println("���ģ�");break;
			case 4:System.out.println("���壡");break;
			case 5:System.out.println("������");break;
			case 6:System.out.println("���ߣ�");break;
		}
	}
}