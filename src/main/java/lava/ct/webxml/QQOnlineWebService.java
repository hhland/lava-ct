package lava.ct.webxml;

import java.text.MessageFormat;

import org.dom4j.Document;
import org.dom4j.Node;

public class QQOnlineWebService extends BaseWebXmlService {

	public QQOnlineWebService(){
		this.serviceUrl=SERVICES_BASE_URL+"/qqOnlineWebService"+SERVICES_SUBFIX;
	}
	
	public QQOnlineWebService(String url){
		this.serviceUrl=url;
	}
	
	
	public enum Endpoint{
		qqCheckOnline 
	}
	
	
	public enum ResultCode{
		Y,N,E,A,V
	}
	
	public CheckResult qqCheckOnline(String qqCode) throws Exception{
		String param=MessageFormat.format("qqCode={0}", qqCode);
		Document doc=doGetEndPoint(Endpoint.qqCheckOnline.name(), param);
		Node node=doc.selectSingleNode(XMLTag.string.name());
		ResultCode resultCode=ResultCode.valueOf(node.getText().trim());
		return new QQOnlineWebService() .new CheckResult(qqCode, resultCode);
	}
	
	public class CheckResult{
		private CheckResult(){}
		protected ResultCode resultCode;
		protected String qqCode;
		public CheckResult(String qqCode,ResultCode resultCode){
			this.qqCode=qqCode;
			this.resultCode=resultCode;
		}
		public ResultCode getResultCode() {
			return resultCode;
		}
		public String getQqCode() {
			return qqCode;
		}
		
		public String getMsg(){
			//Y = 在线；N = 离线；E = QQ号码错误；A = 商业用户验证失败；V = 免费用户超过数量
			switch (this.resultCode) {
			case Y:return "在线";
			case N:return "离线";
			case E:return "QQ号码错误";
			case A:return "商业用户验证失败";
			case V:return "免费用户超过数量";
			default:
			  return "未知代码:"+resultCode;
			}
		}
	}
	
	
}
