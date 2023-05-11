package sec09;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClientExample extends Application {
	AsynchronousSocketChannel socketChannel;
	
	void startClient() {
		try {
			socketChannel = AsynchronousSocketChannel.open();
			socketChannel.connect(new InetSocketAddress("localhost", 50001), null, new CompletionHandler<Void, Void>() {
				@Override
				public void completed(Void result, Void attachment) {
					Platform.runLater(()->{
						try {
							displayText("[연결 완료: "  + socketChannel.getRemoteAddress() + "]");
							btnConn.setText("stop");
							btnSend.setDisable(false);
						} catch (Exception e) {}
					});		
					receive();
				}
				@Override
				public void failed(Throwable e, Void attachment) {
					Platform.runLater(()->displayText("[서버 통신 안됨]"));
					if(socketChannel.isOpen()) { stopClient(); }
				}
			});
		} catch (IOException e) {}
	}
	
	void stopClient() {
		try {
			Platform.runLater(()->{
				btnConn.setText("start");
				btnSend.setDisable(true);
			});
			socketChannel.close();
		} catch (IOException e) {}
	}	
	
	void receive() {
		ByteBuffer byteBuffer = ByteBuffer.allocate(100);
		socketChannel.read(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				try {
					attachment.flip();
					Charset charset = Charset.forName("utf-8");
					String data = charset.decode(attachment).toString();
					Platform.runLater(()->displayText("[받기 완료] "  + data));
					
					ByteBuffer byteBuffer = ByteBuffer.allocate(100);
					socketChannel.read(byteBuffer, byteBuffer, this);
				} catch(Exception e) {}
			}
			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				Platform.runLater(()->displayText("[서버 통신 안됨]"));
				stopClient();
			}
		});
	}
	
	void send(String data) {
		Charset charset = Charset.forName("utf-8");
		ByteBuffer byteBuffer = charset.encode(data);
		socketChannel.write(byteBuffer, null, new CompletionHandler<Integer, Void>() {
			@Override
			public void completed(Integer result, Void attachment) {
				Platform.runLater(()->displayText("[보내기 완료]"));
			}
			@Override
			public void failed(Throwable exc, Void attachment) {
				Platform.runLater(()->displayText("[서버 통신 안됨]"));
				stopClient();
			}
		});
	}
	
	///////////////////////////////////////////
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(300, 200);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		BorderPane bottom = new BorderPane();
			txtInput = new TextField();
			txtInput.setPrefHeight(40);
			BorderPane.setMargin(txtInput, new Insets(0,1,1,1));
			
			btnConn = new Button("start");
			btnConn.setPrefSize(80, 40);
			btnConn.setOnAction(e->{
				if(btnConn.getText().equals("start")) {
					startClient();
				} else if(btnConn.getText().equals("stop")){
					stopClient();
				}
			});
			
			btnSend = new Button("send"); 
			btnSend.setPrefSize(80, 40);
			btnSend.setDisable(true);
			btnSend.setOnAction(e->send(txtInput.getText()));
			
			bottom.setCenter(txtInput);
			bottom.setLeft(btnConn);
			bottom.setRight(btnSend);
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.setOnCloseRequest(event->stopClient());
		primaryStage.show();
	}
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}	
	
	public static void main(String[] args) {
		launch(args);
	}
}

