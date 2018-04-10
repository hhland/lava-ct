package lava.ct.webxml;

import java.text.MessageFormat;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;


public class ValidateEmailWebService extends BaseWebXmlService {


   
	
    public ValidateEmailWebService(){
    	this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;

    }
    
    public ValidateEmailWebService(String url){
    	this.serviceUrl=url;
    }
    
    
    public enum Endpoint{
    	ValidateEmailAddress,ValidateEmailAddressPro 
    }
    
    public ValidateReslut ValidateEmailAddress(String theEmail) throws Exception{
    	String param=MessageFormat.format("theEmail={0}", theEmail);
    	Document doc=this.doGetEndPoint(Endpoint.ValidateEmailAddress.name(),param );
    	Node node=doc.selectSingleNode(XMLTag.unsignedByte.name());
    	int re=Integer.parseInt(node.getText().trim());
    	return new ValidateEmailWebService().new ValidateReslut(theEmail, re);
    }
    
    public ValidateReslut ValidateEmailAddressPro(String theEmail,int theEmailPort) throws Exception{
       	String param=MessageFormat.format("theEmail={0}&theEmailPort={1}", theEmail,String.valueOf(theEmailPort));
    	Document doc=this.doGetEndPoint(Endpoint.ValidateEmailAddressPro.name(),param );
    	Node node=doc.selectSingleNode(XMLTag.unsignedByte.name());
    	int re=Integer.parseInt(node.getText().trim());
    	return new ValidateEmailWebService().new ValidateReslut(theEmail, re);
 
    }
    
    public class ValidateReslut{
    	private ValidateReslut(){}
    	//0 = 请重新验证；1 = 邮件地址合法；2 = 只是域名正确；3 = 一个未知错误；4 = 邮件服务器没有找到；5 = 电子邮件地址错误；6 = 免费用户验证超过数量（50次/24小时）；7 = 商业用户不能通过验证
    	protected int code;
        protected String email;
        public ValidateReslut(String email,int code){
        	this.code=code;
        	this.email=email;
        }
    	
		public boolean isRightFul(){
			return this.code==1;
		}
		
		public String getMsg(){
			switch (this.code) {
			case 0:return "请重新验证";
			case 1:return "邮件地址合法";
			case 2:return "只是域名正确";
			case 3:return "一个未知错误";
			case 4:return "邮件服务器没有找到";
			case 5:return "电子邮件地址错误";
			case 7:return "免费用户验证超过数量（50次/24小时）";
			case 8:return "商业用户不能通过验证";
			default:
				return "未知代码:"+code;
			}
		}
    	
		public String getEmail(){
			return this.email;
		}
		
    }
  
    
}
