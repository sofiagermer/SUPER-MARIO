package superMario.model.menu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.Game;
import superMario.model.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    Menu menu;
    Button button,otherButton;

    @BeforeEach
    void setUp() throws IOException {
        menu=new StubMenu(null);
        List<String> buttonAppearance=new ArrayList<>();
        buttonAppearance.add("Hello");
        button=new Button(buttonAppearance,new Position(20,30),new Position(30,30),"#FFFFFF","#FFFFFF","#FFFFFF");
        List<String> otherButtonAppearance=new ArrayList<>();
        otherButtonAppearance.add("Hi");
        otherButton=new Button(otherButtonAppearance,new Position(20,30),new Position(30,30),"#FFFFFF","#FFFFFF","#FFFFFF");
    }

    @AfterEach
    void cleanUp(){
        menu=null;
        button=null;
        otherButton=null;
    }

    @Test
    void addOption() {
        menu.options.add(null);
        menu.options.add(null);
        menu.options.add(null);
        Assertions.assertEquals(3,menu.getOptions().size());
        menu.addOption(null);
        Assertions.assertEquals(4,menu.getOptions().size());
        Assertions.assertEquals(null,menu.getOptions().get(3));
    }

    @Test
    void getOptions() {
        menu.options.add(null);
        menu.options.add(null);
        menu.options.add(null);
        Assertions.assertEquals(3,menu.getOptions().size());
        for(Button b:menu.getOptions()){
            Assertions.assertEquals(null,b);
        }
    }

    @Test
    void getNumberOptions() {
        menu.options.add(null);
        menu.options.add(null);
        menu.options.add(null);
        Assertions.assertEquals(3,menu.getNumberOptions());
        menu.addOption(null);
        menu.addOption(button);
        Assertions.assertEquals(5,menu.getNumberOptions());

    }

    @Test
    void getSelected() {
        menu.addOption(button);
        menu.addOption(otherButton);
        menu.addOption(button);
        Assertions.assertEquals(0,menu.getSelected());
        menu.nextOption();
        Assertions.assertEquals(1,menu.getSelected());
        menu.nextOption();
        Assertions.assertEquals(2,menu.getSelected());
        menu.nextOption();
        Assertions.assertEquals(0,menu.getSelected());
    }

    @Test
    void getSelectedButton() {
        menu.addOption(button);
        menu.addOption(otherButton);
        Assertions.assertEquals(button,menu.getSelectedButton());
        menu.nextOption();
        Assertions.assertEquals(otherButton,menu.getSelectedButton());
        menu.nextOption();
        Assertions.assertEquals(button,menu.getSelectedButton());
    }

    @Test
    void nextOption() {
        menu.addOption(button);
        menu.addOption(otherButton);
        Assertions.assertEquals(button,menu.getSelectedButton());
        menu.nextOption();
        Assertions.assertFalse(button.isActive());
        Assertions.assertTrue(otherButton.isActive());
        Assertions.assertEquals(otherButton,menu.getSelectedButton());
        menu.nextOption();
        Assertions.assertFalse(otherButton.isActive());
        Assertions.assertTrue(button.isActive());
        Assertions.assertEquals(button,menu.getSelectedButton());
    }

    @Test
    void previousOption() {
        menu.addOption(button);
        menu.addOption(otherButton);
        menu.addOption(otherButton);
        menu.previousOption();
        Assertions.assertFalse(button.isActive());
        Assertions.assertTrue(otherButton.isActive());
        Assertions.assertEquals(otherButton,menu.getSelectedButton());
        menu.previousOption();
        Assertions.assertFalse(button.isActive());
        Assertions.assertTrue(otherButton.isActive());
        Assertions.assertEquals(otherButton,menu.getSelectedButton());
        menu.previousOption();
        Assertions.assertFalse(otherButton.isActive());
        Assertions.assertTrue(button.isActive());
        Assertions.assertEquals(button,menu.getSelectedButton());
    }

    @Test
    void startMenuTest(){
        StartMenu startMenu = null;
        try {
            startMenu=new StartMenu(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(2,startMenu.getNumberOptions());
    }

    @Test
    void gameOverTest(){
        GameOver gameOver=null;
        try {
            gameOver=new GameOver(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(2,gameOver.getNumberOptions());
    }

    @Test
    void transitionTest(){
        Transition transition=null;
        try {
            transition=new Transition(null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(2,transition.getNumberOptions());
    }

    private class StubMenu extends Menu{
        public StubMenu(Game game) throws IOException {
            super(game);
        }

    }
}