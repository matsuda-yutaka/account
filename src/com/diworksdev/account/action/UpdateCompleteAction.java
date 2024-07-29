package com.diworksdev.account.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.UpdateCompleteDAO;
import com.diworksdev.account.dto.UpdateCompleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateCompleteAction extends ActionSupport implements SessionAware {

	private String id;
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
	private List<UpdateCompleteDTO> updateCompleteDTOList = new ArrayList<UpdateCompleteDTO>();
	private Map<String, Object> session;
	private UpdateCompleteDAO updateCompleteDAO = new UpdateCompleteDAO();

	public String execute() throws SQLException {
		String result = ERROR;

		UpdateCompleteDAO dao=new UpdateCompleteDAO();

		System.out.println(id);
		updateCompleteDTOList=dao.select(id);

		try {
			if(id.equals(updateCompleteDTOList.get(0).getId())){

			System.out.println(id);
			int rs = dao.Update(id, family_name, last_name, family_name_kana, last_name_kana, mail, password, gender, postal_code, prefecture, address_1, address_2, authority);

			result = SUCCESS;

			}

		} catch (Exception e) {
			e.printStackTrace();
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}