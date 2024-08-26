package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.diworksdev.account.dao.LoginDAO;
import com.diworksdev.account.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateAction extends ActionSupport {

	private Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO ();
	private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public String execute() throws SQLException {

		HttpSession session = request.getSession();

		if(session.getAttribute("loginDTOList", authority.equals("1"))) {

			String result = SUCCESS;

		} else {
			String result = ERROR;
			return result;
		}
	}

	public Map<String, Object> getSession() {

		return session;
	}

	public void setSession(Map<String, Object> session) {

		this.session = session;
	}
}