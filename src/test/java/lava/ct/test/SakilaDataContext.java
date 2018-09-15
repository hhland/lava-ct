package lava.ct.test; 

import java.lang.String; 
import java.lang.Integer; 
import java.lang.Float; 
import java.lang.Double; 
import java.util.Date; 
import java.math.BigDecimal; 
import java.lang.Byte; 
import java.lang.Boolean; 
import java.lang.Byte; 
import lava.rt.linq.Table; 
import lava.rt.linq.View; 
import lava.rt.linq.Column ; 
import java.io.Serializable; 
import java.lang.Cloneable; 
import javax.sql.DataSource; 


public class SakilaDataContext extends lava.rt.linq.DataContext{ 

	@Override
	protected Class thisClass() {return this.getClass(); }

	 public SakilaDataContext(DataSource dataSource){ super(dataSource);  } 

	 public final Table<PERSON> tablePERSON=createTable(PERSON.class,"PERSON","ID");
	 public final Table<SYS_FILE> tableSYS_FILE=createTable(SYS_FILE.class,"SYS_FILE","F_ID");




	 public  class PERSON implements Serializable,Cloneable {
		 private String ID ; 
 		 private String NAME ; 
 		 private Integer AGE ; 
 
		 public String getID(){ return this.ID; } 
		 public void setID(String ID ){  this.ID=ID; } 
		 public String getNAME(){ return this.NAME; } 
		 public void setNAME(String NAME ){  this.NAME=NAME; } 
		 public Integer getAGE(){ return this.AGE; } 
		 public void setAGE(Integer AGE ){  this.AGE=AGE; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":PERSON:"+this.ID;}

	 } //end PERSON

	 public  class SYS_FILE implements Serializable,Cloneable {
		 private String F_ID ; 
 		 private String F_ORI_NAME ; 
 		 private String F_FILE_SIZE ; 
 		 private String F_PATH ; 
 		 private String F_FID ; 
 
		 public String getF_ID(){ return this.F_ID; } 
		 public void setF_ID(String F_ID ){  this.F_ID=F_ID; } 
		 public String getF_ORI_NAME(){ return this.F_ORI_NAME; } 
		 public void setF_ORI_NAME(String F_ORI_NAME ){  this.F_ORI_NAME=F_ORI_NAME; } 
		 public String getF_FILE_SIZE(){ return this.F_FILE_SIZE; } 
		 public void setF_FILE_SIZE(String F_FILE_SIZE ){  this.F_FILE_SIZE=F_FILE_SIZE; } 
		 public String getF_PATH(){ return this.F_PATH; } 
		 public void setF_PATH(String F_PATH ){  this.F_PATH=F_PATH; } 
		 public String getF_FID(){ return this.F_FID; } 
		 public void setF_FID(String F_FID ){  this.F_FID=F_FID; } 


		@Override
		public boolean equals(Object obj) {return this.toString().equals(obj.toString());} 

		@Override
		public String toString() {return this.getClass().getName()+":SYS_FILE:"+this.F_ID;}

	 } //end SYS_FILE

	public final static Criteria CRITERIA=new Criteria();

	public  static class Criteria{ 

		private Criteria() {} 

		public static final Column 
		F_FILE_SIZE = new Column("F_FILE_SIZE"),
		F_ID = new Column("F_ID"),
		ID = new Column("ID"),
		F_ORI_NAME = new Column("F_ORI_NAME"),
		F_PATH = new Column("F_PATH"),
		F_FID = new Column("F_FID"),
		NAME = new Column("NAME"),
		AGE = new Column("AGE")
		;

	} 




} //end
