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
    public static Texture spritesheet;

    public static TextureRegion[] whiteStand;
    public static TextureRegion[] whiteDraw;
    public static TextureRegion[] whiteShootF;
    public static TextureRegion[] whiteShootD;
    public static TextureRegion whiteShootU;
    public static TextureRegion whiteHurt;
    public static TextureRegion whiteDown;

    public static TextureRegion blackStand;
    public static TextureRegion[] blackDraw;
    public static TextureRegion[] blackShootF;
    public static TextureRegion[] blackShootD;
    public static TextureRegion blackShootU;
    public static TextureRegion blackHurt;
    public static TextureRegion blackDown;

    public static void load() {
        spritesheet = new Texture(Gdx.files.internal("img/sheet.png"));

        //Extreure de 64 en 64 els Textures dels porcs nomec cal alçada de sprite
        whiteStand = extractFrames(1, 12, 4, false);
        whiteDraw = extractFrames(1, 128 + 12, 4, false);
        whiteShootF = extractFrames(1, 192 + 12, 6, false);
        whiteShootD = extractFrames(1, 256 + 12, 5, false);
        whiteShootU = new TextureRegion(spritesheet, 1, 652, 121, 116);
        whiteHurt = new TextureRegion(spritesheet, 0, 384, 64, 64);
        whiteDown = new TextureRegion(spritesheet, 64, 384, 64, 64);

        blackStand = new TextureRegion(spritesheet, 1, 888, 121, 116);
        blackStand.flip(true, false);
        blackDraw = extractFrames(0, 576, 4, true);
        blackShootF = extractFrames(0, 640, 6, true);
        blackShootD = extractFrames(0, 704, 5, true);
        blackShootU = new TextureRegion(spritesheet, 1, 1548, 121, 116);
        blackHurt = new TextureRegion(spritesheet, 0, 832, 64, 64);
        blackHurt.flip(true, false);
        blackDown = new TextureRegion(spritesheet, 64, 832, 64, 64);
        blackDown.flip(true, false);

        // Fonts
        boldFont = new BitmapFont(Gdx.files.internal("fonts/PixelHigh.fnt"));
        mediumFont = new BitmapFont(Gdx.files.internal("fonts/PixelMiddle.fnt"));
        smallFont = new BitmapFont(Gdx.files.internal("fonts/PixelSmall.fnt"));

        boldFont.getData().setScale(3f);
        mediumFont.getData().setScale(2f);
        smallFont.getData().setScale(1.3f);

        // Textures Background
        FileHandle fileBackground = Gdx.files.internal("img/backgroundPigMasters.png");
        Texture texture = new Texture(fileBackground);

        // Crear el TextureRegion a partir de esa textura
        background = new TextureRegion(texture);
    }

    private static TextureRegion[] extractFrames(int x, int y, int count, boolean flipX) {
        TextureRegion[] frames = new TextureRegion[count];
        for (int i = 0; i < count; i++) {
            TextureRegion frame = new TextureRegion(spritesheet, x + i * 121, y, 121, 116);
            if (flipX) frame.flip(true, false);
            frames[i] = frame;
        }
        return frames;
    }

    public static void dispose() {
        boldFont.dispose();
        mediumFont.dispose();
        smallFont.dispose();
        spritesheet.dispose();
    }

}
