package lava.ct.test; 

import java.lang.String; 
import java.lang.Integer; 
import java.lang.Float; 
import java.util.Date; 
import java.math.BigDecimal; 
import lava.rt.linq.Table; 
import java.sql.Connection; 


public class SenDataContext extends lava.rt.linq.DataContext{ 

	 public SenDataContext(Connection conn){ super(conn);  } 

	 public final Table<COUNTRY> tableCOUNTRY=createTable(COUNTRY.class,"ID");
	 public final Table<USED_TO> tableUSED_TO=createTable(USED_TO.class,"ID");
	 public final Table<DUTY_MODE> tableDUTY_MODE=createTable(DUTY_MODE.class,"ID");
	 public final Table<TRANSAC> tableTRANSAC=createTable(TRANSAC.class,"ID");
	 public final Table<PARA_BIZ_TYPE> tablePARA_BIZ_TYPE=createTable(PARA_BIZ_TYPE.class,"ID");
	 public final Table<UNIT> tableUNIT=createTable(UNIT.class,"ID");
	 public final Table<TRADE> tableTRADE=createTable(TRADE.class,"ID");
	 public final Table<PORT> tablePORT=createTable(PORT.class,"ID");
	 public final Table<COMPLEX> tableCOMPLEX=createTable(COMPLEX.class,"ID");
	 public final Table<DISTRICT> tableDISTRICT=createTable(DISTRICT.class,"ID");
	 public final Table<CUSTOMS> tableCUSTOMS=createTable(CUSTOMS.class,"ID");
	 public final Table<TRANSF> tableTRANSF=createTable(TRANSF.class,"ID");
	 public final Table<CURR> tableCURR=createTable(CURR.class,"ID");
	 public final Table<WRAP> tableWRAP=createTable(WRAP.class,"ID");


	 public  class COUNTRY {


		 private String COUNTRY_CODE ; 
 		 private String ISO_E ; 
 		 private String COUN_C_NAME ; 
 		 private String COUN_E_NAME ; 
 		 private String ABBR_C ; 
 		 private String EXAM_MARK ; 
 		 private String HIGH_LOW ; 
 		 private String TDS_HIGH_LOW ; 
 
		 public String getCOUNTRY_CODE(){ return this.COUNTRY_CODE; } 
		 public void setCOUNTRY_CODE(String COUNTRY_CODE ){  this.COUNTRY_CODE=COUNTRY_CODE; } 

		 public String getISO_E(){ return this.ISO_E; } 
		 public void setISO_E(String ISO_E ){  this.ISO_E=ISO_E; } 

		 public String getCOUN_C_NAME(){ return this.COUN_C_NAME; } 
		 public void setCOUN_C_NAME(String COUN_C_NAME ){  this.COUN_C_NAME=COUN_C_NAME; } 

		 public String getCOUN_E_NAME(){ return this.COUN_E_NAME; } 
		 public void setCOUN_E_NAME(String COUN_E_NAME ){  this.COUN_E_NAME=COUN_E_NAME; } 

		 public String getABBR_C(){ return this.ABBR_C; } 
		 public void setABBR_C(String ABBR_C ){  this.ABBR_C=ABBR_C; } 

		 public String getEXAM_MARK(){ return this.EXAM_MARK; } 
		 public void setEXAM_MARK(String EXAM_MARK ){  this.EXAM_MARK=EXAM_MARK; } 

		 public String getHIGH_LOW(){ return this.HIGH_LOW; } 
		 public void setHIGH_LOW(String HIGH_LOW ){  this.HIGH_LOW=HIGH_LOW; } 

		 public String getTDS_HIGH_LOW(){ return this.TDS_HIGH_LOW; } 
		 public void setTDS_HIGH_LOW(String TDS_HIGH_LOW ){  this.TDS_HIGH_LOW=TDS_HIGH_LOW; } 

	 } //end COUNTRY


	 public  class USED_TO {


		 private String USEDT_CODE ; 
 		 private String USEDT_NAME ; 
 
		 public String getUSEDT_CODE(){ return this.USEDT_CODE; } 
		 public void setUSEDT_CODE(String USEDT_CODE ){  this.USEDT_CODE=USEDT_CODE; } 

		 public String getUSEDT_NAME(){ return this.USEDT_NAME; } 
		 public void setUSEDT_NAME(String USEDT_NAME ){  this.USEDT_NAME=USEDT_NAME; } 

	 } //end USED_TO


	 public  class DUTY_MODE {


		 private String CODE ; 
 		 private String VALUE ; 
 
		 public String getCODE(){ return this.CODE; } 
		 public void setCODE(String CODE ){  this.CODE=CODE; } 

		 public String getVALUE(){ return this.VALUE; } 
		 public void setVALUE(String VALUE ){  this.VALUE=VALUE; } 

	 } //end DUTY_MODE


	 public  class TRANSAC {


		 private String TRANS_MODE ; 
 		 private String TRANS_SPEC ; 
 
		 public String getTRANS_MODE(){ return this.TRANS_MODE; } 
		 public void setTRANS_MODE(String TRANS_MODE ){  this.TRANS_MODE=TRANS_MODE; } 

		 public String getTRANS_SPEC(){ return this.TRANS_SPEC; } 
		 public void setTRANS_SPEC(String TRANS_SPEC ){  this.TRANS_SPEC=TRANS_SPEC; } 

	 } //end TRANSAC


	 public  class PARA_BIZ_TYPE {


		 private String CODE ; 
 		 private String VALUE ; 
 
		 public String getCODE(){ return this.CODE; } 
		 public void setCODE(String CODE ){  this.CODE=CODE; } 

		 public String getVALUE(){ return this.VALUE; } 
		 public void setVALUE(String VALUE ){  this.VALUE=VALUE; } 

	 } //end PARA_BIZ_TYPE


	 public  class UNIT {


		 private String UNIT_CODE ; 
 		 private String UNIT_NAME ; 
 		 private String CONV_CODE ; 
 		 private BigDecimal CONV_RATIO ; 
 
		 public String getUNIT_CODE(){ return this.UNIT_CODE; } 
		 public void setUNIT_CODE(String UNIT_CODE ){  this.UNIT_CODE=UNIT_CODE; } 

		 public String getUNIT_NAME(){ return this.UNIT_NAME; } 
		 public void setUNIT_NAME(String UNIT_NAME ){  this.UNIT_NAME=UNIT_NAME; } 

		 public String getCONV_CODE(){ return this.CONV_CODE; } 
		 public void setCONV_CODE(String CONV_CODE ){  this.CONV_CODE=CONV_CODE; } 

		 public BigDecimal getCONV_RATIO(){ return this.CONV_RATIO; } 
		 public void setCONV_RATIO(BigDecimal CONV_RATIO ){  this.CONV_RATIO=CONV_RATIO; } 

	 } //end UNIT


	 public  class TRADE {


		 private String TRADE_MODE ; 
 		 private String ABBR_TRADE ; 
 		 private String FULL_TRADE ; 
 
		 public String getTRADE_MODE(){ return this.TRADE_MODE; } 
		 public void setTRADE_MODE(String TRADE_MODE ){  this.TRADE_MODE=TRADE_MODE; } 

		 public String getABBR_TRADE(){ return this.ABBR_TRADE; } 
		 public void setABBR_TRADE(String ABBR_TRADE ){  this.ABBR_TRADE=ABBR_TRADE; } 

		 public String getFULL_TRADE(){ return this.FULL_TRADE; } 
		 public void setFULL_TRADE(String FULL_TRADE ){  this.FULL_TRADE=FULL_TRADE; } 

	 } //end TRADE


	 public  class PORT {


		 private String PORT_CODE ; 
 		 private String COUNTRY_CODE ; 
 		 private String PORT_C_NAME ; 
 		 private String PORT_E_NAME ; 
 
		 public String getPORT_CODE(){ return this.PORT_CODE; } 
		 public void setPORT_CODE(String PORT_CODE ){  this.PORT_CODE=PORT_CODE; } 

		 public String getCOUNTRY_CODE(){ return this.COUNTRY_CODE; } 
		 public void setCOUNTRY_CODE(String COUNTRY_CODE ){  this.COUNTRY_CODE=COUNTRY_CODE; } 

		 public String getPORT_C_NAME(){ return this.PORT_C_NAME; } 
		 public void setPORT_C_NAME(String PORT_C_NAME ){  this.PORT_C_NAME=PORT_C_NAME; } 

		 public String getPORT_E_NAME(){ return this.PORT_E_NAME; } 
		 public void setPORT_E_NAME(String PORT_E_NAME ){  this.PORT_E_NAME=PORT_E_NAME; } 

	 } //end PORT


	 public  class COMPLEX {


		 private String CODE_TS ; 
 		 private Date BEGIN_DATE ; 
 		 private String LSJM_FLAG ; 
 		 private Date END_DATE ; 
 		 private String G_NAME ; 
 		 private String TARIFF_MARK ; 
 		 private String DUTY_TYPE ; 
 		 private BigDecimal LOW_RATE ; 
 		 private BigDecimal HIGH_RATE ; 
 		 private BigDecimal COM_V_LOW_RATE ; 
 		 private BigDecimal COM_V_HIGH_RATE ; 
 		 private BigDecimal COM_Q_LOW_RATE ; 
 		 private BigDecimal COM_Q_HIGH_RATE ; 
 		 private String COM_UNIT_FLAG ; 
 		 private BigDecimal COM_LOW_CTL_PRICE ; 
 		 private BigDecimal COM_HIGH_CTL_PRICE ; 
 		 private String COM_CTL_CURR ; 
 		 private BigDecimal OUT_RATE ; 
 		 private String REG_TYPE ; 
 		 private BigDecimal REG_RATE ; 
 		 private BigDecimal REG_Q_LOW_RATE ; 
 		 private BigDecimal REG_Q_HIGH_RATE ; 
 		 private String REG_UNIT_FLAG ; 
 		 private BigDecimal REG_CTL_PRICE ; 
 		 private String REG_CTL_CURR ; 
 		 private String TAX_TYPE ; 
 		 private BigDecimal TAX_RATE ; 
 		 private BigDecimal TAIWAN_RATE ; 
 		 private String OTHER_TYPE ; 
 		 private BigDecimal OTHER_RATE ; 
 		 private String UNIT_1 ; 
 		 private String UNIT_2 ; 
 		 private BigDecimal ILOW_PRICE ; 
 		 private BigDecimal IHIGH_PRICE ; 
 		 private BigDecimal ELOW_PRICE ; 
 		 private BigDecimal EHIGH_PRICE ; 
 		 private BigDecimal MAX_IN ; 
 		 private BigDecimal MAX_OUT ; 
 		 private String CONTROL_MARK ; 
 		 private String CHK_PRICE ; 
 		 private String NOTE_S ; 
 		 private String OUT_DUTY_TYPE ; 
 		 private String OUT_COM_UNIT_FLAG ; 
 		 private BigDecimal OUT_COM_Q_RATE ; 
 
		 public String getCODE_TS(){ return this.CODE_TS; } 
		 public void setCODE_TS(String CODE_TS ){  this.CODE_TS=CODE_TS; } 

		 public Date getBEGIN_DATE(){ return this.BEGIN_DATE; } 
		 public void setBEGIN_DATE(Date BEGIN_DATE ){  this.BEGIN_DATE=BEGIN_DATE; } 

		 public String getLSJM_FLAG(){ return this.LSJM_FLAG; } 
		 public void setLSJM_FLAG(String LSJM_FLAG ){  this.LSJM_FLAG=LSJM_FLAG; } 

		 public Date getEND_DATE(){ return this.END_DATE; } 
		 public void setEND_DATE(Date END_DATE ){  this.END_DATE=END_DATE; } 

		 public String getG_NAME(){ return this.G_NAME; } 
		 public void setG_NAME(String G_NAME ){  this.G_NAME=G_NAME; } 

		 public String getTARIFF_MARK(){ return this.TARIFF_MARK; } 
		 public void setTARIFF_MARK(String TARIFF_MARK ){  this.TARIFF_MARK=TARIFF_MARK; } 

		 public String getDUTY_TYPE(){ return this.DUTY_TYPE; } 
		 public void setDUTY_TYPE(String DUTY_TYPE ){  this.DUTY_TYPE=DUTY_TYPE; } 

		 public BigDecimal getLOW_RATE(){ return this.LOW_RATE; } 
		 public void setLOW_RATE(BigDecimal LOW_RATE ){  this.LOW_RATE=LOW_RATE; } 

		 public BigDecimal getHIGH_RATE(){ return this.HIGH_RATE; } 
		 public void setHIGH_RATE(BigDecimal HIGH_RATE ){  this.HIGH_RATE=HIGH_RATE; } 

		 public BigDecimal getCOM_V_LOW_RATE(){ return this.COM_V_LOW_RATE; } 
		 public void setCOM_V_LOW_RATE(BigDecimal COM_V_LOW_RATE ){  this.COM_V_LOW_RATE=COM_V_LOW_RATE; } 

		 public BigDecimal getCOM_V_HIGH_RATE(){ return this.COM_V_HIGH_RATE; } 
		 public void setCOM_V_HIGH_RATE(BigDecimal COM_V_HIGH_RATE ){  this.COM_V_HIGH_RATE=COM_V_HIGH_RATE; } 

		 public BigDecimal getCOM_Q_LOW_RATE(){ return this.COM_Q_LOW_RATE; } 
		 public void setCOM_Q_LOW_RATE(BigDecimal COM_Q_LOW_RATE ){  this.COM_Q_LOW_RATE=COM_Q_LOW_RATE; } 

		 public BigDecimal getCOM_Q_HIGH_RATE(){ return this.COM_Q_HIGH_RATE; } 
		 public void setCOM_Q_HIGH_RATE(BigDecimal COM_Q_HIGH_RATE ){  this.COM_Q_HIGH_RATE=COM_Q_HIGH_RATE; } 

		 public String getCOM_UNIT_FLAG(){ return this.COM_UNIT_FLAG; } 
		 public void setCOM_UNIT_FLAG(String COM_UNIT_FLAG ){  this.COM_UNIT_FLAG=COM_UNIT_FLAG; } 

		 public BigDecimal getCOM_LOW_CTL_PRICE(){ return this.COM_LOW_CTL_PRICE; } 
		 public void setCOM_LOW_CTL_PRICE(BigDecimal COM_LOW_CTL_PRICE ){  this.COM_LOW_CTL_PRICE=COM_LOW_CTL_PRICE; } 

		 public BigDecimal getCOM_HIGH_CTL_PRICE(){ return this.COM_HIGH_CTL_PRICE; } 
		 public void setCOM_HIGH_CTL_PRICE(BigDecimal COM_HIGH_CTL_PRICE ){  this.COM_HIGH_CTL_PRICE=COM_HIGH_CTL_PRICE; } 

		 public String getCOM_CTL_CURR(){ return this.COM_CTL_CURR; } 
		 public void setCOM_CTL_CURR(String COM_CTL_CURR ){  this.COM_CTL_CURR=COM_CTL_CURR; } 

		 public BigDecimal getOUT_RATE(){ return this.OUT_RATE; } 
		 public void setOUT_RATE(BigDecimal OUT_RATE ){  this.OUT_RATE=OUT_RATE; } 

		 public String getREG_TYPE(){ return this.REG_TYPE; } 
		 public void setREG_TYPE(String REG_TYPE ){  this.REG_TYPE=REG_TYPE; } 

		 public BigDecimal getREG_RATE(){ return this.REG_RATE; } 
		 public void setREG_RATE(BigDecimal REG_RATE ){  this.REG_RATE=REG_RATE; } 

		 public BigDecimal getREG_Q_LOW_RATE(){ return this.REG_Q_LOW_RATE; } 
		 public void setREG_Q_LOW_RATE(BigDecimal REG_Q_LOW_RATE ){  this.REG_Q_LOW_RATE=REG_Q_LOW_RATE; } 

		 public BigDecimal getREG_Q_HIGH_RATE(){ return this.REG_Q_HIGH_RATE; } 
		 public void setREG_Q_HIGH_RATE(BigDecimal REG_Q_HIGH_RATE ){  this.REG_Q_HIGH_RATE=REG_Q_HIGH_RATE; } 

		 public String getREG_UNIT_FLAG(){ return this.REG_UNIT_FLAG; } 
		 public void setREG_UNIT_FLAG(String REG_UNIT_FLAG ){  this.REG_UNIT_FLAG=REG_UNIT_FLAG; } 

		 public BigDecimal getREG_CTL_PRICE(){ return this.REG_CTL_PRICE; } 
		 public void setREG_CTL_PRICE(BigDecimal REG_CTL_PRICE ){  this.REG_CTL_PRICE=REG_CTL_PRICE; } 

		 public String getREG_CTL_CURR(){ return this.REG_CTL_CURR; } 
		 public void setREG_CTL_CURR(String REG_CTL_CURR ){  this.REG_CTL_CURR=REG_CTL_CURR; } 

		 public String getTAX_TYPE(){ return this.TAX_TYPE; } 
		 public void setTAX_TYPE(String TAX_TYPE ){  this.TAX_TYPE=TAX_TYPE; } 

		 public BigDecimal getTAX_RATE(){ return this.TAX_RATE; } 
		 public void setTAX_RATE(BigDecimal TAX_RATE ){  this.TAX_RATE=TAX_RATE; } 

		 public BigDecimal getTAIWAN_RATE(){ return this.TAIWAN_RATE; } 
		 public void setTAIWAN_RATE(BigDecimal TAIWAN_RATE ){  this.TAIWAN_RATE=TAIWAN_RATE; } 

		 public String getOTHER_TYPE(){ return this.OTHER_TYPE; } 
		 public void setOTHER_TYPE(String OTHER_TYPE ){  this.OTHER_TYPE=OTHER_TYPE; } 

		 public BigDecimal getOTHER_RATE(){ return this.OTHER_RATE; } 
		 public void setOTHER_RATE(BigDecimal OTHER_RATE ){  this.OTHER_RATE=OTHER_RATE; } 

		 public String getUNIT_1(){ return this.UNIT_1; } 
		 public void setUNIT_1(String UNIT_1 ){  this.UNIT_1=UNIT_1; } 

		 public String getUNIT_2(){ return this.UNIT_2; } 
		 public void setUNIT_2(String UNIT_2 ){  this.UNIT_2=UNIT_2; } 

		 public BigDecimal getILOW_PRICE(){ return this.ILOW_PRICE; } 
		 public void setILOW_PRICE(BigDecimal ILOW_PRICE ){  this.ILOW_PRICE=ILOW_PRICE; } 

		 public BigDecimal getIHIGH_PRICE(){ return this.IHIGH_PRICE; } 
		 public void setIHIGH_PRICE(BigDecimal IHIGH_PRICE ){  this.IHIGH_PRICE=IHIGH_PRICE; } 

		 public BigDecimal getELOW_PRICE(){ return this.ELOW_PRICE; } 
		 public void setELOW_PRICE(BigDecimal ELOW_PRICE ){  this.ELOW_PRICE=ELOW_PRICE; } 

		 public BigDecimal getEHIGH_PRICE(){ return this.EHIGH_PRICE; } 
		 public void setEHIGH_PRICE(BigDecimal EHIGH_PRICE ){  this.EHIGH_PRICE=EHIGH_PRICE; } 

		 public BigDecimal getMAX_IN(){ return this.MAX_IN; } 
		 public void setMAX_IN(BigDecimal MAX_IN ){  this.MAX_IN=MAX_IN; } 

		 public BigDecimal getMAX_OUT(){ return this.MAX_OUT; } 
		 public void setMAX_OUT(BigDecimal MAX_OUT ){  this.MAX_OUT=MAX_OUT; } 

		 public String getCONTROL_MARK(){ return this.CONTROL_MARK; } 
		 public void setCONTROL_MARK(String CONTROL_MARK ){  this.CONTROL_MARK=CONTROL_MARK; } 

		 public String getCHK_PRICE(){ return this.CHK_PRICE; } 
		 public void setCHK_PRICE(String CHK_PRICE ){  this.CHK_PRICE=CHK_PRICE; } 

		 public String getNOTE_S(){ return this.NOTE_S; } 
		 public void setNOTE_S(String NOTE_S ){  this.NOTE_S=NOTE_S; } 

		 public String getOUT_DUTY_TYPE(){ return this.OUT_DUTY_TYPE; } 
		 public void setOUT_DUTY_TYPE(String OUT_DUTY_TYPE ){  this.OUT_DUTY_TYPE=OUT_DUTY_TYPE; } 

		 public String getOUT_COM_UNIT_FLAG(){ return this.OUT_COM_UNIT_FLAG; } 
		 public void setOUT_COM_UNIT_FLAG(String OUT_COM_UNIT_FLAG ){  this.OUT_COM_UNIT_FLAG=OUT_COM_UNIT_FLAG; } 

		 public BigDecimal getOUT_COM_Q_RATE(){ return this.OUT_COM_Q_RATE; } 
		 public void setOUT_COM_Q_RATE(BigDecimal OUT_COM_Q_RATE ){  this.OUT_COM_Q_RATE=OUT_COM_Q_RATE; } 

	 } //end COMPLEX


	 public  class DISTRICT {


		 private String DISTRICT_CODE ; 
 		 private String DISTRICT_NAME ; 
 		 private String ABBR_DIST ; 
 		 private String DISTRICT_TYPE ; 
 
		 public String getDISTRICT_CODE(){ return this.DISTRICT_CODE; } 
		 public void setDISTRICT_CODE(String DISTRICT_CODE ){  this.DISTRICT_CODE=DISTRICT_CODE; } 

		 public String getDISTRICT_NAME(){ return this.DISTRICT_NAME; } 
		 public void setDISTRICT_NAME(String DISTRICT_NAME ){  this.DISTRICT_NAME=DISTRICT_NAME; } 

		 public String getABBR_DIST(){ return this.ABBR_DIST; } 
		 public void setABBR_DIST(String ABBR_DIST ){  this.ABBR_DIST=ABBR_DIST; } 

		 public String getDISTRICT_TYPE(){ return this.DISTRICT_TYPE; } 
		 public void setDISTRICT_TYPE(String DISTRICT_TYPE ){  this.DISTRICT_TYPE=DISTRICT_TYPE; } 

	 } //end DISTRICT


	 public  class CUSTOMS {


		 private String CUSTOMS_CODE ; 
 		 private String CUSTOMS_NAME ; 
 		 private String ABBR_CUST ; 
 
		 public String getCUSTOMS_CODE(){ return this.CUSTOMS_CODE; } 
		 public void setCUSTOMS_CODE(String CUSTOMS_CODE ){  this.CUSTOMS_CODE=CUSTOMS_CODE; } 

		 public String getCUSTOMS_NAME(){ return this.CUSTOMS_NAME; } 
		 public void setCUSTOMS_NAME(String CUSTOMS_NAME ){  this.CUSTOMS_NAME=CUSTOMS_NAME; } 

		 public String getABBR_CUST(){ return this.ABBR_CUST; } 
		 public void setABBR_CUST(String ABBR_CUST ){  this.ABBR_CUST=ABBR_CUST; } 

	 } //end CUSTOMS


	 public  class TRANSF {


		 private String TRAF_CODE ; 
 		 private String TRAF_SPEC ; 
 
		 public String getTRAF_CODE(){ return this.TRAF_CODE; } 
		 public void setTRAF_CODE(String TRAF_CODE ){  this.TRAF_CODE=TRAF_CODE; } 

		 public String getTRAF_SPEC(){ return this.TRAF_SPEC; } 
		 public void setTRAF_SPEC(String TRAF_SPEC ){  this.TRAF_SPEC=TRAF_SPEC; } 

	 } //end TRANSF


	 public  class CURR {


		 private String CURR_CODE ; 
 		 private String CURR_SYMB ; 
 		 private String ISO_CURR ; 
 		 private String CURR_NAME ; 
 
		 public String getCURR_CODE(){ return this.CURR_CODE; } 
		 public void setCURR_CODE(String CURR_CODE ){  this.CURR_CODE=CURR_CODE; } 

		 public String getCURR_SYMB(){ return this.CURR_SYMB; } 
		 public void setCURR_SYMB(String CURR_SYMB ){  this.CURR_SYMB=CURR_SYMB; } 

		 public String getISO_CURR(){ return this.ISO_CURR; } 
		 public void setISO_CURR(String ISO_CURR ){  this.ISO_CURR=ISO_CURR; } 

		 public String getCURR_NAME(){ return this.CURR_NAME; } 
		 public void setCURR_NAME(String CURR_NAME ){  this.CURR_NAME=CURR_NAME; } 

	 } //end CURR


	 public  class WRAP {


		 private String WRAP_CODE ; 
 		 private String WRAP_NAME ; 
 
		 public String getWRAP_CODE(){ return this.WRAP_CODE; } 
		 public void setWRAP_CODE(String WRAP_CODE ){  this.WRAP_CODE=WRAP_CODE; } 

		 public String getWRAP_NAME(){ return this.WRAP_NAME; } 
		 public void setWRAP_NAME(String WRAP_NAME ){  this.WRAP_NAME=WRAP_NAME; } 

	 } //end WRAP





} //end
