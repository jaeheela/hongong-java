package sec03.exam03_convert_buffer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class ByteBufferToStringExample {
	public static void main(String[] args) {
		Charset charset = Charset.forName("UTF-8");
		
		String data = "안녕하세요";
		
		//문자열 -> 인코딩 -> ByteBuffer
		ByteBuffer byteBuffer = charset.encode(data);
		System.out.println(byteBuffer);
		
		//ByteBuffer -> 디코딩 -> 문자열
		data = charset.decode(byteBuffer).toString();
		System.out.println(data);
	}
}
