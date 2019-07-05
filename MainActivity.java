package com.xn__gewq84h.lolquiz;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;

import com.rankpark.RankPark;

public class MainActivity extends Activity {
	//public MediaPlayer titlebgm;
	Locale locale = Locale.getDefault(); 
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		if(locale.equals(Locale.JAPAN) || locale.equals(Locale.JAPANESE)){
		setContentView(R.layout.activity_main);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		
		//	MySe.isPlayBGM = SPUtil.getInstance(this).getSettingBGM();
		View view1 =  this.getLayoutInflater().inflate(R.layout.ikeru, null);
		addContentView(view1, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		
		//titlebgm = MediaPlayer.create(this, R.raw.titlebgm);
		//titlebgm.setLooping(true);
		//titlebgm.start();
		}else{
	
			setContentView(R.layout.activity_mainna);
			setVolumeControlStream(AudioManager.STREAM_MUSIC);
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
			//	MySe.isPlayBGM = SPUtil.getInstance(this).getSettingBGM();
			View view1 =  this.getLayoutInflater().inflate(R.layout.ikeru, null);
			addContentView(view1, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
			
			//titlebgm = MediaPlayer.create(this, R.raw.titlebgm);
			//titlebgm.setLooping(true);
			//titlebgm.start();
		}
		
		
	
	}
	
	
	
	
@Override public void onPause() {
    	
        //音楽を停止する
	//titlebgm.pause();
    	super.onPause();
    	
              }
    @Override 
    public void onResume(){ 
    	 
         //音楽を停止する
    	//titlebgm.start();
        super.onResume();
       
    }
    
    @Override 
    public void onDestroy(){ 
    	 
         //音楽を停止する
    	//titlebgm.stop();
    	//titlebgm.release();
        super.onDestroy();
       
    }

    
	
	//-------------------------------------------------------
	//インテント発行して別ページへ遷移（ボタンクリックで発動）
	//-------------------------------------------------------
	/*
    public void mojishou(View v){
    	
    	if(QGlobal.moji ==0 ){
    	QGlobal.moji = 1;
    	Button button = (Button)findViewById(R.id.button4);
    	button.setText("問題:大");
    	}else{
        QGlobal.moji = 0;
    	Button button = (Button)findViewById(R.id.button4);
    	button.setText("問題:小");
    	}
    }
    */
    
	public void goQuiz(View v){
		
		QGlobal.initScore();
		Intent intent = new Intent(this,Quiz.class);
		startActivity(intent);
	}
public void goQuizNA(View v){
		
		QGlobal.initScore();
		Intent intent = new Intent(this,QuizNA.class);
		startActivity(intent);
	}
	

public void goQuiznormal(View v){
	
	QGlobal.initScorenormal();
	Intent intent = new Intent(this,Quiznormal.class);
	startActivity(intent);
}

	public void goQuiz20(View v){
		
		QGlobal.initScore20();
		Intent intent = new Intent(this,Quizhard.class);
		startActivity(intent);
	}
	
public void goranking(View v){
		
	RankPark.startActivity(this);

		
	}

}