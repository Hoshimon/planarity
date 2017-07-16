package com.planarity.hoshi.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.planarity.hoshi.Planarity;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.foregroundFPS = 144;

		config.title = "Planarity";
		config.width = 600;
		config.height = 600;

		new LwjglApplication(new Planarity(), config);
	}
}
