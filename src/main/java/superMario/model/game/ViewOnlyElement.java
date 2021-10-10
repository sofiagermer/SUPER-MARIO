package superMario.model.game;

import java.util.List;

public class ViewOnlyElement {
    private final int height,width;
    private int x,y;
    private final String hexColor;
    private final List<String> elementAppearance;
    public ViewOnlyElement(int x, int y,String hexColor,List<String> elementAppearance){
        this.x=x;
        this.y=y;
        this.hexColor=hexColor;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x){this.x=x;}

    public void setY(int y){this.y=y;}

    public String getHexColor() {
        return hexColor;
    }

    public List<String> getElementAppearance() {
        return elementAppearance;
    }

    public int getFrontX(){return x+width;}

}
