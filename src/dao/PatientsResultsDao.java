package dao;

import models.AreaData;
import models.LineExtraValues;
import models.PatientsResults;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.shunui.database.ImportData;
import com.shunui.model.dAtlas;

/**
 * Created with IntelliJ IDEA. User: liclu Date: 13-7-19 Time: 下午10:37 To
 * change this template use File | Settings | File Templates.
 */
public class PatientsResultsDao {
	private static PatientsResultsDao instance = null;

	private ArrayList<AreaData> leftResults = null;
	private ArrayList<AreaData> rightResults = null;

	private Map<String, LineExtraValues> volumnMap; // storage for hign and low
													// value
	private Map<String, LineExtraValues> thicknessMap;
	private Map<String, LineExtraValues> surfaceMap;

	private Map<String, Double> volumnZMap; // storage for zscore value
	private Map<String, Double> thicknessZMap;
	private Map<String, Double> surfaceZMap;

	public PatientsResultsDao() {
	}

	public static PatientsResultsDao getInstance() {
		if (instance == null) {
			instance = new PatientsResultsDao();
		}

		return instance;
	}

	// patients_record_Id is like 2013-08-07-main
	public ArrayList<AreaData> getSingleLeftResults(int patients_record_Id) {

		// logic to get data

		// data for testing , please comments these when adding real logic
		/*
		 * leftResults = new ArrayList<AreaData>();
		 * 
		 * leftResults.addAll(Arrays.asList( new
		 * AreaData("G_and_S_frontomargin",1400.5,1567.5,2000.5), new
		 * AreaData("G_and_S_occipital_inf",1500.5,1767.5,2100.5), new
		 * AreaData("G_and_S_paracentral",1540.5,1967.5,2000.5), new
		 * AreaData("G_and_S_subcentral",1240.5,1367.5,2500.5), new
		 * AreaData("G_and_S_transv_frontopol",1240.5,1367.5,2500.5) ));
		 */
		// AreaData(String areaName, double volume, double thickness, double
		// surface)

		leftResults = new ArrayList<AreaData>();

		dAtlas CortexMap = new dAtlas();
		ImportData data = new ImportData();
        InputStream input = this.getClass().getResourceAsStream("lh.aparc.a2009s.stats");
		data.ReadData(input, CortexMap, 'l');
		//System.out.println(url);

		for (int i = 0; i < CortexMap.Lh.size(); i++) {

			leftResults.add(new AreaData(CortexMap.Lh.get(i).StructName,
					CortexMap.Lh.get(i).GrayVol, 
					CortexMap.Lh.get(i).ThickAvg,
					CortexMap.Lh.get(i).SurfArea));

		}

		return leftResults;
	}

	public ArrayList<AreaData> getSingleRightResults(int patients_record_Id) {

		// logic to get data

		// data for testing , plese comments these when adding real logic
		rightResults = new ArrayList<AreaData>();
		/*
		rightResults.addAll(Arrays.asList(new AreaData("G_and_S_frontomargin",
				1300.5, 1467.5, 1900.5), new AreaData("G_and_S_occipital_inf",
				1850.5, 1567.5, 2300.5), new AreaData("G_and_S_paracentral",
				1980.5, 1867.5, 2200.5), new AreaData("G_and_S_subcentral",
				1140.5, 1567.5, 2300.5), new AreaData(
				"G_and_S_transv_frontopol", 1340.5, 1367.5, 2200.5)));
		*/
		
		dAtlas CortexMap = new dAtlas();
		ImportData data = new ImportData();
        InputStream input = this.getClass().getResourceAsStream("rh.aparc.a2009s.stats");
        data.ReadData(input, CortexMap, 'r');
		
		for (int i = 0; i < CortexMap.Rh.size(); i++) {

			rightResults.add(new AreaData(CortexMap.Rh.get(i).StructName,
					CortexMap.Rh.get(i).GrayVol, 
					CortexMap.Rh.get(i).ThickAvg,
					CortexMap.Rh.get(i).SurfArea));

		}

		return rightResults;
	}

	// type's value can be chosen in( volume ,surface , thickness)
	// using map for areaName and LineExtraValue object
	// init the map when the data has been loading
	public LineExtraValues getHighLowVal(String areaName, String type) {
		// logic to get high and low Val

		// test data
		double high = 2800.0;
		double low = 950.0;

		return new LineExtraValues(high, low);

	}

	public void refreshData() {
		leftResults = null;
		rightResults = null;
	}

	public Map<String, LineExtraValues> getVolumnMap(
			ArrayList<AreaData> areaDataList) {

		// for test data
		volumnMap = new HashMap<String, LineExtraValues>();
//		volumnMap.put("G_and_S_frontomargin", new LineExtraValues<Double>(
//				1200.0, 2800.0));
//		volumnMap.put("G_and_S_occipital_inf", new LineExtraValues<Double>(
//				1100.0, 2700.0));
//		volumnMap.put("G_and_S_paracentral", new LineExtraValues<Double>(
//				1200.5, 2300.0));
//		volumnMap.put("G_and_S_subcentral", new LineExtraValues<Double>(900.0,
//				1901.5));
//		volumnMap.put("G_and_S_transv_frontopol", new LineExtraValues<Double>(
//				1400.5, 2600.5));

        dAtlas CortexMap = new dAtlas();
        ImportData data = new ImportData();
        InputStream input = this.getClass().getResourceAsStream("lh.aparc.a2009s.stats");
        data.ReadData(input, CortexMap, 'l');
        for (int i = 0; i < CortexMap.Lh.size(); i++) {
            double low = (Math.random())*1000;
            double high =  (Math.random())*1000+1000;
            volumnMap.put(CortexMap.Lh.get(i).StructName,new LineExtraValues<Double>(low,high));
        }



		return volumnMap;
	}

	public void setVolumnMap(Map<String, LineExtraValues> volumnMap) {
		this.volumnMap = volumnMap;
	}

	public Map<String, LineExtraValues> getThicknessMap(
			ArrayList<AreaData> areaDataList) {

		// for test data
		thicknessMap = new HashMap<String, LineExtraValues>();
//		thicknessMap.put("G_and_S_frontomargin", new LineExtraValues<Double>(
//				1200.0, 2800.0));
//		thicknessMap.put("G_and_S_occipital_inf", new LineExtraValues<Double>(
//				1100.0, 2700.0));
//		thicknessMap.put("G_and_S_paracentral", new LineExtraValues<Double>(
//				1200.5, 2300.0));
//		thicknessMap.put("G_and_S_subcentral", new LineExtraValues<Double>(
//				900.0, 1901.5));
//		thicknessMap.put("G_and_S_transv_frontopol",
//				new LineExtraValues<Double>(1400.5, 2600.5));
        dAtlas CortexMap = new dAtlas();
        ImportData data = new ImportData();
        InputStream input = this.getClass().getResourceAsStream("lh.aparc.a2009s.stats");
        data.ReadData(input, CortexMap, 'l');
        for (int i = 0; i < CortexMap.Lh.size(); i++) {
            double low = (Math.random());
            double high =  (Math.random())+3;
            thicknessMap.put(CortexMap.Lh.get(i).StructName,new LineExtraValues<Double>(low,high));
        }
		return thicknessMap;
	}

	public void setThicknessMap(Map<String, LineExtraValues> thicknessMap) {
		this.thicknessMap = thicknessMap;
	}

	public Map<String, LineExtraValues> getSurfaceMap(
			ArrayList<AreaData> areaDataList) {

		// for test data
		surfaceMap = new HashMap<String, LineExtraValues>();
//		surfaceMap.put("G_and_S_frontomargin", new LineExtraValues<Double>(
//				1200.0, 2800.0));
//		surfaceMap.put("G_and_S_occipital_inf", new LineExtraValues<Double>(
//				1100.0, 2700.0));
//		surfaceMap.put("G_and_S_paracentral", new LineExtraValues<Double>(
//				1200.5, 2300.0));
//		surfaceMap.put("G_and_S_subcentral", new LineExtraValues<Double>(900.0,
//				1901.5));
//		surfaceMap.put("G_and_S_transv_frontopol", new LineExtraValues<Double>(
//				1400.5, 2600.5));
        dAtlas CortexMap = new dAtlas();
        ImportData data = new ImportData();
        InputStream input = this.getClass().getResourceAsStream("/res/lh.aparc.a2009s.stats");
        data.ReadData(input, CortexMap, 'l');
        for (int i = 0; i < CortexMap.Lh.size(); i++) {
            double low = (Math.random())*1000;
            double high =  (Math.random())*1000+1000;
            surfaceMap.put(CortexMap.Lh.get(i).StructName,new LineExtraValues<Double>(low,high));
        }
		return surfaceMap;
	}

	public void setSurfaceMap(Map<String, LineExtraValues> surfaceMap) {
		this.surfaceMap = surfaceMap;
	}

	public Map<String, Double> getVolumnZMap(ArrayList<AreaData> areaDataList) {

		// for test data
		volumnZMap = new HashMap<String, Double>();
//		volumnZMap.put("G_and_S_frontomargin", 0.3);
//		volumnZMap.put("G_and_S_occipital_inf", -0.5);
//		volumnZMap.put("G_and_S_paracentral", 0.9);
//		volumnZMap.put("G_and_S_subcentral", -0.2);
//		volumnZMap.put("G_and_S_transv_frontopol", 0.1);

        dAtlas CortexMap = new dAtlas();
        ImportData data = new ImportData();
        InputStream input = this.getClass().getResourceAsStream("/res/lh.aparc.a2009s.stats");
        data.ReadData(input, CortexMap, 'l');
        for (int i = 0; i < CortexMap.Lh.size(); i++) {
            int temp = (int)((Math.random())*2 + 1) ;
            int temp2 = (int)Math.pow(-1,temp);
            double temp3 =  Math.random()*2*temp2;
            volumnZMap.put(CortexMap.Lh.get(i).StructName,temp3);
        }


        return volumnZMap;
	}

	public Map<String, Double> getThicknessZMap(ArrayList<AreaData> areaDataList) {

		// for test data
		thicknessZMap = new HashMap<String, Double>();
//		thicknessZMap.put("G_and_S_frontomargin", 0.1);
//		thicknessZMap.put("G_and_S_occipital_inf", -0.4);
//		thicknessZMap.put("G_and_S_paracentral", -0.9);
//		thicknessZMap.put("G_and_S_subcentral", 0.2);
//		thicknessZMap.put("G_and_S_transv_frontopol", 0.3);
        dAtlas CortexMap = new dAtlas();
        ImportData data = new ImportData();
        InputStream input = this.getClass().getResourceAsStream("/res/lh.aparc.a2009s.stats");
        data.ReadData(input, CortexMap, 'l');
        for (int i = 0; i < CortexMap.Lh.size(); i++) {
            int temp = (int)((Math.random())*2 + 1) ;
            int temp2 = (int)Math.pow(-1,temp);
            double temp3 =  Math.random()*2*temp2;
            thicknessZMap.put(CortexMap.Lh.get(i).StructName,temp3);
        }

		return thicknessZMap;
	}

	public Map<String, Double> getSurfaceZMap(ArrayList<AreaData> areaDataList) {

		// for test data
		surfaceZMap = new HashMap<String, Double>();
//		surfaceZMap.put("G_and_S_frontomargin", 0.1);
//		surfaceZMap.put("G_and_S_occipital_inf", -0.4);
//		surfaceZMap.put("G_and_S_paracentral", -0.4);
//		surfaceZMap.put("G_and_S_subcentral", 0.1);
//		surfaceZMap.put("G_and_S_transv_frontopol", 0.2);
        dAtlas CortexMap = new dAtlas();
        ImportData data = new ImportData();
        InputStream input = this.getClass().getResourceAsStream("/res/lh.aparc.a2009s.stats");
        data.ReadData(input, CortexMap, 'l');
        for (int i = 0; i < CortexMap.Lh.size(); i++) {
            int temp = (int)((Math.random())*2 + 1) ;
            int temp2 = (int)Math.pow(-1,temp);
            double temp3 =  Math.random()*2*temp2;
            surfaceZMap.put(CortexMap.Lh.get(i).StructName,temp3);
        }

		return surfaceZMap;
	}

}
