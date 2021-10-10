package superMario.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.gui.GlobalConfigs;
import superMario.model.Position;
import superMario.model.game.Element;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {
    private Element element;
    private List<String> appearance;

    @BeforeEach
    void setUp(){
        appearance=new ArrayList<>();
        appearance.add("xxx");
        appearance.add("xxx");
        appearance.add("xxx");
        element=new Stub(10,10,"#FFFFFF",appearance);
    }

    @Test
    void getPosition() {
        Assertions.assertEquals(new Position(10,10),element.getPosition());
    }

    @Test
    void setPosition() {
        Position position=new Position(20,20);
        element.setPosition(position);
        Assertions.assertEquals(position,element.getPosition());
    }

    @Test
    void getHexColor() {
        Assertions.assertEquals("#FFFFFF",element.getHexColor());
    }

    @Test
    void getElementAppearance() {
        Assertions.assertEquals(appearance,element.getElementAppearance());
    }

    @Test
    void setElementAppearance() {
        element.setElementAppearance(new ArrayList<>());
        Assertions.assertEquals(new ArrayList<>(),element.getElementAppearance());
    }

    @Test
    void getFrontX() {
        Assertions.assertEquals(element.getPosition().getX()+3,element.getFrontX());
    }

    @Test
    void getBottomY() {
        Assertions.assertEquals(element.getPosition().getY()-3,element.getBottomY());
    }

    @Test
    void relativePosition() {
        Position position=new Position(10,10);
        element.setRelativePosition(position);
        Assertions.assertEquals(new Position(element.getPosition().getX()-position.getX()+ GlobalConfigs.TERMINAL_WIDTH/2,10),element.getRelativePosition());
    }

    @Test
    void getHeight() {
        Assertions.assertEquals(3,element.getHeight());
    }

    @Test
    void getWidth() {
        Assertions.assertEquals(3,element.getWidth());
    }

    private class Stub extends Element{

        public Stub(int x, int y, String hexColor, List<String> elementAppearance) {
            super(x, y, hexColor, elementAppearance);
        }
    }
}