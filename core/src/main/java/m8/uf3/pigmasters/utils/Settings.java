package m8.uf3.pigmasters.utils;

import com.badlogic.gdx.Gdx;

public class Settings {
    public static final int GAME_WIDTH = Gdx.graphics.getWidth();
    public static final int GAME_HEIGHT = Gdx.graphics.getHeight();

    public static final int PLATFORM_WIDTH = 1;
    public static final int PLATFORM_HEIGHT = 1;

    public static final int PLATFORM1_STARTX = 1;
    public static final int PLATFORM2_STARTX = 1;
    public static final int PLATFORM_STARTY = 0;

    public static final int PLAYER_WIDTH = 1;
    public static final int PLAYER_HEIGHT = 1;

    public static final int PLAYER1_STARTX = 1;
    public static final int PLAYER2_STARTX = 1;
    public static final int PLAYER_STARTY = PLATFORM_STARTY + PLAYER_HEIGHT;
}
