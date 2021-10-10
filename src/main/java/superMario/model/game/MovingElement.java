package superMario.model.game;

import superMario.model.Position;

import java.util.List;

public class MovingElement extends Element {
    private Position oldPosition;

    private int speedX;

    public MovingElement(int x, int y,String hexColor,List<String> elementAppearance, int speedX) {
        super(x, y, hexColor, elementAppearance);
        this.oldPosition = getPosition();
        this.speedX = speedX;
    }

    public void setPosition(Position position) {
        oldPosition=getPosition();
        super.setPosition(position);
    }

    public Position getOldPosition() {
        return oldPosition;
    }


    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }
}
