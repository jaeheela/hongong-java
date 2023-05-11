package sec06.exam02_data_read_write;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

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

			while (true) {
				// 클라이언트의 연결 요청을 수락
				SocketChannel socketChannel = serverSocketChannel.accept();
				InetSocketAddress isa = (InetSocketAddress) socketChannel.getRemoteAddress();
				System.out.println(isa.getHostName() + " 연결 수락");

				ByteBuffer byteBuffer = null;
				Charset charset = Charset.forName("UTF-8");

				// 클라이언트가 보낸 데이터 받기
				byteBuffer = ByteBuffer.allocate(100);
				int byteNum = socketChannel.read(byteBuffer);
				byteBuffer.flip();
				String message = charset.decode(byteBuffer).toString();
				System.out.println(isa.getHostName() + " 데이터 받기: " + message);

				// 클라이언트로 데이터 보내기
				byteBuffer = charset.encode("Hello Client");
				socketChannel.write(byteBuffer);
				System.out.println(isa.getHostName() + " 데이터 보냄");
				
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
			} catch (IOException e1) {
			}
		}
	}
}


