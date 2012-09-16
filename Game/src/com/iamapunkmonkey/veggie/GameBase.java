package com.iamapunkmonkey.veggie;

import com.iamapunkmonkey.framework.GameManager;
import com.iamapunkmonkey.framework.structure.IGameBase;

public class GameBase implements IGameBase {

	public void init() {
		GameManager.GetGameManager().setCurrentLevel("level1");
	}
}
