package superMario.model.game;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class BrickTest {
    Brick brick;

    @BeforeEach
    void setUp() throws IOException {
        brick=new Brick(20,20,false);
    }

    @Test
    void breakBrick() {
        List<String> appearance=brick.getElementAppearance();
        Assertions.assertEquals(true,brick.breakBrick());
        Assertions.assertEquals(false,brick.breakBrick());
        Assertions.assertNotEquals(appearance,brick.getElementAppearance());
    }

    @Test
    void getPoints() {
        Assertions.assertNotNull(brick.getPoints());
    }

}