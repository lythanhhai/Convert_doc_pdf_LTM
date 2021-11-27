package model.BO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableStringConverter;

import org.apache.commons.codec.binary.Hex;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.mysql.jdbc.StringUtils;
import com.spire.doc.Document;
import com.spire.doc.FileFormat;
import com.spire.doc.ToPdfParameterList;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;

import model.Bean.urlFile;
import model.DAO.*;

public class handleFile_BO {
	
	handleFile_DAO handleFile = new handleFile_DAO();
	public void insertUrl_BO(int id, String userName,String fileName) throws ClassNotFoundException, SQLException
	{
		handleFile.insertUrl_DAO(id, userName,fileName);
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
	public ArrayList<urlFile> geturl_BO(String username) throws ClassNotFoundException, SQLException
	{
		return handleFile.geturl_DAO(username);
	}
	
	public void threadHandleFile(int id, String fileName, InputStream fileContent)
	{
		try
		{
			Handle handle = new Handle(id, fileName, fileContent);
			handle.start();
		}
		catch(Exception err)
		{
			
		}
	}
	
}

class Handle extends Thread {
	
	InputStream fileContent;
	int id;
	String fileName;
	public Handle(int id, String fileName, InputStream fileContent) {
		this.fileContent = fileContent;
		this.id = id;
		this.fileName = fileName;
	}

	public void run() {
		 handleFile_DAO handleFile1 = new handleFile_DAO();
		
		try
		{
//			//Load the Word Document
//	        Document doc = new Document();
//	       
//	        doc.loadFromStream(this.fileContent, FileFormat.Docx);
//	        //doc.loadFromFile("D:\\Programming\\java\\testSpire\\gitBasic.docx");
//
//	        //create an instance of ToPdfParameterList.
//	        ToPdfParameterList ppl=new ToPdfParameterList();
//
//	        //embeds full fonts by default when IsEmbeddedAllFonts is set to true.
//	        ppl.isEmbeddedAllFonts(true);
//
//	        //set setDisableLink to true to remove the hyperlink effect for the result PDF page.
//	        //set setDisableLink to false to preserve the hyperlink effect for the result PDF page.
//	        ppl.setDisableLink(true);
//
//	        //Set the output image quality as 40% of the original image. 80% is the default setting.
//	        doc.setJPEGQuality(40);
//
//	        //Save to file.
//	        //doc.saveToFile("D:\\Programming\\java\\testSpire\\toPDF1.pdf", FileFormat.PDF);
////	        String name = "";
////	        for (byte b : this.fileName.getBytes()) {
////                name += String.valueOf(Integer.toHexString(b & 255)) + "  ";
////	        }
//	        
			
			
			try {
				String name = "";
		        for (byte b : this.fileName.getBytes()) {
		            name += String.valueOf(Integer.toHexString(b & 255));
		        }
	    		//InputStream docFile = new FileInputStream(new File("D:\\Downloads\\fileDOC\\B�o-C�o-QLDA-Nh�m-19N12_Team07.docx"));
	    		XWPFDocument doc = new XWPFDocument(this.fileContent);
	    		PdfOptions pdfOptions = PdfOptions.create();
	    		String urlString = name + "_" + "Converted" + ".pdf";
	  	        OutputStream out = new FileOutputStream(new File("C:\\FileServer\\" + urlString));
	    		PdfConverter.getInstance().convert(doc, out, pdfOptions);
	    		handleFile1.updateUrl_DAO(id, urlString);
	    		doc.close();
	    		out.close();
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	        
	        System.out.println("Done");
		}
		catch (Exception e)
		{
			 System.out.println(this.fileName.split(".").length);
			 System.out.println("thread oke1 -- " + e);
		}
	}
}
