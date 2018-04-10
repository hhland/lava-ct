package lava.ct.webxml;

import java.net.URL;
import java.text.MessageFormat;

import org.dom4j.Document;

import com.kull.Stringz;



public class ValidateCodeWebService extends BaseWebXmlService {

	
	public ValidateCodeWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public enum Endpoint{
		cnValidateByte,cnValidateImage,enValidateByte,enValidateImage
		,smallValidateByte,smallValidateImage
	}
	

	public URL cnValidateImage(String byString)throws Exception{
		String url=MessageFormat.format("{0}/{1}?byString={2}",this.serviceUrl,Endpoint.cnValidateImage.name(), Stringz.UrlCoding.utf8.encode(byString));
	    return new URL(url);
	}
	
	public URL enValidateImage(String byString)throws Exception{
		String url=MessageFormat.format("{0}/{1}?byString={2}",this.serviceUrl,Endpoint.enValidateImage.name(), byString);
	    return new URL(url);
	}
	
	public URL smallValidateImage(String byString)throws Exception{
		String url=MessageFormat.format("{0}/{1}?byString={2}",this.serviceUrl,Endpoint.smallValidateImage.name(), byString);
	    return new URL(url);
	}
	
	public byte[] cnValidateByte(String byString)throws Exception{
		String param=MessageFormat.format("byString={0}",byString);
	    Document doc=this.doGetEndPoint(Endpoint.cnValidateByte.name(), param);
		return this.paseBase64(doc);
	}
	
	public byte[] enValidateByte(String byString)throws Exception{
		String param=MessageFormat.format("byString={0}",byString);
	    Document doc=this.doGetEndPoint(Endpoint.enValidateByte.name(), param);
		return this.paseBase64(doc);
	}
	
	public byte[] smallValidateByte(String byString)throws Exception{
		String param=MessageFormat.format("byString={0}",byString);
	    Document doc=this.doGetEndPoint(Endpoint.smallValidateByte.name(), param);
		return this.paseBase64(doc);
	}
	
	

}
