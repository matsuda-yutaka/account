package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.account.dto.DeleteDTO;
import com.diworksdev.account.util.DBConnector;

public class DeleteDAO {

	public String id;
	public String family_name;
	public String last_name;
	public String family_name_kana;
	public String last_name_kana;
	public String mail;
	public String gender;
	public String postal_code;
	public String prefecture;
	public String address_1;
	public String address_2;
	public String authority;

	public List<DeleteDTO> deleteDTOList = new ArrayList<DeleteDTO>();

	public List<DeleteDTO> select(String id, String family_name, String last_name, String family_name_kana, String last_name_kana, String mail, String gender, String postal_code, String prefecture, String address_1, String address_2, String authority) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from account_info where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				DeleteDTO dto=new DeleteDTO();
				dto.setId(rs.getString("id"));
				dto.setFamily_name(rs.getString("family_name"));
				dto.setLast_name(rs.getString("last_name"));
				dto.setFamily_name_kana(rs.getString("family_name_kana"));
				dto.setLast_name_kana(rs.getString("last_name_kana"));
				dto.setMail(rs.getString("mail"));
				dto.setGender(rs.getString("gender"));
				dto.setPostal_code(rs.getString("postal_code"));
				dto.setPrefecture(rs.getString("prefecture"));
				dto.setAddress_1(rs.getString("address_1"));
				dto.setAddress_2(rs.getString("address_2"));
				dto.setAuthority(rs.getString("authority"));
				deleteDTOList.add(dto);
			}

			if(deleteDTOList.size()<=0){
				DeleteDTO dto=new DeleteDTO();
				dto.setId("該当なし");
				dto.setFamily_name("該当なし");
				dto.setLast_name("該当なし");
				dto.setFamily_name_kana("該当なし");
				dto.setLast_name_kana("該当なし");
				dto.setMail("該当なし");
				dto.setGender("該当なし");
				dto.setPostal_code("該当なし");
				dto.setPrefecture("該当なし");
				dto.setAddress_1("該当なし");
				dto.setAddress_2("該当なし");
				dto.setAuthority("該当なし");
				deleteDTOList.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			}
			return deleteDTOList;
		}
	}