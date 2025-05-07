package m8.uf3.pigmasters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import m8.uf3.pigmasters.MainGame;
import m8.uf3.pigmasters.helpers.AssetManager;
import m8.uf3.pigmasters.helpers.InputHandler;

public class MainScreen implements Screen {

    public static final int READY = 0;
    public static final int RUNNING = 1;
    public static final int GAMEOVER = 2;

    private World world;
    private Image background;

    private Stage stage;
    private Batch batch;
    private OrthographicCamera camera;

    private GlyphLayout textLayout;

    private int currentState = -1;

    // Dimensiones
    private final float screenWidth = Gdx.graphics.getWidth();
    private final float screenHeight = Gdx.graphics.getHeight();

    public MainScreen() {
        Vector2 gravedad = new Vector2(0, -9.8f);

        world = new World(gravedad, true);

        textLayout = new GlyphLayout();
        textLayout.setText(AssetManager.mediumFont, "Estas listo/a?");

        // Ajustando camara
        camera = new OrthographicCamera(screenWidth, screenHeight);
        camera.position.set(screenWidth / 2, screenHeight / 2, 0);
        camera.update();
        camera.setToOrtho(false);
        StretchViewport viewport = new StretchViewport(screenWidth, screenHeight, camera);

        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        batch = stage.getBatch();

        background = new Image(AssetManager.background);
        background.setSize((float) (screenWidth*1.2), (float) (screenHeight*1.3));
        background.setPosition(screenWidth / 2, screenHeight / 2 - 50, 0);

        stage.addActor(background);

        Gdx.input.setInputProcessor(new InputHandler(this));
    }

    public Stage getStage() { return stage; }
    public int getCurrentState() { return currentState; }

    public void setCurrentState(int state) {
        currentState =state;
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(delta);

        switch (currentState) {
            case GAMEOVER :
                gameover(delta);
                break;
            case RUNNING :
                running(delta);
                break;
            case READY :
                ready();
                break;
        }
    }

    private void ready() {
        batch.begin();
        AssetManager.mediumFont.draw(batch, textLayout, (screenWidth / 2) - textLayout.width / 2, (screenHeight / 2) - textLayout.height);
        batch.end();
    }

    private void running(float delta) {}

    private void gameover(float delta) {
        stage.act(delta);

        batch.begin();
        textLayout.setText(AssetManager.mediumFont, "GAMEOVER");
        AssetManager.mediumFont.draw(batch, textLayout, (screenWidth / 2) - textLayout.width / 2, (screenHeight / 2) - textLayout.height);
        batch.end();
    }

    public void reset() {
        textLayout.setText(AssetManager.mediumFont, "Estas listo/a?");

        currentState = READY;
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}
}
