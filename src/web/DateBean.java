package web;
import java.util.Calendar;

public class DateBean {
	Calendar ca = Calendar.getInstance();
	String[]arr= {"��","��","ȭ","��","��","��","��"};
	public String getDay(int x) {
		String str ="";
		switch (x){
		case 1 : str="��" ; break;
		case 2 : str ="��"; break;
		case 3 : str ="ȭ"; break;
		case 4 : str ="��"; break;
		case 5 : str ="��"; break;
		case 6 : str ="��"; break;
		case 7 : str ="��"; break;
		}
		return str;
	}
	public String getToday() {
		String str="";
		str+=ca.get(Calendar.YEAR)+"��";
		str+=ca.get(Calendar.MONDAY)-1+"��";
		str+=ca.get(Calendar.DATE)+"��";
		str+=arr[ca.get(Calendar.DAY_OF_WEEK)-1]+"����";
		return str;
	}

}
