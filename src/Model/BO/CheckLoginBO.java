package model.BO;

import model.Bean.Account;

import model.DAO.CheckLoginDAO;
import model.DAO.insertDAO;

public class CheckLoginBO {

	public static Account CheckLogin(String id, String pw) {
		// TODO Auto-generated method stub
		return CheckLoginDAO.CheckLogin(id, pw);
	}
	public static String CheckSignUp(String id, String pw) {
		// TODO Auto-generated method stub
		return insertDAO.CheckSignUp(id, pw);
	}
	
    
	
    
}
