package sec04.exam01_file_read_write;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelWriteExample {
	public static void main(String[] args) throws IOException {		
		//Path 생성과 디렉토리 생성
		Path path = Paths.get("C:/Temp/file.txt");
		Files.createDirectories(path.getParent());
		
		//FileChannel 열기
		FileChannel fileChannel = FileChannel.open(
			path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		//문자열을 ByteBuffer로 변환
		String data = "안녕하세요";
		Charset charset = Charset.forName("UTF-8");
		ByteBuffer byteBuffer = charset.encode(data);
		
		//FileChannel을 통해 ByteBuffer 출력하기
		int byteCount = fileChannel.write(byteBuffer);
		System.out.println("file.txt : " + byteCount + " bytes written");
		
		//FileChannel 닫기
		fileChannel.close();
	}
}
