package com.iamapunkmonkey.framework.structure;

public interface IEntityEventListener {
	void onEventProcess();
	void onEventMove(float x, float y);
	void onEventPress(float x, float y);
	void onEventRelease(float x, float y);
}
