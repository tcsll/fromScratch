package other;

import java.sql.*;

public class ModifyTable {
	String datasourceName ;
	String SQL, message ;

	public ModifyTable( String strName ) {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			datasourceName = strName.trim();

		} catch (Exception e) {
		}
	}

	public void setSQL(String SQL) {
		this.SQL = SQL;
	}

	public void setDatasourceName(String s) {
		datasourceName = s.trim();
	}

	public String modifyRecord() {
		Connection con = null;
		Statement sql = null;
		try {
			String uri = "jdbc:odbc:" + datasourceName;
			String id = "";
			String password = "";
			con = DriverManager.getConnection(uri, id, password);
			sql = con.createStatement();
			sql.execute(SQL);
			message = "²Ù×÷³É¹¦";
			con.close();
		} catch (SQLException e) {
			message = e.toString();
		}
		return message;
	}
}
