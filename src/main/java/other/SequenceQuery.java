package other;

import java.sql.*;
import java.util.*;

public class SequenceQuery extends Query {
	public SequenceQuery(String strName ){
		try { 
			setDatasourceName(strName);
		}
		catch(Exception e) {
			System.out.print(e);
		}
	}
	
	public ArrayList<StringBuffer> getQueryResult() {
		 
		setSQL("SELECT * FROM " + tableName);
		return super.getQueryResult();
	}

}
