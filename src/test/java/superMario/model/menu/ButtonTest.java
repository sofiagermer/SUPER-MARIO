package superMario.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import superMario.Game;
import superMario.controller.command.buttonCommand.ButtonCommand;
import superMario.controller.command.buttonCommand.ExitCommand;
import superMario.model.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ButtonTest {

    private Button button;
    private Position upperLeft;
    private Position lowerRight;
    private List<String> buttonAppearance;
    private ButtonCommand stubButtonCommand;

    @BeforeEach
    void setUp(){
        buttonAppearance=new ArrayList<>();
        buttonAppearance.add("Random");
        buttonAppearance.add("Text");
        upperLeft=new Position(20,30);
        lowerRight=new Position(40,10);
        button=new Button(buttonAppearance,upperLeft,lowerRight,"#1FFFFF","#2FFFFF","#3FFFFF");
        stubButtonCommand=new ButtonCommand(null) {
            @Override
            public void execute() throws IOException {
                return;
            }
        };
    }

    @Test
    void getButtonText() {
        Assertions.assertEquals(buttonAppearance,button.getButtonText());
    }

    @Test
    void getUpperLeft() {
        Assertions.assertEquals(upperLeft,button.getUpperLeft());
    }

    @Test
    void getLowerRight() {
        Assertions.assertEquals(lowerRight,button.getLowerRight());
    }

    @Test
    void getBackgroundColor() {
        Assertions.assertEquals("#1FFFFF",button.getBackgroundColor());
    }

    @Test
    void getBackgroundColorDark() {
        Assertions.assertEquals("#2FFFFF",button.getBackgroundColorDark());
    }

    @Test
    void getTextColor() {
        Assertions.assertEquals("#3FFFFF",button.getTextColor());
    }

    @Test
    void isActive() {
        Assertions.assertFalse(button.isActive());
    }

    @Test
    void setActive() {
        Assertions.assertFalse(button.isActive());
        button.setActive(true);
        Assertions.assertTrue(button.isActive());
        button.setActive(false);
        Assertions.assertFalse(button.isActive());
    }
    @Test
    void getAction() {
        Assertions.assertEquals(null,button.getAction());
    }

    @Test
    void setAction() {
        button.setAction(stubButtonCommand);
        Assertions.assertEquals(stubButtonCommand,button.getAction());
    }


}