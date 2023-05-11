package ch17.exam08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
			new Member("홍길동", "개발자"),
			new Member("김나리", "디자이너"),
			new Member("신용권", "개발자")
		);
		
		Map<String, List<Member>> groupingMap = list.stream()
			.collect(Collectors.groupingBy(m -> m.getJob())); 

		System.out.println("[개발자]");
		groupingMap.get("개발자").stream()
			.forEach(m -> System.out.println(m));
		
		System.out.println();
		
		System.out.println("[디자이너]");
		groupingMap.get("디자이너").stream()
			.forEach(m -> System.out.println(m));
	}
}
