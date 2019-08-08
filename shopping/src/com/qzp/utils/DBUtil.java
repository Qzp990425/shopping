package com.qzp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
	private static Connection ct = null;

	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	
	private static String url = "";
	private static String username = "";
	private static String driver = "";
	private static String passwd = "";

	private static Properties pp = null;
	private static InputStream fis = null;

	//static中只执行一次
	static {
		try {
			pp = new Properties();
			//fis = new FileInputStream("dbinfo.properties");  
			fis = DBUtil.class.getClassLoader().getResourceAsStream("dbinfo.properties");
			pp.load(fis);
			url = pp.getProperty("url");
			username = pp.getProperty("username");
			driver = pp.getProperty("driver");
			passwd = pp.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fis = null;//关闭流文件
		}
	}

	//得到链接
	public static Connection getConnection() {
		try {
			ct = DriverManager.getConnection(url,username,passwd);
		} catch (Exception e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}
		return ct;
	}

	public static Connection getCt() {
		return ct;
	}

	public static PreparedStatement getPs() {
		return ps;
	}

	public static ResultSet getRs() {
		return rs;
	}
	

	public static void close(ResultSet rs, Statement ps, Connection ct) {
		//关闭链接
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ps = null;
		}
		if (null != ct) {
			try {
				ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ct = null;
		}
	}
}
