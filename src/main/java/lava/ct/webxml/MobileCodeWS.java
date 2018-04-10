package lava.ct.webxml;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;







import org.dom4j.Document;

import org.dom4j.Element;
import org.dom4j.Node;

import com.kull.Clazz;






public class MobileCodeWS extends BaseWebXmlService  {

    public MobileCodeWS(){
    	this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;

    }
    
    public MobileCodeWS(String url){
    	this.serviceUrl=url;
    }
    
    public enum EndPoint{
    	getMobileCodeInfo,getDatabaseInfo 
    }
    
    public List<DatabaseInfo> getDatabaseInfo() throws Exception{
    	
    	Object[] results=new Object[]{};
        List<DatabaseInfo> list=new ArrayList<DatabaseInfo>();
        Document doc=null;
    	try {
 
    		 doc=doGetEndPoint(EndPoint.getDatabaseInfo.name(),"");
    		 List<Element> nl =doc.getRootElement().elements();//.selectNodes("//string");
    		// NodeList nodeList= el..getElementsByTagName("string");
    		 for(Element node :nl){
			 //for(int i=0;i<nl.getLength();i++){
				 //Node node=nl.item(i);
    			 try{
				 DatabaseInfo e=new MobileCodeWS() .new DatabaseInfo();
				 String str=node.getText().trim();
					String[] s1=str.split(" ");
					e.provinceName=s1[0];
					e.cityName=s1[1];
					e.total=Clazz.valueOf(s1[2],0);
			
				 list.add(e);
    			 }catch(Exception ex){
    				 ex.printStackTrace();
    			 }
			 }
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    }
    public  MobileCodeInfo getMobileCodeInfo(String mobileCode) throws Exception{
      return getMobileCodeInfo(mobileCode, "");
    }
    
    public  MobileCodeInfo getMobileCodeInfo(String mobileCode,String userID) throws Exception{
    	
    	
        MobileCodeInfo e=new MobileCodeWS() .new MobileCodeInfo();
        Document doc=null;
        String param=MessageFormat.format("mobileCode={0}&userID={1}",mobileCode,userID );
    	try {
          
          doc=doGetEndPoint(EndPoint.getMobileCodeInfo.name(), param);
          Node node=  doc.selectSingleNode(XMLTag.string.name());
          String context=node.getText().trim();
			String[] s1=context.split("：");
			e.number=s1[0].trim();
			e.provinceName=s1[1].trim().split(" ")[0];
			e.cityName=s1[1].trim().split(" ")[1];
			e.simCardName=s1[1].trim().split(" ")[2];
		}  catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
    	return e;
    }
	
    
    
    
    
    public class DatabaseInfo {

    	
    	private DatabaseInfo(){}
    	private String provinceName;
    	private String cityName;
    	private Integer total;
    	
		
		public void valueOf(String str) {
			// TODO Auto-generated method stub
			str=str.trim();
			String[] s1=str.split(" ");
			this.provinceName=s1[0];
			this.cityName=s1[1];
			this.total=Clazz.valueOf(s1[2],0);
		}

		public String getProvinceName() {
			return provinceName;
		}

		public String getCityName() {
			return cityName;
		}

		public Integer getTotal() {
			return total;
		}
		
		
    	
    }
    
    public class MobileCodeInfo{
    	
    	private MobileCodeInfo(){}
    	
    	protected String number,provinceName,cityName,simCardName;
		public String getNumber() {
			return number;
		}

		public String getProvinceName() {
			return provinceName;
		}

		public String getCityName() {
			return cityName;
		}
	
		public String getSimCardName() {
			return simCardName;
		}
	
		
		public void valueOf(String str) {
			// TODO Auto-generated method stub
			str=str.trim();
			String[] s1=str.split("：");
			this.number=s1[0].trim();
			this.provinceName=s1[1].trim().split(" ")[0];
			this.cityName=s1[1].trim().split(" ")[1];
			this.simCardName=s1[1].trim().split(" ")[2];
		}
    	
    	
    	
    }


    
}
