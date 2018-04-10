package lava.ct.webxml;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;



public class EnglishChinese extends BaseWebXmlService {

	public EnglishChinese(){
		this.serviceUrl="http://fy.webxml.com.cn/webservices/"+this.getClass().getSimpleName()+SERVICES_SUBFIX;
	}
	
	public enum Endpoint{
		GetMp3,SuggestWord,Translator,TranslatorReferString
		,TranslatorSentenceString,TranslatorString
	}
	
	public List<String> SuggestWord(String wordKey) throws Exception{
		String param=MessageFormat.format("wordKey={0}", wordKey);
		Document doc=this.doGetEndPoint(Endpoint.SuggestWord.name(), param);
		List<String> words=new ArrayList<String>();
		List<Node> nodes=doc.getRootElement().elements();
		for(Node node:nodes){
			words.add(node.getText().trim());
		}
		return words;
	}
	
	public Translator Translator(String wordKey)throws Exception{
		String param=MessageFormat.format("wordKey={0}", wordKey);
		Document doc=this.doGetEndPoint(Endpoint.Translator.name(), param);
		Node nodeTrans=this.parseDataSets(doc, "Dictionary", "Trans").get(0); 
		List<Node> nodeSentences=this.parseDataSets(doc, "Dictionary" , "Sentence");
	    Translator translator=this.new Translator();
	    translator.Info=nodeTrans.selectSingleNode("Info").getText();
	    translator.Mp3=nodeTrans.selectSingleNode("Mp3").getText();
	    translator.Pron=nodeTrans.selectSingleNode("Pron").getText();
	    translator.Translation=nodeTrans.selectSingleNode("Translation").getText();
	    translator.WordKey=nodeTrans.selectSingleNode("WordKey").getText();
	    for(Node node:nodeSentences){
	    	Sentence sentence=this.new Sentence();
	    	sentence.Orig=node.selectSingleNode("Orig").getText();
	    	sentence.Trans=node.selectSingleNode("Trans").getText();
	    	translator.sentences.add(sentence);
	    }
	    return translator;
	}
	
	public List<String> TranslatorSentenceString(String wordKey)throws Exception{
		String param=MessageFormat.format("wordKey={0}", wordKey);
		Document doc=this.doGetEndPoint(Endpoint.Translator.name(), param);
        List<Node> nodes=doc.getRootElement().elements();
		List<String> strs=new ArrayList<String>();
        for(Node node:nodes){
        	strs.add(node.getText());
        }
        return strs;
	}
	
	public Translator TranslatorString(String wordKey)throws Exception{
		String param=MessageFormat.format("wordKey={0}", wordKey);
		Document doc=this.doGetEndPoint(Endpoint.TranslatorString.name(), param);
		List<Node> nodes=doc.getRootElement().elements();
		Translator translator=this.new Translator();
		int i=0;
		translator.WordKey=nodes.get(i++).getText();
		translator.Pron=nodes.get(i++).getText();
		translator.Mp3=nodes.get(i++).getText();
		translator.Translation=nodes.get(i++).getText();
		translator.Mp3=nodes.get(i++).getText();
		return translator;
	}
	
	public byte[] GetMp3(String Mp3) throws Exception{
		String param=MessageFormat.format("Mp3={0}", Mp3);
		Document doc=this.doGetEndPoint(Endpoint.GetMp3.name(), param);
        return this.paseBase64(doc);
	}
	
	public class Translator{
		private Translator(){
			sentences=new ArrayList<EnglishChinese.Sentence>();
		}
		protected String WordKey,Pron,Info,Translation,Mp3;
		protected List<Sentence> sentences;
		public String getWordKey() {
			return WordKey;
		}
		public String getPron() {
			return Pron;
		}
		public String getInfo() {
			return Info;
		}
		public String getTranslation() {
			return Translation;
		}
		public String getMp3() {
			return Mp3;
		}
		public List<Sentence> getSentences() {
			return sentences;
		}
		
		
	}
	
	public class Sentence{
		private Sentence(){}
		protected String Orig,Trans;
		public String getOrig() {
			return Orig;
		}
		public String getTrans() {
			return Trans;
		}
		
		
	}
	

}
