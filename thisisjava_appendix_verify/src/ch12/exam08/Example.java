package ch12.exam08;

public class Example {
	public static void main(String[] args) {
		long start = System.nanoTime();
		
		int[] scores = new int[1000];
		for(int i=0; i<scores.length; i++) {
			scores[i] = i;
		}

		int sum = 0;
		for(int score : scores) {
			sum += score;
		}

		double avg = sum / scores.length;
		System.out.println(avg);

		long end = System.nanoTime();
		
		System.out.println((end-start) + " ns");
	}
}
