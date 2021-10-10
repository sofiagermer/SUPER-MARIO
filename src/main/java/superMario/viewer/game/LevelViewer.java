package superMario.viewer.game;

import superMario.gui.GUI;
import superMario.model.game.*;
import superMario.viewer.Viewer;

import java.io.IOException;

public class LevelViewer extends Viewer<Level> {

    private final Info info;
    public LevelViewer(Level level) throws IOException {
        super(level);
        this.info= new Info();
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        drawMap(new MapViewer(), gui);
        if(getModel().isInScreen(getModel().getEndFlag())) {
            drawElement(getModel().getEndFlag(), new FlagViewer(),gui);
        }

        for(Enemy e: getModel().getEnemies()){
            if(getModel().isInScreen(e)){
                drawElement(e,new EnemyViewer(),gui);
            }
        }

        for(Brick b: getModel().getBricks()){
            if(getModel().isInScreen(b)){
                drawElement(b, new BrickViewer(),gui);
            }
        }

        for(Coin c: getModel().getCoins()){
            if(getModel().isInScreen(c)){
                drawElement(c, new CoinViewer(),gui);
            }
        }


        drawElement(getModel().getCharacter(),new CharacterViewer(),gui);
        drawInfo(info,new ViewOnlyElementViewer(),gui);

        gui.refresh();
    }

    private void drawInfo(Info info, ViewOnlyElementViewer viewOnlyElementViewer,GUI gui) throws IOException{
        viewOnlyElementViewer.draw(info.getLivesTitle(),gui);
        viewOnlyElementViewer.draw(info.getNumberLives(getModel().getCharacter().getLives()),gui);
        viewOnlyElementViewer.draw(info.getPointsTitle(),gui);
        for(ViewOnlyElement v:info.getNumberPoints(getModel().getPoints())){
            viewOnlyElementViewer.draw(v,gui);
        }
    }

    private <T extends Element> void drawElement(T element, ElementViewer<T> viewer,GUI gui) throws IOException {
        viewer.drawElement(element, gui);
    }

    public void drawMap(MapViewer v,GUI gui){
        gui.drawSky();
        v.draw(getModel().getMap(),gui);
    }
}
