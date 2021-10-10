package superMario.model.game;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.gui.FileReader;
import superMario.gui.GlobalConfigs;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    Map map;
    List<String> fullMap;

    @BeforeEach
    void setUp() throws IOException {
        map=new Map("./src/main/resources/textFiles/level1.txt");
        fullMap=new FileReader().readFile("./src/main/resources/textFiles/level1.txt");
    }

    @Test
    void getMapInfo(){
        Assertions.assertEquals(GlobalConfigs.TERMINAL_WIDTH,map.getMapInfo(0).size());
        Assertions.assertEquals(GlobalConfigs.TERMINAL_WIDTH,map.getMapInfo(GlobalConfigs.TERMINAL_WIDTH/2-10).size());
        Assertions.assertEquals(GlobalConfigs.TERMINAL_WIDTH,map.getMapInfo(GlobalConfigs.TERMINAL_WIDTH/2).size());
        Assertions.assertEquals(GlobalConfigs.TERMINAL_WIDTH,map.getMapInfo(GlobalConfigs.TERMINAL_WIDTH/2+10).size());
        Assertions.assertEquals(GlobalConfigs.TERMINAL_WIDTH,map.getMapInfo(GlobalConfigs.TERMINAL_WIDTH*2).size());
    }

    @Test
    void getMapSection() {
        Assertions.assertEquals(fullMap.subList(0,500),map.getMapSection(0,500));
    }

    @Test
    void getFloorY() {
        Assertions.assertEquals(fullMap.get(0).length(),map.getFloorY(0));
        Assertions.assertEquals(fullMap.get(30).length(),map.getFloorY(30));
    }

    @Test
    void getFullMap() {
        Assertions.assertEquals(fullMap,map.getFullMap());
    }
}