package lava.ct.webxml;



import lava.ct.instance.SimpleDateFormatInstance;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;






public class ChinaTVprogramWebService extends BaseWebXmlService {


	public ChinaTVprogramWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public enum Endpoint{
		getAreaDataSet,getAreaString,getTVstationString,getTVstationDataSet
		,getTVchannelDataSet,getTVchannelString,getTVprogramDateSet,getTVprogramString
	}
	
	public List<Area> getAreaString()throws Exception{
		List<Area> areas=new ArrayList<Area>();
		Document doc=this.doGetEndPoint(Endpoint.getAreaString.name(), "");
		List<Node> nodes=doc.getRootElement().elements();
		for(Node node :nodes){
			Area area=this.new Area();
			String[] texts=node.getText().split("@");
			area.areaID=Integer.parseInt(texts[0]);
			area.Area=texts[1];
			area.Zone=texts[2];
			areas.add(area);
		}
		return areas;
	}
	
	public List<Area> getAreaDataSet()throws Exception{
		List<Area> areas=new ArrayList<Area>();
		Document doc=this.doGetEndPoint(Endpoint.getAreaDataSet.name(), "");
		List<Node> nodes=this.parseDataSets(doc, "Area", "AreaList");
		for(Node node :nodes){
			Area area=this.new Area();
			area.areaID=Integer.parseInt(node.selectSingleNode("areaID").getText());
			area.Area=node.selectSingleNode("Area").getText();
			area.Zone=node.selectSingleNode("Zone").getText();
			areas.add(area);
		}
		return areas;
	}
	
	public List<TvStation> getTVstationString(int theAreaID)throws Exception{
		List<TvStation> tvStations=new ArrayList<TvStation>();
		String param=MessageFormat.format("theAreaID={0}", String.valueOf(theAreaID));
		Document doc=this.doGetEndPoint(Endpoint.getTVstationString.name(), param);
		List<Node> nodes=doc.getRootElement().elements();
		for(Node node:nodes){
			TvStation tvStation=this.new TvStation();
			String[] texts=node.getText().split("@");
			tvStation.tvStationID=Integer.parseInt(texts[0]);
			tvStation.tvStationName=texts[1];
			tvStation.areaID=theAreaID;
			tvStations.add(tvStation);
		}
		return tvStations;
	}
	
	public List<TvStation> getTVstationDataSet(int theAreaID)throws Exception{
		List<TvStation> tvStations=new ArrayList<TvStation>();
		String param=MessageFormat.format("theAreaID={0}", String.valueOf(theAreaID));
		Document doc=this.doGetEndPoint(Endpoint.getTVstationDataSet.name(), param);
		List<Node> nodes=this.parseDataSets(doc, "Station", "TvStation");
		for(Node node:nodes){
			TvStation tvStation=this.new TvStation();
			tvStation.tvStationID=Integer.parseInt(node.selectSingleNode("tvStationID").getText());
			tvStation.tvStationName=node.selectSingleNode("tvStationName").getText();
			tvStation.areaID=theAreaID;
			tvStation.areaID=theAreaID;
			tvStations.add(tvStation);
		}
		return tvStations;
	}
	
	public List<TvChanne> getTVchannelString(int theTVstationID)throws Exception{
		List<TvChanne> tvChannes=new ArrayList<ChinaTVprogramWebService.TvChanne>();
		String param=MessageFormat.format("theTVstationID={0}", String.valueOf(theTVstationID));
	    Document doc=this.doGetEndPoint(Endpoint.getTVchannelString.name(), param);
	    List<Node> nodes=doc.getRootElement().elements();
	    for(Node node:nodes){
	    	TvChanne tvChanne=this.new TvChanne();
	    	String[] texts=node.getText().split("@");
	    	tvChanne.tvChannelID=Integer.parseInt(texts[0]);
	    	tvChanne.tvChannel=texts[1];
	    	tvChanne.tvStationID=theTVstationID;
	    	tvChannes.add(tvChanne);
	    }
	    return tvChannes;
	}
	
	public List<TvChanne> getTVchannelDataSet(int theTVstationID)throws Exception{
		List<TvChanne> tvChannes=new ArrayList<ChinaTVprogramWebService.TvChanne>();
		String param=MessageFormat.format("theTVstationID={0}", String.valueOf(theTVstationID));
	    Document doc=this.doGetEndPoint(Endpoint.getTVchannelDataSet.name(), param);
	    List<Node> nodes=this.parseDataSets(doc, "Channe", "TvChanne");
	    for(Node node:nodes){
	    	TvChanne tvChanne=this.new TvChanne();
	    	tvChanne.tvChannelID=Integer.parseInt(node.selectSingleNode("tvChannelID").getText());
	    	tvChanne.tvChannel=node.selectSingleNode("tvChannel").getText();
	    	tvChanne.tvStationID=theTVstationID;
	    	tvChannes.add(tvChanne);
	    }
	    return tvChannes;
	}
	
	public List<TvProgram> getTVprogramString(int theTVchannelID,Date theDate,String userID)throws Exception{
		List<TvProgram> programs=new ArrayList<ChinaTVprogramWebService.TvProgram>();
		String param=MessageFormat.format("theTVchannelID={0}&theDate={1}&userID={2}"
				,String.valueOf(theTVchannelID),SimpleDateFormatInstance.YMD.getSimpleDateFormat().format(theDate),userID);
	    Document doc=this.doGetEndPoint(Endpoint.getTVprogramString.name(), param);
	    List<Node> nodes=doc.getRootElement().elements();
	    for(Node node:nodes){
	    	TvProgram tvProgram=this.new TvProgram();
	        String[] texts=node.getText().split("@@@");
	        Calendar calendar=Calendar.getInstance();
            calendar.setTime(theDate);
            String[] time=texts[0].substring(0,texts[0].lastIndexOf("(")).split(":");
            int HH=Integer.parseInt(time[0]);
            int mm=Integer.parseInt(time[1]);
            calendar.set(Calendar.HOUR, HH);
            calendar.set(calendar.MINUTE,mm);
            tvProgram.playTime=calendar.getTime();
            tvProgram.meridiem=texts[0].substring(texts[0].indexOf("(")+1,texts[0].lastIndexOf(")"));
	        tvProgram.tvProgram=texts[1];
	        String[] infos=texts[2].split(" | ");
	        tvProgram.Area=infos[0];
	        tvProgram.tvStationName=infos[2];
	        tvProgram.tvChannel=infos[4];
	        tvProgram.tvChannelID=theTVchannelID;
            programs.add(tvProgram);
	    }
	    return programs;
	}
	
	public List<TvProgram> getTVprogramDateSet(int theTVchannelID,Date theDate,String userID)throws Exception{
		List<TvProgram> programs=new ArrayList<ChinaTVprogramWebService.TvProgram>();
		String param=MessageFormat.format("theTVchannelID={0}&theDate={1}&userID={2}"
				,String.valueOf(theTVchannelID),SimpleDateFormatInstance.YMD.getSimpleDateFormat().format(theDate),userID);
	    Document doc=this.doGetEndPoint(Endpoint.getTVprogramDateSet.name(), param);
	    List<Node> nodes=this.parseDataSets(doc, "TV", "tvProgramTable");
	    for(Node node:nodes){
	    	TvProgram tvProgram=this.new TvProgram();
	        
	        Calendar calendar=Calendar.getInstance();
            calendar.setTime(theDate);
            String[] time=node.selectSingleNode("playTime").getText().split(":");
             int HH=Integer.parseInt(time[0]);
            int mm=Integer.parseInt(time[1]);
            calendar.set(Calendar.HOUR, HH);
            calendar.set(calendar.MINUTE,mm);
            tvProgram.playTime=calendar.getTime();
            tvProgram.meridiem=node.selectSingleNode("meridiem").getText();
            tvProgram.tvProgram=node.selectSingleNode("tvProgram").getText();
	        String[] infos=node.selectSingleNode("tvStationInfo").getText().split(" | ");
	        tvProgram.Area=infos[0];
	        tvProgram.tvStationName=infos[2];
	        tvProgram.tvChannel=infos[4];
	        tvProgram.tvChannelID=theTVchannelID;
	        programs.add(tvProgram);
	    }
	    return programs;
	}
	
	public class Area{
		private Area(){}
		protected int areaID;
		protected String Area,Zone;
		public int getAreaID() {
			return areaID;
		}
		public String getArea() {
			return Area;
		}
		public String getZone() {
			return Zone;
		}
		
	}
	
	public class TvStation extends Area{
		private TvStation(){}
		protected int tvStationID;
		protected String tvStationName;
		
	}
	
	public class TvChanne extends TvStation{
        private TvChanne(){}
		protected int tvChannelID;
		protected String tvChannel;
	}
	
	public class TvProgram extends TvChanne{
		private TvProgram(){}
		protected Date playTime;
		protected String meridiem,tvProgram;
	}
	
	
	

}
