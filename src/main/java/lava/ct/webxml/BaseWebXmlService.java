package lava.ct.webxml;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilderFactory;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;




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
		 
		 String context=get(url+"?"+param);
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
		 
		 
		 String context=post(url,paramMap);
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
    
    
    
    private static String toQueryString( Map<String, Object> paramMap) {
		
		 String ret="";
		
		for(Entry<String, Object> _param:paramMap.entrySet()) {
	    	  String key=_param.getKey();
	    	  Object valueObj=_param.getValue();
	    	  String value=valueObj==null?"":valueObj.toString();
	    	  ret+=key+"="+value+"&";
	      }
		return ret;
	}
	
	private static String get(String url) throws Exception{
	    String result = "";
	    BufferedReader in = null;
	    
	      String urlNameString = url ;
	      URL realUrl = new URL(urlNameString);
	      
	      URLConnection connection = realUrl.openConnection();
	  
	      connection.setRequestProperty("accept", "*/*");
	      connection.setRequestProperty("connection", "Keep-Alive");
	      connection.setRequestProperty("user-agent",
	          "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	      
	      connection.connect();
	      in = new BufferedReader(new InputStreamReader(
	          connection.getInputStream()));
	      String line;
	      while ((line = in.readLine()) != null) {
	        result += line; 
	      }
	      
	      return result;
	  }
	 
	 
	  private static String post(String url, Map<String, Object> paramMap)throws Exception {
		
	    PrintWriter out = null;
	    BufferedReader in = null;
	    String result = "";
	    
	      URL realUrl = new URL(url);
	    
	      URLConnection conn = realUrl.openConnection();
	     
	      conn.setRequestProperty("accept", "*/*");
	      conn.setRequestProperty("connection", "Keep-Alive");
	      conn.setRequestProperty("user-agent",
	          "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	      
	      conn.setDoOutput(true);
	      conn.setDoInput(true);
	     
	      out = new PrintWriter(conn.getOutputStream());
	      
	      String param=toQueryString(paramMap);
	      out.print(param);
	      out.flush();
	     
	      in = new BufferedReader(
	          new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = in.readLine()) != null) {
	        result += line;
	      }
	      
	    return result;
	  }  
	  
	  
	  protected static List<String> subString(String value, String start, String end) {
		   	// TODO Auto-generated method stub
		       List<String> vals = new ArrayList<String>();
		        String tempValue = value;
		        while (tempValue.contains(start) && tempValue.contains(end)) {
		            int startIndex = tempValue.indexOf(start);
		            int endIndex = tempValue.indexOf(end);
		            vals.add(tempValue.substring(startIndex + 1, endIndex));
		            tempValue = tempValue.substring(endIndex + 1);
		        }
		        return vals;
		    
		}
}
