package com.zj.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zj.model.Teacher;
import com.zj.util.StringUti;

public class TeacherDao extends BaseDao
{
	public boolean addTeacher(Teacher teacher)
	{
		String sql = "insert into s_teacher values(null,?,?,?,?,?)";
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getSex());
			preparedStatement.setString(3, teacher.getTitle());
			preparedStatement.setInt(4, teacher.getAge());
			preparedStatement.setString(5, teacher.getPassword());
			if (preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public List<Teacher> getTeacherList(Teacher teacher)
	{
		List<Teacher> retList = new ArrayList<Teacher>();
		StringBuffer sqlString = new StringBuffer("select * from s_teacher");
		if (!StringUti.isEmpty(teacher.getName()))
		{
			sqlString.append(" where name like '%" + teacher.getName() + "%'");
		}
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString());
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next())
			{
				Teacher t = new Teacher();
				t.setId(executeQuery.getInt("id"));
				t.setName(executeQuery.getString("name"));
				t.setSex(executeQuery.getString("sex"));
				t.setTitle(executeQuery.getString("title"));
				t.setAge(executeQuery.getInt("age"));
				// t.setPassword(executeQuery.getString("password"));
				retList.add(t);

			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retList;
	}

	public boolean delete(int id)
	{
		String sql = "delete from s_teacher where id=?";
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if (preparedStatement.executeUpdate() > 0)
			{
				return true;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Teacher teacher)
	{
		String sql = "update s_teacher set name=?,sex=?,title=?,age=?,password=? where id=?";
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getSex());
			preparedStatement.setString(3, teacher.getTitle());
			preparedStatement.setInt(4, teacher.getAge());
			preparedStatement.setString(5, teacher.getPassword());
			preparedStatement.setInt(6, teacher.getId());
			if (preparedStatement.executeUpdate() > 0)
			{
				return true;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Teacher login(Teacher teacher)
	{
		String sql = "select * from s_teacher where name=? and password=?";
		Teacher teacherRst = null;
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, teacher.getName());
			preparedStatement.setString(2, teacher.getPassword());
			ResultSet executeQuery = preparedStatement.executeQuery();
			if (executeQuery.next())
			{
				teacherRst = new Teacher();
				teacherRst.setId(executeQuery.getInt("id"));
				teacherRst.setName(executeQuery.getString("name"));
				teacherRst.setPassword(executeQuery.getString("password"));
				teacherRst.setSex(executeQuery.getString("sex"));
				teacherRst.setAge(executeQuery.getInt("age"));
				teacherRst.setTitle(executeQuery.getString("title"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacherRst;
	}

	public String editPassword(Teacher teacher, String newPassword)
	{
		String sql = "select * from s_teacher where id=? and password=?";
		PreparedStatement preparedStatement = null;
		int id = 0;
		try
		{
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, teacher.getId());
			preparedStatement.setString(2, teacher.getPassword());
			ResultSet executeQuery = preparedStatement.executeQuery();
			if (!executeQuery.next())
			{
				String retString = "原始密码错误！";
				return retString;
			}
			id = executeQuery.getInt("id");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String retString = "修改失败！";
		String sqlString = "update s_teacher set password = ? where id=?";
		try
		{
			preparedStatement = con.prepareStatement(sqlString);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, id);
			int rst = preparedStatement.executeUpdate();
			if (rst > 0)
			{
				retString = "修改成功！";
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retString;
	}
}
