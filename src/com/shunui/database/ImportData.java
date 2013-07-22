package com.shunui.database;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.shunui.model.*;

public class ImportData {
	public ImportData() {

	}

	public void ReadData(InputStream input, dAtlas patient, char hemi) {

		
		if (patient == null) patient = new dAtlas();
		 

		//File file = new File(fileName.getPath());
		if (input != null) {
			InputStreamReader ir;
			try {
                ir = new InputStreamReader(input);
				BufferedReader br = new BufferedReader(ir);
				// String str;
				// "#" ACII 35
				String str = null;
				while ((str = br.readLine()) != null) {
					if (str.charAt(0) != 35) {
						break;
					}
				}
				// System.out.println(str);
				// String s = "\\d+|\\d+.\\d+|[a-zA-Z\\-\\_]+";
				String s = "[a-z0-9A-Z\\-\\_\\.]+";

				while (str != null) {

					Pattern pattern = Pattern.compile(s);
					Matcher ma = pattern.matcher(str);

					String[] dataStr = new String[10];
					int i = 0;
					while (ma.find() && (i < 10)) {
						dataStr[i] = ma.group();
						// System.out.println(ma.group());
						i++;
					}

					aparcStat tmp_data = new aparcStat();

					tmp_data.StructName = dataStr[0];
					tmp_data.NumVert = Integer.valueOf(dataStr[1]);
					tmp_data.SurfArea = Integer.valueOf(dataStr[2]);
					tmp_data.GrayVol = Double.valueOf(dataStr[3]);
					tmp_data.ThickAvg = Double.valueOf(dataStr[4]);
					tmp_data.ThickStd = Double.valueOf(dataStr[5]);
					tmp_data.MeanCurv = Double.valueOf(dataStr[6]);
					tmp_data.GausCurv = Double.valueOf(dataStr[7]);
					tmp_data.FoldInd = Double.valueOf(dataStr[8]);
					tmp_data.CurvInd = Double.valueOf(dataStr[9]);

					if (hemi == 'l') {

						patient.Lh.add(tmp_data);
					}
					else if (hemi == 'r'){
						patient.Rh.add(tmp_data);
					}
					
					str = br.readLine();

				}

				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
