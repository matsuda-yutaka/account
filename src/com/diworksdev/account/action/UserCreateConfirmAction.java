package com.diworksdev.account.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

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
	public Map<String, Object> session;
	private String errorMessage;

	public String execute() {

		String result = SUCCESS;

		if(!(family_name.equals(""))) {

			session.put("family_name", family_name);

		} else {
			setErrorMessage1("名前（姓）が未入力です。");
			result = ERROR;
		}

		if(!(last_name.equals(""))) {

			session.put("last_name", last_name);

		} else {
			setErrorMessage2("名前（名）が未入力です。");
			result = ERROR;
		}

		if(!(family_name_kana.equals(""))) {

			session.put("family_name_kana", family_name_kana);

		} else {
			setErrorMessage3("カナ（姓）が未入力です。");
			result = ERROR;
		}

		if(!(last_name_kana.equals(""))) {

			session.put("last_name_kana", last_name_kana);

		} else {
			setErrorMessage4("カナ（名）が未入力です。");
			result = ERROR;
		}

		if(!(mail.equals(""))) {

			session.put("mail", mail);

		} else {
			setErrorMessage5("メールアドレスが未入力です。");
			result = ERROR;
		}

		if(!(password.equals(""))) {

			session.put("password", password);

		} else {
			setErrorMessage6("パスワードが未入力です。");
			result = ERROR;
		}

		if(!(gender.equals(""))) {

			session.put("gender", gender);

		} else {
			setErrorMessage7("性別が未入力です。");
			result = ERROR;
		}

		if(!(postal_code.equals(""))) {

			session.put("postal_code", postal_code);

		} else {
			setErrorMessage8("郵便番号が未入力です。");
			result = ERROR;
		}

		if(!(prefecture.equals(""))) {

			session.put("prefecture", prefecture);

		} else {
			setErrorMessage9("住所（都道府県）が未入力です。");
			result = ERROR;
		}

		if(!(address_1.equals(""))) {

			session.put("address_1", address_1);

		} else {
			setErrorMessage10("住所（市区町村）が未入力です。");
			result = ERROR;
		}

		if(!(address_2.equals(""))) {

			session.put("address_2", address_2);

		} else {
			setErrorMessage11("住所（番地）が未入力です。");
			result = ERROR;
		}

		if(!(authority.equals(""))) {

			session.put("authority", authority);

		} else {
			setErrorMessage12("アカウント権限が未入力です。");
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
		this.postal_code = postal_code;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage1() {
		return errorMessage1;
	}

	public void setErrorMessage1(String errorMessage1) {
		this.errorMessage1 = errorMessage1;
	}

	public String getErrorMessage2() {
		return errorMessage2;
	}

	public void setErrorMessage2(String errorMessage2) {
		this.errorMessage2 = errorMessage2;
	}

	public String getErrorMessage3() {
		return errorMessage3;
	}

	public void setErrorMessage3(String errorMessage3) {
		this.errorMessage3 = errorMessage3;
	}

	public String getErrorMessage4() {
		return errorMessage4;
	}

	public void setErrorMessage4(String errorMessage4) {
		this.errorMessage4 = errorMessage4;
	}

	public String getErrorMessage5() {
		return errorMessage5;
	}

	public void setErrorMessage5(String errorMessage5) {
		this.errorMessage5 = errorMessage5;
	}

	public String getErrorMessage6() {
		return errorMessage6;
	}

	public void setErrorMessage6(String errorMessage6) {
		this.errorMessage6 = errorMessage6;
	}

	public String getErrorMessage7() {
		return errorMessage7;
	}

	public void setErrorMessage7(String errorMessage7) {
		this.errorMessage7 = errorMessage7;
	}

	public String getErrorMessage8() {
		return errorMessage8;
	}

	public void setErrorMessage8(String errorMessage8) {
		this.errorMessage8 = errorMessage8;
	}

	public String getErrorMessage9() {
		return errorMessage9;
	}

	public void setErrorMessage9(String errorMessage9) {
		this.errorMessage9 = errorMessage9;
	}

	public String getErrorMessage1() {
		return errorMessage1;
	}

	public void setErrorMessage10(String errorMessage10) {
		this.errorMessage10 = errorMessage10;
	}

	public String getErrorMessage11() {
		return errorMessage11;
	}

	public void setErrorMessage11(String errorMessage11) {
		this.errorMessage11 = errorMessage11;
	}

	public String getErrorMessage12() {
		return errorMessage12;
	}

	public void setErrorMessage12(String errorMessage1) {
		this.errorMessage12 = errorMessage12;
	}
}