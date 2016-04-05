package com.yl.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.yl.domian.Users;
import com.yl.util.SqlHelper;

public class UserService {

	public static boolean checkInfo(Users user) {
		boolean result = false;
		String sql = "select * from users where id=? and password=?";
		String[] parameters = { user.getId() + "", user.getPassword() };
		ArrayList al = SqlHelper.executeQuery2(sql, parameters);
		if (al.size() == 1) {
			result = true;
		}
		return result;
	}

	public ArrayList getUserByPage(int pageNow, int pageSize) {
		ArrayList<Users> al = new ArrayList<Users>();

		String sql = "select * from users order by id limit " + (pageNow - 1)
				* pageSize + "," + pageSize;
		ArrayList alrs = SqlHelper.executeQuery2(sql, null);
		for (int i = 0; i < alrs.size(); i++) {
			Object[] obj = (Object[]) alrs.get(i);

			Users user = new Users();
			user.setId((Integer) obj[0]);
			user.setUsername(obj[1].toString());
			user.setEmail((String) obj[2]);
			user.setGrade((Integer) obj[3]);
			user.setPassword((String) obj[4]);

			al.add(user);
		}
		return al;
	}

	public int page(int pageSize) {
		String sql = "select count(*) from users";
		ResultSet rs = SqlHelper.executeQuery(sql, null);
		int rowCount = 0;
		try {
			rs.next();
			rowCount = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return (rowCount - 1) / pageSize + 1;
	}

	public boolean delUser(String id) {
		String sql = "delete from users where id=?";
		String[] parameters = { id };
		boolean res = true;
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	public Users presentUser(String id) {
		String sql = "select * from users where id=?";
		String[] parameters = { id };
		ResultSet rs = SqlHelper.executeQuery(sql, parameters);

		Users user = new Users();
		try {
			rs.next();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setGrade(rs.getShort("grade"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs, SqlHelper.getPs(), SqlHelper.getCt());
		}
		return user;
	}

	public boolean changeUser(Users user, int id) {
		try {
			String sql = "update users set username=?,email=?,grade=? where id="
					+ id;
			String[] parameters = { user.getUsername(), user.getEmail(),
					user.getGrade() + "" };
			SqlHelper.executeUpdate(sql, parameters);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean addUser(Users user) {
		try {
			String sql = "insert into users values (?,?,?,?,?)";
			String[] parameters = { user.getId() + "", user.getUsername(),
					user.getEmail(), user.getGrade() + "", user.getPassword() };
			SqlHelper.executeUpdate(sql, parameters);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
