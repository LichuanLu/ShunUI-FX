package view.chart;

import javafx.scene.chart.BarChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;


/**
 * Created with IntelliJ IDEA.
 * User: labuser
 * Date: 14/07/13
 * Time: 23:57
 * To change this template use File | Settings | File Templates.
 */
public class LinebarChart extends BarChart<String,Number> {

    // -------------- test data ----------------------------------------------
    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";


    // -------------- CONSTRUCTORS ----------------------------------------------
    public LinebarChart(Axis<String> xAxis, Axis<Number> yAxis){
       super(xAxis,yAxis);
        setAnimated(false);
        xAxis.setAnimated(false);
        yAxis.setAnimated(false);
    }



    // -------------- METHODS ------------------------------------------------------------------------------------------
//    @Override protected void layoutPlotChildren() {
//        if (getData() == null) {
//            return;
//        }
//        for (int seriesIndex = 0; seriesIndex < getData().size(); seriesIndex++) {
//            Series<String, Number> series = getData().get(seriesIndex);
//            Iterator<Data<String, Number>> iter = getDisplayedDataIterator(series);
//            Path seriesPath = null;
//            if (series.getNode() instanceof Path) {
//                seriesPath = (Path) series.getNode();
//                //seriesPath.getElements().clear();
//            }
//            while (iter.hasNext()) {
//                Data<String, Number> item = iter.next();
//                double x = getXAxis().getDisplayPosition(getCurrentDisplayedXValue(item));
//                double y = getYAxis().getDisplayPosition(getCurrentDisplayedYValue(item));
//                Node itemNode = item.getNode();
//                LineExtraValues extra = (LineExtraValues) item.getExtraValue();
//                if (extra != null) {
//                    //Candle candle = (Candle) itemNode;
//
//                    //double high = getYAxis().getDisplayPosition(extra.getHigh());
//                    //double low = getYAxis().getDisplayPosition(extra.getLow());
//                    // calculate candle width
//                    /*double candleWidth = -1;
//                    if (getXAxis() instanceof NumberAxis) {
//                        NumberAxis xa = (NumberAxis) getXAxis();
//                        candleWidth = xa.getDisplayPosition(xa.getTickUnit()) * 0.90; // use 90% width between ticks
//                    } */
//                    // update candle
//                    //candle.update(close - y, high - y, low - y, candleWidth);
//                    //itemNode.updateTooltip(item.getYValue().doubleValue(), extra.getHigh(), extra.getLow());
//
//                    // position the candle
//                    //candle.setLayoutX(x);
//                    //candle.setLayoutY(y);
//                }
//                if (seriesPath != null) {
//                    if (seriesPath.getElements().isEmpty()) {
//                        seriesPath.getElements().add(new MoveTo(x, getYAxis().getDisplayPosition(extra.getHigh())));
//                    } else {
//                        seriesPath.getElements().add(new LineTo(x, getYAxis().getDisplayPosition(extra.getHigh())));
//                    }
//                }
//                if (seriesPath != null) {
//                    if (seriesPath.getElements().isEmpty()) {
//                        seriesPath.getElements().add(new MoveTo(x, getYAxis().getDisplayPosition(extra.getLow())));
//                    } else {
//                        seriesPath.getElements().add(new LineTo(x, getYAxis().getDisplayPosition(extra.getLow())));
//                    }
//                }
//            }
//        }
//
//    }





    /** Data extra values for high and low. */
    private static class LineExtraValues {
        private double high;
        private double low;

        public LineExtraValues(double high, double low) {
            this.high = high;
            this.low = low;
        }

        public double getHigh() {
            return high;
        }

        public double getLow() {
            return low;
        }


    }



    public static LinebarChart createChart() {

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        //final NumberAxis xAxis = new NumberAxis(0,32,1);
        //xAxis.setMinorTickCount(0);
        //final NumberAxis yAxis = new NumberAxis();
        final LinebarChart blc = new LinebarChart(xAxis,yAxis);
        // setup chart
        blc.setTitle("Custom line bar Chart");
        xAxis.setLabel("Area");
        yAxis.setLabel("Number");
        // add starting data
        Series<String,Number> series = new Series<String,Number>();

        series.setName("2003");
        series.getData().add(new Data(austria,100.34,new LineExtraValues(170.1,50.2)));
        series.getData().add(new Data(brazil,202.82,new LineExtraValues(380.1,100.2)));
        series.getData().add(new Data(france,100,new LineExtraValues(180.1,30.2)));
        series.getData().add(new Data(italy,354.15,new LineExtraValues(480.1,200.2)));
        series.getData().add(new Data(usa,120,new LineExtraValues(180.1,100.2)));


        ObservableList<Series<String,Number>> data = blc.getData();
        if (data == null) {
            data = FXCollections.observableArrayList(series);
            blc.setData(data);
        } else {
            blc.getData().add(series);
        }
        return blc;
    }

    /*public void updateTooltip(double open, double close, double high, double low) {
        TooltipContent tooltipContent = (TooltipContent) tooltip.getGraphic();
        tooltipContent.update(open, close, high, low);
//                    tooltip.setText("Open: "+open+"\nClose: "+close+"\nHigh: "+high+"\nLow: "+low);
    }

    private class TooltipContent extends GridPane {
        private Label openValue = new Label();
        private Label closeValue = new Label();
        private Label highValue = new Label();
        private Label lowValue = new Label();

        private TooltipContent() {
            Label open = new Label("OPEN:");
            Label close = new Label("CLOSE:");
            Label high = new Label("HIGH:");
            Label low = new Label("LOW:");
            open.getStyleClass().add("candlestick-tooltip-label");
            close.getStyleClass().add("candlestick-tooltip-label");
            high.getStyleClass().add("candlestick-tooltip-label");
            low.getStyleClass().add("candlestick-tooltip-label");
            setConstraints(open, 0, 0);
            setConstraints(openValue, 1, 0);
            setConstraints(close, 0, 1);
            setConstraints(closeValue, 1, 1);
            setConstraints(high, 0, 2);
            setConstraints(highValue, 1, 2);
            setConstraints(low, 0, 3);
            setConstraints(lowValue, 1, 3);
            getChildren().addAll(open, openValue, close, closeValue, high, highValue, low, lowValue);
        }

        public void update(double open, double close, double high, double low) {
            openValue.setText(Double.toString(open));
            closeValue.setText(Double.toString(close));
            highValue.setText(Double.toString(high));
            lowValue.setText(Double.toString(low));
        }
    } */



}



