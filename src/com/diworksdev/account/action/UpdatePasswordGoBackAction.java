package com.diworksdev.account.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UpdatePasswordGoBackAction extends ActionSupport implements SessionAware {

	private String id;
	private String password;
	public Map<String, Object> session;

	public String execute() {
		String result = SUCCESS;
		password = session.get("passworde").toString();
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
}