package lava.ct.webxml;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;




import lava.rt.common.IOCommon;






public abstract  class BaseWebXmlService {

	public BaseWebXmlService(){}
	
	public BaseWebXmlService(String url){
		this.serviceUrl=url;
	}
	
	public enum XMLTag{
		string,unsignedByte
	}
	
	protected static String SERVICES_HOST = "www.webxml.com.cn";
	protected static String SERVICES_BASE_URL = "http://ws.webxml.com.cn/WebServices";
	protected static String SERVICES_SUBFIX=".asmx";
	
	protected String serviceUrl="";
	
	protected List<Node> parseDataSets(Document document,String topTag,String subTag){
		Element el=(Element) document.getRootElement().elements().get(1);
		List<Node> nodes=el.element(topTag).elements(subTag);
		return nodes;
	}
	
	protected byte[] paseBase64(Document document){
		String str=document.getRootElement().getTextTrim();
                return null;
		//return BASE64DecoderStream.decode(str.getBytes());
	}
	
	protected  Document doGetEndPoint(String endpiont,String param) throws Exception{
        Document doc=null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        String url=this.serviceUrl+"/"+endpiont;
        
         System.err.println(url);
		 
		 String context=IOCommon.get(url,param);
		 try{
		 doc= DocumentHelper.parseText(context);
		 }catch(Exception ex){
			 throw new Exception(context);
		 }
         return doc;
	}
	
	protected  Document doPostEndPoint(String endpiont,Map<String, Object> paramMap) throws Exception{
        Document doc=null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        String url=MessageFormat.format("{0}/{1}",
          this.serviceUrl
          ,endpiont
         );
		 
		 
		 String context=IOCommon.post(url,paramMap);
		 try{
		 doc= DocumentHelper.parseText(context);
		 }catch(Exception ex){
			 throw new Exception(context);
		 }
         return doc;
	}
	

	
    protected  InputStream getSoapInputStream(String url)
    {
        InputStream is = null;

        try {
			URL U = new URL(url);
			URLConnection conn = U.openConnection();
			conn.setRequestProperty("Host", SERVICES_HOST);
			conn.connect();
			is = conn.getInputStream();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        return is;
    }
}
