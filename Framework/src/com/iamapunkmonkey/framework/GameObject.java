package com.iamapunkmonkey.framework;

import java.util.HashMap;

import com.iamapunkmonkey.framework.structure.IEntity;
import com.iamapunkmonkey.framework.structure.IEntityEventListener;
import com.iamapunkmonkey.framework.structure.IRenderable;

public abstract class GameObject implements IRenderable {

	private HashMap<String, IEntityEventListener> _eventList;
	private HashMap<String, IEntity> _children;
	
	private String _currentEvent = "default";
	
	public GameObject(){
		_eventList = new HashMap<String, IEntityEventListener>();
		_children = new HashMap<String, IEntity>();
	}
	
	@Override
	public void setCurrentEvent(String event){
		this._currentEvent = event;
	}
	
	@Override
	public String getCurrentEvent(){
		return _currentEvent;
	}
	
	@Override
	public void addChild(String name, IEntity child) {
		_children.put(name, child);
	}

	@Override
	public IEntity getChild(String name) {
		return _children.get(name);
	}

	@Override
	public void addEventListener(String name, IEntityEventListener event) {
		_eventList.put(name, event);
	}

	@Override
	public IEntityEventListener getEventListener(String name) {
		return _eventList.get(name);
	}

	@Override
	public void addDefaultEventListener(IEntityEventListener event) {
		_eventList.put("default", event);
	}

	@Override
	public IEntityEventListener getEventListener() {
		return _eventList.get("default");
	}

	@Override
	public void addCurrentEventListener(IEntityEventListener event) {
		_eventList.put(_currentEvent, event);
	}

	@Override
	public IEntityEventListener getCurrentEventListener() {
		return _eventList.get(_currentEvent);
	}
}
