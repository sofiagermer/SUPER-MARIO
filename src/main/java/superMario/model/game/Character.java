package superMario.model.game;

import superMario.gui.GlobalConfigs;
import superMario.model.Position;

import java.util.List;

public abstract class Character extends MovingElement {
    private int lives;
    private int initialLives;
    private boolean isJumping = false;

    public Character(int lives, String hexColor, List<String> characterAppearance){
        super(GlobalConfigs.TERMINAL_WIDTH/2,64,hexColor,characterAppearance,0);
        this.initialLives=lives;
        this.lives=lives;
    }

    public int getLives() {
        return lives;
    }
    public boolean isJumping(){
        return isJumping;
    }
    public void jump(){
        this.isJumping = true;
    }
    public void jumpEnd(){
        this.isJumping = false;
    }

    public void die(){
        if(lives>0) {
            lives--;
            resetPosition();
        }

    }

    public void resetLives(){
        this.lives=initialLives;
    }

    public void resetPosition(){
        setPosition(new Position(GlobalConfigs.TERMINAL_WIDTH/2,64));
    }

}
