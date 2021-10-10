package superMario.model.game;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import superMario.gui.FileReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InfoTest {
    private Info info;

    @BeforeEach
    void setUp() throws IOException {
        info= new Info();
    }

    @Test
    void getLivesTitle() {
        try {
            assertEquals(new FileReader().readFile("./src/main/resources/textFiles/lives.txt"),info.getLivesTitle().getElementAppearance());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Property
    void getNumberLives(@ForAll @IntRange(min=0,max=9) int lives){

        List<String> appearance = null;
        try {
            setUp();
            appearance=new FileReader().readFile("./src/main/resources/textFiles/"+lives+".txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(appearance,info.getNumberLives(lives).getElementAppearance());

    }

    @Test
    void getPointsTitle() {
        try {
            assertEquals(new FileReader().readFile("./src/main/resources/textFiles/points.txt"),info.getPointsTitle().getElementAppearance());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Property
    void getNumberPoints(@ForAll @IntRange(min=0,max=999) int points) throws IOException {
        setUp();
        if(points>=100){
            int pointsCopy=points;
            List<String > a1= (new FileReader().readFile("./src/main/resources/textFiles/"+ points/100+".txt"));
            points=points-(points/100)*100;
            List<String > a2= (new FileReader().readFile("./src/main/resources/textFiles/"+ points/10+".txt"));
            List<String > a3= (new FileReader().readFile("./src/main/resources/textFiles/"+ points%10+".txt"));
            List<ViewOnlyElement> res=info.getNumberPoints(pointsCopy);
            assertEquals(a1,res.get(0).getElementAppearance());
            assertEquals(a2,res.get(1).getElementAppearance());
            assertEquals(a3,res.get(2).getElementAppearance());
        }
        else if(points>=10){
            List<String > a1= (new FileReader().readFile("./src/main/resources/textFiles/"+ points/10+".txt"));
            List<String > a2= (new FileReader().readFile("./src/main/resources/textFiles/"+ points%10+".txt"));
            List<ViewOnlyElement> res=info.getNumberPoints(points);
            assertEquals(a1,res.get(0).getElementAppearance());
            assertEquals(a2,res.get(1).getElementAppearance());
        }
        else{
            List<String > a1= (new FileReader().readFile("./src/main/resources/textFiles/"+ points+".txt"));
            List<ViewOnlyElement> res=info.getNumberPoints(points);
            assertEquals(a1,res.get(0).getElementAppearance());
        }
    }
}