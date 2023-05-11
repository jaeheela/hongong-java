package sec03.exam03_convert_buffer;

import java.nio.ByteBuffer;

public class ArrayToIntBufferExample {
	public static void main(String[] args) throws Exception {
		//byte[] -> ByteBuffer
		byte[] byteArray = {10, 20};
		ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArray);
		System.out.println(byteBuffer1);
		
		//int[] -> ByteBuffer
		int[] intArray = { 10, 20 };
		ByteBuffer byteBuffer2= ByteBuffer.allocate(intArray.length * 4);
		byteBuffer2.asIntBuffer().put(intArray);
		System.out.println(byteBuffer2);
		
		//int[] -> ByteBuffer
		double[] doubleArray = { 10.0, 20.0 };
		ByteBuffer byteBuffer3= ByteBuffer.allocate(doubleArray.length * 8);
		byteBuffer3.asDoubleBuffer().put(doubleArray);
		System.out.println(byteBuffer3);
	}
}
