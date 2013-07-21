package controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.Patients;
import dialog.Dialog;
import view.Main;
import view.PageArea;
import view.SearchBox;
import view.WindowButtons;
import view.chart.StackedBarChart;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import models.LineExtraValues;
import view.page.Page;
import view.page.Pages;

public class Controller implements Initializable {

    @FXML
    public BorderPane right_pane;
    @FXML
    public TreeView tree;
    @FXML
    public SearchBox search_b;
    @FXML
    public TabPane tp;
    @FXML
    public PageArea pa;
    @FXML
    private ToolBar tb;
    @FXML
    private Region spacer;
    @FXML
    private ImageView logo;
    @FXML
    private Region spacer2;






    private ResourceBundle resources = null;
    private double mouseDragOffsetX = 0;
    private double mouseDragOffsetY = 0;

    private Stage primaryStage;

    private WindowButtons windowButtons;


    public Pages pages;


    @Override
    @SuppressWarnings("rawtypes")
    public void initialize(URL location, ResourceBundle resources) {
        this.resources = resources;
        this.primaryStage = Main.stage;

        //init the component
        HBox.setMargin(logo, new Insets(0, 0, 0, 5));
        HBox.setHgrow(spacer, Priority.ALWAYS);
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        HBox.setMargin(search_b, new Insets(0,5,0,0));
        // add close min max
        windowButtons = new WindowButtons(primaryStage);
        tb.getItems().add(windowButtons);
        // add window header double clicking
        tb.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    windowButtons.toogleMaximized();
                }
            }
        });
        // add window dragging
        tb.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                mouseDragOffsetX = event.getSceneX();
                mouseDragOffsetY = event.getSceneY();
            }
        });
        tb.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent event) {
                if(!windowButtons.isMaximized()) {
                    primaryStage.setX(event.getScreenX()-mouseDragOffsetX);
                    primaryStage.setY(event.getScreenY()-mouseDragOffsetY);
                }
            }
        });





        pages = new Pages();
        tree.setShowRoot(true);
        tree.setRoot(pages.getRoot());

        tree.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tree.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue,
                                Object newValue) {

                 Page selectedPage = (Page) tree.getSelectionModel().getSelectedItem();
                 if (selectedPage != pages.getRoot() && selectedPage != pages.getRoot().getChildren().get(0) ){
                     goToPage(selectedPage);

                 }

            }
        });



    }


    public void  goToPage(Page targetPage){

        Node view = targetPage.createView();
        if(view != null){
            pa.getChildren().setAll(view);

        }



    }






//    public void setStage(Stage stage) {
//        this.primaryStage = stage;
//    }

    public void click_handler(ActionEvent actionEvent) {
        //To change body of created methods use File | Settings | File Templates.

        EventHandler yesButtonHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                //To change body of implemented methods use File | Settings | File Templates.

            }
        };


        EventHandler noButtonHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        EventHandler cancelButtonHandler = new EventHandler() {
            @Override
            public void handle(Event event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };

        Dialog.buildConfirmation("test", "hello")
                .addYesButton(yesButtonHandler)
                .addNoButton(noButtonHandler)
                .addCancelButton(cancelButtonHandler)
                .build()
                .show();
    }



}
