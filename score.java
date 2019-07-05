package com.xn__gewq84h.lolquiz;

import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.rankpark.RankPark;


public class score extends Activity{
	Locale locale = Locale.getDefault(); 
	TextView scoreTV , commentTV ;
	
	String[] comment = {
									//-1以下
			"ブロンズ５\n実はsmurf用アカウントとして価値があるという噂",
			"ブロンズ４\nいわゆる魔境",
			"ブロンズ３\n魔境脱出まであと少し",
			"ブロンズ２\n魔境は抜けたようです",
			"ブロンズ１\nもう少しがんばればシルバーです",//0点
			"シルバー５\nシルンゴｗｗｗｗｗｗ",
			"シルバー４\n開発者並の実力です",
			"シルバー３\nこのアプリの開発者並の実力です",
			"シルバー２\nこのアプリの開発者並の実力です",
			"シルバー１\n意外とうまかったりうまくなかったり",//10点
			"ゴールド５\nゴルンゴｗｗｗｗｗｗ",
			"ゴールド４\nなぜか魔境と呼ばれたり呼ばれなかったりする境目",
			"ゴールド３\nこのアプリの開発者は歯がたたないです",
			"ゴールド２\nすごい",
			"ゴールド１\nこのアプリの開発者をフルボッコできる程度の能力",//20点
			"プラチナ５\n上級プレーヤーの仲間入りです",
			"プラチナ４\n個人的にこの辺から動きがおかしい",
			"プラチナ３\n到達できる気がしねえ",
			"プラチナ２\nグラフィック作ってくれた方並みの実力",
			"プラチナ１\nグラフィック作ってくれた方並みの実力",//30点
			"ダイヤモンド５\nエリートの仲間入りです",
			"ダイヤモンド４\nおそロシア",
			"ダイヤモンド３\n極めすぎです",
			"ダイヤモンド２\nどうやったらそんなにうまくなれるんですか？",
			"ダイヤモンド１\nあなたが神か",
			"チャレンジャー\nLOLでお金が稼げるレベル、このクイズをここまでプレイしてくれてありがとう",//40点以上
	};
	
	String[] commentNA = {
			//-1以下
"Bronze V\nIn fact, rumor that an account for smurf includes value",
"Bronze IV\nSo-Called Elo-Hell",
"Bronze III\nThere is few more it until Elo-Hell escape",
"Bronze II\nThe Elo-hell seemed to fall out",
"Bronze I\nIt is silver if I do my best a little more",//0点
"Silver V\nSomeone said to be weaker than Bronze",
"Silver IV\nAt the same level as me",
"Silver III\nAt the same level as me",
"Silver II\nAt the same level as me",
"Silver I\nIt is strong and is weak and",//10点
"Gold V\nSomeone said to be weaker than Silver",
"Gold IV\nThe border which I am called a Elo-hell for some reason, and is not called",
"Gold III\nI can not win to you",
"Gold II\nGreat",
"Gold I\nThere is ability to overwhelm me.",//20点
"Platinum V\nIt is the member of the senior player",
"Platinum IV\nA fight is funny personally from this neighborhood",
"Platinum III\nI do not feel accessible",
"Platinum II\nAt the same level as The person who made this game graphic",
"Platinum I\nAt the same level as The person who made this game graphic",//30点
"Diamond V\n It is the member of the elite",
"Diamond IV\n marvelous player",
"Diamond III\nYou are too much full of it",
"Diamond II\nHow do you get used to being so good if you do it?",
"Diamond I\nAre you God?",
"Challenger\nThe level that money can earn in LoL、Thank you for Playing",//40点以上
};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score);
		
						//クイズの点数
		setLayout();
		View view1 =  this.getLayoutInflater().inflate(R.layout.ikeru, null);
		addContentView(view1, new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		//レイアウトに値をセットしていく
		if(locale.equals(Locale.JAPAN) || locale.equals(Locale.JAPANESE)){
		scoreTV.setText("レート："+QGlobal.score);
		
			if(QGlobal.score > 2550){
				commentTV.setText(comment[25]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}
			else if(QGlobal.score > 2480){
				commentTV.setText(comment[24]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}else if(QGlobal.score > 2410){
				commentTV.setText(comment[23]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}else if(QGlobal.score > 2340){
				commentTV.setText(comment[22]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}else if(QGlobal.score > 2270){
				commentTV.setText(comment[21]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}else if(QGlobal.score > 2200){
				commentTV.setText(comment[20]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}else if(QGlobal.score > 2130){
				commentTV.setText(comment[19]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 2060){
				commentTV.setText(comment[18]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1990){
				commentTV.setText(comment[17]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1920){
				commentTV.setText(comment[16]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1850){
				commentTV.setText(comment[15]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1780){
				commentTV.setText(comment[14]);
				commentTV.setTextColor(Color.rgb(160, 148, 68));
				scoreTV.setTextColor(Color.rgb(160, 148, 68));
			}else if(QGlobal.score > 1710){
				commentTV.setText(comment[13]);
				commentTV.setTextColor(Color.rgb(160, 148, 68));
				scoreTV.setTextColor(Color.rgb(160, 148, 68));
			}else if(QGlobal.score > 1640){
				commentTV.setText(comment[12]);
				commentTV.setTextColor(Color.rgb(160, 148, 68));
				scoreTV.setTextColor(Color.rgb(160, 148, 68));
			}else if(QGlobal.score > 1570){
				commentTV.setText(comment[11]);
				commentTV.setTextColor(Color.rgb(160, 148, 68));
				scoreTV.setTextColor(Color.rgb(160, 148, 68));
			}else if(QGlobal.score > 1500){
				commentTV.setText(comment[10]);
				commentTV.setTextColor(Color.rgb(160, 148, 68));
				scoreTV.setTextColor(Color.rgb(160, 148, 68));
			}else if(QGlobal.score > 1430){
				commentTV.setText(comment[9]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1360){
				commentTV.setText(comment[8]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1290){
				commentTV.setText(comment[7]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1220){
				commentTV.setText(comment[6]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1150){
				commentTV.setText(comment[5]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1080){
				commentTV.setText(comment[4]);
				commentTV.setTextColor(Color.rgb(255, 129, 25));
				scoreTV.setTextColor(Color.rgb(255, 129, 25));
			}else if(QGlobal.score > 1010){
				commentTV.setText(comment[3]);
				commentTV.setTextColor(Color.rgb(255, 129, 25));
				scoreTV.setTextColor(Color.rgb(255, 129, 25));
			}else if(QGlobal.score > 940){
				commentTV.setText(comment[2]);
				commentTV.setTextColor(Color.rgb(255, 129, 25));
				scoreTV.setTextColor(Color.rgb(255, 129, 25));
			}else if(QGlobal.score > 870){
				commentTV.setText(comment[1]);
				commentTV.setTextColor(Color.rgb(255, 129, 25));
				scoreTV.setTextColor(Color.rgb(255, 129, 25));
			}else{
				//マイナスの場合
				commentTV.setText(comment[0]);
				commentTV.setTextColor(Color.rgb(255, 129, 25));
				scoreTV.setTextColor(Color.rgb(255, 129, 25));
			}
		}
		
		else{
			scoreTV.setText("Rate："+QGlobal.score);
			
			if(QGlobal.score > 2550){
				commentTV.setText(commentNA[25]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}
			else if(QGlobal.score > 2480){
				commentTV.setText(commentNA[24]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}else if(QGlobal.score > 2410){
				commentTV.setText(commentNA[23]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}else if(QGlobal.score > 2340){
				commentTV.setText(commentNA[22]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}else if(QGlobal.score > 2270){
				commentTV.setText(commentNA[21]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}else if(QGlobal.score > 2200){
				commentTV.setText(commentNA[20]);
				commentTV.setTextColor(Color.rgb(109, 247, 156));
				scoreTV.setTextColor(Color.rgb(109, 247, 156));
			}else if(QGlobal.score > 2130){
				commentTV.setText(commentNA[19]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 2060){
				commentTV.setText(commentNA[18]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1990){
				commentTV.setText(commentNA[17]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1920){
				commentTV.setText(commentNA[16]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1850){
				commentTV.setText(commentNA[15]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1780){
				commentTV.setText(commentNA[14]);
				commentTV.setTextColor(Color.rgb(160, 148, 68));
				scoreTV.setTextColor(Color.rgb(160, 148, 68));
			}else if(QGlobal.score > 1710){
				commentTV.setText(commentNA[13]);
				commentTV.setTextColor(Color.rgb(160, 148, 68));
				scoreTV.setTextColor(Color.rgb(160, 148, 68));
			}else if(QGlobal.score > 1640){
				commentTV.setText(commentNA[12]);
				commentTV.setTextColor(Color.rgb(160, 148, 68));
				scoreTV.setTextColor(Color.rgb(160, 148, 68));
			}else if(QGlobal.score > 1570){
				commentTV.setText(commentNA[11]);
				commentTV.setTextColor(Color.rgb(160, 148, 68));
				scoreTV.setTextColor(Color.rgb(160, 148, 68));
			}else if(QGlobal.score > 1500){
				commentTV.setText(commentNA[10]);
				commentTV.setTextColor(Color.rgb(160, 148, 68));
				scoreTV.setTextColor(Color.rgb(160, 148, 68));
			}else if(QGlobal.score > 1430){
				commentTV.setText(commentNA[9]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1360){
				commentTV.setText(commentNA[8]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1290){
				commentTV.setText(commentNA[7]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1220){
				commentTV.setText(commentNA[6]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1150){
				commentTV.setText(commentNA[5]);
				commentTV.setTextColor(Color.rgb(165, 165, 16));
				scoreTV.setTextColor(Color.rgb(165, 165, 16));
			}else if(QGlobal.score > 1080){
				commentTV.setText(commentNA[4]);
				commentTV.setTextColor(Color.rgb(255, 129, 25));
				scoreTV.setTextColor(Color.rgb(255, 129, 25));
			}else if(QGlobal.score > 1010){
				commentTV.setText(commentNA[3]);
				commentTV.setTextColor(Color.rgb(255, 129, 25));
				scoreTV.setTextColor(Color.rgb(255, 129, 25));
			}else if(QGlobal.score > 940){
				commentTV.setText(commentNA[2]);
				commentTV.setTextColor(Color.rgb(255, 129, 25));
				scoreTV.setTextColor(Color.rgb(255, 129, 25));
			}else if(QGlobal.score > 870){
				commentTV.setText(commentNA[1]);
				commentTV.setTextColor(Color.rgb(255, 129, 25));
				scoreTV.setTextColor(Color.rgb(255, 129, 25));
			}else{
				//マイナスの場合
				commentTV.setText(commentNA[0]);
				commentTV.setTextColor(Color.rgb(255, 129, 25));
				scoreTV.setTextColor(Color.rgb(255, 129, 25));
			}
		}
			
			
		}
			
	
	
	//------------------------------------
	// XMLのレイアウトたちを取得
	//------------------------------------
	public void setLayout(){
		scoreTV = (TextView)findViewById(R.id.s_score);
		commentTV = (TextView)findViewById(R.id.s_comment);
		RankPark.sendScore(this, QGlobal.score);

	}
	
	public void goTweet(View view){
		

		RankPark.startActivity(this);

	}
	
	public void reStart(View view){
		if(locale.equals(Locale.JAPAN) || locale.equals(Locale.JAPANESE)){
		if(QGlobal.mode == 10){
		QGlobal.initScore();
		Intent intent = new Intent(this , Quiz.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(intent);
		}else if(QGlobal.mode == 20){
			QGlobal.initScore20();
			Intent intent = new Intent(this , Quizhard.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intent);
		}else{
			QGlobal.initScorenormal();
			Intent intent = new Intent(this , Quiznormal.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intent);
		}
		
		
		
		
		}else{
			QGlobal.initScore();
			Intent intent = new Intent(this , QuizNA.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
			startActivity(intent);
		}
	}
	
	public void gotitle(View view){
		Intent intent = new Intent(this , MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(intent);
	}
	
	@Override
	protected void onStop() {
		// TODO 自動生成されたメソッド・スタブ
		Log.d("Score onStop","call");
		super.onStop();
	}

	//-----------------------------------
	// 戻るボタンを押下したら実行される
	//-----------------------------------
	public boolean dispatchKeyEvent(KeyEvent event) {
		return true;
	}

}
