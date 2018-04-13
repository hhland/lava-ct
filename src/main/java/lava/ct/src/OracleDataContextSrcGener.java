package lava.ct.src;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class OracleDataContextSrcGener extends DataContextSrcGener{

	public OracleDataContextSrcGener(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<String> loadViews(String databaseName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> loadTablesPks(String databaseName) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
