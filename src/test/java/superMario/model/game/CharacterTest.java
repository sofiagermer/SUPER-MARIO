package superMario.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import superMario.model.game.Character;
import superMario.model.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharacterTest {
    private Character character;
    @BeforeEach
    void setUp() throws IOException {
        List<String> appearance=new ArrayList<>();
        appearance.add(" oo");
        appearance.add("-|-");
        appearance.add(" x");
        character= new Stub(3,"#FFFFFF",appearance);

    }

    @Test
    void testGetLives(){
        Assertions.assertEquals(3,character.getLives());
    }

    @Test
    void testIsJumping(){
        Assertions.assertEquals(false,character.isJumping());
    }

    @Test
    void testJump(){
        character.jump();
        Assertions.assertEquals(true,character.isJumping());
    }

    @Test
    void testJumpEnd(){
        character.jump();
        character.jumpEnd();
        Assertions.assertEquals(false,character.isJumping());
    }

    @Test
    void testDie(){
        character.die();
        Assertions.assertEquals(2,character.getLives());
        character.die();
        Assertions.assertEquals(1,character.getLives());
        character.die();
        Assertions.assertEquals(0,character.getLives());

        //Checks again to see if it would go below 0
        character.die();
        Assertions.assertEquals(0,character.getLives());
    }

    @Test
    void resetPosition(){
        Position initialPosition=character.getPosition();

        character.setPosition(new Position(0,10));

        character.resetPosition();

        Assertions.assertEquals(initialPosition,character.getPosition());
    }

    @Test
    void resetLives(){
        Assertions.assertEquals(3,character.getLives());
        character.die();
        Assertions.assertEquals(2,character.getLives());
        character.resetLives();
        Assertions.assertEquals(3,character.getLives());
    }

    private class Stub extends Character{
        public Stub(int lives, String hexColor, List<String> characterAppearance) {
            super(lives, hexColor, characterAppearance);
        }
    }
}

