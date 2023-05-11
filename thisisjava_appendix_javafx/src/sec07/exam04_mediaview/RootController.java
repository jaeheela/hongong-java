package sec07.exam04_mediaview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class RootController implements Initializable {
	@FXML private MediaView mediaView;
	@FXML private ImageView imageView;
	@FXML private Button btnPlay;
	@FXML private Button btnPause;
	@FXML private Button btnStop;
	
	//재생 완료를 확인하는 플래그 필드
	private boolean endOfMedia;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//미디어 객체 생성
		//Media media = new Media(getClass().getResource("media/video.m4v").toString());
		Media media = new Media(getClass().getResource("media/audio.wav").toString());
		
		//미디어 플레이어 생성 및 미디어 뷰에 설정
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
	
		//READY 상태가 될 때 실행할 Runnable 설정
		mediaPlayer.setOnReady(new Runnable() {
			@Override
			public void run() {
				btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(true);
				if(mediaPlayer.isAutoPlay()) {mediaView.setVisible(false);}
			}
		});
		
		//PLAYING 상태가 될 때 실행할 Runnable 설정
		mediaPlayer.setOnPlaying(()->{
			btnPlay.setDisable(true); btnPause.setDisable(false); btnStop.setDisable(false);
		});
		
		//PAUSED 상태가 될 때 실행할 Runnable 설정
		mediaPlayer.setOnPaused(()->{
			btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(false);
		});
		
		//EndOfMedia 상태가 될 때 실행할 Runnable 설정
		mediaPlayer.setOnEndOfMedia(()->{
			endOfMedia = true;
			btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(true);
		});
		
		//STOPPED 상태가 될 때 실행할 Runnable 설정
		mediaPlayer.setOnStopped(()->{
			mediaPlayer.seek(mediaPlayer.getStartTime());
			btnPlay.setDisable(false); btnPause.setDisable(true); btnStop.setDisable(true);
		});
		
		//버튼 ActionEvent 처리
		btnPlay.setOnAction(event->{
			if(endOfMedia) { 
				mediaPlayer.stop(); //재생 중지
				mediaPlayer.seek(mediaPlayer.getStartTime()); //재생 시간을 처음으로 돌림
			}
			mediaPlayer.play(); //재생하기
			endOfMedia = false;
		});
		btnPause.setOnAction(event->mediaPlayer.pause()); //일시 정지
		btnStop.setOnAction(event->mediaPlayer.stop()); //중지
	}
}

