package com.iamapunkmonkey.framework;

import java.util.HashMap;

import android.graphics.Canvas;
import android.view.MotionEvent;

import com.iamapunkmonkey.framework.structure.IEntityEventListener;
import com.iamapunkmonkey.framework.structure.ILevel;
import com.iamapunkmonkey.framework.structure.IRenderable;
import com.iamapunkmonkey.framework.util.EntityEventException;

public class GameManager {
	private static GameManager _gameManager;
	private HashMap<String, ILevel> _levels;
	
	private String currentLevel = "default";
	
	public GameManager(){
		_levels = new HashMap<String, ILevel>();
	}
	
	public void setCurrentLevel(String level){
		this.currentLevel = level;
	}
	
	public String getCurrentLevelName(){
		return currentLevel;
	}
	
	public ILevel getCurrentLevel(){
		return _levels.get(currentLevel);
	}
	
	public void addGameObject(GameObject obj) throws EntityEventException {
		if(obj.getEventListener() == null)
			throw new EntityEventException("You need to create a default entity event");
		_levels.get(currentLevel).addObject(obj);
	}
	
	public IRenderable getGameObject(int index){
		return _levels.get(currentLevel).getObject(index);
	}
	
	public void removeGameObject(int index){
		_levels.get(currentLevel).removeObject(index);
	}
	
	public void removeGameObject(IRenderable obj){
		_levels.get(currentLevel).removeObject(obj);
	}
	
	public boolean processTouch(float x, float y, int action){
		ILevel curLevel = _levels.get(currentLevel);
		for(int i = 0; i < curLevel.objectCount(); i++){
			IEntityEventListener event = curLevel.getObject(i).getCurrentEventListener();
			if(event != null){
				switch(action){
				case MotionEvent.ACTION_MOVE:
					event.onEventMove(x, y);
					break;
				case MotionEvent.ACTION_DOWN:
					event.onEventPress(x, y);
					break;
				case MotionEvent.ACTION_UP:
					event.onEventRelease(x, y);
					break;
				}
			}
		}
		
		return true;
	}
	
	public static GameManager GetGameManager(){
		if(_gameManager == null)
			_gameManager = new GameManager();
		
		return _gameManager;
	}

	public void update() {
		_levels.get(currentLevel).update();
	}

	public void draw(Canvas canvas) {
		_levels.get(currentLevel).draw(canvas);
	
	}
}
