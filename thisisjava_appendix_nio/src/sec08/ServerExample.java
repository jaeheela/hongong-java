package sec08;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class ServerExample {
	public static void main(String[] args) {
		System.out.println("[서버 시작]");
		
		DatagramChannel datagramChannel = null;
		
		try {
			//DatagramChannel 생성
			datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
			
			//포트 바인딩
			datagramChannel.bind(new InetSocketAddress(50001));
			
			Charset charset = Charset.forName("UTF-8");

			while(true) {
				try {
					//클라이언트가 보낸 데이터 받기
					ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
					
					InetSocketAddress isa = (InetSocketAddress) datagramChannel.receive(byteBuffer);
					String clientIp = isa.getHostName();
					int clientPort = isa.getPort();
					
					byteBuffer.flip();
					String receiveData = charset.decode(byteBuffer).toString();
					System.out.println("[" + clientIp  + "] 데이터 받음: " + receiveData);
					
					//클라이언트로 데이터 보내기
					String sendData = "Hello Client " + receiveData.substring(13);
					byteBuffer = charset.encode(sendData);
					
					int byteCount = datagramChannel.send(
						byteBuffer,  
						new InetSocketAddress(clientIp, clientPort)
					);
					
					System.out.println("[" + clientIp  + "] 데이터 보냄: " + sendData);
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
		
		System.out.println("[서버 종료]");
	}
}


