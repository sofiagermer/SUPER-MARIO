package superMario.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import superMario.model.game.Element;
import superMario.model.Position;
import superMario.model.game.Character;
import superMario.model.game.ViewOnlyElement;
import superMario.model.menu.Button;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import static com.googlecode.lanterna.screen.Screen.RefreshType.AUTOMATIC;


public class LanternaGUI implements GUI{
    private final Screen screen;

    public LanternaGUI() throws IOException {
        Terminal terminal = createTerminal();
        screen = createScreen(terminal);
    }

    public Screen getScreen(){
        return screen;
    }

    private Terminal createTerminal() throws IOException {
        Font font = new Font(GlobalConfigs.LANTERNA_FONT, Font.PLAIN, GlobalConfigs.LANTERNA_FONT_SIZE);
        SwingTerminalFontConfiguration cfg = SwingTerminalFontConfiguration.newInstance(font);
        Terminal terminal = new DefaultTerminalFactory().setTerminalEmulatorFontConfiguration(cfg).setInitialTerminalSize(new TerminalSize(GlobalConfigs.TERMINAL_WIDTH, GlobalConfigs.TERMINAL_HEIGHT)).createTerminal();
        return terminal;
    }

    private Screen createScreen(Terminal terminal) throws IOException{
        final Screen screen;
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    @Override
    public void drawSky(){
        fillBackground("#4169E1");
    }

    public void fillBackground(String color){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(GlobalConfigs.TERMINAL_WIDTH, GlobalConfigs.TERMINAL_HEIGHT), ' ');
    }

    @Override
    public PressedKey getKeyInput() throws IOException{
        KeyStroke keyStroke = screen.pollInput();
        while(screen.pollInput()!=null);
        if (keyStroke == null) return PressedKey.OTHER;
        if (keyStroke.getKeyType() == KeyType.Escape) return PressedKey.ESCAPE;
        else if (keyStroke.getKeyType() == KeyType.Character && (keyStroke.getCharacter()=='w' ||keyStroke.getCharacter()=='W')) return PressedKey.UP;
        else if (keyStroke.getKeyType() ==  KeyType.Character && (keyStroke.getCharacter()=='d' ||keyStroke.getCharacter()=='D')) return PressedKey.RIGHT;
        else if (keyStroke.getKeyType() ==  KeyType.Character && (keyStroke.getCharacter()=='s' ||keyStroke.getCharacter()=='S')) return PressedKey.DOWN;
        else if (keyStroke.getKeyType() ==  KeyType.Character && (keyStroke.getCharacter()=='a' ||keyStroke.getCharacter()=='A')) return PressedKey.LEFT;
        else if (keyStroke.getKeyType() ==  KeyType.Enter) return PressedKey.ENTER;
        else return PressedKey.OTHER;
    }

    @Override
    public void drawMapColumn(String colData, int xCord){
        for(int i = 0; i < colData.length(); i++){
            drawChar(xCord,i,colData.charAt(i),"#F00000");
        }
    }

    public void drawChar(int x, int y, char c, String color) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFF00"));
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(x, GlobalConfigs.TERMINAL_HEIGHT -y-1, "" + c);
    }

    @Override
    public void drawCharacter(Character character) {
        draw(new Position((GlobalConfigs.TERMINAL_WIDTH)/2,character.getPosition().getY()),character.getElementAppearance(),character.getHexColor(),"#4169E1");
    }

    @Override
    public void drawViewOnlyElement(ViewOnlyElement element){
        draw(new Position(element.getX(),element.getY()),element.getElementAppearance(),element.getHexColor(),"#4169E1");
    }

    @Override
    public void drawElement(Element element) {
        draw(element.getRelativePosition(),element.getElementAppearance(),element.getHexColor(),"#4169E1");
    }

    public void draw(Position position, List<String> appearance, String hexColor,String backgroundColor) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(backgroundColor));
        graphics.setForegroundColor(TextColor.Factory.fromString(hexColor));
        for(int i=0;i<appearance.size();i++){
            if(appearance.get(i) != " "){
                graphics.putString(position.getX(),GlobalConfigs.TERMINAL_HEIGHT-1-position.getY()+i,appearance.get(i),SGR.BOLD);
            }
        }
    }

    public void drawMenuBackground(){
        fillBackground("#d8ac00");
    }

    public void drawTitle( List<String> title, String hexColor) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#d8ac00"));
        graphics.setForegroundColor(TextColor.Factory.fromString(hexColor));
        for(int i=0;i<title.size();i++){
            if(title.get(i) != " "){
                graphics.putString(20,GlobalConfigs.TERMINAL_HEIGHT/2+i - 50,title.get(i),SGR.BOLD);
            }
        }
    }

    public void drawMarioFace( List<String> appearance, String hexColor) {
        draw(new Position(GlobalConfigs.TERMINAL_WIDTH/2+10,136),appearance,hexColor,"#D8AC00");
    }

    public void drawGameOverMario( List<String> appearance, String hexColor) {
        draw(new Position(GlobalConfigs.TERMINAL_WIDTH/2+30 ,126),appearance,hexColor,"#D8AC00");
    }

    public void drawButton(Button button) {
        TextGraphics graphics = screen.newTextGraphics();
        if(button.isActive()){
            graphics.setBackgroundColor(TextColor.Factory.fromString(button.getBackgroundColor()));
        }
        else{
            graphics.setBackgroundColor(TextColor.Factory.fromString(button.getBackgroundColorDark()));
        }
        graphics.setForegroundColor(TextColor.Factory.fromString(button.getTextColor()));
        drawRectangle(graphics, button.getUpperLeft(),button.getLowerRight());
        int yOffset=(button.getUpperLeft().getY()-button.getLowerRight().getY()-button.getButtonText().size())/2;
        int xOffset=(button.getLowerRight().getX()-button.getUpperLeft().getX()-button.getButtonText().get(0).length())/2;
        for(int i=0;i<button.getButtonText().size();i++){

            if(button.getButtonText().get(i) != " "){
                graphics.putString(  button.getUpperLeft().getX() + xOffset,  GlobalConfigs.TERMINAL_HEIGHT-button.getUpperLeft().getY()+yOffset +i,button.getButtonText().get(i),SGR.BOLD);
            }
        }
    }

    private void drawRectangle(TextGraphics graphics, Position upperLeft, Position lowerRight){
        for(int i = upperLeft.getX(); i <= lowerRight.getX(); i++ )
            for(int j = GlobalConfigs.TERMINAL_HEIGHT-upperLeft.getY(); j <= GlobalConfigs.TERMINAL_HEIGHT-lowerRight.getY(); j++)
                graphics.putString(new TerminalPosition(i, j), " ");
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh(AUTOMATIC);
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

}
