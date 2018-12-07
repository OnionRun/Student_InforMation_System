package com.zj.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zj.model.Student;
import com.zj.util.StringUti;

public class StudentDao extends BaseDao
{
	public boolean addStudent(Student student)
	{
		String sql = "insert into s_student values(null,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getClassId());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getSex());
			preparedStatement.setString(5, student.getEmail());
			preparedStatement.setString(6, student.getPhoneNumber());
			preparedStatement.setString(7, student.getAddress());
			preparedStatement.setString(8, student.getBirthday());
			preparedStatement.setString(9, student.getIdcard());
			preparedStatement.setString(10, student.getStuNumber());
			if (preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public List<Student> getStudentList(Student student)
	{
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlString = new StringBuffer("select * from s_student");
		if (!StringUti.isEmpty(student.getName()))
		{
			sqlString.append(" and name like '%" + student.getName() + "%'");
		}
		if (student.getClassId() != 0)
		{
			sqlString.append(" and classId =" + student.getClassId());
		}
		try
		{
			PreparedStatement preparedStatement = con
					.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while (executeQuery.next())
			{
				Student s = new Student();
				s.setId(executeQuery.getInt("id"));
				s.setName(executeQuery.getString("name"));

				s.setClassId(executeQuery.getInt("classId"));
				s.setPassword(executeQuery.getString("password"));
				s.setSex(executeQuery.getString("sex"));
				s.setEmail(executeQuery.getString("email"));
				s.setPhoneNumber(executeQuery.getString("phoneNumber"));

				s.setAddress(executeQuery.getString("address"));
				s.setBirthday(executeQuery.getString("birthday"));
				s.setIdcard(executeQuery.getString("idcard"));
				s.setStuNumber(executeQuery.getString("stunumber"));
				retList.add(s);
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}

	public boolean update(Student student)
	{
		String sql = "update s_student set name=?,classId=?,sex=?,password=?,email=?,phoneNumber=?,address=?,birthday=?,idcard=?,stunumber=? where id=?";
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getClassId());
			preparedStatement.setString(3, student.getSex());
			preparedStatement.setString(4, student.getPassword());

			preparedStatement.setString(5, student.getEmail());
			preparedStatement.setString(6, student.getPhoneNumber());
			preparedStatement.setString(7, student.getAddress());
			preparedStatement.setString(8, student.getBirthday());
			preparedStatement.setString(9, student.getIdcard());
			preparedStatement.setString(10, student.getStuNumber());
			preparedStatement.setInt(11, student.getId());

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

	public boolean delete(int id)
	{
		String sql = "delete from s_student where id=?";
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if (preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public String editPassword(Student student, String newPassword)
	{
		String sql = "select * from s_student where id=? and password=?";
		PreparedStatement preparedStatement = null;
		int id = 0;
		try
		{
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getPassword());
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
		} // 把sql语句传给数据库操作对象

		String retString = "修改失败！";
		String sqlString = "update s_student set password = ? where id = ?";
		try
		{
			preparedStatement = con.prepareStatement(sqlString);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, id);
			int rst = preparedStatement.executeUpdate();
			if (rst > 0)
				retString = "修改成功！";
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 把sql语句传给数据库操作对象

		return retString;
	}

	public Student login(Student student)
	{
		String sql = "select * from s_student where name=? and password=?";
		Student studentRst = null;
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getPassword());
			ResultSet executeQuery = preparedStatement.executeQuery();
			if (executeQuery.next())
			{
				studentRst = new Student();
				studentRst.setId(executeQuery.getInt("id"));
				studentRst.setClassId(executeQuery.getInt("classId"));
				studentRst.setName(executeQuery.getString("name"));
				studentRst.setPassword(executeQuery.getString("password"));
				studentRst.setSex(executeQuery.getString("sex"));
				studentRst.setEmail(executeQuery.getString("email"));
				studentRst.setPhoneNumber(executeQuery.getString("phoneNumber"));
				studentRst.setAddress(executeQuery.getString("address"));
				studentRst.setBirthday(executeQuery.getString("birthday"));
				studentRst.setIdcard(executeQuery.getString("idcard"));
				studentRst.setStuNumber(executeQuery.getString("stunumber"));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentRst;
	}

}
