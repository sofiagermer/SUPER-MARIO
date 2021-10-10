package superMario.model.game;

import superMario.gui.GlobalConfigs;
import superMario.model.Position;

import java.util.List;

public abstract class Element {
    private Position position;
    private Position relativePosition;
    private final String hexColor;
    private List<String> elementAppearance;

    private final int width;
    private final int height;

    public Element(int x, int y,String hexColor,List<String> elementAppearance) {
        this.position = new Position(x, y);
        this.hexColor = hexColor;
        this.elementAppearance = elementAppearance;

        this.height = elementAppearance.size();
        int aux = elementAppearance.get(0).length();
        for (String s : elementAppearance) {
            if (s.length() > aux) {
                aux = s.length();
            }
        }

        this.width = aux;

    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getHexColor() {
        return hexColor;
    }

    public List<String> getElementAppearance() {
        return elementAppearance;
    }

    public void setElementAppearance(List<String > newAppearance){ this.elementAppearance=newAppearance;}

    public int getFrontX(){return getPosition().getX()+width;}

    public int getBottomY(){return getPosition().getY()-height;}

    public Position getRelativePosition() {
        return relativePosition;
    }

    public void setRelativePosition(Position characterPos) {
        Position position=new Position(getPosition().getX()-characterPos.getX()+ GlobalConfigs.TERMINAL_WIDTH/2,getPosition().getY());
        this.relativePosition = position;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth(){
        return width;
    }
}
