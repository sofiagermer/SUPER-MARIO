package superMario.gui;

import com.googlecode.lanterna.TextColor;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.*;
import superMario.model.Position;
import superMario.model.game.Mario;
import superMario.model.menu.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LanternaGUITest {

    private LanternaGUI lanternaGUI;


    @BeforeEach
    void setUp() throws IOException {
        lanternaGUI=new LanternaGUI();
    }

    @AfterEach
    void cleanUp() throws IOException {
        lanternaGUI.close();
        lanternaGUI=null;
    }


    @Test
    void fillBackground() throws IOException {
        lanternaGUI.fillBackground("#4169E1");
        Assertions.assertEquals(" ", lanternaGUI.getScreen().getBackCharacter(0,0).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#4169E1"), lanternaGUI.getScreen().getBackCharacter(0,0).getBackgroundColor());
        Assertions.assertEquals(" ", lanternaGUI.getScreen().getBackCharacter(GlobalConfigs.TERMINAL_WIDTH-1,GlobalConfigs.TERMINAL_HEIGHT-1).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#4169E1"), lanternaGUI.getScreen().getBackCharacter(GlobalConfigs.TERMINAL_WIDTH-1,GlobalConfigs.TERMINAL_HEIGHT-1).getBackgroundColor());
    }

    @Test
    void drawMapColumn() {
        lanternaGUI.drawMapColumn("XXXYYY",3);
        Assertions.assertEquals("X",lanternaGUI.getScreen().getBackCharacter(3,GlobalConfigs.TERMINAL_HEIGHT-1).getCharacterString());
        Assertions.assertEquals("X",lanternaGUI.getScreen().getBackCharacter(3,GlobalConfigs.TERMINAL_HEIGHT-2).getCharacterString());
        Assertions.assertEquals("X",lanternaGUI.getScreen().getBackCharacter(3,GlobalConfigs.TERMINAL_HEIGHT-3).getCharacterString());
        Assertions.assertEquals("Y",lanternaGUI.getScreen().getBackCharacter(3,GlobalConfigs.TERMINAL_HEIGHT-4).getCharacterString());
        Assertions.assertEquals("Y",lanternaGUI.getScreen().getBackCharacter(3,GlobalConfigs.TERMINAL_HEIGHT-5).getCharacterString());
        Assertions.assertEquals("Y",lanternaGUI.getScreen().getBackCharacter(3,GlobalConfigs.TERMINAL_HEIGHT-6).getCharacterString());
    }

    @Test
    void drawChar() throws IOException {
        lanternaGUI.drawChar(10,12,'C',"#FFFFFF");
        Assertions.assertEquals("C",lanternaGUI.getScreen().getBackCharacter(10,GlobalConfigs.TERMINAL_HEIGHT-12-1).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#FFFFFF"),lanternaGUI.getScreen().getBackCharacter(10,GlobalConfigs.TERMINAL_HEIGHT-12-1).getForegroundColor());
    }

    @Test
    void draw() {
        List<String> appearance=new ArrayList<>();
        appearance.add("XX");
        appearance.add("YY");
        lanternaGUI.draw(new Position(20,30),appearance,"#FFFFFF","#000000");
        Assertions.assertEquals("X",lanternaGUI.getScreen().getBackCharacter(20,GlobalConfigs.TERMINAL_HEIGHT-30-1).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#FFFFFF"),lanternaGUI.getScreen().getBackCharacter(20,GlobalConfigs.TERMINAL_HEIGHT-30-1).getForegroundColor());
        Assertions.assertEquals("X",lanternaGUI.getScreen().getBackCharacter(21,GlobalConfigs.TERMINAL_HEIGHT-30-1).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#FFFFFF"),lanternaGUI.getScreen().getBackCharacter(21,GlobalConfigs.TERMINAL_HEIGHT-30-1).getForegroundColor());
        Assertions.assertEquals("Y",lanternaGUI.getScreen().getBackCharacter(20,GlobalConfigs.TERMINAL_HEIGHT-29-1).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#FFFFFF"),lanternaGUI.getScreen().getBackCharacter(20,GlobalConfigs.TERMINAL_HEIGHT-29-1).getForegroundColor());
        Assertions.assertEquals("Y",lanternaGUI.getScreen().getBackCharacter(21,GlobalConfigs.TERMINAL_HEIGHT-29-1).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#FFFFFF"),lanternaGUI.getScreen().getBackCharacter(21,GlobalConfigs.TERMINAL_HEIGHT-29-1).getForegroundColor());
    }

    @Test
    void drawTitle() {
        List<String> appearance=new ArrayList<>();
        appearance.add("XXY");
        lanternaGUI.drawTitle(appearance,"#FFFFFF");
        Assertions.assertEquals("Y",lanternaGUI.getScreen().getBackCharacter(22,GlobalConfigs.TERMINAL_HEIGHT/2-50).getCharacterString());
    }

    @Test
    void drawButton() {
        List<String> appearance=new ArrayList<>();
        appearance.add("XXY");
        Button button=new Button(appearance,new Position(20,40),new Position(40,20),"#FFFFFF","#A1A1A1","#F1F1F1");
        lanternaGUI.drawButton(button);
        Assertions.assertEquals(" ",lanternaGUI.getScreen().getBackCharacter(20,GlobalConfigs.TERMINAL_HEIGHT-40).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#A1A1A1"),lanternaGUI.getScreen().getBackCharacter(20,GlobalConfigs.TERMINAL_HEIGHT-40).getBackgroundColor());

        Assertions.assertEquals("X",lanternaGUI.getScreen().getBackCharacter(28,GlobalConfigs.TERMINAL_HEIGHT-31).getCharacterString());

        Assertions.assertEquals(" ",lanternaGUI.getScreen().getBackCharacter(40,GlobalConfigs.TERMINAL_HEIGHT-20).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#A1A1A1"),lanternaGUI.getScreen().getBackCharacter(40,GlobalConfigs.TERMINAL_HEIGHT-20).getBackgroundColor());

    }

    @Test
    void drawSky(){
        lanternaGUI.drawSky();
        Assertions.assertEquals(" ", lanternaGUI.getScreen().getBackCharacter(0,0).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#4169E1"), lanternaGUI.getScreen().getBackCharacter(0,0).getBackgroundColor());
        Assertions.assertEquals(" ", lanternaGUI.getScreen().getBackCharacter(GlobalConfigs.TERMINAL_WIDTH-1,GlobalConfigs.TERMINAL_HEIGHT-1).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#4169E1"), lanternaGUI.getScreen().getBackCharacter(GlobalConfigs.TERMINAL_WIDTH-1,GlobalConfigs.TERMINAL_HEIGHT-1).getBackgroundColor());
    }

    @Test
    void drawMenuBackground(){
        lanternaGUI.drawMenuBackground();
        Assertions.assertEquals(" ", lanternaGUI.getScreen().getBackCharacter(0,0).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#d8ac00"), lanternaGUI.getScreen().getBackCharacter(0,0).getBackgroundColor());
        Assertions.assertEquals(" ", lanternaGUI.getScreen().getBackCharacter(GlobalConfigs.TERMINAL_WIDTH-1,GlobalConfigs.TERMINAL_HEIGHT-1).getCharacterString());
        Assertions.assertEquals(TextColor.Factory.fromString("#d8ac00"), lanternaGUI.getScreen().getBackCharacter(GlobalConfigs.TERMINAL_WIDTH-1,GlobalConfigs.TERMINAL_HEIGHT-1).getBackgroundColor());
    }


}