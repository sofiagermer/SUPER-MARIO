package superMario.gui;

import superMario.model.game.Character;
import superMario.model.game.Element;
import superMario.model.Position;
import superMario.model.game.ViewOnlyElement;
import superMario.model.menu.Button;

import java.io.IOException;
import java.util.List;

public interface GUI {
    enum PressedKey {UP,DOWN,RIGHT,LEFT,OTHER,ESCAPE, ENTER};
    PressedKey getKeyInput() throws IOException;
    void draw(Position position, List<String> appearance, String hexColor, String backgroundColor) throws IOException;
    void drawSky();
    void drawElement(Element element) throws IOException;
    void drawViewOnlyElement(ViewOnlyElement viewOnlyElement) throws IOException;
    void drawCharacter(Character character) throws IOException;
    void refresh() throws IOException;
    void close() throws IOException;


    /** Menu **/
    void drawMenuBackground();
    void drawTitle( List<String> title, String hexColor);
    void drawMarioFace( List<String> title, String hexColor);
    void drawMapColumn(String s, int i);
    void drawButton(Button button);
    void drawGameOverMario( List<String> title, String hexColor);
}
