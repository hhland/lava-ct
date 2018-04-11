package lava.ct.webxml;



import lava.ct.instance.SimpleDateFormatInstance;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;







public class ExchangeRateWebService extends BaseWebXmlService {

	public ExchangeRateWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public enum Endpoint{
		getExchangeRate,getExchangeRatePro,getSupportCurrency,getSupportCurrencyString
	}
	
	public enum ExchangeType{
		A,B,C
	}
	
	public List<ExchangeRate> getExchangeRate(ExchangeType theType,String theUserID)throws Exception{
	     throw new Exception("缺userid，没有实现");
	}
	
	public List<ExchangeRate> getExchangeRate(ExchangeType theType)throws Exception{
		List<ExchangeRate> exchangeRates=new ArrayList<ExchangeRateWebService.ExchangeRate>();
		String param=MessageFormat.format("theType={0}", theType);
		Document doc=this.doGetEndPoint(Endpoint.getExchangeRate.name(), param);
		List<Node> nodes=this.parseDataSets(doc, "getExchangeRate", "ExchangeRate");
		for(Node node:nodes){
			ExchangeRate exchangeRate=this .new ExchangeRate();
			String temp="";
			exchangeRate.BuyPrice=Double.parseDouble(node.selectSingleNode("BuyPrice").getText());
			exchangeRate.ChangeColor=node.selectSingleNode("ChangeColor").getText();
			exchangeRate.ClosePrice=Double.parseDouble(node.selectSingleNode("ClosePrice").getText());
			exchangeRate.Code=node.selectSingleNode("Code").getText();
			exchangeRate.Currency=node.selectSingleNode("Currency").getText();
			exchangeRate.DataTime=SimpleDateFormatInstance.tryParse(node.selectSingleNode("DataTime").getText());
		 	temp=node.selectSingleNode("DiffPercent").getText();
			exchangeRate.DiffPercent=Double.parseDouble(temp.substring(0,temp.lastIndexOf("%")));
			exchangeRate.HighPrice=Double.parseDouble(node.selectSingleNode("HighPrice").getText());
			exchangeRate.LowPrice=Double.parseDouble(node.selectSingleNode("LowPrice").getText());
			exchangeRate.OpenPrice=Double.parseDouble(node.selectSingleNode("OpenPrice").getText());
			temp=node.selectSingleNode("Range").getText();
			exchangeRate.Range=Double.parseDouble(temp.substring(0,temp.lastIndexOf("%")));
			exchangeRate.SellPrice=Double.parseDouble(node.selectSingleNode("SellPrice").getText());
			exchangeRates.add(exchangeRate);
		}
		return exchangeRates;
	}
	
	public List<CurrencyType> getSupportCurrency()throws Exception{
		List<CurrencyType> currencyTypes=new ArrayList<CurrencyType>();
		Document doc=this.doGetEndPoint(Endpoint.getSupportCurrency.name(), "");
		List<Node> nodes=this.parseDataSets(doc, "NewDataSet", CurrencyType.class.getSimpleName());
		for(Node node:nodes){
			CurrencyType currencyType=new CurrencyType();
			currencyType.Code=node.selectSingleNode("Code").getText();
			currencyType.Currency =node.selectSingleNode("Currency").getText();
		    currencyTypes.add(currencyType);
		}
		return currencyTypes;
	}
	
	public List<CurrencyType> getSupportCurrencyString()throws Exception{
		List<CurrencyType> currencyTypes=new ArrayList<CurrencyType>();
		Document doc=this.doGetEndPoint(Endpoint.getSupportCurrencyString.name(), "");
		List<Node> nodes=doc.getRootElement().elements();
		for(Node node:nodes){
			String[] texts=node.getText().split(",");
			CurrencyType currencyType=new CurrencyType();
			currencyType.Code=texts[1];
			currencyType.Currency =texts[0];
		    currencyTypes.add(currencyType);
		}
		return currencyTypes;
	}
	
	public class CurrencyType{
		private CurrencyType(){}
		protected String Currency,Code;
		public String getCurrency() {
			return Currency;
		}
		
		public String getCode() {
			return Code;
		}
		
		
		
	}
	

	public class ExchangeRate extends CurrencyType{
		private ExchangeRate(){}
		 
		protected String ChangeColor;
		protected Date DataTime;
		protected double ClosePrice, DiffPercent,OpenPrice,HighPrice,LowPrice,Range,BuyPrice,SellPrice;
		public String getChangeColor() {
			return ChangeColor;
		}
		public Date getDataTime() {
			return DataTime;
		}
		public double getClosePrice() {
			return ClosePrice;
		}
		public double getDiffPercent() {
			return DiffPercent;
		}
		public double getOpenPrice() {
			return OpenPrice;
		}
		public double getHighPrice() {
			return HighPrice;
		}
		public double getLowPrice() {
			return LowPrice;
		}
		public double getRange() {
			return Range;
		}
		public double getBuyPrice() {
			return BuyPrice;
		}
		public double getSellPrice() {
			return SellPrice;
		}
		
		
	}
	
	

}
