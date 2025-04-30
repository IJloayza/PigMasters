package m8.uf3.pigmasters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import m8.uf3.pigmasters.MainGame;
import m8.uf3.pigmasters.helpers.AssetManager;

public class FirstScreen implements Screen {

    private MainGame game;

    private Image background;

    private Stage stage;
    private Batch batch;
    private OrthographicCamera camera;

    private GlyphLayout textLayout;
    private GlyphLayout textDescription;

    public FirstScreen(MainGame game) {
        this.game = game;

        textLayout = new GlyphLayout();
        textLayout.setText(AssetManager.mediumFont, "PigMasters");

        textDescription = new GlyphLayout();
        textDescription.setText(AssetManager.mediumFont, "Aprendre el camino del cerdo");

        camera = new OrthographicCamera(1024, 768);
        camera.setToOrtho(false);

        StretchViewport viewport = new StretchViewport(1024, 768, camera);

        stage = new Stage(viewport);

        batch = stage.getBatch();

        background = new Image(AssetManager.background);

        stage.addActor(background);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        stage.draw();
        stage.act(delta);

        batch.begin();
        AssetManager.mediumFont.draw(batch, textLayout, 1024 - textLayout.width/3,
            668);

        AssetManager.mediumFont.draw(batch, textDescription, 1024 - textLayout.width/5,
            668 - 100);
        batch.end();

        /*
        if (Gdx.input.isTouched()) {
            game.setScreen(new MainScreen(game, batch, camera));
            dispose();
        }
        */
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
