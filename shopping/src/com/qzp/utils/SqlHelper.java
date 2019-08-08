package com.qzp.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


import java.sql.*;

public class SqlHelper {
	//定义变量
	private static Connection connection = null;
	 //大多数情况下用preparedstatement替代statement
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
	

	public static ArrayList executeQuery(String sql, String[] parameters) {
		ArrayList al = new ArrayList();
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					preparedStatement.setObject(i + 1, parameters[i]);
				}
			}
			resultSet = preparedStatement.executeQuery();
			
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			//通过上一对象获得结果有多少列
			int columnNum = resultSetMetaData.getColumnCount();
			//循环获取,封装到ArrayList结果集
			while(resultSet.next()) {
				Object[] objects = new Object[columnNum];
				for(int i = 0;i < objects.length;i++) {
					objects[i] = resultSet.getObject(i + 1);
				}
				
				al.add(objects);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		return al;
	}



	public static void executeUpdate2(String[] sql, String[][] parameters) {
		try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);

			for (int i = 0; i < sql.length; i++) {

				if (null != parameters[i]) {
					preparedStatement = connection.prepareStatement(sql[i]);
					for (int j = 0; j < parameters[i].length; j++) {
						preparedStatement.setString(j + 1, parameters[i][j]);
					}
					preparedStatement.executeUpdate();
				}

			}

			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}

	}

	//先写一个update、delete、insert
    //sql格式：update 表名 set 字段名 =？where 字段=？
    //parameter神应该是（”abc“,23）
	public static void executeUpdate(String sql, String[] parameters) {
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			if (parameters != null) {
				for (int i = 0; i < parameters.length; i++) {
					preparedStatement.setString(i + 1, parameters[i]);
				}

			}
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();//开发阶段
            //抛出异常
            //可以处理，也可以不处理
			throw new RuntimeException(e.getMessage());
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
	}

}
