package com.qzp.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qzp.domain.Advice;
import com.qzp.utils.DBUtil;
import com.qzp.utils.SqlHelper;

public class AdviceService {
	private Connection conn = null;
	private PreparedStatement pres = null;
	private ResultSet res = null;
	
	public void addAdvice(Advice advice) {		
		try {
			java.util.Date date = new java.util.Date();
			java.sql.Date my_date = new java.sql.Date(date.getTime()); 
			conn = DBUtil.getConnection();
			String sql = "insert into advice(userid,date,title,neirong) values (?,?,?,?)";
			pres = conn.prepareStatement(sql);
			pres.setInt(1, advice.getUserid());
			pres.setDate(2, my_date);
			pres.setString(3, advice.getTitle());
			pres.setString(4, advice.getNeirong());
			pres.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(res, pres, conn);
		}
	}
	
	public ArrayList<Advice> getAdvice() {
		String sql = "select * from advice where 1 = ?";
		String[] parameters = {"1"};
		ArrayList arrayList = SqlHelper.executeQuery(sql, parameters);
		ArrayList<Advice> adviceList = new ArrayList<Advice>();
		for(int i = 0 ;i<arrayList.size() ; i++) {
			Object[] object = (Object[]) arrayList.get(i);
			Advice advice = new Advice();
			advice.setId(Integer.valueOf(object[0].toString()));
			advice.setUserid(Integer.valueOf(object[1].toString()));
			advice.setDate(Date.valueOf(object[2].toString()));
			advice.setTitle(object[3].toString());
			advice.setNeirong(object[4].toString());
			adviceList.add(advice);
		}
		return adviceList;
	}
}
