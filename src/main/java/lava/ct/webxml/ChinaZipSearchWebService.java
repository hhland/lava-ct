package lava.ct.webxml;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Node;





public class ChinaZipSearchWebService extends BaseWebXmlService {

	public ChinaZipSearchWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;

	}
	
	public enum Endpoint{
		getAddressByZipCode,getSupportCity,getSupportProvince,getSupportProvinceCity
		,getZipCodeByAddress
	}
	
	public List<AddressZipInfo> getAddressByZipCode (String theZipCode,String userID)throws Exception{
		String param=MessageFormat.format("theZipCode={0}&userID={1}",theZipCode,userID);
		Document doc=this.doGetEndPoint(Endpoint.getAddressByZipCode.name(), param);
	    List<Node> nodes=this.parseDataSets(doc, "NewDataSet", "ZipInfo");
	    List<AddressZipInfo> addressZipInfos=new ArrayList<ChinaZipSearchWebService.AddressZipInfo>();
	    for(Node node:nodes){
	    	AddressZipInfo addressZipInfo=this.new AddressZipInfo();
	    	addressZipInfo.ADDRESS=node.selectSingleNode("ADDRESS").getText().trim();
	    	addressZipInfo.CITY=node.selectSingleNode("CITY").getText().trim();
	    	addressZipInfo.PROVINCE=node.selectSingleNode("PROVINCE").getText().trim();
	    	addressZipInfo.ZIP=node.selectSingleNode("ZIP").getText().trim();
	    	addressZipInfos.add(addressZipInfo);
	    }
	    return addressZipInfos;
	}
	
	public List<AddressZipInfo> getZipCodeByAddress (String theProvinceName,String theCityName,String theAddress,String userID)throws Exception{
		String param=MessageFormat.format("theProvinceName={0}&theCityName={1}&theAddress={2}&userID={3}"
				,theProvinceName,theCityName,theAddress,userID);
		Map<String ,String> paramMap=new HashMap<String, String>();
		paramMap.put("theProvinceName", theProvinceName);
		paramMap.put("theCityName", theCityName);
		paramMap.put("theAddress",theAddress );
		paramMap.put("userID",userID);
		Document doc=this.doGetEndPoint(Endpoint.getZipCodeByAddress.name(), param);
	    List<Node> nodes=this.parseDataSets(doc, "NewDataSet", "ZipInfo");
	    List<AddressZipInfo> addressZipInfos=new ArrayList<ChinaZipSearchWebService.AddressZipInfo>();
	    for(Node node:nodes){
	    	AddressZipInfo addressZipInfo=this.new AddressZipInfo();
	    	addressZipInfo.ADDRESS=node.selectSingleNode("ADDRESS").getText().trim();
	    	addressZipInfo.CITY=node.selectSingleNode("CITY").getText().trim();
	    	addressZipInfo.PROVINCE=node.selectSingleNode("PROVINCE").getText().trim();
	    	addressZipInfo.ZIP=node.selectSingleNode("ZIP").getText().trim();
	    	addressZipInfos.add(addressZipInfo);
	    }
	    return addressZipInfos;
	}
	
	public List<String> getSupportProvince ()throws Exception{
	    List<String> privinces=new ArrayList<String>();
		Document doc=this.doGetEndPoint(Endpoint.getSupportProvince.name(), "");
	    List<Node> nodes=doc.getRootElement().elements();
	    for(Node node:nodes){
	    	privinces.add(node.getText().trim());
	    }
		return privinces;
	}
	
	public List<City> getSupportProvinceCity() throws Exception{
		Document doc=this.doGetEndPoint(Endpoint.getSupportProvinceCity.name(), "");
		List<Node> nodes=this.parseDataSets(doc, "NewDataSet", City.class.getSimpleName());
		List<City> cities=new ArrayList<ChinaZipSearchWebService.City>();
		for(Node node :nodes){
			City city=this.new City();
			city.CITY= node.selectSingleNode("CITY").getText().trim();
			city.PROVINCE=node.selectSingleNode("PROVINCE").getText().trim();
		cities.add(city);	
		}
		return cities;
	}
	
	public List<City> getSupportCity(String byProvinceName) throws Exception{
		String param=MessageFormat.format("byProvinceName={0}", byProvinceName);
		Document doc=this.doGetEndPoint(Endpoint.getSupportCity.name(), param);
		List<Node> nodes=doc.getRootElement().elements();
		List<City> cities=new ArrayList<ChinaZipSearchWebService.City>();
		for(Node node :nodes){
			City city=this.new City();
			String[] texts=node.getText().split(" ");
			city.PROVINCE= texts[1].substring(texts[1].indexOf("（")+1,texts[1].indexOf("）"));
			city.CITY=texts[0];
		cities.add(city);	
		}
		return cities;
	}
	
	public class City{
		private City(){}
		protected String CITY,PROVINCE;

		public String getCITY() {
			return CITY;
		}

		public String getPROVINCE() {
			return PROVINCE;
		}
		
	}
	
	public class AddressZipInfo extends City{

		private AddressZipInfo(){}
		protected String ADDRESS,ZIP;

		public String getADDRESS() {
			return ADDRESS;
		}

		public String getZIP() {
			return ZIP;
		}
	 
	}
	

}
