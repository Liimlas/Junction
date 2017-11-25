package com.heatfeet;

import android.os.Bundle;
import android.view.*;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.heatfeet.HeatFeet;

public class AndroidLauncher extends AndroidApplication implements ScreenOn{

	View game;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		game = initializeForView(new HeatFeet(this), config);
		setContentView(game);

	}
	@Override
	public void keepScreenOn(final boolean isOn) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				game.setKeepScreenOn(isOn);
			}
		});
	}

}
