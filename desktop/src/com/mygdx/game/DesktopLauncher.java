package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument

/**
 * Class for setting-up and running the game
 */
public class DesktopLauncher {
    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.useVsync(true);
        config.setWindowedMode(1280, 720);
        config.setResizable(false);
        config.setWindowIcon("icon.png");

        config.setTitle("Smurf Game");
        new Lwjgl3Application(new MyGdxGame(), config);

    }
}
