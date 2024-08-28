package com.diworksdev.account.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.AccountListDAO;
import com.diworksdev.account.dto.AccountListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AccountSearchAction extends ActionSupport implements SessionAware{

	private List<AccountListDTO> accountListDTOList = new ArrayList<AccountListDTO>();
	private Map<String, Object> session;

	public String execute() {

		String result = SUCCESS;

		AccountListDAO dao=new AccountListDAO();
		accountListDTOList = dao.select();

		if(accountListDTOList.size() > 0 && session.get("authority").equals("1")){

			session.put("accountListDTOList", accountListDTOList);
			result = SUCCESS;

		} else {

			result = ERROR;
		}

		return result;

	}
	public Map<String, Object> getSession() {

		return session;
	}

	public void setSession(Map<String, Object> session) {

		this.session = session;
	}
}