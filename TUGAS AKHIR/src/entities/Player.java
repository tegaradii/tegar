package entities;

import utilz.LoadSave;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.DirectionConstants.*;
import static utilz.Constants.DirectionConstants.DOWN;
import static utilz.Constants.PlayerConstants.*;

public class Player extends Entity{

    private BufferedImage img;
    private BufferedImage [][] animations;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerAction = IDLE;
    private boolean moving = false, attacking = false;
    private boolean left, right, up, down;
    private float playerSpeed = 2.0f;


    public Player(float x, float y){
        super(x, y);
        loadAnimation();
    }

    public void update(){

        updatePosition();
        updateAnimationTick();
        setAnimation();

    }


    public void render(Graphics g){
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, 256, 180, null);
    }



    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed){
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)){
                aniIndex = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() {

        int starAni = playerAction;

        if(moving){
            playerAction = RUNNING;
        }else{
            playerAction = IDLE;
        }

        if(attacking){
            playerAction = ATTACK_1;
        }

        if(starAni != playerAction){
            resetAniTick();
        }
    }

    private void resetAniTick() {
        aniTick = 0;
        aniIndex = 0;
    }

    private void updatePosition() {

        moving = false;

        if (left && !right ){
            x -= playerSpeed;
            moving = true;
        } else if (right && !left){
            x += playerSpeed;
            moving = true;
        }

        if(up && !down){
            y -= playerSpeed;
            moving = true;
        } else if (down && !up){
            y += playerSpeed;
            moving = true;
        }

    }


    private void loadAnimation() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);

        animations = new BufferedImage[9][6];
        for (int i = 0; i < animations.length; i++) {
            for (int j = 0; j < animations[i].length; j++) {
                animations[i][j] = img.getSubimage(j * 64, i * 40, 64, 40);
            }
        }
    }

    public void resetDirectionBoolean(){
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public void setAttacking(boolean attacking){
        this.attacking = attacking;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
