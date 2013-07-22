package com.shunui.model;

import java.util.ArrayList;



public class dAtlas {
	
	/*
	//construct dAtlas without argument.
	public dAtlas(){	
		
		
		
		aparcStat tmp[] = new aparcStat[75];
		
		for(int i = 0 ; i < 74 ; i++){
			
		tmp[i] = new aparcStat();
		
		}
		
		tmp[0].StructName = "G_and_S_frontomargin";
		tmp[1].StructName = "G_and_S_occipital_inf";
		tmp[2].StructName = "G_and_S_paracentral";
		tmp[3].StructName = "G_and_S_subcentral";
		tmp[4].StructName = "G_and_S_transv_frontopol";
		tmp[5].StructName = "G_and_S_cingul-Ant";
		tmp[6].StructName = "G_and_S_cingul-Mid-Ant";
		tmp[7].StructName = "G_and_S_cingul-Mid-Post";
		tmp[8].StructName = "G_cingul-Post-dorsal";
		tmp[9].StructName = "G_cingul-Post-ventral";
		tmp[10].StructName = "G_cuneus";
		tmp[11].StructName = "G_front_inf-Opercular";
		tmp[12].StructName = "G_front_inf-Orbital";
		tmp[13].StructName = "G_front_inf-Triangul";
		tmp[14].StructName = "G_front_middle";
		tmp[15].StructName = "G_front_sup";
		tmp[16].StructName = "G_Ins_lg_and_S_cent_ins";
		tmp[17].StructName = "G_insular_short";
		tmp[18].StructName = "G_occipital_middle";
		tmp[19].StructName = "G_occipital_sup";
		tmp[20].StructName = "G_oc-temp_lat-fusifor";
		tmp[21].StructName = "G_oc-temp_med-Lingual";
		tmp[22].StructName = "G_oc-temp_med-Parahip";
		tmp[23].StructName = "G_orbital";
		tmp[24].StructName = "G_pariet_inf-Angular";
		tmp[25].StructName = "G_pariet_inf-Supramar";
		tmp[26].StructName = "G_parietal_sup ";
		tmp[27].StructName = "G_postcentral";
		tmp[28].StructName = "G_precentral";
		tmp[29].StructName = "G_precuneus";
		tmp[30].StructName = "G_rectus";
		tmp[31].StructName = "G_subcallosal";
		tmp[32].StructName = "G_temp_sup-G_T_transv";
		tmp[33].StructName = "G_temp_sup-Lateral";
		tmp[34].StructName = "G_temp_sup-Plan_polar";
		tmp[35].StructName = "G_temp_sup-Plan_tempo";
		tmp[36].StructName = "G_temporal_inf";
		tmp[37].StructName = "G_temporal_middle";
		tmp[38].StructName = "Lat_Fis-ant-Horizont";
		tmp[39].StructName = "Lat_Fis-ant-Vertical ";
		tmp[40].StructName = "Lat_Fis-post";
		tmp[41].StructName = "Pole_occipital";
		tmp[42].StructName = "Pole_temporal";
		tmp[43].StructName = "S_calcarine";
		tmp[44].StructName = "S_central";
		tmp[45].StructName = "S_cingul-Marginalis";
		tmp[46].StructName = "S_circular_insula_ant";
		tmp[47].StructName = "S_circular_insula_inf";
		tmp[48].StructName = "S_circular_insula_sup";
		tmp[49].StructName = "S_collat_transv_ant";
		tmp[50].StructName = "S_collat_transv_post";
		tmp[51].StructName = "S_front_inf";
		tmp[52].StructName = "S_front_middle";
		tmp[53].StructName = "S_front_sup";
		tmp[54].StructName = "S_interm_prim-Jensen ";
		tmp[55].StructName = "S_intrapariet_and_P_trans";
		tmp[56].StructName = "S_oc_middle_and_Lunatus";
		tmp[57].StructName = "S_oc_sup_and_transversal";
		tmp[58].StructName = "S_occipital_ant";
		tmp[59].StructName = "S_oc-temp_lat";
		tmp[60].StructName = "S_oc-temp_med_and_Lingual";
		tmp[61].StructName = "S_orbital_lateral";
		tmp[62].StructName = "S_orbital_med-olfact";
		tmp[63].StructName = "S_orbital-H_Shaped";
		tmp[64].StructName = "S_parieto_occipital";
		tmp[65].StructName = "S_pericallosal";
		tmp[66].StructName = "S_postcentral";
		tmp[67].StructName = "S_precentral-inf-part";
		tmp[68].StructName = "S_precentral-sup-part";
		tmp[69].StructName = "S_suborbital";
		tmp[70].StructName = "S_subparietal";
		tmp[71].StructName = "S_temporal_inf";
		tmp[72].StructName = "S_temporal_sup";
		tmp[73].StructName = "S_temporal_transverse";		
		
		for(int i=0; i<74 ; i ++){
			this.Lh.add(tmp[i]);
			this.Rh.add(tmp[i]);
		}
		
	}
	
	//overload constructor
	public dAtlas(String name, int age, int gender){
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		
		aparcStat tmp[] = new aparcStat[75];
		
		tmp[0].StructName = "G_and_S_frontomargin";
		tmp[1].StructName = "G_and_S_occipital_inf";
		tmp[2].StructName = "G_and_S_paracentral";
		tmp[3].StructName = "G_and_S_subcentral";
		tmp[4].StructName = "G_and_S_transv_frontopol";
		tmp[5].StructName = "G_and_S_cingul-Ant";
		tmp[6].StructName = "G_and_S_cingul-Mid-Ant";
		tmp[7].StructName = "G_and_S_cingul-Mid-Post";
		tmp[8].StructName = "G_cingul-Post-dorsal";
		tmp[9].StructName = "G_cingul-Post-ventral";
		tmp[10].StructName = "G_cuneus";
		tmp[11].StructName = "G_front_inf-Opercular";
		tmp[12].StructName = "G_front_inf-Orbital";
		tmp[13].StructName = "G_front_inf-Triangul";
		tmp[14].StructName = "G_front_middle";
		tmp[15].StructName = "G_front_sup";
		tmp[16].StructName = "G_Ins_lg_and_S_cent_ins";
		tmp[17].StructName = "G_insular_short";
		tmp[18].StructName = "G_occipital_middle";
		tmp[19].StructName = "G_occipital_sup";
		tmp[20].StructName = "G_oc-temp_lat-fusifor";
		tmp[21].StructName = "G_oc-temp_med-Lingual";
		tmp[22].StructName = "G_oc-temp_med-Parahip";
		tmp[23].StructName = "G_orbital";
		tmp[24].StructName = "G_pariet_inf-Angular";
		tmp[25].StructName = "G_pariet_inf-Supramar";
		tmp[26].StructName = "G_parietal_sup ";
		tmp[27].StructName = "G_postcentral";
		tmp[28].StructName = "G_precentral";
		tmp[29].StructName = "G_precuneus";
		tmp[30].StructName = "G_rectus";
		tmp[31].StructName = "G_subcallosal";
		tmp[32].StructName = "G_temp_sup-G_T_transv";
		tmp[33].StructName = "G_temp_sup-Lateral";
		tmp[34].StructName = "G_temp_sup-Plan_polar";
		tmp[35].StructName = "G_temp_sup-Plan_tempo";
		tmp[36].StructName = "G_temporal_inf";
		tmp[37].StructName = "G_temporal_middle";
		tmp[38].StructName = "Lat_Fis-ant-Horizont";
		tmp[39].StructName = "Lat_Fis-ant-Vertical ";
		tmp[40].StructName = "Lat_Fis-post";
		tmp[41].StructName = "Pole_occipital";
		tmp[42].StructName = "Pole_temporal";
		tmp[43].StructName = "S_calcarine";
		tmp[44].StructName = "S_central";
		tmp[45].StructName = "S_cingul-Marginalis";
		tmp[46].StructName = "S_circular_insula_ant";
		tmp[47].StructName = "S_circular_insula_inf";
		tmp[48].StructName = "S_circular_insula_sup";
		tmp[49].StructName = "S_collat_transv_ant";
		tmp[50].StructName = "S_collat_transv_post";
		tmp[51].StructName = "S_front_inf";
		tmp[52].StructName = "S_front_middle";
		tmp[53].StructName = "S_front_sup";
		tmp[54].StructName = "S_interm_prim-Jensen ";
		tmp[55].StructName = "S_intrapariet_and_P_trans";
		tmp[56].StructName = "S_oc_middle_and_Lunatus";
		tmp[57].StructName = "S_oc_sup_and_transversal";
		tmp[58].StructName = "S_occipital_ant";
		tmp[59].StructName = "S_oc-temp_lat";
		tmp[60].StructName = "S_oc-temp_med_and_Lingual";
		tmp[61].StructName = "S_orbital_lateral";
		tmp[62].StructName = "S_orbital_med-olfact";
		tmp[63].StructName = "S_orbital-H_Shaped";
		tmp[64].StructName = "S_parieto_occipital";
		tmp[65].StructName = "S_pericallosal";
		tmp[66].StructName = "S_postcentral";
		tmp[67].StructName = "S_precentral-inf-part";
		tmp[68].StructName = "S_precentral-sup-part";
		tmp[69].StructName = "S_suborbital";
		tmp[70].StructName = "S_subparietal";
		tmp[71].StructName = "S_temporal_inf";
		tmp[72].StructName = "S_temporal_sup";
		tmp[73].StructName = "S_temporal_transverse";		
		
		for(int i=0; i<74 ; i ++){
			this.Lh.add(tmp[i]);
			this.Rh.add(tmp[i]);
		}
	}
	*/
	
	public ArrayList<aparcStat> Lh = new ArrayList<aparcStat>();
	
	public ArrayList<aparcStat> Rh = new ArrayList<aparcStat>();
	
	public String name;
	public int age;
	public int gender; // 1 means male, 0 means famle.
	public String notes;
	

}
