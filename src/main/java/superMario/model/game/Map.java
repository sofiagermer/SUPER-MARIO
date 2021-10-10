package superMario.model.game;

import superMario.gui.FileReader;
import superMario.gui.GlobalConfigs;


import java.io.IOException;
import java.util.List;

public class Map {

    private final List<String> fullMap;

    Map(String path) throws IOException {

        fullMap = new FileReader().readFile(path);

    }

    public List<String> getMapInfo(int x){
        if(x<GlobalConfigs.TERMINAL_WIDTH/2){
            return fullMap.subList(0,GlobalConfigs.TERMINAL_WIDTH);
        }
        return fullMap.subList(x- GlobalConfigs.TERMINAL_WIDTH/2,x+GlobalConfigs.TERMINAL_WIDTH/2);

    }

    public List<String> getMapSection(int x1, int x2){
        return fullMap.subList(x1,x2);
    }

    public int getFloorY(int x){
        return fullMap.get(x).length();
    }

    public List<String> getFullMap(){
        return fullMap;
    }

}
