package superMario.viewer.menu;

import superMario.gui.FileReader;
import superMario.gui.GUI;
import superMario.model.menu.GameOver;
import superMario.viewer.Viewer;

import java.io.IOException;

public class GameOverViewer extends Viewer<GameOver> {

    public GameOverViewer(GameOver gameOver) {
        super(gameOver);
    }

    @   Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawMenuBackground();
        gui.drawTitle(new FileReader().readFile("./src/main/resources/textFiles/gameOver/gameover.txt"), "#000000");
        gui.drawGameOverMario(new FileReader().readFile("./src/main/resources/textFiles/gameOver/mario.txt"), "#b22222");
        for(int i = 0; i < getModel().getNumberOptions() ; i++){
            gui.drawButton(getModel().getOptions().get(i));
        }
    }
}
