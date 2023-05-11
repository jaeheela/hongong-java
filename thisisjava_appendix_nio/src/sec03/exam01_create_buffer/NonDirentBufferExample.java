package sec03.exam01_create_buffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public class NonDirentBufferExample {
	public static void main(String[] args) {
		//넌다이렉트 ByteBuffer 생성
		ByteBuffer buffer1 = ByteBuffer.allocate(100);
		System.out.println(buffer1);
		System.out.println();

		//넌다이렉트 IntBuffer 생성
		IntBuffer buffer2 = IntBuffer.allocate(100);
		System.out.println(buffer2);
		System.out.println();
		
		//배열을 래핑해서 넌다이렉트 ByteBuffer 생성
		byte[] array3 = { 10, 20 };
		ByteBuffer buffer3 = ByteBuffer.wrap(array3);
		System.out.println(buffer3 + ", ");
		//래핑된 배열을 얻어 출력하기
		System.out.println(Arrays.toString(buffer3.array()));
		System.out.println();
		
		//배열을 래핑해서 넌다이렉트 CharBuffer 생성
		char[] array4 = "This is Java".toCharArray();
		CharBuffer buffer4 = CharBuffer.wrap(array4);
		System.out.println(buffer4);
		//래핑된 배열을 얻어 출력하기
		System.out.println(Arrays.toString(buffer4.array()));
	}
}
