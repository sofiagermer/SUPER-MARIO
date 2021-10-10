package superMario.state;

import superMario.controller.Controller;
import superMario.controller.menu.MenuController;
import superMario.model.menu.StartMenu;
import superMario.viewer.Viewer;
import superMario.viewer.menu.MenuViewer;

import java.io.IOException;

public class StateMenu extends State<StartMenu>{
    public StateMenu(StartMenu model) throws IOException {
        super(model);
    }

    @Override
    protected Viewer<StartMenu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<StartMenu> getController() {
        return new MenuController(getModel());
    }


}
