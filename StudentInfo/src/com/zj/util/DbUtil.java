package com.zj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/***
 * 
 * @author Onion 与数据库连接
 */
public class DbUtil
{
	private String dbUrl = "jdbc:mysql://localhost:3306/db_student?useUnicode=true&characterEncoding=utf8"; // 数据库连接地址
	private String dbUserName = "root"; // user name
	private String dbPassWord = "123456"; // password
	private String jdbcName = "com.mysql.jdbc.Driver"; // Driver name

	/***
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws Exception
	 */

	public Connection getCon()
	{
		try
		{
			Class.forName(jdbcName);

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		Connection con = null;
		try
		{
			con = DriverManager.getConnection(dbUrl, dbUserName, dbPassWord);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception
	{
		if (con != null)
		{
			con.close();
		}
	}

	public static void main(String[] args)
	{
		DbUtil dbUtil = new DbUtil();
		try
		{
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
	}
}