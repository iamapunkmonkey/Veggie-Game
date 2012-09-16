package com.iamapunkmonkey.framework.structure;

public interface ICharacter extends IRenderable {
	int getHealth();
	void setHealth(int value);
	void addHealth(int toAdd);
	void removeHealth(int toRemove);
}
