/*流程结构练习*/
import java.util.Scanner;	
class BranchSentence{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("输入年月日判断周几？");
		System.out.println("********************");
		System.out.println("输入年份？");
		int year = sc.nextInt();
		System.out.println("输入月份？");
		int month = sc.nextInt();
		System.out.println("输入日子？");
		int day = sc.nextInt();
		if(month == 1 ||month ==2)
		{
			month+=12;
			year--;
		}
		int week = (day + 2*month + 3*(month+1)/5+year+year/4-year/100+year/400)%7;
		switch(week)
		{
			case 0:System.out.println("周一！");break;
			case 1:System.out.println("周二！");break;
			case 2:System.out.println("周三！");break;
			case 3:System.out.println("周四！");break;
			case 4:System.out.println("周五！");break;
			case 5:System.out.println("周六！");break;
			case 6:System.out.println("周七！");break;
		}
	}
}