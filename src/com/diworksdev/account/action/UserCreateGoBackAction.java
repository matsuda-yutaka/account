package com.diworksdev.account.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateGoBackAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private String family_name;
	private String last_name;
	private String family_name_kana;
	private String last_name_kana;
	private String mail;
	private String password;
	private String gender;
	private String postal_code;
	private String prefecture;
	private String address_1;
	private String address_2;
	private String authority;

	public String execute() {
		String result = SUCCESS;
		String family_name = null;
		session.put("family_name", family_name);
		System.out.println(family_name);
		session.put("last_name", last_name);
		session.put("family_name_kana", family_name_kana);
		session.put("last_name_kana", last_name_kana);
		session.put("mail", mail);
		session.put("gender", gender);
		session.put("password", password);
		session.put("postal_code", postal_code);
		session.put("prefecture", prefecture);
		session.put("address_1", address_1);
		session.put("address_2", address_2);
		session.put("authority", authority);
		return result;

	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setFamily_name_kana(String family_name_kana) {
		this.family_name_kana = family_name_kana;
	}

	public void setLast_name_kana(String last_name_kana) {
		this.last_name_kana = last_name_kana;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}