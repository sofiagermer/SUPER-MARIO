package superMario.viewer.menu;

import superMario.gui.FileReader;
import superMario.gui.GUI;
import superMario.model.menu.StartMenu;
import superMario.viewer.Viewer;


import java.io.IOException;

public class MenuViewer extends Viewer<StartMenu> {

    public MenuViewer(StartMenu menu) {
        super(menu);
    }

@   Override
    public void drawElements(GUI gui) throws IOException {
        gui.drawMenuBackground();
        gui.drawTitle(new FileReader().readFile("./src/main/resources/textFiles/menu/title.txt"), "#000000");
        gui.drawMarioFace(new FileReader().readFile("./src/main/resources/textFiles/menu/mario.txt"), "#b22222");
        for(int i = 0; i < getModel().getNumberOptions() ; i++){
            gui.drawButton(getModel().getOptions().get(i));
        }
    }
}
