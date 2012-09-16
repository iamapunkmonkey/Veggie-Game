package com.iamapunkmonkey.framework.structure;

public interface IEntity {
	void addChild(String name, IEntity child);
	IEntity getChild(String name);
	
	void addEventListener(String name, IEntityEventListener event);
	IEntityEventListener getEventListener(String name);
	
	void addDefaultEventListener(IEntityEventListener event);
	IEntityEventListener getEventListener();
	
	void addCurrentEventListener(IEntityEventListener event);
	IEntityEventListener getCurrentEventListener();
	
	void setCurrentEvent(String name);
	String getCurrentEvent();
	
	void update();
}
