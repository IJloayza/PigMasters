package m8.uf3.pigmasters.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Platform extends Actor {

    private Vector2 position;
    private int width, height;
    private Rectangle collisionRect;

    public Platform(float x, float y, int width, int height) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);

        collisionRect = new Rectangle();
        collisionRect.set(position.x, position.y, width, height);
    }

    public TextureRegion getPlatformTexture() {
        return null;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(getPlatformTexture(), position.x, position.y, width, height);
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }
}
