package com.iamapunkmonkey.framework;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread implements Runnable {

	private boolean running;
	private Thread thread;
	
	SurfaceHolder surfaceHolder;
	
	public GameThread(SurfaceHolder s){
		surfaceHolder = s;
	}

	@Override
	public void run() {
		while(running){
			if(surfaceHolder.getSurface().isValid()){
				Canvas canvas = surfaceHolder.lockCanvas();
				
				//GameManager.GetGameManager().getCurrentLevel().update();
				
				//GameManager.GetGameManager().getCurrentLevel().draw(canvas);
				
				GameManager.GetGameManager().update();
				GameManager.GetGameManager().draw(canvas);
				
				surfaceHolder.unlockCanvasAndPost(canvas);
			}
		}
	}

	public void onResume(){
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void onPause(){
		boolean retry = true;
		running = false;
		
		while(retry){
			try{
				thread.join();
				retry = false;
			} catch(InterruptedException e){
				
			}
		}
	}
}
