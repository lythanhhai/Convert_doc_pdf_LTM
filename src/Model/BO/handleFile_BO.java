package Model.BO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.sql.SQLException;

import Model.DAO.*;

public class handleFile_BO {
	
	handleFile_DAO handleFile = new handleFile_DAO();
	public void insertUrl_BO(int id, String userName) throws ClassNotFoundException, SQLException
	{
		handleFile.insertUrl_DAO(id, userName);
	}
	public void updateUrl_BO(int id, String url) throws ClassNotFoundException, SQLException
	{
		handleFile.updateUrl_DAO(id, url);
	}
	public void removeUrl_BO(int id) throws ClassNotFoundException, SQLException
	{
		handleFile.removeUrl_DAO(id);
	}
	
	public int getIdMax_BO() throws ClassNotFoundException, SQLException
	{
		return handleFile.getIDMax_DAO();
	}
	
	public void threadHandleFile(InputStream fileContent)
	{
		try
		{
			Handle handle = new Handle();
			handle.start();
		}
		catch(Exception err)
		{
			
		}
	}
}

class Handle extends Thread {
	

	public Handle() {
	}

	public void run() {
		try
		{

		}
		catch (Exception e)
		{
			
		}
	}
}
