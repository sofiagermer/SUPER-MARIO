package superMario.viewer.game;

import superMario.gui.GUI;
import java.util.List;


public class MapViewer{
    void draw(List<String> levelData, GUI gui){
        for(int i = 0; i < levelData.size();i++){
            gui.drawMapColumn(levelData.get(i),i);
        }
    }
}
