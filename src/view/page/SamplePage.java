
/*
 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package view.page;

import dao.PatientsResultsDao;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.DataFormat;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.text.TextAlignment;
import view.chart.ChartView;
import view.page.Page;

/**
 * SamplePage
 */
public class SamplePage extends Page {  private static WebEngine engine = null;
    private static WebView webView = null;
    private Class sampleClass;
    private ChartView lChartView;
    private ChartView rChartView;
    private PatientsResultsDao patientsResultsDao =  PatientsResultsDao.getInstance();




    public SamplePage(int patientRecordId , String name)  {
        super(name);
//        String unqualifiedClassName = sourceFileUrl.substring(sourceFileUrl.lastIndexOf('/')+1,
//                sourceFileUrl.length()-5);

    }

    public SamplePage(SamplePage pageToClone) {
        super(pageToClone.getName());
        this.sampleClass = pageToClone.sampleClass;
    }



    @Override public Node createView() {
        // check if 3d sample and on supported platform
        //System.out.println("sampleClass.getSuperclass() == Sample3D.class = " + (sampleClass.getSuperclass() == Sample3D.class));
        //System.out.println("Platform.isSupported(ConditionalFeature.SCENE3D) = " + Platform.isSupported(ConditionalFeature.SCENE3D));
//        if (sampleClass.getSuperclass() == Sample3D.class && !Platform.isSupported(ConditionalFeature.SCENE3D)) {
//            Label error =  new Label("JavaFX 3D is currently not supported on your configuration.");
//            error.setStyle("-fx-text-fill: orangered; -fx-font-size: 1.4em;");
//            error.setWrapText(true);
//            error.setAlignment(Pos.CENTER);
//            error.setTextAlignment(TextAlignment.CENTER);
//            return error;
//        }
        //  load the code
//        loadCode();
        try {
            // create main grid
            //final FlowSafeVBox main = new FlowSafeVBox();
            final VBox main = new VBox(8);
            main.getStyleClass().add("sample-page");
            // create header
            Label leftHeader = new Label(getName()+ " Statistic Analysis Chart - Left");
            leftHeader.getStyleClass().add("page-header");
            main.getChildren().add(leftHeader);
            //final Sample sample = (Sample)sampleClass.newInstance();
            if(getName().equals("GrayVolume")){
                lChartView = new ChartView(patientsResultsDao.getSingleLeftResults(0),getName(),patientsResultsDao.getVolumnMap(null),patientsResultsDao.getVolumnZMap(null));
                rChartView = new ChartView(patientsResultsDao.getSingleRightResults(0),getName(),patientsResultsDao.getVolumnMap(null),patientsResultsDao.getVolumnZMap(null));


            }
            else if(getName().equals("Thickness")){
                lChartView = new ChartView(patientsResultsDao.getSingleLeftResults(0),getName(),patientsResultsDao.getThicknessMap(null),patientsResultsDao.getThicknessZMap(null));
                rChartView = new ChartView(patientsResultsDao.getSingleRightResults(0),getName(),patientsResultsDao.getThicknessMap(null),patientsResultsDao.getThicknessZMap(null));


            }
            else if(getName().equals("Surface")){
                lChartView = new ChartView(patientsResultsDao.getSingleLeftResults(0),getName(),patientsResultsDao.getSurfaceMap(null),patientsResultsDao.getSurfaceZMap(null));
                rChartView = new ChartView(patientsResultsDao.getSingleRightResults(0),getName(),patientsResultsDao.getSurfaceMap(null),patientsResultsDao.getSurfaceZMap(null));


            }
            main.getChildren().add(lChartView.getBc());
            main.getChildren().add(lChartView.getLc());





            BorderPane borderPane = new BorderPane();
            borderPane.setCenter(main);


           // borderPane.setRight(createSideBar(sample));
            ScrollPane scrollPane = new ScrollPane();
            scrollPane.getStyleClass().add("noborder-scroll-pane");
            scrollPane.setContent(borderPane);
            scrollPane.setFitToWidth(true);
            scrollPane.setFitToHeight(true);
            scrollPane.setMinWidth(725);


            //for right conent
            final VBox main2 = new VBox(8);
            main2.getStyleClass().add("sample-page");
            // create header
            Label leftHeader2 = new Label(getName()+ "Statistic Analysis Chart - Right");
            leftHeader2.getStyleClass().add("page-header");
            main2.getChildren().add(leftHeader2);
            main2.getChildren().add(rChartView.getBc());
            main2.getChildren().add(rChartView.getLc());


            BorderPane borderPane2 = new BorderPane();
            borderPane2.setCenter(main2);


            // borderPane.setRight(createSideBar(sample));
            ScrollPane scrollPane2 = new ScrollPane();
            scrollPane2.getStyleClass().add("noborder-scroll-pane");
            scrollPane2.setContent(borderPane2);
            scrollPane2.setFitToWidth(true);
            scrollPane2.setFitToHeight(true);
            scrollPane2.setMinWidth(725);



            // create tab pane
            TabPane tabPane = new TabPane();
            tabPane.setId("source-tabs");
            final Tab leftTab = new Tab();
            leftTab.setText("Left Brain");
            leftTab.setContent(scrollPane);
            leftTab.setClosable(false);
            final Tab rightTab = new Tab();
            rightTab.setText("Right Brain");
            rightTab.setContent(scrollPane2);
            rightTab.setClosable(false);
//            tabPane.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
//                @Override public void invalidated(Observable ov) {
//                    if (tabPane.getSelectionModel().getSelectedItem() == sampleTab) {
//                        sample.play();
//                    } else {
//                        sample.stop();
//                    }
//                }
//            });
            tabPane.getTabs().addAll(leftTab,rightTab);
            return tabPane;
        } catch (Exception e) {
            e.printStackTrace();
            return new Text("Failed to create sample because of ["+e.getMessage()+"]");
        }
    }

//    private Node createSideBar(Sample sample) {
//        GridPane sidebar = new GridPane();
//        sidebar.getStyleClass().add("right-sidebar");
//        sidebar.setMaxWidth(Double.MAX_VALUE);
//        sidebar.setMaxHeight(Double.MAX_VALUE);
//        int sideRow = 0;
//        // create side bar content
//        // description
//        Label discTitle = new Label("Description");
//        discTitle.getStyleClass().add("right-sidebar-title");
//        GridPane.setConstraints(discTitle, 0, sideRow++);
//        sidebar.getChildren().add(discTitle);
//        Text disc = new Text(sampleInfo.getDescription());
//        disc.setWrappingWidth(200);
//        disc.getStyleClass().add("right-sidebar-body");
//        GridPane.setConstraints(disc, 0, sideRow++);
//        sidebar.getChildren().add(disc);
//        // docs
//        if (sampleInfo.getApiClasspaths()!=null && sampleInfo.getApiClasspaths().length>0) {
//            Separator separator = new Separator();
//            GridPane.setConstraints(separator, 0, sideRow++);
//            sidebar.getChildren().add(separator);
//            Label docsTitle = new Label("API Documentation");
//            docsTitle.getStyleClass().add("right-sidebar-title");
//            GridPane.setConstraints(docsTitle, 0, sideRow++);
//            sidebar.getChildren().add(docsTitle);
//            for (String docPath:sampleInfo.getApiClasspaths()) {
//                Hyperlink link = new Hyperlink(docPath);
//                link.setOnAction(new GoToPageEventHandler(Pages.API_DOCS+'/'+docPath.replace('.','/')));
//                GridPane.setConstraints(link, 0, sideRow++);
//                sidebar.getChildren().add(link);
//            }
//        }
//        // related
//        if (sampleInfo.getRelatesSamplePaths()!=null && sampleInfo.getRelatesSamplePaths().length>0) {
//            Separator separator = new Separator();
//            GridPane.setConstraints(separator, 0, sideRow++);
//            sidebar.getChildren().add(separator);
//            Label relatedTitle = new Label("Related");
//            relatedTitle.getStyleClass().add("right-sidebar-title");
//            GridPane.setConstraints(relatedTitle, 0, sideRow++);
//            sidebar.getChildren().add(relatedTitle);
//            for (String relatedPath:sampleInfo.getRelatesSamplePaths()) {
//                String[] parts = relatedPath.split("/");
//                Hyperlink link = new Hyperlink(parts[parts.length-1]);
//                //convert path
//                String path = "";
//                for(String part:parts) {
//                    path = path+'/'+ SampleHelper.formatName(part);
//                }
//                link.setOnAction(new GoToPageEventHandler(Pages.SAMPLES+path));
//                ///System.out.println("Pages.SAMPLES+path==>" + Pages.SAMPLES + path);
//                GridPane.setConstraints(link, 0, sideRow++);
//                sidebar.getChildren().add(link);
//            }
//        }
//        // resources
//        // TODO add back in later
////        if (resourceUrls!=null && resourceUrls.length>0) {
////            Separator separator = new Separator();
////            separator.setLayoutInfo(new GridLayoutInfo(sideRow++, 0));
////            sidebar.getChildren().add(separator);
////            Label docsTitle = new Label("Resources");
////            docsTitle.getStyleClass().add("right-sidebar-title");
////            docsTitle.setLayoutInfo(new GridLayoutInfo(sideRow++, 0));
////            sidebar.getChildren().add(docsTitle);
////            for (String resourceUrl:resourceUrls) {
////                String[] parts = resourceUrl.split("/");
////                Hyperlink link = new Hyperlink(parts[parts.length-1]);
////                link.setLayoutInfo(new GridLayoutInfo(sideRow++, 0));
////                sidebar.getChildren().add(link);
////            }
////        }
//        // sample extras
//        Node sampleExtras = sample.getSideBarExtraContent();
//        if (sampleExtras != null) {
//            Separator separator = new Separator();
//            GridPane.setConstraints(separator, 0, sideRow++);
//            sidebar.getChildren().add(separator);
//            Label docsTitle = new Label(sample.getSideBarExtraContentTitle());
//            docsTitle.getStyleClass().add("right-sidebar-title");
//            GridPane.setConstraints(docsTitle, 0, sideRow++);
//            sidebar.getChildren().add(docsTitle);
//            GridPane.setConstraints(sampleExtras, 0, sideRow++);
//            sidebar.getChildren().add(sampleExtras);
//        }
//        return sidebar;
//    }

//    private Node getIcon() {
//        URL url = sampleClass.getResource(sampleClass.getSimpleName()+".png");
//        if (url != null) {
//            ImageView imageView = new ImageView(new Image(url.toString()));
//            return imageView;
//        } else {
//            ImageView imageView = new ImageView(new Image(Ensemble2.class.getResource("images/icon-overlay.png").toString()));
//            imageView.setMouseTransparent(true);
//            Rectangle overlayHighlight = new Rectangle(-8,-8,130,130);
//            overlayHighlight.setFill(new LinearGradient(0,0.5,0,1,true, CycleMethod.NO_CYCLE, new Stop[]{ new Stop(0,Color.BLACK), new Stop(1,Color.web("#444444"))}));
//            overlayHighlight.setOpacity(0.8);
//            overlayHighlight.setMouseTransparent(true);
//            overlayHighlight.setBlendMode(BlendMode.ADD);
//            Rectangle background = new Rectangle(-8,-8,130,130);
//            background.setFill(Color.web("#b9c0c5"));
//            Group group = new Group(background);
//            Rectangle clipRect = new Rectangle(114,114);
//            clipRect.setArcWidth(38);
//            clipRect.setArcHeight(38);
//            group.setClip(clipRect);
//            Node content = createIconContent();
//            if (content != null) {
//                content.setTranslateX((int)((114-content.getBoundsInParent().getWidth())/2)-(int)content.getBoundsInParent().getMinX());
//                content.setTranslateY((int)((114-content.getBoundsInParent().getHeight())/2)-(int)content.getBoundsInParent().getMinY());
//                group.getChildren().add(content);
//            }
//            group.getChildren().addAll(overlayHighlight,imageView);
//            // Wrap in extra group as clip dosn't effect layout without it
//            return new Group(group);
//        }
//    }

//    public Node createIconContent() {
//        try {
//            Method createIconContent = sampleClass.getDeclaredMethod("createIconContent");
//            return (Node)createIconContent.invoke(sampleClass);
//        } catch (NoSuchMethodException e) {
//            System.err.println("Sample ["+getName()+"] is missing a icon.");
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public Node createTile() {
//        Button tile = new Button(getName().trim(),getIcon());
//        tile.setMinSize(140,145);
//        tile.setPrefSize(140,145);
//        tile.setMaxSize(140,145);
//        tile.setContentDisplay(ContentDisplay.TOP);
//        tile.getStyleClass().clear();
//        tile.getStyleClass().add("sample-tile");
//        tile.setOnAction(new EventHandler() {
//            public void handle(Event event) {
//                Ensemble2.getEnsemble2().goToPage(SamplePage.this);
//            }
//        });
//        return tile;
//    }

    protected WebView getWebView() {
        if (engine == null) {
            webView = new WebView();
            webView.setContextMenuEnabled(false);
            engine = webView.getEngine();
        }
        return webView;
    }



}
