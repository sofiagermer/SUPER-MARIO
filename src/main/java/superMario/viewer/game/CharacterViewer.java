package superMario.viewer.game;

import superMario.gui.GUI;
import superMario.model.game.Character;

import java.io.IOException;

public class CharacterViewer implements ElementViewer<Character> {
    @Override
    public void drawElement(Character character, GUI gui) throws IOException {
        gui.drawCharacter(character);
    }
}
