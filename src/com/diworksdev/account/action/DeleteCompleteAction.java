package com.diworksdev.account.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.DeleteCompleteDAO;
import com.diworksdev.account.dto.DeleteCompleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCompleteAction extends ActionSupport implements SessionAware {

	private String id;
	private String delete_flag;
	private List<DeleteCompleteDTO> deleteCompleteDTOList = new ArrayList<DeleteCompleteDTO>();
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		DeleteCompleteDAO dao=new DeleteCompleteDAO();

		deleteCompleteDTOList=dao.select(id, delete_flag);

		System.out.println(this.id);
		System.out.println(deleteCompleteDTOList.get(0).getId());
		if(this.id.equals(deleteCompleteDTOList.get(0).getId())){

			result = SUCCESS;

		} else {

			session.put("deleteCompleteDTOList", deleteCompleteDTOList);

			result = ERROR;
		}
		return result;
	}

	public String getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}