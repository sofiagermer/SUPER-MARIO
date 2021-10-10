package superMario.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import superMario.model.Position;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LevelTest {
    private Level level;
    private Character character;

    @BeforeEach
    void setUp() throws IOException {
        character=new Mario();
        level=new Level(character);
        level.loadLevel(1);
    }

    @Test
    void isElementFloating() {
        character.setPosition(new Position(320,31+character.getHeight()));
        Assertions.assertFalse(level.isElementFloating(character));

        character.setPosition(new Position(454,character.getPosition().getY()));
        Assertions.assertTrue(level.isElementFloating(character));
    }

    @Test
    void brickCollision() {
        character.setPosition(new Position(320,31+character.getHeight()));
        Assertions.assertFalse(level.brickCollision());
        character.jump();
        if(level.getBricks().size()>0) {
            character.setPosition(new Position(level.getBricks().get(0).getPosition().getX()+1,level.getBricks().get(0).getBottomY()));
            Assertions.assertTrue(level.brickCollision());
            character.setPosition(new Position(level.getBricks().get(0).getFrontX()-1,level.getBricks().get(0).getBottomY()));
            Assertions.assertTrue(level.brickCollision());
        }
    }

    @Test
    void isMoveLegal() {
        character.setPosition(new Position(300,31+character.getHeight()));
        Assertions.assertTrue(level.isMoveLegal(character.getPosition().getRight(),character));

        character.setPosition(new Position(300,31+character.getHeight()-1));
        Assertions.assertFalse(level.isMoveLegal(character.getPosition().getRight(),character));

        character.setPosition(new Position(416-character.getWidth(),character.getPosition().getY()));
        Assertions.assertFalse(level.isMoveLegal(character.getPosition().getRight(),character));

        character.setPosition(new Position(100,character.getPosition().getY()));
        Assertions.assertFalse(level.isMoveLegal(character.getPosition().getRight(),character));
    }

    @Test
    void checkElementCollision(){
        if(level.getBricks().size()>0) {
            character.setPosition(new Position(level.getBricks().get(0).getPosition().getX()-character.getWidth(),level.getBricks().get(0).getPosition().getY()-level.getBricks().get(0).getHeight()));
            assertTrue(level.checkElementCollision(level.getBricks().get(0),character));

            character.setPosition(new Position(level.getBricks().get(0).getPosition().getX()-character.getWidth(),level.getBricks().get(0).getPosition().getY()));
            assertTrue(level.checkElementCollision(level.getBricks().get(0),character));

            character.setPosition(new Position(level.getBricks().get(0).getPosition().getX(),level.getBricks().get(0).getPosition().getY()-level.getBricks().get(0).getHeight()));
            assertTrue(level.checkElementCollision(level.getBricks().get(0),character));

            character.setPosition(new Position(level.getBricks().get(0).getFrontX(),level.getBricks().get(0).getPosition().getY()-level.getBricks().get(0).getHeight()));
            assertTrue(level.checkElementCollision(level.getBricks().get(0),character));

            character.setPosition(new Position(level.getBricks().get(0).getFrontX(),level.getBricks().get(0).getPosition().getY()));
            assertTrue(level.checkElementCollision(level.getBricks().get(0),character));
        }
    }

    @Test
    void die(){
        Assertions.assertEquals(3,level.getCharacter().getLives());
        level.die();
        Assertions.assertEquals(2,level.getCharacter().getLives());
        Assertions.assertEquals(0,level.getPoints());
    }

    @Test
    void updateRelativePosition(){
        int brickX=level.getBricks().get(0).getRelativePosition().getX();
        character.setPosition(character.getPosition().getRight());
        level.updateRelativePositions();
        Assertions.assertEquals(brickX-1,level.getBricks().get(0).getRelativePosition().getX());

        character.setPosition(new Position(1000,character.getPosition().getY()));
        level.updateRelativePositions();

        int coinX=level.getCoins().get(0).getRelativePosition().getX();
        character.setPosition(character.getPosition().getRight());
        level.updateRelativePositions();
        Assertions.assertEquals(coinX-1,level.getCoins().get(0).getRelativePosition().getX());

        character.setPosition(new Position(1500,character.getPosition().getY()));
        level.updateRelativePositions();

        int flagX=level.getEndFlag().getRelativePosition().getX();
        character.setPosition(character.getPosition().getRight());
        level.updateRelativePositions();
        Assertions.assertEquals(flagX-1,level.getEndFlag().getRelativePosition().getX());
    }

    @Test
    void getCurrentLevel(){
        assertEquals(1,level.getCurrentLevel());
    }

    @Test
    void getNumLevel(){
        assertEquals(3,level.getNumLevels());
    }

    @Test
    void nextLevel(){
        assertEquals(1,level.getCurrentLevel());
        level.nextLevel();
        assertEquals(2,level.getCurrentLevel());
        level.nextLevel();
        assertEquals(3,level.getCurrentLevel());
        level.nextLevel();
        assertEquals(3,level.getCurrentLevel());
    }

    @Test
    void getCharacter(){
        assertEquals(character,level.getCharacter());
    }

    @Test
    void isInScreen(){
        character.setPosition(new Position(400,character.getPosition().getY()));
        Brick brick = null;
        try {
            brick=new Brick(600,90,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(level.isInScreen(brick));
        brick.setPosition(new Position(200,90));
        Assertions.assertTrue(level.isInScreen(brick));
        brick.setPosition(new Position(700,90));
        Assertions.assertFalse(level.isInScreen(brick));
    }


}