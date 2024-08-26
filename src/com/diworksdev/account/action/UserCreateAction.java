package com.diworksdev.account.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.LoginDAO;
import com.diworksdev.account.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport implements SessionAware {
	private String mail;
	private String password;
	private String authority;
	private Map<String, Object> session;
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public String execute() {
		String result =ERROR;

		LoginDAO dao = new LoginDAO();

		loginDTOList = dao.select(mail, password, authority);

		System.out.println(loginDTOList.get(0).getAuthority());
		if((loginDTOList.get(0).getAuthority()).equals("1")) {

			result = SUCCESS;

		} else {
			result =ERROR;
		}
		return result ;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}