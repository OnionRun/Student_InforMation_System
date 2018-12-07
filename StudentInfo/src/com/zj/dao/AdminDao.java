package com.zj.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zj.model.Admin;

public class AdminDao extends BaseDao
{
	/**
	 * 管理员登录
	 */
	public Admin login(Admin admin)
	{
		String sql = "select * from s_admin where name=? and password=?"; // 这里出现过语法错误...select
		Admin adminRst = null;
		try
		{
			PreparedStatement prst = con.prepareStatement(sql); // 把sql语句传给数据库操作对象
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet excuteQuery = prst.executeQuery();
			if (excuteQuery.next())
			{
				adminRst = new Admin();
				adminRst.setId(excuteQuery.getInt("id"));
				adminRst.setName(excuteQuery.getString("name"));
				adminRst.setPassword(excuteQuery.getString("password"));
				adminRst.setCreateDate(excuteQuery.getString("createDate"));
			}

		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminRst;
	}

	public String editPassword(Admin admin, String newPassword)
	{
		// TODO Auto-generated method stub
		String sql = "select * from s_admin where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try
		{
			prst = con.prepareStatement(sql);
			prst.setInt(1, admin.getId());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if (!executeQuery.next())
			{
				String retString = "原始密码错误！";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} // 把sql语句传给数据库操作对象
		String retString = "修改失败";
		String sqlString = "update s_admin set password = ? where id = ?";
		try
		{
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if (rst > 0)
			{
				retString = "修改成功！";
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 把sql语句传给数据库操作对象
		return retString;
	}
}
