package sec07.exam01_asynchronous_tcpchannel;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ClientExample {
	public static void main(String[] args) {
		System.out.println("[클라이언트 시작]");			
		
		try {
			//비동기 소켓 채널 생성
			AsynchronousSocketChannel asc = AsynchronousSocketChannel.open();
			
			//서버로 연결 요청하기
			asc.connect(
					new InetSocketAddress("localhost", 50001), 
					null, 
					new CompletionHandler<Void, Void>() {
						@Override
						public void completed(Void result, Void attachment) {
							System.out.println("연결 성공");
							try { asc.close(); } catch (Exception e) {}
							System.out.println("연결 종료");
						}
						@Override
						public void failed(Throwable exc, Void attachment) {
							exc.printStackTrace();
							try { asc.close(); } catch (Exception e) {}
						}
				}
			);
			
			//키보드 입력이 있을 때까지 대기
			try { System.in.read(); } catch (Exception e) {}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("[클라이언트 종료]");
	}
}

