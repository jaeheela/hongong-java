package ch12.exam16;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Example {
	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");
		System.out.println( sdf.format(now) );
	}
}
