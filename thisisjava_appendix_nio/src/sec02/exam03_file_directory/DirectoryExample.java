package sec02.exam03_file_directory;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryExample {
	public static void main(String[] args) {
		try {
			//디렉토리 및 파일 생성
			Path path = Paths.get("C:/Temp/file1.txt");
			if(Files.notExists(path)) { Files.createFile(path); }
			path = Paths.get("C:/Temp/dir1");		
			if(Files.notExists(path)) { Files.createDirectories(path); }
			path = Paths.get("C:/Temp/dir1/file2.txt");		
			if(Files.notExists(path)) { Files.createFile(path); }
			path = Paths.get("C:/Temp/dir1/dir2");		
			if(Files.notExists(path)) { Files.createDirectories(path); }
			path = Paths.get("C:/Temp/dir1/dir2/file3.txt");		
			if(Files.notExists(path)) { Files.createFile(path); }
			
			path = Paths.get("C:/Temp");
			printDirContent(path, 0);
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//디렉토리 내용 출력
	public static void printDirContent(Path path, int indent) {
		try {
			//파일들만 출력
			DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
			directoryStream.forEach(p -> {
				if(!Files.isDirectory(p)) {
					//들여쓰기
					for(int i=0; i<indent; i++) { System.out.print("\t"); }
					//파일 이름과 크기 출력
					try {
						System.out.println(p.getFileName() + " (크기:" + Files.size(p) + ")");
					} catch(IOException e) {
						System.out.println(e.getMessage());
					}
				}
			});
			
			//디렉토리들만 출력
			directoryStream = Files.newDirectoryStream(path);
			directoryStream.forEach(p -> {
				if(Files.isDirectory(p)) {
					//들여쓰기
					for(int i=0; i<indent; i++) { System.out.print("\t"); }
					//디렉토리 이름 출력
					System.out.println("[" + p.getFileName() + "]");
					//재귀호출, 들여쓰기를 1 추가함
					printDirContent(p, indent+1);
				}
			});
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}


