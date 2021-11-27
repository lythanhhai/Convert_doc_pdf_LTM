package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Bean.Account;
import model.Bean.urlFile;
import model.DAO.*;

public class handleFile_DAO {
	DBConnection db = new DBConnection();
	public void insertUrl_DAO(int id, String userName,String filename) throws ClassNotFoundException, SQLException
	{
		
		Connection con = db.Connection_DAO();
		Statement stm = con.createStatement();
		
		String sql = "insert into urlfile values('" + String.valueOf(id) + "','" + userName + "','" +filename + "','" + String.valueOf(0) + "')";
		stm.executeUpdate(sql);

	}
	
	public void updateUrl_DAO(int id, String url) throws ClassNotFoundException, SQLException
	{
		Connection con = db.Connection_DAO();
		Statement stm = con.createStatement();
		
		String sql = "update urlfile set url = '" + url + "', status = '1' where id = '" + String.valueOf(id) + "'";
		
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
	public ArrayList<urlFile> geturl_DAO( String username) throws ClassNotFoundException, SQLException
	{
		Connection con = db.Connection_DAO();
		Statement stm = con.createStatement();
		ArrayList<urlFile> l = new ArrayList<urlFile>();
		String sql = "select * from urlfile where username='"+username+"'";
		
		ResultSet rs = 	stm.executeQuery(sql);
		ResultSetMetaData rsmd = rs.getMetaData();
		int socot = rsmd.getColumnCount();
		System.out.print(socot);
		
		
		while(rs.next())
		{

			 	urlFile a1 = new urlFile();
			         a1.setId(Integer.parseInt(rs.getObject("id").toString()));
			         System.out.print((rs.getObject("id").toString()));
					  a1.setUrl(rs.getObject("url").toString());
					  System.out.print((rs.getObject("url").toString()));
					  a1.setUserName(rs.getObject("username").toString());
					  System.out.print((rs.getObject("username").toString()));
					  a1.setStatus(Integer.parseInt(rs.getObject("status").toString()));
					  System.out.print((rs.getObject("status").toString()));
					 
			 l.add(a1);
	
			
		
	}
		return l;
	
}
}
