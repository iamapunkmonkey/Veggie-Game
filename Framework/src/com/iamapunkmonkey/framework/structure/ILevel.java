package com.iamapunkmonkey.framework.structure;

import android.graphics.Canvas;

public interface ILevel {
	void addObject(IRenderable obj);
	void removeObject(int index);
	void removeObject(IRenderable obj);
	IRenderable getObject(int index);
	int objectCount();
	void update();
	void draw(Canvas canvas);
}
