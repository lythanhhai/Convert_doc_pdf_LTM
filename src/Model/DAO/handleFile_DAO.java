package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Model.DAO.*;

public class handleFile_DAO {
	DBConnection db = new DBConnection();
	public void insertUrl_DAO(int id, String userName) throws ClassNotFoundException, SQLException
	{
		
		Connection con = db.Connection_DAO();
		Statement stm = con.createStatement();
		
		String sql = "insert into urlfile values('" + String.valueOf(id) + "','" + userName + "','" + "" + "','" + String.valueOf(0) + "')";
		stm.executeUpdate(sql);

	}
	
	public void updateUrl_DAO(int id, String url) throws ClassNotFoundException, SQLException
	{
		Connection con = db.Connection_DAO();
		Statement stm = con.createStatement();
		
		String sql = "update urlfile set url = '" + url + "', status = 1 where id = '" + String.valueOf(id) + "'";
		
		stm.executeUpdate(sql);
		
	}
	
	public void removeUrl_DAO(int id) throws ClassNotFoundException, SQLException
	{
		Connection con = db.Connection_DAO();
		Statement stm = con.createStatement();
		
		String sql = "delete from urlfile where id = '" + String.valueOf(id) + "'";
		
		stm.executeUpdate(sql);
		
	}
	
	public int getIDMax_DAO() throws ClassNotFoundException, SQLException
	{
		Connection con = db.Connection_DAO();
		Statement stm = con.createStatement();
		
		String sql = "select * from urlfile";
		
		ResultSet rs = 	stm.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int socot = rsmd.getColumnCount();
		
		int Max = 1;
		while(rs.next())
		{
			if(Max < rs.getInt(1))
			{
				Max = rs.getInt(1);
			}
		}
		return Max;
	}
}
