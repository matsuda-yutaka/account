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
//	public String last_name;
//	public String family_name_kana;
//	public String last_name_kana;
//	public String mail;
//	public String gender;
//	public String authority;

	List<AccountListDTO> accountListDTOList = new ArrayList<AccountListDTO>();

	public List<AccountListDTO> select(String family_name) {
//	public List<AccountListDTO> select(String family_name, String last_name, String family_name_kana, String last_name_kana, String mail, String gender, String authority) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
//		String sql = "select * from account_info where family_name like '%%' and last_name like ? and family_name_kana like ? and last_name_kana like ? and mail like ? and gender = ? and authority = ?";
		String sql = "select * from account_info where family_name like ? or family_name not in ('null')";
		// ファミリーネームが指定されていたら `family_name like ?` を SQL 文に追加する
//		String sql3 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ? and last_name_kana like ? and mail like ? ";
//		if (性別が指定されていた場合) {
//			// sql3 に文字列を追加するか？
//		} else {
//			// sql3 に文字列を追加するか？
//		}
//		if (権限が指定されていた場合) {
//			// sql3 に文字列を追加するか？
//		} else {
//			// sql3 に文字列を追加するか？
//		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + family_name + "%");
//			ps.setString(2, "%" + last_name + "%");
//			ps.setString(3, "%" + family_name_kana + "%");
//			ps.setString(4, "%" + last_name_kana + "%");
//			ps.setString(5, "%" + mail + "%");
//			ps.setString(6, gender);
//			ps.setString(7, authority);
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
		try {
			con.close();

		} catch (SQLException e) {
				e.printStackTrace();
		}
		return accountListDTOList;
	}
}