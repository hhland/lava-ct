package lava.ct.webxml;

import com.kull.datetime.DateFormatter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Node;





public class WeatherWS extends BaseWebXmlService {


	public static String PATTERN_IMG_URL_LARGE="http://www.webxml.com.cn/images/weather/a_{0}";
	public static String PATTERN_IMG_URL_MIDDLE="http://www.webxml.com.cn/images/weather/b_{0}";
	public static String PATTERN_IMG_URL_SMALL="http://www.webxml.com.cn/images/weather/{0}";
	
	public enum ImgSize{
		large,middle,small
	}
	
    public WeatherWS(){
    	this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
    }
   
    public WeatherWS(String url){
    	this.serviceUrl=url;
    }

    public enum Endpoint{
    	getRegionCountry,getRegionDataset,getRegionProvince,getSupportCityDataset,getSupportCityString,getWeather  
    }
   
    public Map<String,RegionCountry> getRegionCountry()throws Exception{
    	Map<String,RegionCountry> list=new HashMap<String,RegionCountry>();
    	Document doc=this.doGetEndPoint(Endpoint.getRegionCountry.name(),"");
    	List<Node> nodes= doc.getRootElement().elements();
    	for(Node node:nodes){
    		String[] texts=node.getText().trim().split(",");
    		String name=texts[0];
    		int code=Integer.parseInt(texts[1]);
    		list.put(String.valueOf(code),new RegionCountry(name,code));
    	}
    	return list;
    }
    
    public Map<String,RegionProvince> getRegionProvince()throws Exception{
    	Map<String,RegionProvince> list=new HashMap<String,RegionProvince>();
    	Document doc=this.doGetEndPoint(Endpoint.getRegionProvince.name(),"");
    	List<Node> nodes= doc.getRootElement().elements();
    	for(Node node:nodes){
    		String[] texts=node.getText().trim().split(",");
    		String name=texts[0];
    		int code=Integer.parseInt(texts[1]);
    		list.put(String.valueOf(code),new RegionProvince(name,code));
    	}
    	return list;
    }
    
    public Map<String,SupportCity> getSupportCityString(int id)throws Exception{
    	return getSupportCityString(String.valueOf(id));
    } 
    
    public Map<String,SupportCity> getSupportCityString(String name)throws Exception{
    	Map<String,SupportCity> list=new HashMap<String,SupportCity>();
    	String parma=MessageFormat.format("theRegionCode={0}", name);
    	Document doc=this.doGetEndPoint(Endpoint.getSupportCityString.name(),parma);
    	List<Node> nodes= doc.getRootElement().elements();
    	for(Node node:nodes){
    		String[] texts=node.getText().trim().split(",");
    		String rname=texts[0];
    		int code=Integer.parseInt(texts[1]);
    		list.put(String.valueOf(code),new SupportCity(rname,code));
    	}
    	return list;
    }
    
    public Weather getWeather(String theCityCode,String theUserID) throws Exception{
    	Weather weather=this.new Weather();
    	String parma=MessageFormat.format("theCityCode={0}&theUserID={1}", theCityCode,theUserID);
    	Document doc=this.doGetEndPoint(Endpoint.getWeather.name(),parma);
    	List<Node> nodes= doc.getRootElement().elements();
    	int index=0;
    	Node node=nodes.get(index++);
    	weather.provinceName=node.getText().trim().split(" ")[0];
    	node=nodes.get(index++);
    	weather.cityName=node.getText().trim();
    	node=nodes.get(index++);
    	weather.cityId=Integer.valueOf(node.getText().trim());
    	node=nodes.get(index++);
    	weather.date=DateFormatter.parsez(node.getText().trim());
    	node=nodes.get(index++);
    	StringBuffer context=new StringBuffer("");
    	String[] texts=node.getText().substring(node.getText().indexOf('：')).split("；");
    	context.append(node.getText().trim());
    	weather.temperature=Integer.parseInt(texts[0].split("：")[2].substring(0,texts[0].split("：")[2].lastIndexOf("℃")));
    	weather.windDir=texts[1].split("：")[1].split(" ")[0];
    	weather.windPower=Integer.parseInt(texts[1].split("：")[1].split(" ")[1].substring(0, texts[1].split("：")[1].split(" ")[1].lastIndexOf("级")));
    	weather.humidity=Integer.parseInt(texts[2].split("：")[1].substring(0,texts[2].split("：")[1].lastIndexOf("%")));
    	node=nodes.get(index++);
    	context.append(node.getText().trim());
    	node=nodes.get(index++);
    	context.append(node.getText().trim());
    	weather.context=context.toString();
    	for(int i=0;i<5;i++){
    		FutrueWeather futrueWeather=this.new FutrueWeather();
    		node=nodes.get(index++);
    		Calendar calendar=Calendar.getInstance();
    		calendar.add(Calendar.DATE, i+1);
    		futrueWeather.date=calendar.getTime();
    		futrueWeather.weathContext=node.getText().trim().split(" ")[1];
    		node=nodes.get(index++);
    	    texts=node.getText().trim().split("/");
    		futrueWeather.minTemperature=Integer.parseInt(texts[0].substring(0, texts[0].lastIndexOf("℃")));
    		futrueWeather.maxTemperature=Integer.parseInt(texts[1].substring(0, texts[1].lastIndexOf("℃")));
    		node=nodes.get(index++);
    		futrueWeather.windContext=node.getText().trim();
    		node=nodes.get(index++);
    		futrueWeather.img0=node.getText().trim();
    		node=nodes.get(index++);
    		futrueWeather.img1=node.getText().trim();
    		weather.futrueWeathers.add(futrueWeather);
    	}
    	return weather;
    }
    
    public abstract class Region{
     	private Region(String name,int id){
    		this.name=name;
    		this.id=id;
    	}
    	
    	protected String name;
    	protected int id;
		public String getName() {
			return name;
		}
		public int getId() {
			return id;
		}
    }
    
    public class RegionCountry extends Region{

		private RegionCountry(String name, int id) {
			super(name, id);
			// TODO Auto-generated constructor stub
		}
    	public Map<String,RegionProvince> regionProvinces=new HashMap<String,WeatherWS.RegionProvince>();
    }
    
    public class RegionProvince extends Region{

		private RegionProvince(String name, int id) {
			super(name, id);
			// TODO Auto-generated constructor stub
		}
    	public Map<String,SupportCity> supportCities=new HashMap<String,WeatherWS.SupportCity>();
    }
    
    public class SupportCity extends Region{

		private SupportCity(String name, int id) {
			super(name, id);
			// TODO Auto-generated constructor stub
		}
     
    }
    
    public class Weather{
    	
    	private Weather(){}
    	protected String provinceName,cityName,context,windDir,airQuality;
    	protected int cityId,windPower;
    	protected Date date; 
    	protected float temperature,humidity;
    	
   
    	private List<FutrueWeather> futrueWeathers=new ArrayList<WeatherWS.FutrueWeather>();


		public String getProvinceName() {
			return provinceName;
		}


		public String getCityName() {
			return cityName;
		}


		public String getContext() {
			return context;
		}


		public String getWindDir() {
			return windDir;
		}


		public String getAirQuality() {
			return airQuality;
		}


		public int getCityId() {
			return cityId;
		}


		public int getWindPower() {
			return windPower;
		}


		public Date getDate() {
			return date;
		}


		public float getTemperature() {
			return temperature;
		}


		public float getHumidity() {
			return humidity;
		}


		public List<FutrueWeather> getFutrueWeathers() {
			return futrueWeathers;
		}

		

    	
    }
    
    public class FutrueWeather{
    	private FutrueWeather(){}
    	protected Date date;
    	protected float minTemperature,maxTemperature;
    	protected String img0,img1,weathContext,windContext;
		
		
    	
		public Date getDate() {
			return date;
		}

		public float getMinTemperature() {
			return minTemperature;
		}

		public float getMaxTemperature() {
			return maxTemperature;
		}

		public String getImg0() {
			return img0;
		}

		public String getImg1() {
			return img1;
		}

		public String getWeathContext() {
			return weathContext;
		}

		public String getWindContext() {
			return windContext;
		}

		public String getImg0Url(ImgSize imgSize) {
			String url="";
			switch (imgSize) {
			case large:{url=MessageFormat.format(PATTERN_IMG_URL_LARGE, this.img0);break;}
			case middle:{url=MessageFormat.format(PATTERN_IMG_URL_MIDDLE, this.img0);break;}
			case small:{url=MessageFormat.format(PATTERN_IMG_URL_SMALL, this.img0);break;}
			default:{break;}
			}
			
			return url;
		}
		
		public String getImg1Url(ImgSize imgSize) {
			String url="";
			switch (imgSize) {
			case large:{url=MessageFormat.format(PATTERN_IMG_URL_LARGE, this.img1);break;}
			case middle:{url=MessageFormat.format(PATTERN_IMG_URL_MIDDLE, this.img1);break;}
			case small:{url=MessageFormat.format(PATTERN_IMG_URL_SMALL, this.img1);break;}
			default:{break;}
			}
			
			return url;
		}
		
	
    }
    
    
    
}
