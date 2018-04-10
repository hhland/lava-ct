package lava.ct.webxml;

import java.util.ArrayList;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;



public class ForexRmbRateWebService extends BaseWebXmlService {

	
	public ForexRmbRateWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public enum Endpoint{
		getForexRmbRate,getForexRmbRatePro
		
	}

	public List<ForexRmbRate> getForexRmbRatePro()throws Exception{
		throw new Exception("非商业用户无法测试");
	}
	
	public List<ForexRmbRate> getForexRmbRate()throws Exception{
		List<ForexRmbRate> forexRmbRates=new ArrayList<ForexRmbRateWebService.ForexRmbRate>();
		Document doc=this.doGetEndPoint(Endpoint.getForexRmbRate.name(), "");
		List<Node> nodes=this.parseDataSets(doc, "getForexRmbRate", ForexRmbRate.class.getSimpleName());
		for(Node node:nodes){
			ForexRmbRate forexRmbRate=this.new ForexRmbRate();
			if(node.selectSingleNode("fBuyPrice").hasContent()){
			 forexRmbRate.fBuyPrice=Double.parseDouble(node.selectSingleNode("fBuyPrice").getText());
			}
			if(node.selectSingleNode("mBuyPrice").hasContent()){
			forexRmbRate.mBuyPrice=Double.parseDouble(node.selectSingleNode("mBuyPrice").getText());
			}
			forexRmbRate.Name=node.selectSingleNode("Name").getText();
			forexRmbRate.Symbol=node.selectSingleNode("Symbol").getText();
			if(node.selectSingleNode("BasePrice").hasContent()){
			  forexRmbRate.BasePrice=Double.parseDouble(node.selectSingleNode("BasePrice").getText());
			}
			if(node.selectSingleNode("SellPrice").hasContent()){
				  forexRmbRate.SellPrice=Double.parseDouble(node.selectSingleNode("SellPrice").getText());
				}
			forexRmbRates.add(forexRmbRate);
		}
		return forexRmbRates;
	}
	
	public class ForexRmbRate{
		private ForexRmbRate(){}
		protected String Symbol,Name;
		protected double mBuyPrice,fBuyPrice,SellPrice,BasePrice;
		public String getSymbol() {
			return Symbol;
		}
		public String getName() {
			return Name;
		}
		public double getmBuyPrice() {
			return mBuyPrice;
		}
		public double getfBuyPrice() {
			return fBuyPrice;
		}
		public double getSellPrice() {
			return SellPrice;
		}
		public double getBasePrice() {
			return BasePrice;
		}
		
		
	}
	
	
	
}
