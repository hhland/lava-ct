package lava.ct.webxml;


import java.text.MessageFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;

import org.dom4j.Node;

import lava.ct.instance.SimpleDateFormatInstance;





public class DomesticAirline extends BaseWebXmlService {

	public static String REGEXP_TIME="HH:mm:ss";
	public static String REGEXP_TIME_SHORT="HH:mm";
	
	public DomesticAirline(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public enum Endpoint{
		getDomesticCity,getDomesticAirlinesTime
	}

	public List<AirlinesTime> getDomesticAirlinesTime(String startCity,String lastCity,Date theDate,String userID) throws Exception{
		theDate=theDate==null?new Date():theDate;
		List<AirlinesTime> airlinesTimes=new ArrayList<DomesticAirline.AirlinesTime>();
		String parma=MessageFormat.format("startCity={0}&lastCity={1}&theDate={2}&userID={3}", startCity,lastCity,SimpleDateFormatInstance.YMD.getSimpleDateFormat().format(theDate),userID);
		Document doc=this.doGetEndPoint(Endpoint.getDomesticAirlinesTime.name(),parma);
		//Element el=(Element) doc.getRootElement().elements().get(1);
		//List<Node> nodes=el.element("Airlines").elements(AirlinesTime.class.getSimpleName());
		List<Node> nodes=this.parseDataSets(doc, "Airlines", AirlinesTime.class.getSimpleName());
		for(Node node:nodes){
			AirlinesTime airlinesTime=this.new AirlinesTime();
			airlinesTime.Company=node.selectSingleNode("Company").getText().trim();
			airlinesTime.AirlineCode=node.selectSingleNode("AirlineCode").getText().trim();
			airlinesTime.AirlineStop=Integer.parseInt(node.selectSingleNode("AirlineStop").getText().trim());
			airlinesTime.ArriveDrome=node.selectSingleNode("ArriveDrome").getText().trim();
			//airlinesTime.ArriveTime=SimpleDateFormatInstance.tryParse(node.selectSingleNode("ArriveTime").getText().trim(),REGEXP_TIME_SHORT);
			airlinesTime.Mode=node.selectSingleNode("Mode").getText().trim();
			airlinesTime.StartDrome=node.selectSingleNode("StartDrome").getText().trim();
			//airlinesTime.StartTime=SimpleDateFormatInstance.tryParse(node.selectSingleNode("StartTime").getText().trim(),REGEXP_TIME_SHORT);
            airlinesTime.Week=node.selectSingleNode("Week").getText().trim();
			airlinesTimes.add(airlinesTime);
		}
		return airlinesTimes;
	}
	
	public List<Address> getDomesticCity() throws Exception{
		List<Address> addresses=new ArrayList<DomesticAirline.Address>();
		Document doc=this.doGetEndPoint(Endpoint.getDomesticCity.name(), "");
		//Element el=(Element) doc.getRootElement().elements().get(1);
		//List<Node> nodes=el.element("Airline1").elements(Address.class.getSimpleName());
		List<Node> nodes=this.parseDataSets(doc, "Airline1", Address.class.getSimpleName());
		for(Node node:nodes){
			Address address=this.new Address();
			address.enCityName=node.selectSingleNode("enCityName").getText().trim();
			address.cnCityName=node.selectSingleNode("cnCityName").getText().trim();
			address.Abbreviation=node.selectSingleNode("Abbreviation").getText().trim();
			addresses.add(address);
		}
		return addresses;
	}
	
	public class Address{
		private Address(){}
		protected String enCityName,cnCityName,Abbreviation;

		public String getEnCityName() {
			return enCityName;
		}

		public String getCnCityName() {
			return cnCityName;
		}

		public String getAbbreviation() {
			return Abbreviation;
		}
		
	}
	
	public class AirlinesTime{
		private AirlinesTime(){}
		protected String Company,AirlineCode,StartDrome,ArriveDrome,Mode,Week;
		protected Date StartTime,ArriveTime;
		protected int AirlineStop;
		public String getCompany() {
			return Company;
		}
		public String getAirlineCode() {
			return AirlineCode;
		}
		public String getStartDrome() {
			return StartDrome;
		}
		public String getArriveDrome() {
			return ArriveDrome;
		}
		public String getMode() {
			return Mode;
		}
		public String getWeek() {
			return Week;
		}
		public Date getStartTime() {
			return StartTime;
		}
		public Date getArriveTime() {
			return ArriveTime;
		}
		public int getAirlineStop() {
			return AirlineStop;
		}
		
		
	}
	

}
