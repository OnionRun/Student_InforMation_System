package com.zj.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.zj.util.DbUtil;

/****
 * 
 * @author Onion 创建数据库连接对象
 */
public class BaseDao
{
	public Connection con = new DbUtil().getCon();

	public void closeDao()
	{
		try
		{
			con.close();

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
