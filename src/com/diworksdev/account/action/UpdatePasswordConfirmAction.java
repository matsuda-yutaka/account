package com.diworksdev.account.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UpdatePasswordConfirmAction extends ActionSupport implements SessionAware {

	private String id;
	private String password;
	public Map<String, Object> session;
	private String errorMessage6;

	public String execute() {

		String result = SUCCESS;

		if(!(password.equals(""))) {

			session.put("password", password);

		} else {
			setErrorMessage6("パスワードが未入力です。");
			result = ERROR;
		}

		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage6() {
		return errorMessage6;
	}

	public void setErrorMessage6(String errorMessage6) {
		this.errorMessage6 = errorMessage6;
	}
}