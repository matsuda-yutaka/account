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

		// 全部なかったら
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
		// family_nameだけあったら
		} else if (last_name.equals("") && family_name_kana.equals("") && last_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql2 = "select * from account_info where family_name like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql2);
				ps.setString(1, "%" + family_name + "%");
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
		// last_nameだけあったら
		} else if (family_name.equals("") && family_name_kana.equals("") && last_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql3 = "select * from account_info where last_name like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql3);
				ps.setString(1, "%" + last_name + "%");
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
		// family_name_kanaだけあったら
		} else if (family_name.equals("") && last_name.equals("") && last_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql4 = "select * from account_info where family_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql4);
				ps.setString(1, "%" + family_name_kana + "%");
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
		// last_name_kanaだけあったら
		} else if (family_name.equals("") && last_name.equals("") && family_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql5 = "select * from account_info where last_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql5);
				ps.setString(1, "%" + last_name_kana + "%");
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
		// mailだけあったら
		} else if (family_name.equals("") && last_name.equals("") && family_name_kana.equals("") && last_name_kana.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql6 = "select * from account_info where mail like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql6);
				ps.setString(1, "%" + mail + "%");
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
		// family_nameとlast_nameだけあったら
		} else if (family_name_kana.equals("") && last_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql7 = "select * from account_info where family_name like ? and last_name like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql7);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name + "%");
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
		// family_nameとfamily_name_kanaだけあったら
		} else if (last_name.equals("") && last_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql8 = "select * from account_info where family_name like ? and family_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql8);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + family_name_kana + "%");
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
		// family_nameとlast_name_kanaだけあったら
		} else if (last_name.equals("") && family_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql9 = "select * from account_info where family_name like ? and last_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql9);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name_kana + "%");
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
		// family_nameとmailだけあったら
		} else if (last_name.equals("") && family_name_kana.equals("") && last_name_kana.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql10 = "select * from account_info where family_name like ? and mail like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql10);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + mail + "%");
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
		// last_nameとfamily_name_kanaだけあったら
		} else if (family_name.equals("") && last_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql11 = "select * from account_info where last_name like ? and family_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql11);
				ps.setString(1, "%" + last_name + "%");
				ps.setString(2, "%" + family_name_kana + "%");
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
		// last_nameとlast_name_kanaだけあったら
		} else if (family_name.equals("") && family_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql12 = "select * from account_info where last_name like ? and last_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql12);
				ps.setString(1, "%" + last_name + "%");
				ps.setString(2, "%" + last_name_kana + "%");
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
		// last_nameとlast_name_kanaだけあったら
		} else if (family_name.equals("") && family_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql13 = "select * from account_info where last_name like ? and last_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql13);
				ps.setString(1, "%" + last_name + "%");
				ps.setString(2, "%" + last_name_kana + "%");
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
		// last_nameとmailだけあったら
		} else if (family_name.equals("") && family_name_kana.equals("") && last_name_kana.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql14 = "select * from account_info where last_name like ? and mail like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql14);
				ps.setString(1, "%" + last_name + "%");
				ps.setString(2, "%" + mail + "%");
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
		// family_name_kanaとlast_name_kanaだけあったら
		} else if (family_name.equals("") && last_name.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql15 = "select * from account_info where family_name_kana like ? and last_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql15);
				ps.setString(1, "%" + family_name_kana + "%");
				ps.setString(2, "%" + last_name_kana + "%");
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
		// family_name_kanaとmailだけあったら
		} else if (family_name.equals("") && last_name.equals("") && last_name_kana.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql16 = "select * from account_info where family_name_kana like ? and mail like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql16);
				ps.setString(1, "%" + family_name_kana + "%");
				ps.setString(2, "%" + mail + "%");
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
		// last_name_kanaとmailだけあったら
		} else if (family_name.equals("") && last_name.equals("") && family_name_kana.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql17 = "select * from account_info where last_name_kana like ? and mail like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql17);
				ps.setString(1, "%" + last_name_kana + "%");
				ps.setString(2, "%" + mail + "%");
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
		// family_nameとlast_nameとfamily_name_kanaだけあったら
		} else if (last_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql18 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql18);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name + "%");
				ps.setString(3, "%" + family_name_kana + "%");
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
		// family_nameとlast_nameとlast_name_kanaだけあったら
		} else if (family_name_kana.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql19 = "select * from account_info where family_name like ? and last_name like ? and last_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql19);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name + "%");
				ps.setString(3, "%" + last_name_kana + "%");
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
		// family_nameとlast_nameとmailだけあったら
		} else if (family_name_kana.equals("") && last_name_kana.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql20 = "select * from account_info where family_name like ? and last_name like ? and mail like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql20);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name + "%");
				ps.setString(3, "%" + mail + "%");
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
		// family_nameとfamily_name_kanaとlast_name_kanaだけあったら
		} else if (last_name.equals("") && mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql21 = "select * from account_info where family_name like ? and family_name_kana like ? and last_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql21);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + family_name_kana + "%");
				ps.setString(3, "%" + last_name_kana + "%");
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
		// family_nameとfamily_name_kanaとmailだけあったら
		} else if (last_name.equals("") && last_name_kana.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql22 = "select * from account_info where family_name like ? and family_name_kana like ? and mail like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql22);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + family_name_kana + "%");
				ps.setString(3, "%" + mail + "%");
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
		// family_nameとlast_name_kanaとmailだけあったら
		} else if (last_name.equals("") && family_name_kana.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql23 = "select * from account_info where family_name like ? and last_name_kana like ? and mail like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql23);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name_kana + "%");
				ps.setString(3, "%" + mail + "%");
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
		// family_nameとlast_nameとfamily_name_kanaとlast_name_kanaだけあったら
		} else if (mail.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql24 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ? and ? last_name_kana like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql24);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name + "%");
				ps.setString(3, "%" + family_name_kana + "%");
				ps.setString(4, "%" + last_name_kana + "%");
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
		// family_nameとlast_nameとfamily_name_kanaとmailだけあったら
		} else if (last_name_kana.equals("") && gender.equals("2") && authority.equals("2")) {
			String sql25 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ? and ? mail like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql25);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name + "%");
				ps.setString(3, "%" + family_name_kana + "%");
				ps.setString(4, "%" + mail + "%");
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
		// genderとauthority以外あったら
		} else if (gender.equals("2") && authority.equals("2")) {
			String sql26 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ? and last_name_kana like ? and mail like ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql26);
				ps.setString(1, "%" + family_name + "%");
				ps.setString(2, "%" + last_name + "%");
				ps.setString(3, "%" + family_name_kana + "%");
				ps.setString(4, "%" + last_name_kana + "%");
				ps.setString(5, "%" + mail + "%");
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
			String sql27 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ? and last_name_kana like ? and mail like ? and authority = ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql27);
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
			String sql28 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ? and last_name_kana like ? and mail like ? and gender = ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql28);
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
			String sql29 = "select * from account_info where family_name like ? and last_name like ? and family_name_kana like ? and last_name_kana like ? and mail like ? and gender = ? and authority = ?";

			try {
				PreparedStatement ps = con.prepareStatement(sql29);
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