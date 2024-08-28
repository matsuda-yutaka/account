package com.diworksdev.account.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AccountListAction extends ActionSupport implements SessionAware {
	private String authority;
	private Map<String, Object> session;

	public String execute() {

		String result = SUCCESS;

		System.out.println(session.get("authority"));
		if(session.get("authority").equals("1")) {
			result = SUCCESS;

		} else {
			result = ERROR;
		}
		return result;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session ;
	}
}