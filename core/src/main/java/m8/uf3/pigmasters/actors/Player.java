package m8.uf3.pigmasters.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import m8.uf3.pigmasters.helpers.AssetManager;

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

    private int remaining_lives;

    public Player(float x, float y, int width, int height, int number) {
        this.remaining_lives = 3;

        this.width = width;
        this.height = height;
        position = new Vector2(x, y);

        this.number = number;

        collisionRect = new Rectangle();
        collisionRect.set(position.x, position.y, width, height);
    }

    public TextureRegion getPlayerTexture() {
        switch (status) {
            case PLAYER_AIMING : {
                if (number == PLAYER_1) return AssetManager.whiteShootU;
                else return AssetManager.blackShootU;
            }
            case PLAYER_HIT : {
                if (number == PLAYER_1) return AssetManager.whiteHurt;
                else return AssetManager.blackHurt;
            }
            default : {
                if (number == PLAYER_1) return AssetManager.whiteStand[0];
                else return AssetManager.blackStand;
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
