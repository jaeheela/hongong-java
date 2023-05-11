package sec03.exam01_create_buffer;

import java.nio.ByteBuffer;

public class DirectBufferExample {
	public static void main(String[] args) {
		//다이렉트 ByteBuffer 생성
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		System.out.println(buffer);
	}
}
