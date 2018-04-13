package lava.ct.test; 

import java.lang.String; 
import java.lang.Integer; 
import java.lang.Float; 
import java.util.Date; 
import java.math.BigDecimal; 
import java.lang.Byte; 
import lava.rt.linq.Table; 
import lava.rt.linq.View; 
import java.io.Serializable; 
import java.lang.Cloneable; 
import java.sql.Connection; 


public class SenDataContext extends lava.rt.linq.DataContext{ 

	 public SenDataContext(Connection conn){ super(conn);  } 

	 public final Table<LANGUAGE> tableLANGUAGE=createTable(LANGUAGE.class,"LANGUAGE","LANGUAGE_ID");
	 public final Table<PAYMENT> tablePAYMENT=createTable(PAYMENT.class,"PAYMENT","PAYMENT_ID");
	 public final Table<FILM> tableFILM=createTable(FILM.class,"FILM","FILM_ID");
	 public final Table<FILM_TEXT> tableFILM_TEXT=createTable(FILM_TEXT.class,"FILM_TEXT","FILM_ID");
	 public final Table<ACTOR> tableACTOR=createTable(ACTOR.class,"ACTOR","ACTOR_ID");
	 public final Table<CITY> tableCITY=createTable(CITY.class,"CITY","CITY_ID");
	 public final Table<COUNTRY> tableCOUNTRY=createTable(COUNTRY.class,"COUNTRY","COUNTRY_ID");
	 public final Table<INVENTORY> tableINVENTORY=createTable(INVENTORY.class,"INVENTORY","INVENTORY_ID");
	 public final Table<CATEGORY> tableCATEGORY=createTable(CATEGORY.class,"CATEGORY","CATEGORY_ID");
	 public final Table<ADDRESS> tableADDRESS=createTable(ADDRESS.class,"ADDRESS","ADDRESS_ID");
	 public final Table<STAFF> tableSTAFF=createTable(STAFF.class,"STAFF","STAFF_ID");
	 public final Table<STORE> tableSTORE=createTable(STORE.class,"STORE","STORE_ID");
	 public final Table<CUSTOMER> tableCUSTOMER=createTable(CUSTOMER.class,"CUSTOMER","CUSTOMER_ID");
	 public final Table<RENTAL> tableRENTAL=createTable(RENTAL.class,"RENTAL","RENTAL_ID");
	 public final Table<FILM_ACTOR> tableFILM_ACTOR=createTable(FILM_ACTOR.class,"FILM_ACTOR","FILM_ID");
	 public final Table<FILM_CATEGORY> tableFILM_CATEGORY=createTable(FILM_CATEGORY.class,"FILM_CATEGORY","CATEGORY_ID");


	 public final View<ACTOR_INFO> viewACTOR_INFO=createView(ACTOR_INFO.class,"ACTOR_INFO");
	 public final View<FILM_LIST> viewFILM_LIST=createView(FILM_LIST.class,"FILM_LIST");
	 public final View<SALES_BY_FILM_CATEGORY> viewSALES_BY_FILM_CATEGORY=createView(SALES_BY_FILM_CATEGORY.class,"SALES_BY_FILM_CATEGORY");
	 public final View<NICER_BUT_SLOWER_FILM_LIST> viewNICER_BUT_SLOWER_FILM_LIST=createView(NICER_BUT_SLOWER_FILM_LIST.class,"NICER_BUT_SLOWER_FILM_LIST");
	 public final View<CUSTOMER_LIST> viewCUSTOMER_LIST=createView(CUSTOMER_LIST.class,"CUSTOMER_LIST");
	 public final View<STAFF_LIST> viewSTAFF_LIST=createView(STAFF_LIST.class,"STAFF_LIST");
	 public final View<SALES_BY_STORE> viewSALES_BY_STORE=createView(SALES_BY_STORE.class,"SALES_BY_STORE");


	 public  class LANGUAGE implements Serializable,Cloneable {
		 private Integer LANGUAGE_ID ; 
 		 private String NAME ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getLANGUAGE_ID(){ return this.LANGUAGE_ID; } 
		 public void setLANGUAGE_ID(Integer LANGUAGE_ID ){  this.LANGUAGE_ID=LANGUAGE_ID; } 
		 public String getNAME(){ return this.NAME; } 
		 public void setNAME(String NAME ){  this.NAME=NAME; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":LANGUAGE:"+this.LANGUAGE_ID;}

	 } //end LANGUAGE

	 public  class PAYMENT implements Serializable,Cloneable {
		 private Integer PAYMENT_ID ; 
 		 private Integer CUSTOMER_ID ; 
 		 private Integer STAFF_ID ; 
 		 private Integer RENTAL_ID ; 
 		 private BigDecimal AMOUNT ; 
 		 private Date PAYMENT_DATE ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getPAYMENT_ID(){ return this.PAYMENT_ID; } 
		 public void setPAYMENT_ID(Integer PAYMENT_ID ){  this.PAYMENT_ID=PAYMENT_ID; } 
		 public Integer getCUSTOMER_ID(){ return this.CUSTOMER_ID; } 
		 public void setCUSTOMER_ID(Integer CUSTOMER_ID ){  this.CUSTOMER_ID=CUSTOMER_ID; } 
		 public Integer getSTAFF_ID(){ return this.STAFF_ID; } 
		 public void setSTAFF_ID(Integer STAFF_ID ){  this.STAFF_ID=STAFF_ID; } 
		 public Integer getRENTAL_ID(){ return this.RENTAL_ID; } 
		 public void setRENTAL_ID(Integer RENTAL_ID ){  this.RENTAL_ID=RENTAL_ID; } 
		 public BigDecimal getAMOUNT(){ return this.AMOUNT; } 
		 public void setAMOUNT(BigDecimal AMOUNT ){  this.AMOUNT=AMOUNT; } 
		 public Date getPAYMENT_DATE(){ return this.PAYMENT_DATE; } 
		 public void setPAYMENT_DATE(Date PAYMENT_DATE ){  this.PAYMENT_DATE=PAYMENT_DATE; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":PAYMENT:"+this.PAYMENT_ID;}

	 } //end PAYMENT

	 public  class FILM implements Serializable,Cloneable {
		 private Integer FILM_ID ; 
 		 private String TITLE ; 
 		 private String DESCRIPTION ; 
 		 private Date RELEASE_YEAR ; 
 		 private Integer LANGUAGE_ID ; 
 		 private Integer ORIGINAL_LANGUAGE_ID ; 
 		 private Integer RENTAL_DURATION ; 
 		 private BigDecimal RENTAL_RATE ; 
 		 private Integer LENGTH ; 
 		 private BigDecimal REPLACEMENT_COST ; 
 		 private String RATING ; 
 		 private String SPECIAL_FEATURES ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getFILM_ID(){ return this.FILM_ID; } 
		 public void setFILM_ID(Integer FILM_ID ){  this.FILM_ID=FILM_ID; } 
		 public String getTITLE(){ return this.TITLE; } 
		 public void setTITLE(String TITLE ){  this.TITLE=TITLE; } 
		 public String getDESCRIPTION(){ return this.DESCRIPTION; } 
		 public void setDESCRIPTION(String DESCRIPTION ){  this.DESCRIPTION=DESCRIPTION; } 
		 public Date getRELEASE_YEAR(){ return this.RELEASE_YEAR; } 
		 public void setRELEASE_YEAR(Date RELEASE_YEAR ){  this.RELEASE_YEAR=RELEASE_YEAR; } 
		 public Integer getLANGUAGE_ID(){ return this.LANGUAGE_ID; } 
		 public void setLANGUAGE_ID(Integer LANGUAGE_ID ){  this.LANGUAGE_ID=LANGUAGE_ID; } 
		 public Integer getORIGINAL_LANGUAGE_ID(){ return this.ORIGINAL_LANGUAGE_ID; } 
		 public void setORIGINAL_LANGUAGE_ID(Integer ORIGINAL_LANGUAGE_ID ){  this.ORIGINAL_LANGUAGE_ID=ORIGINAL_LANGUAGE_ID; } 
		 public Integer getRENTAL_DURATION(){ return this.RENTAL_DURATION; } 
		 public void setRENTAL_DURATION(Integer RENTAL_DURATION ){  this.RENTAL_DURATION=RENTAL_DURATION; } 
		 public BigDecimal getRENTAL_RATE(){ return this.RENTAL_RATE; } 
		 public void setRENTAL_RATE(BigDecimal RENTAL_RATE ){  this.RENTAL_RATE=RENTAL_RATE; } 
		 public Integer getLENGTH(){ return this.LENGTH; } 
		 public void setLENGTH(Integer LENGTH ){  this.LENGTH=LENGTH; } 
		 public BigDecimal getREPLACEMENT_COST(){ return this.REPLACEMENT_COST; } 
		 public void setREPLACEMENT_COST(BigDecimal REPLACEMENT_COST ){  this.REPLACEMENT_COST=REPLACEMENT_COST; } 
		 public String getRATING(){ return this.RATING; } 
		 public void setRATING(String RATING ){  this.RATING=RATING; } 
		 public String getSPECIAL_FEATURES(){ return this.SPECIAL_FEATURES; } 
		 public void setSPECIAL_FEATURES(String SPECIAL_FEATURES ){  this.SPECIAL_FEATURES=SPECIAL_FEATURES; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":FILM:"+this.FILM_ID;}

	 } //end FILM

	 public  class FILM_TEXT implements Serializable,Cloneable {
		 private Integer FILM_ID ; 
 		 private String TITLE ; 
 		 private String DESCRIPTION ; 
 
		 public Integer getFILM_ID(){ return this.FILM_ID; } 
		 public void setFILM_ID(Integer FILM_ID ){  this.FILM_ID=FILM_ID; } 
		 public String getTITLE(){ return this.TITLE; } 
		 public void setTITLE(String TITLE ){  this.TITLE=TITLE; } 
		 public String getDESCRIPTION(){ return this.DESCRIPTION; } 
		 public void setDESCRIPTION(String DESCRIPTION ){  this.DESCRIPTION=DESCRIPTION; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":FILM_TEXT:"+this.FILM_ID;}

	 } //end FILM_TEXT

	 public  class ACTOR implements Serializable,Cloneable {
		 private Integer ACTOR_ID ; 
 		 private String FIRST_NAME ; 
 		 private String LAST_NAME ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getACTOR_ID(){ return this.ACTOR_ID; } 
		 public void setACTOR_ID(Integer ACTOR_ID ){  this.ACTOR_ID=ACTOR_ID; } 
		 public String getFIRST_NAME(){ return this.FIRST_NAME; } 
		 public void setFIRST_NAME(String FIRST_NAME ){  this.FIRST_NAME=FIRST_NAME; } 
		 public String getLAST_NAME(){ return this.LAST_NAME; } 
		 public void setLAST_NAME(String LAST_NAME ){  this.LAST_NAME=LAST_NAME; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":ACTOR:"+this.ACTOR_ID;}

	 } //end ACTOR

	 public  class CUSTOMER_LIST implements Serializable,Cloneable {
		 private Integer ID ; 
 		 private String NAME ; 
 		 private String ADDRESS ; 
 		 private String ZIP_CODE ; 
 		 private String PHONE ; 
 		 private String CITY ; 
 		 private String COUNTRY ; 
 		 private String NOTES ; 
 		 private Integer SID ; 
 
		 public Integer getID(){ return this.ID; } 
		 public void setID(Integer ID ){  this.ID=ID; } 
		 public String getNAME(){ return this.NAME; } 
		 public void setNAME(String NAME ){  this.NAME=NAME; } 
		 public String getADDRESS(){ return this.ADDRESS; } 
		 public void setADDRESS(String ADDRESS ){  this.ADDRESS=ADDRESS; } 
		 public String getZIP_CODE(){ return this.ZIP_CODE; } 
		 public void setZIP_CODE(String ZIP_CODE ){  this.ZIP_CODE=ZIP_CODE; } 
		 public String getPHONE(){ return this.PHONE; } 
		 public void setPHONE(String PHONE ){  this.PHONE=PHONE; } 
		 public String getCITY(){ return this.CITY; } 
		 public void setCITY(String CITY ){  this.CITY=CITY; } 
		 public String getCOUNTRY(){ return this.COUNTRY; } 
		 public void setCOUNTRY(String COUNTRY ){  this.COUNTRY=COUNTRY; } 
		 public String getNOTES(){ return this.NOTES; } 
		 public void setNOTES(String NOTES ){  this.NOTES=NOTES; } 
		 public Integer getSID(){ return this.SID; } 
		 public void setSID(Integer SID ){  this.SID=SID; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 



	 } //end CUSTOMER_LIST

	 public  class STAFF_LIST implements Serializable,Cloneable {
		 private Integer ID ; 
 		 private String NAME ; 
 		 private String ADDRESS ; 
 		 private String ZIP_CODE ; 
 		 private String PHONE ; 
 		 private String CITY ; 
 		 private String COUNTRY ; 
 		 private Integer SID ; 
 
		 public Integer getID(){ return this.ID; } 
		 public void setID(Integer ID ){  this.ID=ID; } 
		 public String getNAME(){ return this.NAME; } 
		 public void setNAME(String NAME ){  this.NAME=NAME; } 
		 public String getADDRESS(){ return this.ADDRESS; } 
		 public void setADDRESS(String ADDRESS ){  this.ADDRESS=ADDRESS; } 
		 public String getZIP_CODE(){ return this.ZIP_CODE; } 
		 public void setZIP_CODE(String ZIP_CODE ){  this.ZIP_CODE=ZIP_CODE; } 
		 public String getPHONE(){ return this.PHONE; } 
		 public void setPHONE(String PHONE ){  this.PHONE=PHONE; } 
		 public String getCITY(){ return this.CITY; } 
		 public void setCITY(String CITY ){  this.CITY=CITY; } 
		 public String getCOUNTRY(){ return this.COUNTRY; } 
		 public void setCOUNTRY(String COUNTRY ){  this.COUNTRY=COUNTRY; } 
		 public Integer getSID(){ return this.SID; } 
		 public void setSID(Integer SID ){  this.SID=SID; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 



	 } //end STAFF_LIST

	 public  class ACTOR_INFO implements Serializable,Cloneable {
		 private Integer ACTOR_ID ; 
 		 private String FIRST_NAME ; 
 		 private String LAST_NAME ; 
 		 private String FILM_INFO ; 
 
		 public Integer getACTOR_ID(){ return this.ACTOR_ID; } 
		 public void setACTOR_ID(Integer ACTOR_ID ){  this.ACTOR_ID=ACTOR_ID; } 
		 public String getFIRST_NAME(){ return this.FIRST_NAME; } 
		 public void setFIRST_NAME(String FIRST_NAME ){  this.FIRST_NAME=FIRST_NAME; } 
		 public String getLAST_NAME(){ return this.LAST_NAME; } 
		 public void setLAST_NAME(String LAST_NAME ){  this.LAST_NAME=LAST_NAME; } 
		 public String getFILM_INFO(){ return this.FILM_INFO; } 
		 public void setFILM_INFO(String FILM_INFO ){  this.FILM_INFO=FILM_INFO; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 



	 } //end ACTOR_INFO

	 public  class FILM_LIST implements Serializable,Cloneable {
		 private Integer FID ; 
 		 private String TITLE ; 
 		 private String DESCRIPTION ; 
 		 private String CATEGORY ; 
 		 private BigDecimal PRICE ; 
 		 private Integer LENGTH ; 
 		 private String RATING ; 
 		 private String ACTORS ; 
 
		 public Integer getFID(){ return this.FID; } 
		 public void setFID(Integer FID ){  this.FID=FID; } 
		 public String getTITLE(){ return this.TITLE; } 
		 public void setTITLE(String TITLE ){  this.TITLE=TITLE; } 
		 public String getDESCRIPTION(){ return this.DESCRIPTION; } 
		 public void setDESCRIPTION(String DESCRIPTION ){  this.DESCRIPTION=DESCRIPTION; } 
		 public String getCATEGORY(){ return this.CATEGORY; } 
		 public void setCATEGORY(String CATEGORY ){  this.CATEGORY=CATEGORY; } 
		 public BigDecimal getPRICE(){ return this.PRICE; } 
		 public void setPRICE(BigDecimal PRICE ){  this.PRICE=PRICE; } 
		 public Integer getLENGTH(){ return this.LENGTH; } 
		 public void setLENGTH(Integer LENGTH ){  this.LENGTH=LENGTH; } 
		 public String getRATING(){ return this.RATING; } 
		 public void setRATING(String RATING ){  this.RATING=RATING; } 
		 public String getACTORS(){ return this.ACTORS; } 
		 public void setACTORS(String ACTORS ){  this.ACTORS=ACTORS; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 



	 } //end FILM_LIST

	 public  class SALES_BY_FILM_CATEGORY implements Serializable,Cloneable {
		 private String CATEGORY ; 
 		 private BigDecimal TOTAL_SALES ; 
 
		 public String getCATEGORY(){ return this.CATEGORY; } 
		 public void setCATEGORY(String CATEGORY ){  this.CATEGORY=CATEGORY; } 
		 public BigDecimal getTOTAL_SALES(){ return this.TOTAL_SALES; } 
		 public void setTOTAL_SALES(BigDecimal TOTAL_SALES ){  this.TOTAL_SALES=TOTAL_SALES; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 



	 } //end SALES_BY_FILM_CATEGORY

	 public  class CITY implements Serializable,Cloneable {
		 private Integer CITY_ID ; 
 		 private String CITY ; 
 		 private Integer COUNTRY_ID ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getCITY_ID(){ return this.CITY_ID; } 
		 public void setCITY_ID(Integer CITY_ID ){  this.CITY_ID=CITY_ID; } 
		 public String getCITY(){ return this.CITY; } 
		 public void setCITY(String CITY ){  this.CITY=CITY; } 
		 public Integer getCOUNTRY_ID(){ return this.COUNTRY_ID; } 
		 public void setCOUNTRY_ID(Integer COUNTRY_ID ){  this.COUNTRY_ID=COUNTRY_ID; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":CITY:"+this.CITY_ID;}

	 } //end CITY

	 public  class COUNTRY implements Serializable,Cloneable {
		 private Integer COUNTRY_ID ; 
 		 private String COUNTRY ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getCOUNTRY_ID(){ return this.COUNTRY_ID; } 
		 public void setCOUNTRY_ID(Integer COUNTRY_ID ){  this.COUNTRY_ID=COUNTRY_ID; } 
		 public String getCOUNTRY(){ return this.COUNTRY; } 
		 public void setCOUNTRY(String COUNTRY ){  this.COUNTRY=COUNTRY; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":COUNTRY:"+this.COUNTRY_ID;}

	 } //end COUNTRY

	 public  class INVENTORY implements Serializable,Cloneable {
		 private Integer INVENTORY_ID ; 
 		 private Integer FILM_ID ; 
 		 private Integer STORE_ID ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getINVENTORY_ID(){ return this.INVENTORY_ID; } 
		 public void setINVENTORY_ID(Integer INVENTORY_ID ){  this.INVENTORY_ID=INVENTORY_ID; } 
		 public Integer getFILM_ID(){ return this.FILM_ID; } 
		 public void setFILM_ID(Integer FILM_ID ){  this.FILM_ID=FILM_ID; } 
		 public Integer getSTORE_ID(){ return this.STORE_ID; } 
		 public void setSTORE_ID(Integer STORE_ID ){  this.STORE_ID=STORE_ID; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":INVENTORY:"+this.INVENTORY_ID;}

	 } //end INVENTORY

	 public  class NICER_BUT_SLOWER_FILM_LIST implements Serializable,Cloneable {
		 private Integer FID ; 
 		 private String TITLE ; 
 		 private String DESCRIPTION ; 
 		 private String CATEGORY ; 
 		 private BigDecimal PRICE ; 
 		 private Integer LENGTH ; 
 		 private String RATING ; 
 		 private String ACTORS ; 
 
		 public Integer getFID(){ return this.FID; } 
		 public void setFID(Integer FID ){  this.FID=FID; } 
		 public String getTITLE(){ return this.TITLE; } 
		 public void setTITLE(String TITLE ){  this.TITLE=TITLE; } 
		 public String getDESCRIPTION(){ return this.DESCRIPTION; } 
		 public void setDESCRIPTION(String DESCRIPTION ){  this.DESCRIPTION=DESCRIPTION; } 
		 public String getCATEGORY(){ return this.CATEGORY; } 
		 public void setCATEGORY(String CATEGORY ){  this.CATEGORY=CATEGORY; } 
		 public BigDecimal getPRICE(){ return this.PRICE; } 
		 public void setPRICE(BigDecimal PRICE ){  this.PRICE=PRICE; } 
		 public Integer getLENGTH(){ return this.LENGTH; } 
		 public void setLENGTH(Integer LENGTH ){  this.LENGTH=LENGTH; } 
		 public String getRATING(){ return this.RATING; } 
		 public void setRATING(String RATING ){  this.RATING=RATING; } 
		 public String getACTORS(){ return this.ACTORS; } 
		 public void setACTORS(String ACTORS ){  this.ACTORS=ACTORS; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 



	 } //end NICER_BUT_SLOWER_FILM_LIST

	 public  class CATEGORY implements Serializable,Cloneable {
		 private Integer CATEGORY_ID ; 
 		 private String NAME ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getCATEGORY_ID(){ return this.CATEGORY_ID; } 
		 public void setCATEGORY_ID(Integer CATEGORY_ID ){  this.CATEGORY_ID=CATEGORY_ID; } 
		 public String getNAME(){ return this.NAME; } 
		 public void setNAME(String NAME ){  this.NAME=NAME; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":CATEGORY:"+this.CATEGORY_ID;}

	 } //end CATEGORY

	 public  class ADDRESS implements Serializable,Cloneable {
		 private Integer ADDRESS_ID ; 
 		 private String ADDRESS ; 
 		 private String ADDRESS2 ; 
 		 private String DISTRICT ; 
 		 private Integer CITY_ID ; 
 		 private String POSTAL_CODE ; 
 		 private String PHONE ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getADDRESS_ID(){ return this.ADDRESS_ID; } 
		 public void setADDRESS_ID(Integer ADDRESS_ID ){  this.ADDRESS_ID=ADDRESS_ID; } 
		 public String getADDRESS(){ return this.ADDRESS; } 
		 public void setADDRESS(String ADDRESS ){  this.ADDRESS=ADDRESS; } 
		 public String getADDRESS2(){ return this.ADDRESS2; } 
		 public void setADDRESS2(String ADDRESS2 ){  this.ADDRESS2=ADDRESS2; } 
		 public String getDISTRICT(){ return this.DISTRICT; } 
		 public void setDISTRICT(String DISTRICT ){  this.DISTRICT=DISTRICT; } 
		 public Integer getCITY_ID(){ return this.CITY_ID; } 
		 public void setCITY_ID(Integer CITY_ID ){  this.CITY_ID=CITY_ID; } 
		 public String getPOSTAL_CODE(){ return this.POSTAL_CODE; } 
		 public void setPOSTAL_CODE(String POSTAL_CODE ){  this.POSTAL_CODE=POSTAL_CODE; } 
		 public String getPHONE(){ return this.PHONE; } 
		 public void setPHONE(String PHONE ){  this.PHONE=PHONE; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":ADDRESS:"+this.ADDRESS_ID;}

	 } //end ADDRESS

	 public  class STAFF implements Serializable,Cloneable {
		 private Integer STAFF_ID ; 
 		 private String FIRST_NAME ; 
 		 private String LAST_NAME ; 
 		 private Integer ADDRESS_ID ; 
 		 private Byte PICTURE ; 
 		 private String EMAIL ; 
 		 private Integer STORE_ID ; 
 		 private Byte ACTIVE ; 
 		 private String USERNAME ; 
 		 private String PASSWORD ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getSTAFF_ID(){ return this.STAFF_ID; } 
		 public void setSTAFF_ID(Integer STAFF_ID ){  this.STAFF_ID=STAFF_ID; } 
		 public String getFIRST_NAME(){ return this.FIRST_NAME; } 
		 public void setFIRST_NAME(String FIRST_NAME ){  this.FIRST_NAME=FIRST_NAME; } 
		 public String getLAST_NAME(){ return this.LAST_NAME; } 
		 public void setLAST_NAME(String LAST_NAME ){  this.LAST_NAME=LAST_NAME; } 
		 public Integer getADDRESS_ID(){ return this.ADDRESS_ID; } 
		 public void setADDRESS_ID(Integer ADDRESS_ID ){  this.ADDRESS_ID=ADDRESS_ID; } 
		 public Byte getPICTURE(){ return this.PICTURE; } 
		 public void setPICTURE(Byte PICTURE ){  this.PICTURE=PICTURE; } 
		 public String getEMAIL(){ return this.EMAIL; } 
		 public void setEMAIL(String EMAIL ){  this.EMAIL=EMAIL; } 
		 public Integer getSTORE_ID(){ return this.STORE_ID; } 
		 public void setSTORE_ID(Integer STORE_ID ){  this.STORE_ID=STORE_ID; } 
		 public Byte getACTIVE(){ return this.ACTIVE; } 
		 public void setACTIVE(Byte ACTIVE ){  this.ACTIVE=ACTIVE; } 
		 public String getUSERNAME(){ return this.USERNAME; } 
		 public void setUSERNAME(String USERNAME ){  this.USERNAME=USERNAME; } 
		 public String getPASSWORD(){ return this.PASSWORD; } 
		 public void setPASSWORD(String PASSWORD ){  this.PASSWORD=PASSWORD; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":STAFF:"+this.STAFF_ID;}

	 } //end STAFF

	 public  class STORE implements Serializable,Cloneable {
		 private Integer STORE_ID ; 
 		 private Integer MANAGER_STAFF_ID ; 
 		 private Integer ADDRESS_ID ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getSTORE_ID(){ return this.STORE_ID; } 
		 public void setSTORE_ID(Integer STORE_ID ){  this.STORE_ID=STORE_ID; } 
		 public Integer getMANAGER_STAFF_ID(){ return this.MANAGER_STAFF_ID; } 
		 public void setMANAGER_STAFF_ID(Integer MANAGER_STAFF_ID ){  this.MANAGER_STAFF_ID=MANAGER_STAFF_ID; } 
		 public Integer getADDRESS_ID(){ return this.ADDRESS_ID; } 
		 public void setADDRESS_ID(Integer ADDRESS_ID ){  this.ADDRESS_ID=ADDRESS_ID; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":STORE:"+this.STORE_ID;}

	 } //end STORE

	 public  class CUSTOMER implements Serializable,Cloneable {
		 private Integer CUSTOMER_ID ; 
 		 private Integer STORE_ID ; 
 		 private String FIRST_NAME ; 
 		 private String LAST_NAME ; 
 		 private String EMAIL ; 
 		 private Integer ADDRESS_ID ; 
 		 private Byte ACTIVE ; 
 		 private Date CREATE_DATE ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getCUSTOMER_ID(){ return this.CUSTOMER_ID; } 
		 public void setCUSTOMER_ID(Integer CUSTOMER_ID ){  this.CUSTOMER_ID=CUSTOMER_ID; } 
		 public Integer getSTORE_ID(){ return this.STORE_ID; } 
		 public void setSTORE_ID(Integer STORE_ID ){  this.STORE_ID=STORE_ID; } 
		 public String getFIRST_NAME(){ return this.FIRST_NAME; } 
		 public void setFIRST_NAME(String FIRST_NAME ){  this.FIRST_NAME=FIRST_NAME; } 
		 public String getLAST_NAME(){ return this.LAST_NAME; } 
		 public void setLAST_NAME(String LAST_NAME ){  this.LAST_NAME=LAST_NAME; } 
		 public String getEMAIL(){ return this.EMAIL; } 
		 public void setEMAIL(String EMAIL ){  this.EMAIL=EMAIL; } 
		 public Integer getADDRESS_ID(){ return this.ADDRESS_ID; } 
		 public void setADDRESS_ID(Integer ADDRESS_ID ){  this.ADDRESS_ID=ADDRESS_ID; } 
		 public Byte getACTIVE(){ return this.ACTIVE; } 
		 public void setACTIVE(Byte ACTIVE ){  this.ACTIVE=ACTIVE; } 
		 public Date getCREATE_DATE(){ return this.CREATE_DATE; } 
		 public void setCREATE_DATE(Date CREATE_DATE ){  this.CREATE_DATE=CREATE_DATE; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":CUSTOMER:"+this.CUSTOMER_ID;}

	 } //end CUSTOMER

	 public  class RENTAL implements Serializable,Cloneable {
		 private Integer RENTAL_ID ; 
 		 private Date RENTAL_DATE ; 
 		 private Integer INVENTORY_ID ; 
 		 private Integer CUSTOMER_ID ; 
 		 private Date RETURN_DATE ; 
 		 private Integer STAFF_ID ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getRENTAL_ID(){ return this.RENTAL_ID; } 
		 public void setRENTAL_ID(Integer RENTAL_ID ){  this.RENTAL_ID=RENTAL_ID; } 
		 public Date getRENTAL_DATE(){ return this.RENTAL_DATE; } 
		 public void setRENTAL_DATE(Date RENTAL_DATE ){  this.RENTAL_DATE=RENTAL_DATE; } 
		 public Integer getINVENTORY_ID(){ return this.INVENTORY_ID; } 
		 public void setINVENTORY_ID(Integer INVENTORY_ID ){  this.INVENTORY_ID=INVENTORY_ID; } 
		 public Integer getCUSTOMER_ID(){ return this.CUSTOMER_ID; } 
		 public void setCUSTOMER_ID(Integer CUSTOMER_ID ){  this.CUSTOMER_ID=CUSTOMER_ID; } 
		 public Date getRETURN_DATE(){ return this.RETURN_DATE; } 
		 public void setRETURN_DATE(Date RETURN_DATE ){  this.RETURN_DATE=RETURN_DATE; } 
		 public Integer getSTAFF_ID(){ return this.STAFF_ID; } 
		 public void setSTAFF_ID(Integer STAFF_ID ){  this.STAFF_ID=STAFF_ID; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":RENTAL:"+this.RENTAL_ID;}

	 } //end RENTAL

	 public  class FILM_ACTOR implements Serializable,Cloneable {
		 private Integer ACTOR_ID ; 
 		 private Integer FILM_ID ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getACTOR_ID(){ return this.ACTOR_ID; } 
		 public void setACTOR_ID(Integer ACTOR_ID ){  this.ACTOR_ID=ACTOR_ID; } 
		 public Integer getFILM_ID(){ return this.FILM_ID; } 
		 public void setFILM_ID(Integer FILM_ID ){  this.FILM_ID=FILM_ID; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":FILM_ACTOR:"+this.FILM_ID;}

	 } //end FILM_ACTOR

	 public  class FILM_CATEGORY implements Serializable,Cloneable {
		 private Integer FILM_ID ; 
 		 private Integer CATEGORY_ID ; 
 		 private Date LAST_UPDATE ; 
 
		 public Integer getFILM_ID(){ return this.FILM_ID; } 
		 public void setFILM_ID(Integer FILM_ID ){  this.FILM_ID=FILM_ID; } 
		 public Integer getCATEGORY_ID(){ return this.CATEGORY_ID; } 
		 public void setCATEGORY_ID(Integer CATEGORY_ID ){  this.CATEGORY_ID=CATEGORY_ID; } 
		 public Date getLAST_UPDATE(){ return this.LAST_UPDATE; } 
		 public void setLAST_UPDATE(Date LAST_UPDATE ){  this.LAST_UPDATE=LAST_UPDATE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":FILM_CATEGORY:"+this.CATEGORY_ID;}

	 } //end FILM_CATEGORY

	 public  class SALES_BY_STORE implements Serializable,Cloneable {
		 private String STORE ; 
 		 private String MANAGER ; 
 		 private BigDecimal TOTAL_SALES ; 
 
		 public String getSTORE(){ return this.STORE; } 
		 public void setSTORE(String STORE ){  this.STORE=STORE; } 
		 public String getMANAGER(){ return this.MANAGER; } 
		 public void setMANAGER(String MANAGER ){  this.MANAGER=MANAGER; } 
		 public BigDecimal getTOTAL_SALES(){ return this.TOTAL_SALES; } 
		 public void setTOTAL_SALES(BigDecimal TOTAL_SALES ){  this.TOTAL_SALES=TOTAL_SALES; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 



	 } //end SALES_BY_STORE




} //end
