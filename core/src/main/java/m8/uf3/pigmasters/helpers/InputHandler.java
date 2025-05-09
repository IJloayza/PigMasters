package m8.uf3.pigmasters.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import m8.uf3.pigmasters.screens.MainScreen;

public class InputHandler implements InputProcessor {

    private MainScreen screen;

    private Vector2 stageCoord;
    private Stage stage;

    private boolean aiming = false;

    public InputHandler(MainScreen screen) {
        this.screen = screen;
        stage = screen.getStage();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        switch (screen.getCurrentState()) {
            case 0 :
                AssetManager.waitMusic.stop();
                AssetManager.battleMusic.play();
                screen.setCurrentState(1);
                break;
            case 1 :
                aiming = true;
                screen.setCurrentState(2);
                break;
            case 2 :
                AssetManager.battleMusic.stop();
                AssetManager.waitMusic.play();
                screen.reset();
                break;
            default:
                screen.setCurrentState(0);
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        aiming = false;
        return true;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
