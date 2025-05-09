package m8.uf3.pigmasters.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
    public static TextureRegion[] whiteShootU;
    public static TextureRegion whiteHurt;
    public static TextureRegion whiteDown;

    public static TextureRegion[] blackStand;
    public static TextureRegion[] blackDraw;
    public static TextureRegion[] blackShootF;
    public static TextureRegion[] blackShootD;
    public static TextureRegion[] blackShootU;
    public static TextureRegion blackHurt;
    public static TextureRegion blackDown;

    // Sounds
    // White
    public static Sound whiteDeathSound;
    public static Sound whiteFailSond;
    public static Sound whiteHurtSound;
    public static Sound[] whiteTurnSounds;

    // Black
    public static Sound blackDeathSound;
    public static Sound blackFailSound;
    public static Sound blackHurtSound;
    public static Sound[] blackTurnSounds;

    // Background music: https://tallbeard.itch.io/music-loop-bundle
    // Sketchbook 2024-11-07
    // Sketchbook 2024-11-13
    public static Music waitMusic;
    public static Music battleMusic;

    public static void load() {
        spritesheet = new Texture(Gdx.files.internal("img/sheet.png"));

        //Extreure de 64 en 64 els Textures dels porcs nomec cal alçada de sprite
        whiteStand = extractFrames(0, 0, 4, false);
        whiteDraw = extractFrames(0, 128, 4, false);
        whiteShootF = extractFrames(0, 192, 6, false);
        whiteShootD = extractFrames(0, 256, 5, false);
        whiteShootU = extractFrames(0, 320, 5, false);
        whiteHurt = new TextureRegion(spritesheet, 0, 384, 64, 64);
        whiteDown = new TextureRegion(spritesheet, 64, 384, 64, 64);

        blackStand = extractFrames(0, 448, 4, true);
        blackDraw = extractFrames(0, 576, 4, true);
        blackShootF = extractFrames(0, 640, 6, true);
        blackShootD = extractFrames(0, 704, 5, true);
        blackShootU = extractFrames(0, 768, 5, true);
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

        // Crea sonidos
        initSounds();
    }

    private static TextureRegion[] extractFrames(int x, int y, int count, boolean flipX) {
        TextureRegion[] frames = new TextureRegion[count];
        for (int i = 0; i < count; i++) {
            TextureRegion frame = new TextureRegion(spritesheet, x + i * 64, y, 64, 64);
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
        disposeSounds();
    }

    private static void initSounds() {
        // White pig sounds
        whiteDeathSound = Gdx.audio.newSound(Gdx.files.internal("sounds/white_death.ogg"));
        whiteFailSond = Gdx.audio.newSound(Gdx.files.internal("sounds/white_fail.ogg"));
        whiteHurtSound = Gdx.audio.newSound(Gdx.files.internal("sounds/white_hurt.ogg"));
        whiteTurnSounds = new Sound[3];
        whiteTurnSounds[0] = Gdx.audio.newSound(Gdx.files.internal("sounds/white_turn_1.wav"));
        whiteTurnSounds[1] = Gdx.audio.newSound(Gdx.files.internal("sounds/white_turn_2.wav"));
        whiteTurnSounds[2] = Gdx.audio.newSound(Gdx.files.internal("sounds/white_turn_3.ogg"));


        // Black pig sounds
        blackDeathSound = Gdx.audio.newSound(Gdx.files.internal("sounds/black_death.ogg"));
        blackFailSound = Gdx.audio.newSound(Gdx.files.internal("sounds/black_fail.ogg"));
        blackHurtSound = Gdx.audio.newSound(Gdx.files.internal("sounds/black_hurt.ogg"));
        blackTurnSounds = new Sound[2];
        blackTurnSounds[0] = Gdx.audio.newSound(Gdx.files.internal("sounds/black_turn_1.ogg"));
        blackTurnSounds[1] = Gdx.audio.newSound(Gdx.files.internal("sounds/black_turn_2.ogg"));

        // Background music
        waitMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/wait_music_1.ogg"));
        battleMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/battle_music_1.ogg"));


        // init volumes
        waitMusic.setVolume(0.4f);
        battleMusic.setVolume(0.2f);
        waitMusic.setLooping(true);
        battleMusic.setLooping(true);
    }

    public static void disposeSounds() {
        whiteDeathSound.dispose();
        whiteFailSond.dispose();
        whiteHurtSound.dispose();
        for (Sound sound : whiteTurnSounds) {
            sound.dispose();
        }

        blackDeathSound.dispose();
        blackFailSound.dispose();
        blackHurtSound.dispose();
        for (Sound sound : blackTurnSounds) {
            sound.dispose();
        }

        waitMusic.dispose();
        battleMusic.dispose();
    }

}
