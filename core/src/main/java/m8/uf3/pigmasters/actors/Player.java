package m8.uf3.pigmasters.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {
    // player status
    public static final int PLAYER_RESTING = 0;
    public static final int PLAYER_AIMING = 1;
    public static final int PLAYER_HIT = 2;

    // player number
    public static final int PLAYER_1 = 0;
    public static final int PLAYER_2 = 1;

    private Vector2 position;
    private int width, height;
    private int number;
    private int status;
    private Rectangle collisionRect;

    public Player(float x, float y, int width, int height, int number) {
        this.width = width;
        this.height = height;
        position = new Vector2(x, y);

        this.number = number;

        collisionRect = new Rectangle();
        collisionRect.set(position.x, position.y, width, height);
    }

    public TextureRegion getPlayerTexture() {
        switch (status) {
            case PLAYER_RESTING -> {
                if (number == PLAYER_1) return null;
                else return null;

            }
            case PLAYER_AIMING -> {
                if (number == PLAYER_1) return null;
                else return null;
            }
            case PLAYER_HIT -> {
                if (number == PLAYER_1) return null;
                else return null;
            }
            default -> {
                return null;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(getPlayerTexture(), position.x, position.y, width, height);
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

    public void setPlayerResting() {
        status = PLAYER_RESTING;
    }

    public void setPlayerAiming() {
        status = PLAYER_AIMING;
    }

    public void setPlayerHit() {
        status = PLAYER_HIT;
    }
}
