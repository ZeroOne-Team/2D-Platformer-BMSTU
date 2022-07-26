package playing.entities.statics;

import playing.PlayingDrawInterface;
import playing.PlayingUpdateInterface;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.Constants.GameConstants.ANI_SPEED_ENEMY;
import static utilz.Constants.GameConstants.ANI_SPEED_OBJECT;
import static utilz.Constants.LvlConstants.Entity.Coin.COIN_HEIGHT_DEFAULT;
import static utilz.Constants.LvlConstants.Entity.Coin.COIN_WIDTH_DEFAULT;
import static utilz.Constants.TextureConstants.Entity.*;


public class Coin extends ObjectEntity implements PlayingDrawInterface, PlayingUpdateInterface {
    private BufferedImage[] coinAnimation;

    private int aniTick, aniIndex;

    private boolean isActive = true;

    public Coin(double x, double y) {
        super(x, y, COIN_WIDTH_DEFAULT, COIN_HEIGHT_DEFAULT);
        setHitBoxTexture(x, y, COIN_WIDTH_DEFAULT, COIN_HEIGHT_DEFAULT);
        loadImages();
    }

    private void loadImages() {
        BufferedImage img = LoadSave.GetSpriteAtlas(ENTITY_LOCATION_TEXTURES, COIN_ATLAS_PNG);
        coinAnimation = new BufferedImage[4];
        for (int i = 0; i < coinAnimation.length; i++) {
            coinAnimation[i] = img.getSubimage(i * 16, 0, 16, 16);
        }
    }

    @Override
    public void draw(Graphics g, float scale, int lvlOffsetX, int lvlOffsetY) {
        g.drawImage(coinAnimation[aniIndex],
                (int) ((hitBoxTexture.x - lvlOffsetX) * scale),
                (int) ((hitBoxTexture.y - lvlOffsetY) * scale),
                (int) (hitBoxTexture.width * scale),
                (int) (hitBoxTexture.height * scale),
                null);
        drawHitBox(g, scale, lvlOffsetX, lvlOffsetY);
    }

    @Override
    public void update() {
        updateAnimationTick();
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= ANI_SPEED_OBJECT) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= coinAnimation.length) {
                aniIndex = 0;
            }
        }
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
