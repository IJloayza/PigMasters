package m8.uf3.pigmasters.textVisual;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import m8.uf3.pigmasters.helpers.AssetManager;

public class AnimationTestApp extends ApplicationAdapter {
    private SpriteBatch batch;
    private float stateTime;

    private Animation<TextureRegion> whiteStandAnim;
    private Animation<TextureRegion> blackStandAnim;

    @Override
    public void create() {
        batch = new SpriteBatch();
        AssetManager.load();

        // Por ejemplo solo test STAND para ambos cerdos
        whiteStandAnim = new Animation<>(0.2f, AssetManager.whiteStand);
        blackStandAnim = new Animation<>(0.2f, AssetManager.blackStand);

        stateTime = 0f;
    }

    @Override
    public void render() {
        stateTime += Gdx.graphics.getDeltaTime();

        Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        // Obtener frame actual
        TextureRegion whiteFrame = whiteStandAnim.getKeyFrame(stateTime, true);
        TextureRegion blackFrame = blackStandAnim.getKeyFrame(stateTime, true);

        // Dibujar lado a lado
        batch.draw(whiteFrame, 100, 200);
        batch.draw(blackFrame, 200, 200);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        AssetManager.spritesheet.dispose();
    }
}
