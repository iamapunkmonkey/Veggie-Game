package com.iamapunkmonkey.framework;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback{

	private GameThread _gameThread;
	public static int SCREEN_WIDTH = 480;
	public static int SCREEN_HEIGHT = 800;
	
	public GamePanel(Context context) {
		super(context);
		
		getHolder().addCallback(this);
		
		_gameThread = new GameThread(getHolder());
		
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
		GamePanel.SCREEN_WIDTH = width;
		GamePanel.SCREEN_HEIGHT = height;
	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		_gameThread.onPause();
	}

	@Override
	public boolean onTouchEvent(MotionEvent e){
		float x = e.getX();
		float y = e.getY();
		
		return GameManager.GetGameManager().processTouch(x, y, e.getAction());
	}
	
	public void onPause(){
		_gameThread.onPause();
	}
	
	public void onResume(){
		_gameThread.onResume();
	}
}
