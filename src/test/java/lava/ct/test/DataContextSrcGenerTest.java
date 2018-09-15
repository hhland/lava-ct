package lava.ct.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Driver;

import lava.ct.src.datacontext.DataContextSrcGener;
import lava.ct.src.datacontext.MySQLDataContextSrcGener;



public class DataContextSrcGenerTest {

	Connection connection;
	
	@Before
	public void setUp() throws Exception {
		Class.forName(Driver.class.getName());
	    String url="jdbc:mysql://192.168.1.88:3306/test?useUnicode=true&characterEncoding=UTF-8"
	    		,user="root"
	    		,password="root"
	    		;
		connection= DriverManager.getConnection(url, user, password);
	}

	@Test
	public void test() throws SQLException {
		DataContextSrcGener dataContextSrcGener=new MySQLDataContextSrcGener(connection);
		String src=dataContextSrcGener.toSrc(SakilaDataContext.class,"test");
		System.out.println(src);
	}

}
