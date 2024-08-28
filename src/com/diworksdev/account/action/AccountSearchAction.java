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
	private List<AccountListDTO> accountListDTOList = new ArrayList<AccountListDTO>();
	private Map<String, Object> session;

	public String execute() {

		String result = SUCCESS;

		AccountListDAO dao=new AccountListDAO();
		accountListDTOList = dao.select();

		System.out.println(this.family_name);

		if(this.family_name.equals(accountListDTOList.get(0).getFamily_name())){
//		if(accountListDTOList.size() > 0 && this.family_name.equals(accountListDTOList.get(0).getFamily_name())){

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

	public Map<String, Object> getSession() {

		return session;
	}

	public void setSession(Map<String, Object> session) {

		this.session = session;
	}
}