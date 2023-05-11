package sec04.exam01_file_read_write;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelReadExample {
	public static void main(String[] args) throws IOException {		
		//Path 생성
		Path path = Paths.get("C:/Temp/file.txt");

		//FileChannel 열기
		FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
		
		//읽은 바이트가 저장될 ByteBuffer 생성
		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
		
		//FileChannel로 부터 입력받기
		Charset charset = Charset.forName("UTF-8");
		String data = "";
		while(true) {
			int byteNum = fileChannel.read(byteBuffer);
			if(byteNum == -1) break;
			byteBuffer.flip();
			data += charset.decode(byteBuffer).toString();
			byteBuffer.clear();
		}
		
		//FileChannel 닫기
		fileChannel.close();
		
		//읽은 내용을 콘솔에 출력
		System.out.println("file.txt : " + data);
	}
}
