package ch18.exam10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			
			//경로 입력 받기
			System.out.print("원본 파일 경로: ");
			String originalFilePath = scanner.nextLine();
			
			System.out.print("복사 파일 경로: ");
			String targetFilePath = scanner.nextLine();
			
			//원본 파일 존재 여부 확인
			File originalFile = new File(originalFilePath);
			if(!originalFile.exists()) {
				System.out.println("원본 파일이 존재하지 않습니다.");
				System.exit(0);
			}
			
			//복사 파일 경로상에 없는 모든 디렉토리 생성
			File targetFile = new File(targetFilePath);
			File parentFile = targetFile.getParentFile();
			if(!parentFile.exists()) {
				parentFile.mkdirs();
			}
			
			//입출력 스트림 얻기
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(originalFilePath));
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(targetFilePath));
			
			//파일 데이터를 읽고 출력하기
			byte[] data = new byte[1024];
			int num = -1;
			while(true) {
				num = bis.read(data);
				if(num == -1) break;
				bos.write(data, 0, num);
			}
			System.out.println("복사가 성공되었습니다.");
			
			//입출력 스트림 닫기
			bis.close();
			bos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
