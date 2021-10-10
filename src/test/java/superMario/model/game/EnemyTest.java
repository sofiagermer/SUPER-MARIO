package superMario.model.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.model.Position;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {

    Enemy enemy;

    @BeforeEach
    void setUp(){
        List<String> appearance=new ArrayList<>();
        appearance.add("ooo");
        appearance.add("ooo");
        enemy=new Enemy(300,32,"#FFFFFF",appearance,1);
    }

    @Test
    void resetPosition() {
        Position originalPosition=enemy.getPosition();
        Position position=new Position(400,32);
        enemy.setPosition(position);
        assertEquals(position,enemy.getPosition());
        enemy.resetPosition();
        assertEquals(originalPosition,enemy.getPosition());
    }
}