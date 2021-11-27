package model.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.Bean.Account;

public class Checkup {
public static Account Checkup(String id) {
		
		List<Account> l = new ArrayList<Account>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Ket Noi CSDL");
			String url = "jdbc:mysql://127.0.0.1:3307/btl";
			Connection con = (Connection)DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement)con.createStatement();
			String sql = "select * from account;";
			ResultSet rs = stmt.executeQuery(sql);
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
		
			
			
			 while(rs.next())
				 
			{    	Account a1 = new Account();
					  a1.setId(rs.getObject(1).toString());   
					  a1.setPass(rs.getObject(2).toString());
					 
					 
			 l.add(a1);
			}
			rs.close();
			stmt.close();			
		}
		catch(Exception a)
		{
			System.out.println("Error " + a);
		}	
		
		
		
		for (Account a : l) {
			if (a.getId().equals(id) ){
				return a;
			}
		}
		
		return null;
	}

}
