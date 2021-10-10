package superMario.model.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewOnlyElementTest {

    private ViewOnlyElement viewOnlyElement;
    List<String> appearance;

    @BeforeEach
    void setUp(){
        appearance=new ArrayList<>();
        appearance.add("ooo");
        appearance.add("ooo");
        viewOnlyElement=new ViewOnlyElement(10,10,"#FFFFFF",appearance);
    }

    @Test
    void getX() {
        Assertions.assertEquals(10,viewOnlyElement.getX());
    }

    @Test
    void getY() {
        Assertions.assertEquals(10,viewOnlyElement.getY());
    }

    @Test
    void setX() {
        Assertions.assertEquals(10,viewOnlyElement.getX());
        viewOnlyElement.setX(20);
        Assertions.assertEquals(20,viewOnlyElement.getX());
    }

    @Test
    void setY() {
        Assertions.assertEquals(10,viewOnlyElement.getY());
        viewOnlyElement.setY(20);
        Assertions.assertEquals(20,viewOnlyElement.getY());
    }

    @Test
    void getHexColor() {
        Assertions.assertEquals("#FFFFFF",viewOnlyElement.getHexColor());
    }

    @Test
    void getElementAppearance() {
        Assertions.assertEquals(appearance,viewOnlyElement.getElementAppearance());
    }

    @Test
    void getFrontX() {
        Assertions.assertEquals(13,viewOnlyElement.getFrontX());
    }
}