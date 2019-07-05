package com.xn__gewq84h.lolquiz;



import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizQuest extends Activity{
	
	public static final int DULAY = 60;
	public static final int QUESTION_NUM = 10;	//出題数
	//public MediaPlayer mp;
	public MediaPlayer seikai;
	public MediaPlayer hazure;
	int x1 =(int) System.currentTimeMillis();
	
	
	
	
	//DB接続用
	MySQLHelpernormal opener;
	SQLiteDatabase mydbConecter;
	Cursor cursor;
	//レイアウト関連
	TextView scoreTV , countTV , questionView;
	
	
	 ImageView imageView;
	 
	Button b0,b1,b2,b3,collectBtn;
	FrameLayout maruFL , batuFL;

	//画像表示用
	Bitmap bitmap;
	//乱数
	Random rand = new Random(System.currentTimeMillis());
	//乱数を元にクイズＩＤ、正解ボタンを格納する
	int quizId , collectBtnId ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quizquest);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		
		//DB接続
		opener = new MySQLHelpernormal(this, MySQLHelpernormal.DB_NAME, null, MySQLHelpernormal.DB_VERSION);
		mydbConecter = opener.getWritableDatabase();
		
		setLayout();
		View view1 =  this.getLayoutInflater().inflate(R.layout.ikeru, null);
		addContentView(view1, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
	    // ディスプレイのインスタンス生成
	    Display disp = wm.getDefaultDisplay();
	    
	    DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
	   
	    int width = (int) metrics.xdpi;
	    int scare = (int) ((int) Math.sqrt(width)*1.4);
	    
	 
	    //指定のテキストビューのテキストサイズに倍率をかける
	    if(QGlobal.moji==0){
	    TextView text = (TextView) findViewById(R.id.q_img);
	    text.setTextSize(scare);
	    }
		
		//クエリ生成＆問い合わせ
		String query = "select * from " + MySQLHelpernormal.TBL_NAME+";";
		cursor = mydbConecter.rawQuery(query, null);
		//乱数のセット
		quizId = rand.nextInt(cursor.getCount());
		
		for(int z=1;z<11;z++){
			if(quizId == QGlobal.kishutu[z] ){
				quizId = rand.nextInt(cursor.getCount());
				z= 1;
			}
			
			}
		QGlobal.kishutu[QGlobal.count] = quizId;
		collectBtnId = rand.nextInt(4);
		//生成した乱数を元にCursorを移動
		cursor.moveToPosition(quizId);
		cursor.moveToPosition(quizId);
		//Log.d("RandomValue---->","quizId = "+quizId);
		
		/*ここさくじょしたよ
		 * 
		
		//画像をソースからゲット
		int strId = getResources().getIdentifier("i"+cursor.getInt(0), "string", this.getPackageName());
		bitmap = BitmapFactory.decodeResource(getResources(), strId);
		
		
		//レイアウトに値をセットしていく
		imageView.setImageBitmap(bitmap);
		
		
		
		TranslateAnimation  rAnime = new TranslateAnimation(0, 0,-500,0);
	rAnime.setDuration(DULAY);
	imageView.startAnimation(rAnime);
		/*
		プログレスバーxml
		<ProgressBar android:id="@+id/progbar_id"
             android:layout_width="fill_parent"
             android:layout_height="wrap_content"
             
             android:indeterminate="false"
			 style="?android:attr/progressBarStyleHorizontal"
/>
		
		ProgressBar progBar = (ProgressBar)findViewById(R.id.progbar_id);
	// 最大値を設定する.
	progBar.setMax(100);
	// プログレスバーの値を設定する.
	progBar.setProgress(50);
	// セカンダリ値を設定する.
	progBar.setSecondaryProgress(70);
	*/
	
	mydbConecter.close();
	
		int strId = getResources().getIdentifier("i"+cursor.getInt(0), "string", this.getPackageName());
		questionView.setText("\n\n "+cursor.getString(2));
		questionView.setTextColor(Color.BLACK);
		
		
		setRandomButton();//乱数によって正解のボタンを変える
		seikai = MediaPlayer.create(this, R.raw.seikai);
		hazure = MediaPlayer.create(this, R.raw.hazure);
		//mp = MediaPlayer.create(this, R.raw.bgm);
		//mp.setLooping(true);
       // mp.start();
        tokei();
        scoreTV.setText("レート："+Integer.toString(QGlobal.score));
		countTV.setText(Integer.toString(QGlobal.count)+"/"+ "10");
        
	}
@Override public void onPause() {
    	
        //音楽を停止する
       // mp.pause();
    	super.onPause();
    	
              }
    @Override 
    public void onResume(){ 
    	 
         //音楽を停止する
    	//mp.start();
        super.onResume();
       
    }
    
    @Override 
    public void onDestroy(){ 
    	 
         //音楽を停止する
    	//mp.stop();
    	//mp.release();
    	seikai.release();
    	hazure.release();
        super.onDestroy();
       
    }

    
 

	
	//--------------------------------------------
	//選択ボタンに正解とダミーの文字をセットする
	//--------------------------------------------
	public void setRandomButton(){
		String[] dummy = new String[8];
		
		int i = 4;
		while(true){
			int random = rand.nextInt(cursor.getCount());
			if(random != quizId){
				
				dummy[i] = cursor.getString(i);
				//Log.d("dummy" , "dummy"+i+"= "+dummy[i]);
				i++;
				if(i==7)break;
			}
		}
		cursor.moveToPosition(quizId);
		switch(collectBtnId){
		case 0:
			b0.setText(cursor.getString(3));//正解
			collectBtn = b0;
			b1.setText(dummy[4]);
			b2.setText(dummy[5]);
			b3.setText(dummy[6]);
			break;
		case 1:
			b1.setText(cursor.getString(3));//正解
			collectBtn = b1;
			b0.setText(dummy[4]);
			b2.setText(dummy[5]);
			b3.setText(dummy[6]);
			break;
		case 2:
			b2.setText(cursor.getString(3));//正解
			collectBtn = b2;
			b0.setText(dummy[4]);
			b1.setText(dummy[5]);
			b3.setText(dummy[6]);
			break;
		case 3:
			b3.setText(cursor.getString(3));//正解
			collectBtn = b3;
			b0.setText(dummy[4]);
			b1.setText(dummy[5]);
			b2.setText(dummy[6]);
			break;
		}
		
	}
	
	//------------------------------------
	// XMLのレイアウトたちを取得
	//------------------------------------
	public void setLayout(){
		scoreTV = (TextView) findViewById(R.id.q_score);
		countTV = (TextView) findViewById(R.id.q_count);
		questionView = (TextView) findViewById(R.id.q_img);
		b0 = (Button) findViewById(R.id.q_btn0);
		b1 = (Button) findViewById(R.id.q_btn1);
		b2 = (Button) findViewById(R.id.q_btn2);
		b3 = (Button) findViewById(R.id.q_btn3);
		
	}
	
	public void tokei(){
		Chronometer mChronometer = (Chronometer) findViewById(R.id.chronometer);
		
	     // カウントアップスタート
	     mChronometer.start();
	      
	     // カウントアップストップmChronometer.stop();
	     
	     }
	
	
	
	
	//--------------------------------------
	//選択のボタンが押下されたとき実行
	//--------------------------------------
	public void btnPress(View view){
		//Log.d("btnPress run","");
		view = (Button) view;
		if(view.getId() == collectBtn.getId()){
			//Log.d("collect","正解");
			int x2 =(int) System.currentTimeMillis();
			x1 = x1/1000;
			x2 = x2/1000;
			int  x3 =x2-x1;
			int  x4 =21-x3;
			seikai.start();
			
			view.setBackgroundColor(Color.RED);
			view.setEnabled(false);
			
			if(QGlobal.mode == 30){
				x4 = (int) (x4*6.7);
			}else{
				x4= (int) (x4*7.0);
			}
			QGlobal.score += x4;
			scoreTV.setText("+"+x4);
			
			maruFL = (FrameLayout) View.inflate(this, R.layout.maru, null);
			addContentView(maruFL, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			TranslateAnimation anime = new TranslateAnimation(0, 0,-500,0);
			anime.setDuration(DULAY);
			maruFL.startAnimation(anime);
		}else{
			//Log.d("disCollect","はずれ");
			//ボタンの無効化処理
			hazure.start();
			view.setBackgroundColor(Color.BLACK);
			view.setEnabled(false);
			//減点処理
			
			if(QGlobal.mode == 30){
				QGlobal.score -= 100;
				scoreTV.setText("-100");
			}else{
				QGlobal.score -= 50;
				scoreTV.setText("-50");
			}
			
			
			batuFL = (FrameLayout)View.inflate(this, R.layout.batu, null);
			addContentView(batuFL, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			TranslateAnimation anime = new TranslateAnimation(0, 0,-500,0);
			anime.setDuration(DULAY);
			batuFL.startAnimation(anime);
		}
	}
	//--------------------------------------------------
	//クイズ不正解時、画面タップで×画面が除去される処理
	//-------------------------------------------------
	public void NextSelect(View view){
		Log.d("frame touched" , "");
		TranslateAnimation anime = new TranslateAnimation(0, 500,0,0);
		anime.setDuration(DULAY);
		batuFL.startAnimation(anime);
		batuFL.setVisibility(View.INVISIBLE);
		scoreTV.setText("レート："+Integer.toString(QGlobal.score));
	}
	
	//------------------------------------------
	//クイズ正解時、画面タップで次の問題へ進む処理
	//------------------------------------------
	public void NextQuiz(View view){
		QGlobal.count++;
		 
		
			 if(QGlobal.count > 10){
					//10or20問終わったら結果発表のページへ
					Intent intent = new Intent(this , score.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(intent);
				}else{
					Intent intent = new Intent(this,Quiznormal.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(intent);
				
				}
		 }
		
		
	

	

	//-----------------------------------
	// 戻るボタンを押下したら実行される
	//-----------------------------------
	public boolean dispatchKeyEvent(KeyEvent event) {
		
		return true;
	}

}