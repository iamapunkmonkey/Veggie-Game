package com.iamapunkmonkey.veggie;

import com.iamapunkmonkey.framework.GameActivity;

import android.os.Bundle;

public class MainActivity extends GameActivity {

    private GameBase _game;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        _game = new GameBase();
        _game.init();
    }
}
