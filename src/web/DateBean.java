package web;
import java.util.Calendar;

public class DateBean {
	Calendar ca = Calendar.getInstance();
	String[]arr= {"일","월","화","수","목","금","토"};
	public String getDay(int x) {
		String str ="";
		switch (x){
		case 1 : str="일" ; break;
		case 2 : str ="월"; break;
		case 3 : str ="화"; break;
		case 4 : str ="수"; break;
		case 5 : str ="목"; break;
		case 6 : str ="금"; break;
		case 7 : str ="토"; break;
		}
		return str;
	}
	public String getToday() {
		String str="";
		str+=ca.get(Calendar.YEAR)+"년";
		str+=ca.get(Calendar.MONDAY)-1+"월";
		str+=ca.get(Calendar.DATE)+"일";
		str+=arr[ca.get(Calendar.DAY_OF_WEEK)-1]+"요일";
		return str;
	}

}
