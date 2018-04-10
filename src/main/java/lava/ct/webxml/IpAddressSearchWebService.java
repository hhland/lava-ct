package lava.ct.webxml;

import java.text.MessageFormat;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;






public class IpAddressSearchWebService extends BaseWebXmlService {

	
	public IpAddressSearchWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public enum Endpoint{
		getCountryCityByIp
	}
	
	public IpGeo thisIpGeo() throws Exception{
		return null;//getCountryCityByIp(Machinez.DNSOnWindows());
	}
	
	public IpGeo getCountryCityByIp(String theIpAddress) throws Exception{
		String param=MessageFormat.format("theIpAddress={0}", theIpAddress);
		Document doc=this.doGetEndPoint(Endpoint.getCountryCityByIp.name(), param);
		List<Node> nodes=doc.getRootElement().elements();
		IpGeo ipGeo=this.new IpGeo();
		ipGeo.ip=nodes.get(0).getText();
		ipGeo.geo=nodes.get(1).getText();
		return ipGeo;
	}
	
	public class IpGeo{
		protected String ip,geo;

		public String getIp() {
			return ip;
		}

		public String getGeo() {
			return geo;
		}
		
	}
	
	 

	
	

}
