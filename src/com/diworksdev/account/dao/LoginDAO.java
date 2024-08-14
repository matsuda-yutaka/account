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

	public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

	public List<LoginDTO> select(String mail, String password) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from account_info where mail=? and password=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			//取得した結果を1件ずつDTOに格納し、更にDTOをArrayListに格納している
			LoginDTO dto = new LoginDTO();
			dto.setMail(rs.getString("mail"));
			BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
			bcpe.matches(password, loginDTOList.get(0).getPassword());
			dto.setPassword(rs.getString("password"));
			loginDTOList.add(dto);
		}

		if(loginDTOList.size()<=0){
			LoginDTO dto = new LoginDTO();
			dto.setMail("該当なし");
			dto.setPassword("該当なし");
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