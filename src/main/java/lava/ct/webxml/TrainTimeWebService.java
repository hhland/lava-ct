package lava.ct.webxml;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import lava.ct.instance.SimpleDateFormatInstance;

import org.dom4j.Element;







public class TrainTimeWebService extends BaseWebXmlService {

	public static String REGEXP_TIME="HH:mm:ss";
	public static String REGEXP_TIME_SHORT="HH:mm";
	
	public TrainTimeWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public TrainTimeWebService(String url){
		this.serviceUrl=url;
	}
	
	public enum Endpoint{
		getDetailInfoByTrainCode,getStationAndTimeByStationName,getStationAndTimeByTrainCode
		,getStationAndTimeDataSetByLikeTrainCode,getStationAndTimeDataSetByTrainCode
		,getStationName,getStationNameDataSet,getVersionTime
	}
	
	public List<String> getStationName() throws Exception{
		List<String> stationNames=new ArrayList<String>();
		
		Document doc=this.doGetEndPoint(Endpoint.getStationName.name(), "");
		List<Node> nodes=doc.getRootElement().elements();
		for(Node node:nodes){
           stationNames.add(node.getText().trim());
		}
		return stationNames;
	}
	
	public List<TrainDetailInfo> getDetailInfoByTrainCode(String TrainCode,String UserID) throws Exception{
		List<TrainDetailInfo> trainDetailInfos=new ArrayList<TrainTimeWebService.TrainDetailInfo>();
		String param=MessageFormat.format("TrainCode={0}&UserID={1}",TrainCode,UserID);
		Document doc=this.doGetEndPoint(Endpoint.getDetailInfoByTrainCode.name(), param);
		Element el=(Element) doc.getRootElement().elements().get(1);
		el=el.element("getDetailInfo");
		List<Node> nodes=el.elements("TrainDetailInfo");
		for(Node node:nodes){
			TrainDetailInfo trainDetailInfo=this.new TrainDetailInfo();
			trainDetailInfo.TrainStation=node.selectSingleNode("TrainStation").getText().trim();
			trainDetailInfo.StartTime=SimpleDateFormatInstance.tryParse(node.selectSingleNode("StartTime").getText().trim());
			trainDetailInfo.ArriveTime=SimpleDateFormatInstance.tryParse(node.selectSingleNode("ArriveTime").getText().trim());
            trainDetailInfo.KM=Integer.parseInt(node.selectSingleNode("KM").getText().trim());
			trainDetailInfos.add(trainDetailInfo);
		}
		return trainDetailInfos;
	}
	
	public TrainTimeTable getStationAndTimeByTrainCode(String TrainCode,String UserID) throws Exception{
		TrainTimeTable train=this.new TrainTimeTable();
		String param=MessageFormat.format("TrainCode={0}&UserID={1}",TrainCode,UserID);
		Document doc=this.doGetEndPoint(Endpoint.getStationAndTimeByTrainCode.name(), param);
        List<Node> nodes=doc.getRootElement().elements();
        int index=0;
        train.TrainCode=nodes.get(index++).getText().trim();
        train.FirstStation=nodes.get(index++).getText().trim();
        train.LastStation=nodes.get(index++).getText().trim();
        train.StartStation=nodes.get(index++).getText().trim();
        train.StartTime=SimpleDateFormatInstance.tryParse(nodes.get(index++).getText().trim());
        train.ArriveStation=nodes.get(index++).getText().trim();
        train.ArriveTime=SimpleDateFormatInstance.tryParse(nodes.get(index++).getText().trim());
        train.KM=Integer.parseInt(nodes.get(index++).getText().trim());
        train.UseDate=SimpleDateFormatInstance.tryParse(nodes.get(index++).getText().trim());
        
        return train;
	}
	
	public List<TrainTimeTable> getStationAndTimeByStationName(String StartStation,String ArriveStation,String UserID ) throws Exception{
		String param=MessageFormat.format("StartStation={0}&ArriveStation={1}&UserID={2}",StartStation, ArriveStation,UserID);
		Document doc=this.doGetEndPoint(Endpoint.getStationAndTimeByStationName.name(), param);
        return parseTrainTimeDataSet(doc);
	}
	
	public TrainTimeTable getStationAndTimeDataSetByLikeTrainCode(String TrainCode,String UserID ) throws Exception{
		String param=MessageFormat.format("TrainCode={0}&UserID={1}",TrainCode,UserID);
		Document doc=this.doGetEndPoint(Endpoint.getStationAndTimeDataSetByLikeTrainCode.name(), param);
        return parseTrainTimeDataSet(doc).get(0);
	}
	
	public TrainTimeTable getStationAndTimeDataSetByTrainCode(String TrainCode,String UserID ) throws Exception{
		String param=MessageFormat.format("TrainCode={0}&UserID={1}",TrainCode,UserID);
		Document doc=this.doGetEndPoint(Endpoint.getStationAndTimeDataSetByTrainCode.name(), param);
        return parseTrainTimeDataSet(doc).get(0);
	}
	
	private List<TrainTimeTable> parseTrainTimeDataSet(Document doc) throws Exception{
		List<TrainTimeTable> trainTimes=new ArrayList<TrainTimeWebService.TrainTimeTable>();
		Element el=(Element) doc.getRootElement().elements().get(1);
		el=el.element("getStationAndTime");
		List<Node> nodes=el.elements("TimeTable");
		for(Node node :nodes){
			TrainTimeTable trainTime=this.new TrainTimeTable();
			trainTime.ArriveStation=node.selectSingleNode("ArriveStation").getText().trim();
		    trainTime.StartStation=node.selectSingleNode("StartStation").getText().trim();
			trainTime.FirstStation=node.selectSingleNode("FirstStation").getText().trim();
		    trainTime.LastStation=node.selectSingleNode("FirstStation").getText().trim();
		    //trainTime.ArriveTime=SimpleDateFormatInstance.tryParse(node.selectSingleNode("ArriveTime").getText().trim(), 	REGEXP_TIME);
		    //trainTime.StartTime=SimpleDateFormatInstance.tryParse(node.selectSingleNode("StartTime").getText().trim(), REGEXP_TIME);
            trainTime.KM=Float.parseFloat(node.selectSingleNode("KM").getText().trim());
		    trainTime.TrainCode=node.selectSingleNode("TrainCode").getText().trim();
		    //trainTime.UseDate=SimpleDateFormatInstance.tryParse(node.selectSingleNode("UseDate").getText().trim(), REGEXP_TIME_SHORT);
		    trainTimes.add(trainTime);
		}
		return trainTimes;
	}
	
	public List<Station> getStationNameDataSet() throws Exception{
		List<Station> stations=new ArrayList<TrainTimeWebService.Station>();
		Document doc=this.doGetEndPoint(Endpoint.getStationNameDataSet.name(), "");
		Element el=(Element) doc.getRootElement().elements().get(1);
		el=el.element("getStationNameDataSet");
		List<Node> nodes=el.elements("StationName");
		for(Node node:nodes){
			//if(!"StationName".equals(node.getName()))continue;
			String name= node.selectSingleNode("station_name").getText();
		    String shortcode=node.selectSingleNode("station_shortcode").getText();
		    stations.add(this.new Station(name, shortcode));
		}
		return stations;
	}
	
	public class Station{
		
		protected String name,shortcode;
		
		private Station(){}
		private Station(String name){
			this.name=name;
			this.shortcode="";
		}
		private Station(String name,String shortcode){
			this.name=name;
			this.shortcode=shortcode;
		}
		public String getName() {
			return name;
		}
		public String getShortcode() {
			return shortcode;
		}
		
	}
	
	public class TrainDetailInfo{
		private TrainDetailInfo(){}
		protected String TrainStation;
		protected Date ArriveTime,StartTime;
		protected float KM;
		public String getTrainStation() {
			return TrainStation;
		}
		public Date getArriveTime() {
			return ArriveTime;
		}
		public Date getStartTime() {
			return StartTime;
		}
		public float getKM() {
			return KM;
		}
		
	}
	
	public class TrainTimeTable extends TrainDetailInfo{
		private TrainTimeTable(){}
		protected String TrainCode,FirstStation,LastStation,ArriveStation,StartStation;
		protected Date UseDate;
		
		public String getTrainCode() {
			return TrainCode;
		}
		public String getFirstStation() {
			return FirstStation;
		}
		public String getLastStation() {
			return LastStation;
		}
		public String getArriveStation() {
			return ArriveStation;
		}
		public String getStartStation() {
			return StartStation;
		}
		
		public Date getUseDate() {
			return UseDate;
		}
		
		
		
	}
	
	

}
