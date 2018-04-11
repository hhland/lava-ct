package lava.ct.webxml;


import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import lava.ct.instance.SimpleDateFormatInstance;





public class ChinaStockWebService extends BaseWebXmlService {

	public ChinaStockWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public enum EndPoint{
		getStockImageByCode,getStockImageByteByCode,getStockImage_kByCode
		,getStockImage_kByteByCode,getStockInfoByCode
	}
	
	public enum LocalCode{
		sh,sz
	}
	
	public enum KType{
		D,W,M
	}
	
	public URL getStockImageByCode(LocalCode localCode,String theStockCode) throws Exception{
	    if(theStockCode.toLowerCase().startsWith(localCode.name())){
	    	return getStockImageByCode(theStockCode);
	    }else{
		    return getStockImageByCode(localCode+theStockCode);
	    }
	}
	
	public URL getStockImageByCode(String theStockCode) throws Exception{
        String url=MessageFormat.format("{0}/{1}?theStockCode={2}", this.serviceUrl,EndPoint.getStockImageByCode,theStockCode);
	    return new URL(url);
	}
	
	public URL getStockImage_kByCode(LocalCode localCode,String theStockCode,KType theType) throws Exception{
	    if(theStockCode.toLowerCase().startsWith(localCode.name())){
	      return	getStockImage_kByCode(theStockCode, theType);
	    }else{
		   return getStockImage_kByCode(localCode+theStockCode,theType);
	    }
	}
	
	public URL getStockImage_kByCode(String theStockCode,KType theType) throws Exception{
        String url=MessageFormat.format("{0}/{1}?theStockCode={2}&theType={3}", this.serviceUrl,EndPoint.getStockImage_kByCode,theStockCode,theType);
	    return new URL(url);
	}
	
	public byte[] getStockImageByteByCode(LocalCode localCode,String theStockCode) throws Exception{
		return this.getStockImageByteByCode(localCode+theStockCode);
	}
	
	public byte[] getStockImageByteByCode(String theStockCode) throws Exception{
		String param=MessageFormat.format("theStockCode={0}", theStockCode);
		Document doc=this.doGetEndPoint(EndPoint.getStockImageByteByCode.name(), param);
		return this.paseBase64(doc);
	}
	
	public byte[] getStockImage_kByteByCode(LocalCode localCode,String theStockCode,KType theType) throws Exception{
		return this.getStockImage_kByteByCode(localCode+theStockCode,theType);
	}
	
	public byte[] getStockImage_kByteByCode(String theStockCode,KType theType) throws Exception{
		String param=MessageFormat.format("theStockCode={0}&theType={1}", theStockCode);
		Document doc=this.doGetEndPoint(EndPoint.getStockImage_kByteByCode.name(), param);
		return this.paseBase64(doc);
	}
	
	public Stock getStockInfoByCode(LocalCode localCode,String theStockCode) throws Exception{
		return getStockInfoByCode(localCode+theStockCode);
	}
	
	/*杈撳叆鍙傛暟锛歵heStockCode = 鑲＄エ浠ｅ彿锛屽锛歴h000001锛� 杩斿洖鏁版嵁锛氫竴涓竴缁村瓧绗︿覆鏁扮粍 String(24)锛�
	缁撴瀯涓猴細String(0)鑲＄エ浠ｅ彿銆丼tring(1)鑲＄エ鍚嶇О銆丼tring(2)琛屾儏鏃堕棿銆�
	String(3)鏈�鏂颁环锛堝厓锛夈�丼tring(4)鏄ㄦ敹鐩橈紙鍏冿級銆丼tring(5)浠婂紑鐩橈紙鍏冿級銆�
	String(6)娑ㄨ穼棰濓紙鍏冿級銆丼tring(7)鏈�浣庯紙鍏冿級銆丼tring(8)鏈�楂橈紙鍏冿級銆�
	String(9)娑ㄨ穼骞咃紙%锛夈�丼tring(10)鎴愪氦閲忥紙鎵嬶級銆丼tring(11)鎴愪氦棰濓紙涓囧厓锛夈��
	String(12)绔炰拱浠凤紙鍏冿級銆丼tring(13)绔炲崠浠凤紙鍏冿級銆丼tring(14)濮旀瘮锛�%锛夈��
	String(15)-String(19)涔颁竴 - 涔颁簲锛堝厓锛�/鎵嬨�丼tring(20)-String(24)鍗栦竴 - 鍗栦簲锛堝厓锛�/鎵嬨��
	*/
	public Stock getStockInfoByCode(String theStockCode) throws Exception{
		Stock stock=this.new Stock();
		String param=MessageFormat.format("theStockCode={0}",theStockCode);
		Document doc=this.doGetEndPoint(EndPoint.getStockInfoByCode.name(), param);
        List<Node> nodes=doc.getRootElement().elements();
        String text="";
        int i=0;
        stock.code=nodes.get(i++).getText();
        stock.name=nodes.get(i++).getText();
        stock.date=SimpleDateFormatInstance.tryParse(nodes.get(i++).getText());
        stock.newestAmount=Double.parseDouble(nodes.get(i++).getText());
        stock.yesterdayClosingAmount=Double.parseDouble(nodes.get(i++).getText());
        stock.todayOpeningAmount=Double.parseDouble(nodes.get(i++).getText());
        stock.upDownAmount=Double.parseDouble(nodes.get(i++).getText());
        stock.lowestAmount=Double.parseDouble(nodes.get(i++).getText());
        stock.highestAmount=Double.parseDouble(nodes.get(i++).getText());
        text=nodes.get(i++).getText().trim();
        stock.upDownRate=Double.parseDouble(text.substring(0,text.lastIndexOf("%")));
        stock.turnoverHand=Double.parseDouble(nodes.get(i++).getText());
        stock.turnoverMillionAmount=Double.parseDouble(nodes.get(i++).getText());
        if(!nodes.get(i).hasContent()){
        	return stock;
        }
        stock.bidAmount=Double.parseDouble(nodes.get(i++).getText());
        stock.auctionAmount=Double.parseDouble(nodes.get(i++).getText());
        text=nodes.get(i++).getText().trim();
        stock.committeeRate=Double.parseDouble(text.substring(0,text.lastIndexOf("%")));
        for(int j=0;j<5;j++){
        	String[] texts=nodes.get(i++).getText().split("/");
        	stock.buyAmounts.add(Double.parseDouble(texts[0]));
        	stock.buyHands.add(Double.parseDouble(texts[1]));
        }
        for(int j=0;j<5;j++){
        	String[] texts=nodes.get(i++).getText().split("/");
        	stock.sellAmounts.add(Double.parseDouble(texts[0]));
        	stock.sellHands.add(Double.parseDouble(texts[1]));  
        }

        //stock.bidAmount=Double.parseDouble(nodes.get(i++).getText());
		return stock;
	}
	
	public class Stock{
		
		private Stock(){
			buyAmounts=new ArrayList<Double>();
			sellAmounts=new ArrayList<Double>();
			buyHands=new ArrayList<Double>();
			sellHands=new ArrayList<Double>();
		}
		
		protected String code,name;
		protected Date date;
		protected Double newestAmount,yesterdayClosingAmount
		,todayOpeningAmount,upDownAmount,lowestAmount,highestAmount,upDownRate
		,turnoverMillionAmount,bidAmount,auctionAmount,committeeRate,turnoverHand;
		
        protected List<Double> buyAmounts,sellAmounts,buyHands,sellHands;
		public String getCode() {
			return code;
		}
		public String getName() {
			return name;
		}
		public Date getDate() {
			return date;
		}
		public Double getNewestAmount() {
			return newestAmount;
		}
		public Double getYesterdayClosingAmount() {
			return yesterdayClosingAmount;
		}
		public Double getTodayOpeningAmount() {
			return todayOpeningAmount;
		}
		public Double getUpDownAmount() {
			return upDownAmount;
		}
		public Double getLowestAmount() {
			return lowestAmount;
		}
		public Double getHighestAmount() {
			return highestAmount;
		}
		public Double getUpDownRate() {
			return upDownRate;
		}
		public Double getTurnoverMillionAmount() {
			return turnoverMillionAmount;
		}
		public Double getTurnoverHand() {
			return turnoverHand;
		}
		public List<Double> getBuyAmounts() {
			return buyAmounts;
		}
		public List<Double> getSellAmounts() {
			return sellAmounts;
		}
        
        
	}
	

}
