package sec03.exam03_convert_buffer;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

public class ByteBufferToArrayExample {
	public static void main(String[] args) throws Exception {
		//ByteBuffer -> byte[] ------------------------------------------
		ByteBuffer byteBuffer1 = ByteBuffer.allocate(3);
		byte b1 = 10; byteBuffer1.put(b1);
		byte b2 = 20; byteBuffer1.put(b2);
		byteBuffer1.flip();
		System.out.print(byteBuffer1 + " -> ");
		
		byte[] byteArray = new byte[byteBuffer1.limit()];
		byteBuffer1.get(byteArray);
		System.out.println(Arrays.toString(byteArray));
		
		//ByteBuffer -> int[] ---------------------------------------------
		ByteBuffer byteBuffer2 = ByteBuffer.allocate(16);
		byteBuffer2.putInt(10);
		byteBuffer2.putInt(20);
		byteBuffer2.flip();
		System.out.print(byteBuffer2 + " -> ");		
		
		IntBuffer intBuffer = byteBuffer2.asIntBuffer();
		int[] intArray = new int[intBuffer.capacity()];
		intBuffer.get(intArray);
		System.out.println(Arrays.toString(intArray));
		
		//ByteBuffer -> double[] ---------------------------------------
		ByteBuffer byteBuffer3 = ByteBuffer.allocate(24);
		byteBuffer3.putDouble(10.0);
		byteBuffer3.putDouble(20.0);
		byteBuffer3.flip();
		System.out.print(byteBuffer3 + " -> ");		
		
		DoubleBuffer doubleBuffer = byteBuffer3.asDoubleBuffer();
		double[] doubleArray = new double[doubleBuffer.capacity()];
		doubleBuffer.get(doubleArray);
		System.out.println(Arrays.toString(doubleArray));		
	}
}
