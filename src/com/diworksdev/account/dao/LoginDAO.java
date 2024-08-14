package com.diworksdev.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.diworksdev.account.dto.LoginDTO;
import com.diworksdev.account.util.DBConnector;

public class LoginDAO {
	public String mail;
	public String password;
	public String authority;

	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public List<LoginDTO> select(String mail, String password) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();

		String sql = "select * from account_info where mail=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			//取得した結果を1件ずつDTOに格納し、更にDTOをArrayListに格納している
			LoginDTO dto = new LoginDTO();
			dto.setMail(rs.getString("mail"));
			dto.setAuthority(rs.getString("authority"));

			if (bcpe.matches(password, (rs.getString("password")))) {
				dto.setPassword(password);
				loginDTOList.add(dto);
			}
		}

		if(loginDTOList.size()<=0){
			LoginDTO dto = new LoginDTO();
			dto.setMail("該当なし");
			dto.setPassword("該当なし");
			dto.setAuthority("該当なし");
			loginDTOList.add(dto);
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	try {
		con.close();
	} catch (SQLException e) {
		e.printStackTrace();
		}
		return loginDTOList;
	}
}