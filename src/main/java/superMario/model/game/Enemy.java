package superMario.model.game;

import superMario.model.Position;

import java.util.List;

public class Enemy extends MovingElement{

    private Position spawnPoint;
    private int originalSpeed;


    public Enemy(int x, int y, String hexColor,List<String> elementAppearance, int speedX){
        super(x,y+elementAppearance.size(),hexColor,elementAppearance,speedX);
        this.spawnPoint = new Position(x,y+elementAppearance.size());
        this.originalSpeed = speedX;
    }

    public void resetPosition(){
        this.setPosition(this.spawnPoint);
        this.setSpeedX(originalSpeed);
    }

}
