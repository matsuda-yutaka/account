package com.diworksdev.account.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.LoginDAO;
import com.diworksdev.account.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String mail;
	private String password;
	private String authority;
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();
	private Map<String, Object> session;
	private String errorMessage;

	public String execute() {
		String result =ERROR;

		LoginDAO dao=new LoginDAO();

		loginDTOList=dao.select(mail, password, authority);

//		System.out.println(this.password);
//		System.out.println(loginDTOList.get(0).getPassword());
		System.out.println(loginDTOList.get(0).getAuthority());

		if(this.mail.equals(loginDTOList.get(0).getMail()) && this.password.equals(loginDTOList.get(0).getPassword())){
			session.put("loginDTOList", loginDTOList);

			result = SUCCESS;

		} else {
			session.put("loginDTOList", loginDTOList);
			setErrorMessage("エラーが発生したためログイン情報を取得できません。");
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

	public String getAuthority() {
		System.out.println("getAuthority()");
		System.out.println(authority);
		return authority;
	}

	public void setAuthority(String authority) {
		System.out.println("setAuthority()");
		System.out.println(this.authority);
		System.out.println(authority);
		this.authority = authority;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}