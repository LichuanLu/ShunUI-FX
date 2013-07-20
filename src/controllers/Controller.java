package controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.Patients;
import dialog.Dialog;
import view.Main;
import view.SearchBox;
import view.WindowButtons;
import view.chart.StackedBarChart;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import models.LineExtraValues;

public class Controller implements Initializable {

    @FXML
    public BorderPane right_pane;
    @FXML
    public TreeView tree;
    @FXML
    public SearchBox search_b;
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



//        final CategoryAxis xAxis = new CategoryAxis();
//        final NumberAxis yAxis = new NumberAxis();
//
//        //final NumberAxis xAxis = new NumberAxis(0,32,1);
//        //xAxis.setMinorTickCount(0);
//        //final NumberAxis yAxis = new NumberAxis();
//        final StackedBarChart blc = new StackedBarChart(xAxis,yAxis);
//        // setup chart
//        blc.setTitle("Custom line bar Chart");
//        xAxis.setLabel("Area");
//        yAxis.setLabel("Number");
//        // add starting data
//        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
//
//        series.setName("2003");
//        series.getData().add(new BarChart.Data(austria,100.34));
//        series.getData().add(new BarChart.Data(brazil,202.82));
//        series.getData().add(new BarChart.Data(france,100));
//        series.getData().add(new BarChart.Data(italy,354.15));
//        series.getData().add(new BarChart.Data(usa,120));
//
//
//        ObservableList<XYChart.Series<String,Number>> data = blc.getData();
//        if (data == null) {
//            data = FXCollections.observableArrayList(series);
//            blc.setData(data);
//        } else {
//            blc.getData().add(series);
//        }

        //init bar line chart

        final String[] years = {"2007", "2008", "2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037"};
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        //yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"$",null));

        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis){
            @Override
            public String toString(Number object){
                String label;
                label = String.format("%7.2f", object.floatValue());
                return label;
            }
        });
        final StackedBarChart<String,Number> bc = new StackedBarChart<String,Number>(xAxis,yAxis);
        // setup chart
        //bc.setTitle("Thickness Statistics Chart");
       // xAxis.setLabel("Area");
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(years)));
        //yAxis.setLabel("Value");
        // add starting data
        XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        series1.setName("Thickness Value");
//        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
//        series2.setName("Data Series 2");
//        XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
//        series3.setName("Data Series 3");
        // create sample data

        series1.getData().add(new XYChart.Data<String,Number>(years[0], 567.2, new LineExtraValues<Number>(765.1,234.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[1], 1292.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[2], 2180.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[3], 567.2, new LineExtraValues<Number>(764.1,254.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[4], 1292.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[5], 2180.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[6], 567.2, new LineExtraValues<Number>(765.1,234.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[7], 1292.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[8], 2180.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[9], 567.2, new LineExtraValues<Number>(765.1,234.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[10], 1292.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[11], 2880.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[12], 577.2, new LineExtraValues<Number>(765.1,234.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[13], 1192.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[14], 2580.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[15], 567.2, new LineExtraValues<Number>(765.1,234.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[16], 1192.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[17], 2120.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[18], 565.2, new LineExtraValues<Number>(765.1,234.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[19], 1242.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[20], 2110.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[21], 2150.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[22], 563.2, new LineExtraValues<Number>(765.1,234.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[23], 1252.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[24], 2181.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[25], 2110.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[26], 2150.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[27], 563.2, new LineExtraValues<Number>(765.1,234.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[28], 1252.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[29], 2181.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series1.getData().add(new XYChart.Data<String,Number>(years[30], 2181.4 , new LineExtraValues<Number>(2562.1,123.1)));

//        series2.getData().add(new XYChart.Data<String,Number>(years[1], 1665));
//        series2.getData().add(new XYChart.Data<String,Number>(years[2], 2450));
//        series3.getData().add(new XYChart.Data<String,Number>(years[0], 800));
//        series3.getData().add(new XYChart.Data<String,Number>(years[1], 1000));
//        series3.getData().add(new XYChart.Data<String,Number>(years[2], 2800));
        bc.getData().add(series1);
//        bc.getData().add(series2);
//        bc.getData().add(series3);




        //init line chart
        final CategoryAxis xAxis2 = new CategoryAxis();
        final NumberAxis yAxis2 = new NumberAxis();
        final LineChart<String,Number> lc = new LineChart<String,Number>(xAxis2,yAxis2);
       // lc.setTitle("Zscore chart");
        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();


        series2.getData().add(new XYChart.Data<String,Number>(years[0], 567.2, new LineExtraValues<Number>(765.1,234.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[1], 1292.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[2], 2180.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[3], 567.2, new LineExtraValues<Number>(764.1,254.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[4], 1292.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[5], 2180.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[6], 567.2, new LineExtraValues<Number>(765.1,234.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[7], 1292.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[8], 2180.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[9], 567.2, new LineExtraValues<Number>(765.1,234.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[10], 1292.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[11], 2880.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[12], 577.2, new LineExtraValues<Number>(765.1,234.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[13], 1192.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[14], 2580.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[15], 567.2, new LineExtraValues<Number>(765.1,234.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[16], 1192.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[17], 2120.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[18], 565.2, new LineExtraValues<Number>(765.1,234.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[19], 1242.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[20], 2110.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[21], 2150.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[22], 563.2, new LineExtraValues<Number>(765.1,234.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[23], 1252.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[24], 2181.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[25], 2110.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[26], 2150.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[27], 563.2, new LineExtraValues<Number>(765.1,234.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[28], 1252.3 , new LineExtraValues<Number>(1432.1,678.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[29], 2181.4 , new LineExtraValues<Number>(2562.1,123.1)));
        series2.getData().add(new XYChart.Data<String,Number>(years[30], 2181.4 , new LineExtraValues<Number>(2562.1,123.1)));


        series2.setName("Zscore value");
        lc.getData().add(series2);

      //set pages , add bc and lc
        final VBox main = new VBox(8);
        main.getStyleClass().add("sample-page");
        // create header
        Label header = new Label("Thickness Statistic Analysis Chart");
        header.getStyleClass().add("page-header");
        main.getChildren().add(header);
        main.getChildren().add(bc);
        main.getChildren().add(lc);

        right_pane.setCenter(main);




       //init tree view
       final TreeItem<String> treeRoot = new TreeItem<String>("Patients");
        Patients patient = new Patients();
        patient.setId(1);
        patient.setAge(20);
        patient.setGender("male");
        patient.setName("Li Gang");
        treeRoot.getChildren().addAll(Arrays.asList(new TreeItem<String>(patient.getName())));
        treeRoot.getChildren().get(0).getChildren().addAll(Arrays.asList(
                new TreeItem<String>("Main-2013-07-09") ));

        treeRoot.getChildren().get(0).getChildren().get(0).getChildren().addAll(Arrays.asList(
                new TreeItem<String>("Volumn"), new TreeItem<String>("Surface"), new TreeItem<String>("Thickness")
        ));

        treeRoot.setExpanded(true);
        tree.setShowRoot(true);
        tree.setRoot(treeRoot);



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
