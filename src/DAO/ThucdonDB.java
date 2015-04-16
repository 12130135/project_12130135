package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThucdonDB {
	public static  ResultSet getdata(){
		ResultSet rs=null;
		String sqlCommand="select * from thucdon ";
		PreparedStatement pst;
		try {
			pst=ConnectDB.getConnection().prepareStatement(sqlCommand);
			
			rs=pst.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
		
	}
}
