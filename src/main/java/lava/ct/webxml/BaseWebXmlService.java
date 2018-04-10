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

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;




import com.kull.Netz;






public abstract  class BaseWebXmlService {

	public BaseWebXmlService(){}
	
	public BaseWebXmlService(String url){
		this.serviceUrl=url;
	}
	
	public enum XMLTag{
		string,unsignedByte
	}
	
	protected static String SERVICES_HOST = "www.webxml.com.cn";
	protected static String SERVICES_BASE_URL = "http://webservice.webxml.com.cn/WebServices";
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
        String url=MessageFormat.format("{0}/{1}?{2}",
          this.serviceUrl
          ,endpiont
          ,param
         );
         System.err.println(url);
		 HttpGet get=new HttpGet(url);
		 String context=Netz.getString(url);
		 try{
		 doc= DocumentHelper.parseText(context);
		 }catch(Exception ex){
			 throw new Exception(context);
		 }
         return doc;
	}
	
	protected  Document doPostEndPoint(String endpiont,Map<String, String> paramMap) throws Exception{
        Document doc=null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        String url=MessageFormat.format("{0}/{1}",
          this.serviceUrl
          ,endpiont
         );
		 //HttpGet get=new HttpGet(url);
		 HttpPost post=new HttpPost(url);
		 HttpParams params=new BasicHttpParams();
		 for(Iterator<String> it=paramMap.keySet().iterator();it.hasNext();){
			 String key=it.next();
			 params.setParameter(key, paramMap.get(key));
		 }
		
		 post.setParams(params);
		 String context=Netz.doPost(post).getMsg();
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
