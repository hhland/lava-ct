package lava.ct.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import lava.ct.test.SakilaDataContext.ACTOR;
import lava.rt.linq.DataContext;
import lava.rt.linq.Table;

public class DataContextTest {

	SakilaDataContext dataContext;
	
	Table<ACTOR> table;
	Class cls=ACTOR.class;
	
	@Before
	public void setUp() throws Exception {
		 String url="jdbc:mysql://lava-ct-test-dbhost:3306/sakila?useUnicode=true&characterEncoding=UTF-8"
		    		,user="root"
		    		,password="nfha_505"
		    		;
		 MysqlDataSource dataSource=new MysqlDataSource();
		 
		 dataSource.setURL(url);
		 dataSource.setUser(user);
		 dataSource.setPassword(password);
		 dataSource.setUseUnicode(true);
		 
		 dataContext=new SakilaDataContext(dataSource);
		 table=dataContext.getTable(cls);
	}

	
	
	@Test
	public void testInsert() throws SQLException {
		ACTOR model=dataContext.new ACTOR();
		model.setFIRST_NAME("fist_name");
		model.setLAST_NAME("last_name");
		model.setLAST_UPDATE(Calendar.getInstance().getTime());
		float re=table.insert(model);
		assertEquals(1, re,0);
	}
	
	@Test
	public void testUpdate() throws SQLException {
		ACTOR model=table.load(1);
		model.setFIRST_NAME(model.getFIRST_NAME()+"_xxx");
		model.setLAST_NAME(model.getLAST_NAME()+"_xxx");
		model.setLAST_UPDATE(Calendar.getInstance().getTime());
		float re=table.update(model);
		assertEquals(1, re,0);
	}
	
	
	@Test
	public void testDelete() throws SQLException {
		ACTOR model=table.load(2);
		float re=table.delete(model);
		assertEquals(1, re,0);
	}
	

}
