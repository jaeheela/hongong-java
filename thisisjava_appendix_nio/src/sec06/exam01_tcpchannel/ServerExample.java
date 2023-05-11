package sec06.exam01_tcpchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerExample {
	public static void main(String[] args) {
		// ServerSocketChannel 변수 선언
		ServerSocketChannel serverSocketChannel = null;

		try {
			// ServerSocketChannel 열기
			serverSocketChannel = ServerSocketChannel.open();

			// ServerSocketChannel 포트 바인딩
			serverSocketChannel.bind(new InetSocketAddress(50001));

			System.out.println("[서버 시작]");
			
			// 클라이언트의 연결 요청을 수락
			while (true) {
				SocketChannel socketChannel = serverSocketChannel.accept();
				InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
				System.out.println(isa.getHostName() + " 연결 수락");
				//연결 끊기
				System.out.println(isa.getHostName() + " 연결 끊기");
				socketChannel.close();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ServerSocketChannel 닫기
			try {
				serverSocketChannel.close();
			} catch (IOException e1) {}
		}
	}
}
