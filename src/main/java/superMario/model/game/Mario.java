package superMario.model.game;

import superMario.gui.FileReader;

import java.io.IOException;

public class Mario extends Character {
    public Mario() throws IOException {
        super( 3,"#000000",new FileReader().readFile("./src/main/resources/textFiles/mario.txt"));
    }
}
