package sec07.exam02_data_read_write;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;

public class ServerExample {
	private static AsynchronousChannelGroup channelGroup;
	private static AsynchronousServerSocketChannel assc;

	public static void main(String[] args) {
		System.out.println("[서버 시작]");
		
		try {
			//비동기 채널 그룹 생성
			channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
					10, Executors.defaultThreadFactory());
			
			//비동기 서버 소켓 채널 생성
			assc = AsynchronousServerSocketChannel.open(channelGroup);
			
			//포트 바인딩
			assc.bind(new InetSocketAddress(50001));
			
			//클라이언트 연결 수락하기
			assc.accept(
				null, 
				new CompletionHandler<AsynchronousSocketChannel, Void>() {
					@Override
					public void completed(AsynchronousSocketChannel asc, Void attachment) {	
											
						//클라이언트가 보낸 데이터 받기
						receive(asc);
						
						//다음 클라이언트 연결 수락하기
						assc.accept(null, this);
					}
					
					@Override
					public void failed(Throwable exc, Void attachment) {
					}
				}
			);
			
			//키보드 입력이 있을 때까지 대기
			try { System.in.read(); } catch (Exception e) {}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				assc.close();
				channelGroup.shutdownNow();
			} catch (Exception e) {}
		}

		System.out.println("[서버 종료]");
	}
	
	//클라이언트가 보낸 데이터 받기
	public static void receive(AsynchronousSocketChannel asc) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
		asc.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				try {
					attachment.flip();
					Charset charset = Charset.forName("utf-8");
					String receiveData = charset.decode(attachment).toString();
					
					String threadName = Thread.currentThread().getName();
					System.out.println("[" + threadName + "] " + "데이터 받음: " + receiveData);		
					
					//클라이언트로 데이터 보내기
					send(asc, receiveData);
				} catch(Exception e) {}
			}
			
			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				exc.printStackTrace();
				try { asc.close(); } catch (IOException e) {}
			}
		});
	}
	
	//클라이언트로 데이터 보내기
	public static void send(AsynchronousSocketChannel asc, String receiveData) {
		String sendData = "Hello Client " + receiveData.substring(13);
		Charset charset = Charset.forName("utf-8");
		ByteBuffer byteBuffer = charset.encode(sendData);
		asc.write(byteBuffer, sendData, new CompletionHandler<Integer, String>() {
			@Override
			public void completed(Integer result, String attachment) {
				String threadName = Thread.currentThread().getName();
				System.out.println("[" + threadName + "] " + "데이터 보냄: " + attachment);
				try { asc.close(); } catch (IOException e) {}
			}
			
			@Override
			public void failed(Throwable exc, String attachment) {
				exc.printStackTrace();
				try { asc.close(); } catch (IOException e) {}
			}
		});
	}
}
