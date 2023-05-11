package sec07.exam02_data_read_write;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;

public class ClientExample {
	public static void main(String[] args) {
		System.out.println("[클라이언트 시작]");

		try {
			for (int i = 1; i <= 100; i++) {
				// 비동기 소켓 채널 생성
				AsynchronousSocketChannel asc = AsynchronousSocketChannel.open();

				// 서버로 연결 요청하기
				int count = i;
				asc.connect(new InetSocketAddress("localhost", 50001), null, 
					new CompletionHandler<Void, Void>() {
						@Override
						public void completed(Void result, Void attachment) {
							// 서버로 데이터 보내기
							receive(asc, count);
						}
	
						@Override
						public void failed(Throwable exc, Void attachment) {
							exc.printStackTrace();
							try { asc.close(); } catch (Exception e) {}
						}
					}
				);
			}

			// 키보드 입력이 있을 때까지 대기
			try { System.in.read(); } catch (Exception e) {}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("[클라이언트 종료]");
	}
	
	// 서버로 데이터 보내기
	public static void receive(AsynchronousSocketChannel asc, int count) {
		Charset charset = Charset.forName("utf-8");
		String sendData = "Hello Server " + count;
		ByteBuffer byteBuffer = charset.encode(sendData);
		asc.write(byteBuffer, null, new CompletionHandler<Integer, Void>() {
			@Override
			public void completed(Integer result, Void attachment) {
				System.out.println("데이터 보냄: " + sendData);
				// 서버가 보낸 데이터 받기
				send(asc);
			}

			@Override
			public void failed(Throwable exc, Void attachment) {
				exc.printStackTrace();
				try {
					asc.close();
				} catch (Exception e) {
				}
			}
		});
	}
	
	// 서버가 보낸 데이터 받기
	public static void send(AsynchronousSocketChannel asc) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
		asc.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				try {
					attachment.flip();
					Charset charset = Charset.forName("utf-8");
					String receiveData = charset.decode(attachment).toString();
					System.out.println("데이터 받음: " + receiveData);
					asc.close();
				} catch (Exception e) {
				}
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				exc.printStackTrace();
				try { asc.close(); } catch (Exception e) {}
			}
		});
	}
}
