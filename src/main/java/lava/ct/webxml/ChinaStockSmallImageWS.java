package lava.ct.webxml;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;

import org.dom4j.Document;



public class ChinaStockSmallImageWS extends BaseWebXmlService {

	public ChinaStockSmallImageWS(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public enum Endpoint{
		getSmallImageByte,getSmallImage
	}
	
	public static int IMAGE_TYPE_SMALL=1;
	
	public URL getSmallImage(String theStockCode,int theImageType)throws Exception{
		String url=MessageFormat.format("{0}/{1}?theStockCode={0}&theImageType={1}", theStockCode,theImageType);
		return new URL(url);
	}
	
	public byte[] getSmallImageByte(String theStockCode,int theImageType)throws Exception{
		String param=MessageFormat.format("theStockCode={0}&theImageType={1}", theStockCode,theImageType);
		Document doc=this.doGetEndPoint(Endpoint.getSmallImageByte.name(), param);
		return this.paseBase64(doc);
	}
	
	

}
