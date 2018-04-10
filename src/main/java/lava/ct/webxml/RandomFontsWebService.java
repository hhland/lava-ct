package lava.ct.webxml;

import java.text.MessageFormat;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;



public class RandomFontsWebService extends BaseWebXmlService {

	public RandomFontsWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public RandomFontsWebService(String url){
		this.serviceUrl=url;
	}
	
	public enum EndPoint{
		getCharFonts,getChineseFonts
	}
	
	public String getCharFonts(int byFontsLength) throws Exception{
		StringBuffer val=new StringBuffer("");
		String parma=MessageFormat.format("byFontsLength={0}",String.valueOf(byFontsLength));
	   	Document doc=this.doGetEndPoint(EndPoint.getCharFonts.name(),parma);
    	List<Node> nodes= doc.getRootElement().elements();
    	for(Node node:nodes){
           val.append(node.getText().trim());
    	}
    	return val.toString();
	}
	
	public String getChineseFonts(int byFontsLength)throws Exception{
		StringBuffer val=new StringBuffer("");
		String parma=MessageFormat.format("byFontsLength={0}",String.valueOf(byFontsLength));
	   	Document doc=this.doGetEndPoint(EndPoint.getChineseFonts.name(),parma);
    	List<Node> nodes= doc.getRootElement().elements();
    	for(Node node:nodes){
           val.append(node.getText().trim());
    	}
    	return val.toString();
	}
	
	
}
