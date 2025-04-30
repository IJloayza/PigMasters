package m8.uf3.pigmasters.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager {
    public static TextureRegion background;
    public static BitmapFont font;

    public static void load(){
        FileHandle fileBackground = Gdx.files.internal("img/backgroundPigMasters.png");
        Texture texture = new Texture(fileBackground);

        // Crear el TextureRegion a partir de esa textura
        background = new TextureRegion(texture);
    }
}
