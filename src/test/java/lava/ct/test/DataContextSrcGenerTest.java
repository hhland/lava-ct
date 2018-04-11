package lava.ct.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Driver;

import lava.rt.linq.DataContextSrcGener;

public class DataContextSrcGenerTest {

	Connection connection;
	
	@Before
	public void setUp() throws Exception {
		Class.forName(Driver.class.getName());
	    String url="jdbc:mysql://192.168.0.161:3306/blcpara?useUnicode=true&characterEncoding=UTF-8"
	    		,user="para_admin"
	    		,password="nfha_505"
	    		;
		connection= DriverManager.getConnection(url, user, password);
	}

	@Test
	public void test() throws SQLException {
		DataContextSrcGener dataContextSrcGener=new DataContextSrcGener(connection);
		String src=dataContextSrcGener.toSrc(SenDataContext.class,"ID");
		System.out.println(src);
	}

}
