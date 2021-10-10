package superMario.model.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.model.Position;
import superMario.model.game.Mario;
import superMario.model.game.MovingElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MovingElementTest {
    private MovingElement movingElement;

    @BeforeEach
    public void setUp() {
        List<String> appearance=new ArrayList<>();
        appearance.add("X");
        movingElement = new MovingElement(20,0,"",appearance,1);
    }

    @Test
    public void setMovingElement(){
        Position position1 = new Position(10,10);
        movingElement.setPosition(position1);
        assertEquals(position1, movingElement.getPosition());
    }

    @Test
    public void getOldPosition(){
        Position position1 = new Position(10,10);
        movingElement.setPosition(position1);

        Position position2 = new Position(10,10);
        movingElement.setPosition(position2);

        assertEquals(position1 , movingElement.getOldPosition());

    }

    @Test
    public void setSpeedX(){
        int newSpeed=3;
        movingElement.setSpeedX(newSpeed);
        assertEquals(newSpeed,movingElement.getSpeedX());
    }


}
