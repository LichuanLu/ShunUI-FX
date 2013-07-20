package view;

import javafx.scene.layout.BorderPane;

/**
 * Created with IntelliJ IDEA.
 * User: labuser
 * Date: 21/06/13
 * Time: 04:22
 * To change this template use File | Settings | File Templates.
 */
public class CusBorderPane extends BorderPane {



    private WindowResizeButton windowResizeButton;

    public  CusBorderPane(){
        super();
    }

    @Override protected void layoutChildren() {
        super.layoutChildren();
        windowResizeButton.autosize();
        windowResizeButton.setLayoutX(getWidth() - windowResizeButton.getLayoutBounds().getWidth());
        windowResizeButton.setLayoutY(getHeight() - windowResizeButton.getLayoutBounds().getHeight());
    }

    public void setWindowResizeButton(WindowResizeButton windowResizeButton) {
        this.windowResizeButton = windowResizeButton;
    }

}
