package ch04.exam02;

public class Example {
	public static void main(String[] args) {
		String grade = "B";
		
		/*int score = 0;
		switch (grade) {
		case "A":
			score = 100;
			break;
		case "B":
			int result = 100 - 20;
			score = result;
			break;
		default:
			score = 60;
		}*/
		
		int score = switch (grade) {
			case "A" -> 100;
			case "B" -> {
				int result = 100 - 20;
				yield result;
			}
			default -> 60;
		};		
		
		System.out.println(score);
	}
}
