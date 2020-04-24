/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.covid19.controllers;

import com.shifan.covid19.models.CovidStatus;
import com.shifan.covid19.models.LatLng;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dimiksonkha
 */
@Controller
public class HomeController {
    

    List list = new ArrayList<>();
   
    
    public static final HashMap<String, LatLng> COUNTRY_ISOS = new HashMap<String, LatLng>() {{
    put("AD", new LatLng(42.546245,1.601554));
    put("AE", new LatLng(23.424076,53.847818));
    put("AF", new LatLng(33.93911,67.709953));
    put("AG", new LatLng(17.060816,-61.796428));
    put("AI", new LatLng(18.220554,-63.068615));
    put("AL", new LatLng(41.153332,20.168331));
    put("AM", new LatLng(40.069099,45.038189));
    put("AN", new LatLng(12.226079,-69.060087));
    put("AO", new LatLng(-11.202692,17.873887));
    put("AQ", new LatLng(-75.250973,-0.071389));
    put("AR", new LatLng(-38.416097,-63.616672));
    put("AS", new LatLng(-14.270972,-170.132217));
    put("AT", new LatLng(47.516231,14.550072));
    put("AU", new LatLng(-25.274398,133.775136));
    put("AW", new LatLng(12.52111,-69.968338));
    put("AZ", new LatLng(40.143105,47.576927));
    put("BA", new LatLng(43.915886,17.679076));
    put("BB", new LatLng(13.193887,-59.543198));
    put("BD", new LatLng(23.684994,90.356331));
    put("BE", new LatLng(50.503887,4.469936));
    put("BF", new LatLng(12.238333,-1.561593));
    put("BG", new LatLng(42.733883,25.48583));
    put("BH", new LatLng(25.930414,50.637772));
    put("BI", new LatLng(-3.373056,29.918886));
    put("BJ", new LatLng(9.30769,2.315834));
    put("BM", new LatLng(32.321384,-64.75737));
    put("BN", new LatLng(4.535277,114.727669));
    put("BO", new LatLng(-16.290154,-63.588653));
    put("BR", new LatLng(-14.235004,-51.92528));
    put("BS", new LatLng(25.03428,-77.39628));
    put("BT", new LatLng(27.514162,90.433601));
    put("BV", new LatLng(-54.423199,3.413194));
    put("BW", new LatLng(-22.328474,24.684866));
    put("BY", new LatLng(53.709807,27.953389));
    put("BZ", new LatLng(17.189877,-88.49765));
    put("CA", new LatLng(56.130366,-106.346771));
    put("CC", new LatLng(-12.164165,96.870956));
    put("CD", new LatLng(-4.038333,21.758664));
    put("CF", new LatLng(6.611111,20.939444));
    put("CG", new LatLng(-0.228021,15.827659));
    put("CH", new LatLng(46.818188,8.227512));
    put("CI", new LatLng(7.539989,-5.54708));
    put("CK", new LatLng(-21.236736,-159.777671));
    put("CL", new LatLng(-35.675147,-71.542969));
    put("CM", new LatLng(7.369722,12.354722));
    put("CN", new LatLng(35.86166,104.195397));
    put("CO", new LatLng(4.570868,-74.297333));
    put("CR", new LatLng(9.748917,-83.753428));
    put("CU", new LatLng(21.521757,-77.781167));
    put("CV", new LatLng(16.002082,-24.013197));
    put("CX", new LatLng(-10.447525,105.690449));
    put("CY", new LatLng(35.126413,33.429859));
    put("CZ", new LatLng(49.817492,15.472962));
    put("DE", new LatLng(51.165691,10.451526));
    put("DJ", new LatLng(11.825138,42.590275));
    put("DK", new LatLng(56.26392,9.501785));
    put("DM", new LatLng(15.414999,-61.370976));
    put("DO", new LatLng(18.735693,-70.162651));
    put("DZ", new LatLng(28.033886,1.659626));
    put("EC", new LatLng(-1.831239,-78.183406));
    put("EE", new LatLng(58.595272,25.013607));
    put("EG", new LatLng(26.820553,30.802498));
    put("EH", new LatLng(24.215527,-12.885834));
    put("ER", new LatLng(15.179384,39.782334));
    put("ES", new LatLng(40.463667,-3.74922));
    put("ET", new LatLng(9.145,40.489673));
    put("FI", new LatLng(61.92411,25.748151));
    put("FJ", new LatLng(-16.578193,179.414413));
    put("FK", new LatLng(-51.796253,-59.523613));
    put("FM", new LatLng(7.425554,150.550812));
    put("FO", new LatLng(61.892635,-6.911806));
    put("FR", new LatLng(46.227638,2.213749));
    put("GA", new LatLng(-0.803689,11.609444));
    put("GB", new LatLng(55.378051,-3.435973));
    put("GD", new LatLng(12.262776,-61.604171));
    put("GE", new LatLng(42.315407,43.356892));
    put("GF", new LatLng(3.933889,-53.125782));
    put("GG", new LatLng(49.465691,-2.585278));
    put("GH", new LatLng(7.946527,-1.023194));
    put("GI", new LatLng(36.137741,-5.345374));
    put("GL", new LatLng(71.706936,-42.604303));
    put("GM", new LatLng(13.443182,-15.310139));
    put("GN", new LatLng(9.945587,-9.696645));
    put("GP", new LatLng(16.995971,-62.067641));
    put("GQ", new LatLng(1.650801,10.267895));
    put("GR", new LatLng(39.074208,21.824312));
    put("GS", new LatLng(-54.429579,-36.587909));
    put("GT", new LatLng(15.783471,-90.230759));
    put("GU", new LatLng(13.444304,144.793731));
    put("GW", new LatLng(11.803749,-15.180413));
    put("GY", new LatLng(4.860416,-58.93018));
    put("GZ", new LatLng(31.354676,34.308825));
    put("HK", new LatLng(22.396428,114.109497));
    put("HM", new LatLng(-53.08181,73.504158));
    put("HN", new LatLng(15.199999,-86.241905));
    put("HR", new LatLng(45.1,15.2));
    put("HT", new LatLng(18.971187,-72.285215));
    put("HU", new LatLng(47.162494,19.503304));
    put("ID", new LatLng(-0.789275,113.921327));
    put("IE", new LatLng(53.41291,-8.24389));
    put("IL", new LatLng(31.046051,34.851612));
    put("IM", new LatLng(54.236107,-4.548056));
    put("IN", new LatLng(20.593684,78.96288));
    put("IO", new LatLng(-6.343194,71.876519));
    put("IQ", new LatLng(33.223191,43.679291));
    put("IR", new LatLng(32.427908,53.688046));
    put("IS", new LatLng(64.963051,-19.020835));
    put("IT", new LatLng(41.87194,12.56738));
    put("JE", new LatLng(49.214439,-2.13125));
    put("JM", new LatLng(18.109581,-77.297508));
    put("JO", new LatLng(30.585164,36.238414));
    put("JP", new LatLng(36.204824,138.252924));
    put("KE", new LatLng(-0.023559,37.906193));
    put("KG", new LatLng(41.20438,74.766098));
    put("KH", new LatLng(12.565679,104.990963));
    put("KI", new LatLng(-3.370417,-168.734039));
    put("KM", new LatLng(-11.875001,43.872219));
    put("KN", new LatLng(17.357822,-62.782998));
    put("KP", new LatLng(40.339852,127.510093));
    put("KR", new LatLng(35.907757,127.766922));
    put("KW", new LatLng(29.31166,47.481766));
    put("KY", new LatLng(19.513469,-80.566956));
    put("KZ", new LatLng(48.019573,66.923684));
    put("LA", new LatLng(19.85627,102.495496));
    put("LB", new LatLng(33.854721,35.862285));
    put("LC", new LatLng(13.909444,-60.978893));
    put("LI", new LatLng(47.166,9.555373));
    put("LK", new LatLng(7.873054,80.771797));
    put("LR", new LatLng(6.428055,-9.429499));
    put("LS", new LatLng(-29.609988,28.233608));
    put("LT", new LatLng(55.169438,23.881275));
    put("LU", new LatLng(49.815273,6.129583));
    put("LV", new LatLng(56.879635,24.603189));
    put("LY", new LatLng(26.3351,17.228331));
    put("MA", new LatLng(31.791702,-7.09262));
    put("MC", new LatLng(43.750298,7.412841));
    put("MD", new LatLng(47.411631,28.369885));
    put("ME", new LatLng(42.708678,19.37439));
    put("MG", new LatLng(-18.766947,46.869107));
    put("MH", new LatLng(7.131474,171.184478));
    put("MK", new LatLng(41.608635,21.745275));
    put("ML", new LatLng(17.570692,-3.996166));
    put("MM", new LatLng(21.913965,95.956223));
    put("MN", new LatLng(46.862496,103.846656));
    put("MO", new LatLng(22.198745,113.543873));
    put("MP", new LatLng(17.33083,145.38469));
    put("MQ", new LatLng(14.641528,-61.024174));
    put("MR", new LatLng(21.00789,-10.940835));
    put("MS", new LatLng(16.742498,-62.187366));
    put("MT", new LatLng(35.937496,14.375416));
    put("MU", new LatLng(-20.348404,57.552152));
    put("MV", new LatLng(3.202778,73.22068));
    put("MW", new LatLng(-13.254308,34.301525));
    put("MX", new LatLng(23.634501,-102.552784));
    put("MY", new LatLng(4.210484,101.975766));
    put("MZ", new LatLng(-18.665695,35.529562));
    put("NA", new LatLng(-22.95764,18.49041));
    put("NC", new LatLng(-20.904305,165.618042));
    put("NE", new LatLng(17.607789,8.081666));
    put("NF", new LatLng(-29.040835,167.954712));
    put("NG", new LatLng(9.081999,8.675277));
    put("NI", new LatLng(12.865416,-85.207229));
    put("NL", new LatLng(52.132633,5.291266));
    put("NO", new LatLng(60.472024,8.468946));
    put("NP", new LatLng(28.394857,84.124008));
    put("NR", new LatLng(-0.522778,166.931503));
    put("NU", new LatLng(-19.054445,-169.867233));
    put("NZ", new LatLng(-40.900557,174.885971));
    put("OM", new LatLng(21.512583,55.923255));
    put("PA", new LatLng(8.537981,-80.782127));
    put("PE", new LatLng(-9.189967,-75.015152));
    put("PF", new LatLng(-17.679742,-149.406843));
    put("PG", new LatLng(-6.314993,143.95555));
    put("PH", new LatLng(12.879721,121.774017));
    put("PK", new LatLng(30.375321,69.345116));
    put("PL", new LatLng(51.919438,19.145136));
    put("PM", new LatLng(46.941936,-56.27111));
    put("PN", new LatLng(-24.703615,-127.439308));
    put("PR", new LatLng(18.220833,-66.590149));
    put("PS", new LatLng(31.952162,35.233154));
    put("PT", new LatLng(39.399872,-8.224454));
    put("PW", new LatLng(7.51498,134.58252));
    put("PY", new LatLng(-23.442503,-58.443832));
    put("QA", new LatLng(25.354826,51.183884));
    put("RE", new LatLng(-21.115141,55.536384));
    put("RO", new LatLng(45.943161,24.96676));
    put("RS", new LatLng(44.016521,21.005859));
    put("RU", new LatLng(61.52401,105.318756));
    put("RW", new LatLng(-1.940278,29.873888));
    put("SA", new LatLng(23.885942,45.079162));
    put("SB", new LatLng(-9.64571,160.156194));
    put("SC", new LatLng(-4.679574,55.491977));
    put("SD", new LatLng(12.862807,30.217636));
    put("SE", new LatLng(60.128161,18.643501));
    put("SG", new LatLng(1.352083,103.819836));
    put("SH", new LatLng(-24.143474,-10.030696));
    put("SI", new LatLng(46.151241,14.995463));
    put("SJ", new LatLng(77.553604,23.670272));
    put("SK", new LatLng(48.669026,19.699024));
    put("SL", new LatLng(8.460555,-11.779889));
    put("SM", new LatLng(43.94236,12.457777));
    put("SN", new LatLng(14.497401,-14.452362));
    put("SO", new LatLng(5.152149,46.199616));
    put("SR", new LatLng(3.919305,-56.027783));
    put("ST", new LatLng(0.18636,6.613081));
    put("SV", new LatLng(13.794185,-88.89653));
    put("SY", new LatLng(34.802075,38.996815));
    put("SZ", new LatLng(-26.522503,31.465866));
    put("TC", new LatLng(21.694025,-71.797928));
    put("TD", new LatLng(15.454166,18.732207));
    put("TF", new LatLng(-49.280366,69.348557));
    put("TG", new LatLng(8.619543,0.824782));
    put("TH", new LatLng(15.870032,100.992541));
    put("TJ", new LatLng(38.861034,71.276093));
    put("TK", new LatLng(-8.967363,-171.855881));
    put("TL", new LatLng(-8.874217,125.727539));
    put("TM", new LatLng(38.969719,59.556278));
    put("TN", new LatLng(33.886917,9.537499));
    put("TO", new LatLng(-21.178986,-175.198242));
    put("TR", new LatLng(38.963745,35.243322));
    put("TT", new LatLng(10.691803,-61.222503));
    put("TV", new LatLng(-7.109535,177.64933));
    put("TW", new LatLng(23.69781,120.960515));
    put("TZ", new LatLng(-6.369028,34.888822));
    put("UA", new LatLng(48.379433,31.16558));
    put("UG", new LatLng(1.373333,32.290275));
    put("US", new LatLng(37.09024,-95.712891));
    put("UY", new LatLng(-32.522779,-55.765835));
    put("UZ", new LatLng(41.377491,64.585262));
    put("VA", new LatLng(41.902916,12.453389));
    put("VC", new LatLng(12.984305,-61.287228));
    put("VE", new LatLng(6.42375,-66.58973));
    put("VG", new LatLng(18.420695,-64.639968));
    put("VI", new LatLng(18.335765,-64.896335));
    put("VN", new LatLng(14.058324,108.277199));
    put("VU", new LatLng(-15.376706,166.959158));
    put("WF", new LatLng(-13.768752,-177.156097));
    put("WS", new LatLng(-13.759029,-172.104629));
    put("XK", new LatLng(42.602636,20.902977));
    put("YE", new LatLng(15.552727,48.516388));
    put("YT", new LatLng(-12.8275,45.166244));
    put("ZA", new LatLng(-30.559482,22.937506));
    put("ZM", new LatLng(-13.133897,27.849332));
    put("ZW", new LatLng(-19.015438,29.154857));
}};
    
    
      String newConfirmed = ""; 
      String newRecoverd = "";
      String newDeaths = ""; 
      String totalConfirmed = ""; 
      String totalRecoverd = "";
      String totalDeaths = "";
    
    public void loadData(){
     
      JSONArray jsonArray =null;
         
          try {
          
            String url = "https://api.covid19api.com/summary";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();
            
//            Extracting Global and Country wise status
              String result = response.toString();
              
              String [] strArray = result.split(",\"Countries");
              result = strArray[0].toString();
              String [] global = result.split("Global\":");
              String globalStatus = global[1];

              JSONObject jsonObject = new JSONObject(globalStatus.toString());
              newConfirmed = jsonObject.getInt("NewConfirmed") + "";
              newRecoverd = jsonObject.getInt("NewRecovered") + "";
              newDeaths = jsonObject.getInt("NewDeaths") + "";
              totalConfirmed = jsonObject.getInt("TotalConfirmed") + "";
              totalRecoverd = jsonObject.getInt("TotalRecovered") + "";
              totalDeaths = jsonObject.getInt("TotalDeaths") + "";
              
              JSONObject jsonObject2 = new JSONObject(response.toString());
              
              jsonArray = jsonObject2.getJSONArray("Countries");
              
              for (int i = 0; i <=jsonArray.length(); i++) {
                  
                  JSONObject tempJsonObject = jsonArray.getJSONObject(i);
                  
                  String country = tempJsonObject.getString("Country");
                  String countryCode = tempJsonObject.getString("CountryCode");
                  Integer confirmed = tempJsonObject.getInt("TotalConfirmed");
                  Integer recovered = tempJsonObject.getInt("TotalRecovered");
                  Integer deaths = tempJsonObject.getInt("TotalDeaths");
                  
                  CovidStatus cs = new CovidStatus();
                  cs.setCountry(country);
                  
                  if(COUNTRY_ISOS.containsKey(countryCode)){
                    LatLng latLng = COUNTRY_ISOS.get(countryCode);
                    cs.setLat(latLng.getLat());
                    cs.setLng(latLng.getLng());
                    
                  }else{
                    cs.setLat(0.0);
                    cs.setLng(0.0);
                  }
                  
                  cs.setConfirmed(confirmed);
                  cs.setRecovered(recovered);
                  cs.setDeaths(deaths);
                  
                  list.add(cs);
                  
              }
              
              
              
              
              
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    
    }
    
    @RequestMapping("/status")
    public String showHomePage(Model model) {
      
        loadData();
        
        model.addAttribute("covidStatus", list);
        model.addAttribute("newConfirmed", newConfirmed);
        model.addAttribute("newRecovered", newRecoverd);
        model.addAttribute("newDeaths", newDeaths);
        model.addAttribute("totalConfirmed", totalConfirmed);
        model.addAttribute("totalRecovered", totalRecoverd);
        model.addAttribute("totalDeaths", totalDeaths);
     
        return "index";
               
	}
    @RequestMapping("/")
    public String showMap(Model model){
        
        loadData();
       
        model.addAttribute("locations",list);
            
        return "map";
    
    }
    
}
