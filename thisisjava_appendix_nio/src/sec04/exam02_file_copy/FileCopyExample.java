package sec04.exam02_file_copy;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileCopyExample {
	public static void main(String[] args) throws IOException {		
		//Path 생성
		Path from = Paths.get("src/sec04/exam02_file_copy/house.jpg");
		Path to = Paths.get("C:/Temp/house.jpg");
		
		//입력용 FileChannel 열기
		FileChannel fileChannel_from = FileChannel.open(
			from, StandardOpenOption.READ);
		
		//출력용 FileChannel 열기
		FileChannel fileChannel_to = FileChannel.open(
			to, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		//다이렉트 ByteBuffer를 이용해서 데이터 입출력
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		while(true) {
			int byteCount = fileChannel_from.read(buffer);
			if(byteCount == -1) break;
			buffer.flip();
			fileChannel_to.write(buffer);
			buffer.clear();
		}
		
		//FileChannel 닫기
		fileChannel_from.close();
		fileChannel_to.close();
		System.out.println("파일 복사 성공");
	}
}
