package view;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * Created with IntelliJ IDEA.
 * User: liclu
 * Date: 13-7-21
 * Time: 下午8:04
 * To change this template use File | Settings | File Templates.
 */
public class PageArea extends Pane {
    public PageArea(){
        super();
    }

    @Override protected void layoutChildren() {
        for (Node child:this.getChildren()) {
            child.resizeRelocate(0, 0, this.getWidth(), this.getHeight());
        }
    }

}
