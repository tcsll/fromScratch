package other;

import java.sql.*;
import java.util.*;

public class Example14_8 {
	public static void main(String args[]) {
		ModifyTable modify = new ModifyTable("moon");
		modify.setDatasourceName("moon");
		modify.setSQL("UPDATE message SET 品名='长虹电视' WHERE 货号='c324'");
		String backMess = modify.modifyRecord();
		System.out.println(backMess);
		Query query = new SequenceQuery("moon");
		//query.setDatasourceName("moon");
		query.setTableName("message");
		ArrayList<StringBuffer> result = query.getQueryResult();
		for (StringBuffer str : result) {
			System.out.println(str);
		}
	}

}