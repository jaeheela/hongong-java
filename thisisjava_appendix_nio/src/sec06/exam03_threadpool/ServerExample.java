package sec06.exam03_threadpool;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample {
	public static void main(String[] args) {
		try {
			// 스레드풀 생성
			ExecutorService executorService = Executors.newFixedThreadPool(10);

			// ServerSocketChannel 열기
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

			// ServerSocketChannel 포트 바인딩
			serverSocketChannel.bind(new InetSocketAddress(50001));
			
			System.out.println("[서버 시작]");

			// 스레드풀 작업 처리
			executorService.execute(() -> {
				try {
					// 지속적인 클라이언트 연결 요청 수락
					while (true) {
						SocketChannel socketChannel = serverSocketChannel.accept();
						System.out.println();
						InetSocketAddress isa = 
								(InetSocketAddress) socketChannel.getRemoteAddress();
						System.out.println(isa.getHostName() + " 연결 수락");

						// 스레드풀 작업 처리
						executorService.execute(() -> {
							//작업 스레드 이름 얻기
							String threadName = Thread.currentThread().getName();
							
							try {
								Charset charset = Charset.forName("UTF-8");

								// 클라이언트가 보낸 데이터 받기
								ByteBuffer byteBuffer = ByteBuffer.allocate(100);
								int byteNum = socketChannel.read(byteBuffer);
								if (byteNum == -1) {
									throw new IOException();
								}
								byteBuffer.flip();
								String message = charset.decode(byteBuffer).toString();
								System.out.println("[" + threadName + "]" +
										isa.getHostName() + " 데이터 받기: " + message);

								// 클라이언트로 데이터 보내기
								byteBuffer = charset.encode("Hello Client");
								socketChannel.write(byteBuffer);
								System.out.println("[" + threadName + "]" +
										isa.getHostName() + " 데이터 보냄");
							} catch (Exception e) {
							} finally {
								try {
									// 연결 끊기
									System.out.println("[" + threadName + "]" +
											isa.getHostName() + " 연결 끊기");
									socketChannel.close();
								} catch (Exception e) {
								}
							}
						});
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						// ServerSocketChannel 닫기
						serverSocketChannel.close();
						// 스레드풀 종료
						executorService.shutdown();
					} catch (Exception e) {
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

