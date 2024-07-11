package com.diworksdev.account.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.account.dao.DeleteDAO;
import com.diworksdev.account.dto.DeleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements SessionAware{
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
	private List<DeleteDTO> deleteDTOList = new ArrayList<DeleteDTO>();
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		DeleteDAO dao=new DeleteDAO();

		deleteDTOList=dao.select(id, family_name, last_name, family_name_kana, last_name_kana, mail, password, gender, postal_code, prefecture, address_1, address_2, authority);

		System.out.println(this.id);// 28!!
		System.out.println(deleteDTOList.get(0).getId());// 28?->該当なし
		System.out.println(this.family_name);// ???->null!?
		System.out.println(deleteDTOList.get(0).getFamily_name());// ???->該当なし
		if(this.id.equals(deleteDTOList.get(0).getId())
				&& this.family_name.equals(deleteDTOList.get(0).getFamily_name())
				&& this.last_name.equals(deleteDTOList.get(0).getLast_name())
				&& this.family_name_kana.equals(deleteDTOList.get(0).getFamily_name_kana())
				&& this.last_name_kana.equals(deleteDTOList.get(0).getLast_name_kana())
				&& this.mail.equals(deleteDTOList.get(0).getMail())
				&& this.password.equals(deleteDTOList.get(0).getPassword())
				&& this.gender.equals(deleteDTOList.get(0).getGender())
				&& this.postal_code.equals(deleteDTOList.get(0).getPostal_code())
				&& this.prefecture.equals(deleteDTOList.get(0).getPrefecture())
				&& this.address_1.equals(deleteDTOList.get(0).getAddress_1())
				&& this.address_2.equals(deleteDTOList.get(0).getAddress_2())
				&& this.authority.equals(deleteDTOList.get(0).getAuthority())){

			session.put("deleteDTOList", deleteDTOList);

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.password = postal_code;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
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