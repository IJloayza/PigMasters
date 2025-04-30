package m8.uf3.pigmasters.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager {


    // Fonts
    public static BitmapFont boldFont;
    public static BitmapFont mediumFont;
    public static BitmapFont smallFont;

    // Textures
    public static TextureRegion background;

    public static void load() {
        // Fonts
        boldFont = new BitmapFont(Gdx.files.internal("fonts/PixelHigh.fnt"));
        mediumFont = new BitmapFont(Gdx.files.internal("fonts/PixelMiddle.fnt"));
        smallFont = new BitmapFont(Gdx.files.internal("fonts/PixelSmall.fnt"));

        boldFont.getData().setScale(0.6f);
        mediumFont.getData().setScale(0.4f);
        smallFont.getData().setScale(0.4f);

        // Textures
        FileHandle fileBackground = Gdx.files.internal("img/backgroundPigMasters.png");
        Texture texture = new Texture(fileBackground);

        // Crear el TextureRegion a partir de esa textura
        background = new TextureRegion(texture);

        // Sounds TODO

    }

    public static void dispose() {
        boldFont.dispose();
        mediumFont.dispose();
        smallFont.dispose();
    }

}
