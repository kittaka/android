package com.xn__gewq84h.lolquiz;

import java.util.Locale;

public class QGlobal {
	public static int mode;
	public static int score;	//獲得点数
	public static int count;    //今何問目か
	public static int moji;
	public static int[] kishutu = new int[11];
	public static boolean isAnimation;	//フレーム除去アニメーションが動作中か？
	Locale _lo = Locale.getDefault();
	public QGlobal() {
		 
		score = 1200;
		count = 1;
		isAnimation = false;
	}
	public static void initScore(){
		int i;
		for(i=0;i<11;i++){
			kishutu[i]=0;
		}
		mode=10;
		count = 1;
		score = 1200;
		isAnimation = false;
	}
	
	public static void initScorenormal(){
		int i;
		for(i=0;i<11;i++){
			kishutu[i]=0;
		}
		mode=30;
		count = 1;
		score = 1200;
		isAnimation = false;
	}
	
	public static void initScore20(){
		
		int i;
		for(i=0;i<11;i++){
			kishutu[i]=0;
		}
		//現在はハードモードとして使用
		mode=20;
		count = 1;
		score = 1200;
		isAnimation = false;
	}
}