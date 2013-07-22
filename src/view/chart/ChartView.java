package view.chart;

import dao.PatientsResultsDao;
import javafx.collections.FXCollections;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import models.AreaData;
import models.LineExtraValues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liclu
 * Date: 13-7-21
 * Time: 下午5:08
 * To change this template use File | Settings | File Templates.
 */
public class ChartView {


    private StackedBarChart<String,Number> bc;
    private LineChart lc;
    private ArrayList<AreaData> chartData;
    private String name;
    private Map<String,LineExtraValues> high_low_map;
    private Map<String,Double> zscoreMap;

    public ChartView(ArrayList<AreaData> chartData , String name ,  Map<String,LineExtraValues> high_low_map ,  Map<String,Double> zscoreMap){
        this.chartData = chartData;
        this.name = name;
        this.high_low_map =  high_low_map;
        this.zscoreMap = zscoreMap;
        initChart();

    }

    public void initChart() {
         CategoryAxis xAxis = new CategoryAxis();
         NumberAxis yAxis = new NumberAxis();

         //zscore line chart
         CategoryAxis xAxis2 = new CategoryAxis();
         NumberAxis yAxis2 = new NumberAxis();


         int len = chartData.size();
         int index = 0;
         String areas[] = new String[len];
         AreaData areaData;

         XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        //zscore
         XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();

        series1.setName(name + " Value");
        series2.setName("Zscore value");

        while(index<len){
             areaData =  ((AreaData)chartData.get(index));
             areas[index] = areaData.getAreaName();
             if(name.equals("GrayVolume")){
                 series1.getData().add(new XYChart.Data<String,Number>(areas[index], areaData.getVolumn(),high_low_map.get(areas[index])));

             }else if(name.equals("Thickness")){
                 series1.getData().add(new XYChart.Data<String,Number>(areas[index], areaData.getThickness(),high_low_map.get(areas[index])));

             }else if(name.equals("Surface")){
                 series1.getData().add(new XYChart.Data<String,Number>(areas[index], areaData.getSurface(),high_low_map.get(areas[index])));


             }

            series2.getData().add(new XYChart.Data<String,Number>(areas[index],zscoreMap.get(areas[index])));

            ++index;
         }
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis){
            @Override
            public String toString(Number object){
                String label;
                label = String.format("%7.2f", object.floatValue());
                return label;
            }
        });
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(areas)));
        bc = new StackedBarChart<String,Number>(xAxis,yAxis);
        lc = new LineChart<String,Number>(xAxis2,yAxis2);
        bc.getData().add(series1);
        lc.getData().add(series2);



        // setup chart
        //bc.setTitle("Thickness Statistics Chart");
        // xAxis.setLabel("Area");
        //yAxis.setLabel("Value");




    }


    public StackedBarChart<String, Number> getBc() {
        return bc;
    }

    public LineChart getLc() {
        return lc;
    }






}
