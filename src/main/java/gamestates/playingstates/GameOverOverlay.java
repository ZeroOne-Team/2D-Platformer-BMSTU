package gamestates.playingstates;

import gamestates.Playing;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class GameOverOverlay extends PlayState {

    private BufferedImage backgroundImg;
    private int gameOverX, gameOverY, gameOverWidth, gameOverHeight;

    public GameOverOverlay(Playing playing) {
        super(playing);
        loadImages();
        calcBorder();
        createButtons();
    }


    @Override
    protected void loadImages() {

    }

    @Override
    protected void calcBorder() {

    }

    @Override
    protected void createButtons() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g, float scale) {

    }

    @Override
    public void mouseClicked(MouseEvent e, float scale) {

    }

    @Override
    public void mousePressed(MouseEvent e, float scale) {

    }

    @Override
    public void mouseReleased(MouseEvent e, float scale) {

    }

    @Override
    public void mouseDragged(MouseEvent e, float scale) {

    }

    @Override
    public void mouseMoved(MouseEvent e, float scale) {

    }

    @Override
    public void keyPressed(KeyEvent e, float scale) {

    }

    @Override
    public void keyReleased(KeyEvent e, float scale) {

    }

}
