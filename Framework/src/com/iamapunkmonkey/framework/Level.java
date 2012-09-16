package com.iamapunkmonkey.framework;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

import com.iamapunkmonkey.framework.structure.IEntity;
import com.iamapunkmonkey.framework.structure.ILevel;
import com.iamapunkmonkey.framework.structure.IRenderable;

public abstract class Level implements ILevel {
	
	List<IRenderable> levelObjects;
	
	public Level(){
		levelObjects = new ArrayList<IRenderable>();
	}
	
	@Override
	public void update() {
		
	}

	@Override
	public void draw(Canvas canvas){
		
	}
	
	@Override
	public void addObject(IRenderable obj) {
		levelObjects.add(obj);
	}

	@Override
	public void removeObject(int obj) {
		levelObjects.remove(obj);
	}
	
	@Override
	public void removeObject(IRenderable obj){
		levelObjects.remove(obj);
	}

	@Override
	public IRenderable getObject(int index) {
		return levelObjects.get(index);
	}

	@Override
	public int objectCount(){
		return levelObjects.size();
	}
}
