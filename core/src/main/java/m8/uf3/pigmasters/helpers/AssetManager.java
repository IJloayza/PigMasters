package m8.uf3.pigmasters.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetManager {

    // Fonts
    public static BitmapFont boldFont;
    public static BitmapFont mediumFont;
    public static BitmapFont smallFont;

    // Textures


    public static void load() {
        // Fonts
        boldFont = new BitmapFont(Gdx.files.internal("fonts/PixelHigh.ttf"));
        mediumFont = new BitmapFont(Gdx.files.internal("fonts/PixelMiddle.ttf"));
        smallFont = new BitmapFont(Gdx.files.internal("fonts/PixelSmall.ttf"));

        boldFont.getData().setScale(0.6f);
        mediumFont.getData().setScale(0.4f);
        smallFont.getData().setScale(0.4f);

        // Textures

        // Sounds TODO

    }

    public static void dispose() {
        boldFont.dispose();
        mediumFont.dispose();
        smallFont.dispose();
    }

}
