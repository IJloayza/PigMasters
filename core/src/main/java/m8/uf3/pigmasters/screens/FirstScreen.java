package m8.uf3.pigmasters.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import m8.uf3.pigmasters.MainGame;
import m8.uf3.pigmasters.helpers.AssetManager;
import m8.uf3.pigmasters.utils.Settings;

public class FirstScreen implements Screen {

    private MainGame game;

    private Image background;

    private Stage stage;
    private Batch batch;
    private OrthographicCamera camera;

    private GlyphLayout textLayout;
    private GlyphLayout textDescription;
    private TextButton playButton;


    // Dimensiones
    private final float screenWidth = Gdx.graphics.getWidth();
    private final float screenHeight = Gdx.graphics.getHeight();

    public FirstScreen(MainGame game) {
        this.game = game;

        textLayout = new GlyphLayout();
        textLayout.setText(AssetManager.mediumFont, "PigMasters");

        textDescription = new GlyphLayout();
        textDescription.setText(AssetManager.mediumFont, "Aprendre el camí del porc");

        // Ajustando camara
        camera = new OrthographicCamera(screenWidth, screenHeight);
        camera.position.set(screenWidth / 2, screenHeight / 2, 0);
        camera.update();
        camera.setToOrtho(false);
        StretchViewport viewport = new StretchViewport(screenWidth, screenHeight, camera);

        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);

        background = new Image(AssetManager.background);
        background.setSize((float) (screenWidth*1.2), (float) (screenHeight*1.3));
        background.setPosition(screenWidth / 2, screenHeight / 2 - 50, 0);

        stage.addActor(background);
        loadBtn();

        // Play lobby music
        AssetManager.waitMusic.play();
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.draw();
        stage.act(delta);

        stage.getBatch().begin();
        AssetManager.mediumFont.draw(stage.getBatch(), textLayout, screenWidth/2 - textLayout.width/2,
                Gdx.graphics.getHeight()*0.75f);

        AssetManager.mediumFont.draw(stage.getBatch(), textDescription, screenWidth/2 - textDescription.width/2,
                Gdx.graphics.getHeight()*0.75f - 100);
        stage.getBatch().end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new MainScreen());
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        camera.update();
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}

    public void loadBtn() {
        TextButton.TextButtonStyle buttonStyle = new TextButton.TextButtonStyle();
        buttonStyle.font = AssetManager.mediumFont;
        buttonStyle.fontColor = Color.WHITE;
        buttonStyle.overFontColor = Color.YELLOW;  // al pasar el mouse
        buttonStyle.downFontColor = Color.GRAY;    // al presionar

        // También puedes definir fondo con NinePatch o simple Drawable
        Pixmap pixmap = new Pixmap(200, 50, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.DARK_GRAY);
        pixmap.fill();
        buttonStyle.up = new TextureRegionDrawable(new Texture(pixmap));

        playButton = new TextButton("Play", buttonStyle);
        playButton.setPosition(
            Settings.GAME_WIDTH / 2f - playButton.getWidth() / 2,
            Settings.GAME_HEIGHT / 2f - playButton.getHeight() / 2
        );

        // Acción al hacer clic
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("¡Play pulsado!");
                // Aquí puedes cambiar de screen o iniciar el juego
            }
        });

        stage.addActor(playButton);
    }
}
