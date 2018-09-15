package lava.ct.test;

import static org.junit.Assert.*;

import java.util.List;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PERSIST_STORE;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import lava.ct.test.SakilaDataContext.PERSON;

import lava.rt.linq.DataContext;
import lava.rt.linq.Table;

public class DataContextTest {

	SakilaDataContext dataContext;
	
	
	@Before
	public void setUp() throws Exception {
		 String url="jdbc:mysql://192.168.1.88:3306/test?useUnicode=true&characterEncoding=UTF-8"
		    		,user="root"
		    		,password="root"
		    		;
		 MysqlDataSource dataSource=new MysqlDataSource();
		 
		 dataSource.setURL(url);
		 dataSource.setUser(user);
		 dataSource.setPassword(password);
		 dataSource.setUseUnicode(true);
		 
		 dataContext=new SakilaDataContext(dataSource);
		 dataContext.DEBUG=true;
		// table=dataContext.getTable(cls);
	}

	
	
	//@Test
	public void testInsert() throws SQLException {
		PERSON model=dataContext. new PERSON();
		model.setAGE(10);
		model.setID("100");
		float re=dataContext.tablePERSON.insert(model);
		assertEquals(1, re,0);
	}
	
	//@Test
	public void testUpdate() throws SQLException {
		Table<PERSON>  table=dataContext.tablePERSON;
		PERSON model=table.load(3);
		model.setNAME("方雄");
        
		float re=table.update(model);
		assertEquals(1, re,0);
	}
	
	@Test
	public void testSelect() throws SQLException {
	    SakilaDataContext.Criteria cr=dataContext.CRITERIA;
		List<PERSON> list=dataContext.tablePERSON.select("where "+ cr.NAME.notBetween(null,null),"西","方");
		assertTrue(list.size()>0);
	}
//	
//	
//	@Test
//	public void testDelete() throws SQLException {
//		ACTOR model=table.loadLast();
//		float re=table.delete(model);
//		assertEquals(1, re,0);
//	}
	

}
