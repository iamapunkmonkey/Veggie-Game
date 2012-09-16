package com.iamapunkmonkey.framework;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity {
	private GamePanel mView;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		mView = new GamePanel(this);
		
		setContentView(mView);
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		mView.onPause();
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		mView.onResume();
	}
}
