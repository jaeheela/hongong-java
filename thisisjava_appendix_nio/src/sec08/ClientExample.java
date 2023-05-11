package sec08;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class ClientExample {
	public static void main(String[] args) {
		System.out.println("[클라이언트 시작]");
		
		DatagramChannel datagramChannel = null;
		
		try {
			//DatagramChannel 생성
			datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
			
			Charset charset = Charset.forName("UTF-8");

			for(int i=1; i<=100; i++) {
				try {
					//서버로 데이터 보내기
					String sendData = "Hello Server " + i;
					ByteBuffer byteBuffer = charset.encode(sendData);
					int byteCount = datagramChannel.send(
						byteBuffer,  
						new InetSocketAddress("localhost", 50001)
					);
					System.out.println("데이터 보냄: " + sendData);
					
					//서버가 보낸 데이터 받기
					byteBuffer = ByteBuffer.allocateDirect(100);
					InetSocketAddress isa = (InetSocketAddress) datagramChannel.receive(byteBuffer);
					byteBuffer.flip();				
					String receiveData = charset.decode(byteBuffer).toString();
					System.out.println("데이터 받음: " + receiveData);
				} catch(IOException e) {
					e.printStackTrace();
					break;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			//DatagramChannel 닫기
			try { datagramChannel.close(); } catch(Exception e) {}
		}
		
		System.out.println("[클라이언트 종료]");
	}
}

