package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.account.dto.AccountListDTO;
import com.diworksdev.account.util.DBConnector;

public class AccountListDAO {

	public String family_name;
	public String last_name;
	public String family_name_kana;
	public String last_name_kana;
	public String mail;
	public String gender;
	public String authority;

	List<AccountListDTO> accountListDTOList = new ArrayList<AccountListDTO>();

//	public List<AccountListDTO> select(String family_name) {
	public List<AccountListDTO> select(String family_name, String last_name, String family_name_kana, String last_name_kana, String mail, String gender, String authority) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
//		String sql = "select * from account_info where family_name like '%%' and last_name like ? and family_name_kana like ? and last_name_kana like ? and mail like ? and gender = ? and authority = ?";
//		String sql = "select * from account_info where family_name like ? or family_name is not NULL";
		// 誤）ファミリーネームが入力された値『？』か、ファミリーネームが入力されているデータを出力する
		// ファミリーネームが入力された値『？』があれば表示して、なければ全部のデータを出力する

		// 正）指定された変数 family_name に値が代入されていれば、代入された値で検索する
		// 変数 family_name に値が代入されていなければ、全件表示する

		// ファミリーネームが指定されていたら `family_name like ?` を SQL 文に追加する

		// genderもauthorityも全部なかったら
		if (family_name.equals("") && last_name.equals("") && family_name_kana.equals("") && last_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql = "select * from account_info order by id desc";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					AccountListDTO dto=new AccountListDTO();
					dto.setId(rs.getString("id"));
					dto.setFamily_name(rs.getString("family_name"));
					dto.setLast_name(rs.getString("last_name"));
					dto.setFamily_name_kana(rs.getString("family_name_kana"));
					dto.setLast_name_kana(rs.getString("last_name_kana"));
					dto.setMail(rs.getString("mail"));
					dto.setGender(rs.getString("gender"));
					dto.setAuthority(rs.getString("authority"));
					dto.setDelete_flag(rs.getString("delete_flag"));
					dto.setRegistered_time(rs.getString("registered_time"));
					dto.setUpdate_time(rs.getString("update_time"));

					accountListDTOList.add(dto);
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
		// genderがなかったら
		} else if (gender.equals("2")) {
			String sql2 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ? and last_name_kana like ? and mail like ? and authority = ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql2);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name + "%");
				ps.setString(3, "%" + family_name_kana + "%");
				ps.setString(4, "%" + last_name_kana + "%");
				ps.setString(5, "%" + mail + "%");
				ps.setString(6, authority);
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					AccountListDTO dto=new AccountListDTO();
					dto.setId(rs.getString("id"));
					dto.setFamily_name(rs.getString("family_name"));
					dto.setLast_name(rs.getString("last_name"));
					dto.setFamily_name_kana(rs.getString("family_name_kana"));
					dto.setLast_name_kana(rs.getString("last_name_kana"));
					dto.setMail(rs.getString("mail"));
					dto.setGender(rs.getString("gender"));
					dto.setAuthority(rs.getString("authority"));
					dto.setDelete_flag(rs.getString("delete_flag"));
					dto.setRegistered_time(rs.getString("registered_time"));
					dto.setUpdate_time(rs.getString("update_time"));

					accountListDTOList.add(dto);
				}

			} catch (SQLException e) {
					e.printStackTrace();
			}
		// authorityがなかったら
		} else if (authority.equals("2")) {
			String sql3 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ? and last_name_kana like ? and mail like ? and gender = ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql3);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name + "%");
				ps.setString(3, "%" + family_name_kana + "%");
				ps.setString(4, "%" + last_name_kana + "%");
				ps.setString(5, "%" + mail + "%");
				ps.setString(6, gender);
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					AccountListDTO dto=new AccountListDTO();
					dto.setId(rs.getString("id"));
					dto.setFamily_name(rs.getString("family_name"));
					dto.setLast_name(rs.getString("last_name"));
					dto.setFamily_name_kana(rs.getString("family_name_kana"));
					dto.setLast_name_kana(rs.getString("last_name_kana"));
					dto.setMail(rs.getString("mail"));
					dto.setGender(rs.getString("gender"));
					dto.setAuthority(rs.getString("authority"));
					dto.setDelete_flag(rs.getString("delete_flag"));
					dto.setRegistered_time(rs.getString("registered_time"));
					dto.setUpdate_time(rs.getString("update_time"));

					accountListDTOList.add(dto);
				}

			} catch (SQLException e) {
					e.printStackTrace();
			}
		// どっちもあったら
		} else {
			String sql4 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ? and last_name_kana like ? and mail like ? and gender = ? and authority = ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql4);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name + "%");
				ps.setString(3, "%" + family_name_kana + "%");
				ps.setString(4, "%" + last_name_kana + "%");
				ps.setString(5, "%" + mail + "%");
				ps.setString(6, gender);
				ps.setString(7, authority);
				ResultSet rs = ps.executeQuery();

				while(rs.next()) {
					AccountListDTO dto=new AccountListDTO();
					dto.setId(rs.getString("id"));
					dto.setFamily_name(rs.getString("family_name"));
					dto.setLast_name(rs.getString("last_name"));
					dto.setFamily_name_kana(rs.getString("family_name_kana"));
					dto.setLast_name_kana(rs.getString("last_name_kana"));
					dto.setMail(rs.getString("mail"));
					dto.setGender(rs.getString("gender"));
					dto.setAuthority(rs.getString("authority"));
					dto.setDelete_flag(rs.getString("delete_flag"));
					dto.setRegistered_time(rs.getString("registered_time"));
					dto.setUpdate_time(rs.getString("update_time"));

					accountListDTOList.add(dto);
				}
			} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		try {
			con.close();

		} catch (SQLException e) {
				e.printStackTrace();
		}
		return accountListDTOList;
	}
}