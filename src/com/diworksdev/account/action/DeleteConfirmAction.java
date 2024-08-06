package com.diworksdev.account.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.diworksdev.account.dao.DeleteDAO;
import com.diworksdev.account.dto.DeleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteConfirmAction extends ActionSupport {
	private String id;
	private String family_name;
	private String last_name;
	private String family_name_kana;
	private String last_name_kana;
	private String mail;
	private String gender;
	private String postal_code;
	private String prefecture;
	private String address_1;
	private String address_2;
	private String authority;
	private List<DeleteDTO> deleteDTOList = new ArrayList<DeleteDTO>();
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		DeleteDAO dao=new DeleteDAO();

		deleteDTOList=dao.select(id, family_name, last_name, family_name_kana, last_name_kana, mail, gender, postal_code, prefecture, address_1, address_2, authority);

		//System.out.println(id);// 28!!
		//System.out.println(deleteDTOList.get(0).getId());// 28?->該当なし
		if(id.equals(deleteDTOList.get(0).getId())){

			result = SUCCESS;

		} else {

			session.put("deleteDTOList", deleteDTOList);

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
}