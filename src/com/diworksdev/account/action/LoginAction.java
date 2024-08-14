package com.diworksdev.account.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.LoginDAO;
import com.diworksdev.account.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private String mail;
	private String password;
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private Map<String, Object> session;

	public String execute() {
		String result =ERROR;

		LoginDAO dao=new LoginDAO();

		loginDTOList=dao.select(mail, password);

		System.out.println(this.password);
		System.out.println(loginDTOList.get(0).getPassword());

		if(this.mail.equals(loginDTOList.get(0).getMail()) && this.password.equals(loginDTOList.get(0).getPassword())){
			session.put("loginDTOList", loginDTOList);

			result = SUCCESS;

		} else {
			session.put("loginDTOList", loginDTOList);

			result =ERROR;
		}
		return result ;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}
}