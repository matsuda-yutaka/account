package com.diworksdev.account.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.AccountListDAO;
import com.diworksdev.account.dto.AccountListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AccountSearchAction extends ActionSupport implements SessionAware{
	private String family_name;
	private String last_name;
	private String family_name_kana;
	private String last_name_kana;
	private String mail;
	private String gender;
	private String authority;
	private List<AccountListDTO> accountListDTOList = new ArrayList<AccountListDTO>();
	private Map<String, Object> session;

	public String execute() {

		String result = SUCCESS;

		AccountListDAO dao=new AccountListDAO();

		accountListDTOList = dao.select(family_name);
//		accountListDTOList = dao.select(family_name, last_name, family_name_kana, last_name_kana, mail, gender, authority);

		if(accountListDTOList.size() > 0){

			session.put("accountListDTOList", accountListDTOList);
			result = SUCCESS;

		} else {
			result = ERROR;
		}

		return result;

	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFamily_name_kana() {
		return family_name_kana;
	}

	public void setFamily_name_kana(String family_name_kana) {
		this.family_name_kana = family_name_kana;
	}

	public String getLast_name_kana() {
		return last_name_kana;
	}

	public void setLast_name_kana(String last_name_kana) {
		this.last_name_kana = last_name_kana;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

		this.session = session;
	}
}