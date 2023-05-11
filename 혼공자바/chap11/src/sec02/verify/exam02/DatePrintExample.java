package sec02.verify.exam02;

import java.util.Calendar;

public class DatePrintExample {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		
		int year = now.get(Calendar.YEAR);
		
		int month = now.get(Calendar.MONTH) + 1;
		String strMonth = (month<10)? ("0"+month) : (""+month);
		
		int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
		String strDayOfMonth = (dayOfMonth<10)? ("0"+dayOfMonth) : (""+dayOfMonth);
		
		String[] dayArray = {"��", "��", "ȭ", "��", "��", "��", "��"};
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		String strDayOfWeek = dayArray[dayOfWeek-1] + "����";
		
		int hour = now.get(Calendar.HOUR_OF_DAY);
		String strHour = (hour<10)? ("0"+hour) : (""+hour);
		
		int second = now.get(Calendar.SECOND);
		String strSecond = (second<10)? ("0"+second) : (""+second);
		
		System.out.print(year + "�� ");
		System.out.print(strMonth + "�� ");
		System.out.print(strDayOfMonth + "�� ");
		System.out.print(strDayOfWeek + " ");
		System.out.print(strHour + "�� ");
		System.out.print(strSecond + "�� ");
	}
}
