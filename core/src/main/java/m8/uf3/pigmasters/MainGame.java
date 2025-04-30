package m8.uf3.pigmasters;

import com.badlogic.gdx.Game;

import m8.uf3.pigmasters.screens.FirstScreen;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MainGame extends Game {
    @Override
    public void create() {
        setScreen(new FirstScreen());
    }
}
