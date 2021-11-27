package model.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.Bean.Account;

public class insertDAO {
public static String CheckSignUp(String id, String pw) {
		Account account= Checkup.Checkup(id);
		if(account!=null)
		{
			return "NOTOK";
		}
		else
		{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Ket Noi CSDL");
			String url = "jdbc:mysql://127.0.0.1:3307/btl";
			Connection con = (Connection)DriverManager.getConnection(url, "root", "");
			Statement stmt = (Statement)con.createStatement();
			String sql = "Insert into account values('"+id+"','"+pw+"');";
			
			
			 stmt.executeUpdate(sql);
			 stmt.close();
			
		}catch (Exception e) {
			
		}
	}
		return "OK";
}

}
