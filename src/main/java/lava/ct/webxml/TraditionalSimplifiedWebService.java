package lava.ct.webxml;

import java.text.MessageFormat;

import org.dom4j.Document;
import org.dom4j.Node;



public class TraditionalSimplifiedWebService extends BaseWebXmlService {

	public TraditionalSimplifiedWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public TraditionalSimplifiedWebService(String url){
		this.serviceUrl=url;
	}
	
	public enum Endpoint{
		toSimplifiedChinese,toTraditionalChinese
	}
	
	public Chinese toSimplifiedChinese(String sText) throws Exception{
		String val="";
		String parma=MessageFormat.format("sText={0}", sText);
		Document doc=doGetEndPoint(Endpoint.toSimplifiedChinese.name(), parma);
		Node node=doc.selectSingleNode(XMLTag.string.name());
		val=node.getText().trim();
		return new Chinese(val, sText);
	}
	
	public Chinese toTraditionalChinese(String sText) throws Exception{
		String val="";
		String parma=MessageFormat.format("sText={0}", sText);
		Document doc=doGetEndPoint(Endpoint.toTraditionalChinese.name(), parma);
		Node node=doc.selectSingleNode(XMLTag.string.name());
		val=node.getText().trim();
		return new Chinese(sText,val);
	}
	
	
	public class Chinese{
		private Chinese(String simplified,String traditional){
			this.simplified=simplified;
			this.traditional=traditional;
		}
		protected String simplified , traditional;
		public String getSimplified() {
			return simplified;
		}
		public String getTraditional() {
			return traditional;
		}
		
		
	}
	
	

}
