package lava.ct.webxml;

import java.text.MessageFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import lava.ct.instance.SimpleDateFormatInstance;
import lava.rt.common.TextCommon;

import java.util.Calendar;



public class WeatherWebService extends BaseWebXmlService{

	public WeatherWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public WeatherWebService(String url){
		this.serviceUrl=url;
	}
	
	public enum Endpoint{
		getSupportCity,getSupportDataSet,getSupportProvince,getWeatherbyCityName,getWeatherbyCityNamePro    
	}
	
	public List<Area> getSupportCity(String byProvinceName) throws Exception{
		List<Area> areas=new ArrayList<WeatherWebService.Area>();
		String param=MessageFormat.format("byProvinceName={0}", byProvinceName);
		Document doc=this.doGetEndPoint(Endpoint.getSupportCity.name(), param);
		List<Node> nodes=doc.getRootElement().elements();
		for(Node node:nodes){
			Area area=this.new Area();
			String text=node.getText();
			area.AreaCode=Integer.parseInt(TextCommon.subString(text, "(", ")").get(0));
			area.Area=text.substring(0,text.indexOf("("));
			areas.add(area);
		}
		return areas;
		
	}
	
	public List<String> getSupportProvince()throws Exception{
		List<String> provinces=new ArrayList<String>();
		Document doc=this.doGetEndPoint(Endpoint.getSupportProvince.name(), "");
		List<Node> nodes=doc.getRootElement().elements();
		for(Node node:nodes){
			provinces.add(node.getText().trim());
		}
		return provinces;
	}
	
	public Weather getWeatherbyCityName(String theCityName)throws Exception{
		Weather weather=this.new Weather();
		String param=MessageFormat.format("theCityName={0}", theCityName);
		Document doc=this.doGetEndPoint(Endpoint.getWeatherbyCityName.name(), param);
		List<Node> nodes=doc.getRootElement().elements();
		int index=0;
		Node node=nodes.get(index++);
    	weather.provinceName=node.getText();
    	node=nodes.get(index++);
    	weather.cityName=node.getText().trim();
    	node=nodes.get(index++);
    	weather.cityCode=Integer.parseInt(node.getText());
     	node=nodes.get(index++);
    	weather.cityPic=node.getText();
    	node=nodes.get(index++);
    	weather.date=SimpleDateFormatInstance.tryParse(node.getText().trim());
    	//node=nodes.get(index++);
    	StringBuffer context=new StringBuffer("");
    	//String[] texts=node.getText().split("/");
        //weather.lowestTemperature=Float.parseFloat(texts[0].substring(0,texts[0].lastIndexOf("℃")));
        //weather.highestTemperature=Float.parseFloat(texts[1].substring(0,texts[1].lastIndexOf("℃")));
        int[] weatherIndexs={5,12,17};
    	for(int weaterIndex:weatherIndexs){
    		FutrueWeather futrueWeather=this.new FutrueWeather();
    		node=nodes.get(weaterIndex);
    	   	String[] texts=node.getText().split("/");
    	   	futrueWeather.lowestTemperature=Float.parseFloat(texts[0].substring(0,texts[0].lastIndexOf("℃")));
    	   	futrueWeather.highestTemperature=Float.parseFloat(texts[1].substring(0,texts[1].lastIndexOf("℃")));
    		node=nodes.get(weaterIndex+1);
    	   	texts=node.getText().split(" ");
    	   	int yyyy=Calendar.getInstance().get(Calendar.YEAR);
    	   	Date date=SimpleDateFormatInstance.tryParse(texts[0]);//,"MM月dd日");
    	   	//futrueWeather.date=Calendar.getInstance()..set(Calendar.YEAR, yyyy);
    	   	futrueWeather.weathContext=texts[1];
    	   	node=nodes.get(weaterIndex+2);
    	   	futrueWeather.windContext=node.getText();
    	   	node=nodes.get(weaterIndex+3);
    	   	futrueWeather.img0=node.getText();
    	   	node=nodes.get(weaterIndex+4);
    	   	futrueWeather.img1=node.getText();
    	   	weather.futrueWeathers.add(futrueWeather);
    		
    	}
    	node=nodes.get(22);
    	weather.citySummary=node.getText();
        
        return weather;
	}
	
	public class Weather{
    	private Weather(){
    		
    		futrueWeathers=new ArrayList<WeatherWebService.FutrueWeather>();
    	}
    	protected String provinceName,cityName,context,windDir,airQuality,cityPic,citySummary;
    	protected int windPower,cityCode;
    	protected Date date; 
    	protected float humidity;
    	protected List<FutrueWeather> futrueWeathers;
	}
	
    public class FutrueWeather{
    	private FutrueWeather(){}
    	protected Date date;
    	protected float highestTemperature,lowestTemperature;
    	protected String img0,img1,weathContext,windContext;
    	}
	
	public class Zone{
		private Zone(){}
		protected int ID;
		protected String Zone;
		public int getID() {
			return ID;
		}
		public String getZone() {
			return Zone;
		}
		
		
	}
	
	public class Area {
		private Area(){}
		protected int ID,ZoneID,AreaCode;
		protected String Area;
		public int getID() {
			return ID;
		}
		public int getZoneID() {
			return ZoneID;
		}
		public int getAreaCode() {
			return AreaCode;
		}
		public String getArea() {
			return Area;
		}
		
		
	}

	
	
	
}
