package sec07.exam01_asynchronous_tcpchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
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
						try {
							InetSocketAddress isa = (InetSocketAddress) asc.getRemoteAddress();
							System.out.println(isa.getHostName() + " 연결 수락");
							try { asc.close(); } catch (Exception e) {}
							System.out.println(isa.getHostName() + " 연결 종료");
						} catch (IOException e) {}
						
						//다음 클라이언트 연결 수락하기
						assc.accept(null, this);
					}			
					@Override
					public void failed(Throwable e, Void attachment) {
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
}

