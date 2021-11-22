package Model.BO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.sql.SQLException;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.ToPdfParameterList;

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
	
	public void convert()
	{
		try 
		{
			//Load the Word Document
			Document doc = new Document();
			
			doc.loadFromFile("D:\\Programming\\java\\testSpire\\gitBasic.docx");
			
			//create an instance of ToPdfParameterList.
			ToPdfParameterList ppl=new ToPdfParameterList();
			
			//embeds full fonts by default when IsEmbeddedAllFonts is set to true.
			ppl.isEmbeddedAllFonts(true);
			
			//set setDisableLink to true to remove the hyperlink effect for the result PDF page.
			//set setDisableLink to false to preserve the hyperlink effect for the result PDF page.
			ppl.setDisableLink(true);
			
			//Set the output image quality as 40% of the original image. 80% is the default setting.
			doc.setJPEGQuality(40);
			
			//Save to file.
			doc.saveToFile("D:\\Programming\\java\\testSpire\\toPDF1.pdf", FileFormat.PDF);
			
			//System.out.println("oke");
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
			//Load the Word Document
	        Document doc = new Document();
	        
	        doc.loadFromFile("D:\\Programming\\java\\testSpire\\gitBasic.docx");

	        //create an instance of ToPdfParameterList.
	        ToPdfParameterList ppl=new ToPdfParameterList();

	        //embeds full fonts by default when IsEmbeddedAllFonts is set to true.
	        ppl.isEmbeddedAllFonts(true);

	        //set setDisableLink to true to remove the hyperlink effect for the result PDF page.
	        //set setDisableLink to false to preserve the hyperlink effect for the result PDF page.
	        ppl.setDisableLink(true);

	        //Set the output image quality as 40% of the original image. 80% is the default setting.
	        doc.setJPEGQuality(40);

	        //Save to file.
	        doc.saveToFile("D:\\Programming\\java\\testSpire\\toPDF1.pdf", FileFormat.PDF);
	        
	        System.out.println("oke");
		}
		catch (Exception e)
		{
			
		}
	}
}
