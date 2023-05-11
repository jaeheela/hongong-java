package sec06.exam01_tcpchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ClientExample {
	public static void main(String[] args) {
		// SocketChannel 변수 선언
		SocketChannel socketChannel = null;

		try {
			// SocketChannel 열기
			socketChannel = SocketChannel.open();

			// 로컬 PC의 50001에서 실행 중인 ServerSocketChannel로 연결 요청
			System.out.println("[연결 요청]");
			socketChannel.connect(new InetSocketAddress("localhost", 50001));
			System.out.println("[연결 성공]");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// SocketChannel 닫기
			try {
				System.out.println("[연결 끊기]");
				socketChannel.close();
			} catch (IOException e1) {}
		}
	}
}
