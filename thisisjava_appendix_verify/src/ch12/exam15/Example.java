package ch12.exam15;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Example {
	public static void main(String[] args) {
		LocalDateTime startDateTime = LocalDateTime.now();
		
		LocalDateTime endDateTime = LocalDateTime.of(
				startDateTime.getYear(),  12, 31, 0, 0, 0);
		
		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		System.out.println("남은 일자: " + remainDay);
	}
}
