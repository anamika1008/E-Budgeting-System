package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import javax.sql.DataSource;

import com.BO.ServiceBO;
import com.BO.ServiceYear;



public class ServiceTestSet {

	public static DataSource datasource;
	
	public ServiceTestSet() {
		
	}
	//select dt_ex from trial where dt_ex between '01-01-2011' and '31-12-2011';
	public static int addServices(ServiceBO serve) throws ParseException{
		
		
		Connection con=getConnection();
		PreparedStatement ps=null;
		int a=0;
		String sql="INSERT INTO services values(?,?,?,?)";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setLong(1,serve.getService_id());
			ps.setString(2, serve.getService_name());
			System.out.println(serve.getDt());
			ps.setDate(3, new java.sql.Date((new SimpleDateFormat("dd-MM-yyyy").parse(serve.getDt()).getTime())));
			ps.setDouble(4, serve.getBudget());
			a=ps.executeUpdate();
			closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	//need to look out
	
	public static List<Double> getYearAvg(){
		
		List<Double> mylist=new ArrayList<Double>();
		String sql="select SUM(budget) from Services where extract(YEAR FROM dateEx)=?";
		ResultSet rs=null;
		Connection con=getConnection();
		
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
		
		for(int i=2010;i<=2018;i++){
		st.setInt(1, i);
		rs=st.executeQuery();
		if(rs.next())
		mylist.add(rs.getDouble(1));
		else
			mylist.add(0.0);
		}
		closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(mylist);
	return mylist;
	}
	public static Double getYearlyServicesAvg(int year,String service){
		//select dt_ex from trial where dt_ex between '01-01-2011' and '31-12-2011';
		//List<Double> mylist=new ArrayList<Double>();
		
		ResultSet rs=null;
		String sql="select SUM(budget) from Services where extract(YEAR FROM dateEx)=? and service=?";
		Connection con=getConnection();
		Double result=0.0;
		PreparedStatement st;
		try {
		st=con.prepareStatement(sql);
		st.setInt(1, year);
		st.setString(2, service);
		rs=st.executeQuery();
		if(rs.next())
			result=rs.getDouble(1);
		closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return result;
	}
	
	
	private static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private static Connection getConnection() {
		
		
		Connection con=null;
		try {
			con = datasource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;
	}
	public static List<ServiceYear> getyearlybudget(int year){
		List<ServiceYear> mylist=new LinkedList<>();
		ResultSet rs=null;
		String sql="select SUM(budget) from Services where extract(YEAR FROM dateEx)=? group by service";
		Connection con=getConnection();
		
		PreparedStatement st;
		try {
		st=con.prepareStatement(sql);
		st.setInt(1, year);
		rs=st.executeQuery();
		while(rs.next())
			mylist.add(new ServiceYear(rs.getDouble(1),rs.getString(2)));
		closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return mylist;
		
	}
//	public static void main(String[] args) {
//		/*List<Double> mylist=new ArrayList<Double>();
//		mylist=ServiceTestSet.getYearAvg();
//		for(Double d:mylist)
//			System.out.println(d);
//	*/
//		System.out.println(ServiceTestSet.addServices(new ServiceBO(101,"Sports","19-6-2018",29000.00)));
//	}
	@SuppressWarnings("finally")
	public static int deleteRecord(ServiceBO serve) {
		// TODO Auto-generated method stub
		
		Connection con=getConnection();
		PreparedStatement ps=null;
		int a=0;
		String sql="DELETE FROM services where sevice_id=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setLong(1,serve.getService_id());
//			ps.setString(2, serve.getService_name());
//			ps.setString(3, serve.getDt());
//			ps.setDouble(4, serve.getBudget());
			a=ps.executeUpdate();
			closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		return a;
		}
	}
	public static int updateService(ServiceBO serve) {
		Connection con=getConnection();
		PreparedStatement ps=null;
		int a=0;
		String sql="UPDATE services set budget=? where sevice_id=? and service=? and dateEx=?";
		
		try {
			ps=con.prepareStatement(sql);
			ps.setDouble(1,serve.getBudget());
			ps.setString(3, serve.getService_name());
			try {
				ps.setDate(4, new java.sql.Date((new SimpleDateFormat("dd-MM-yyyy").parse(serve.getDt()).getTime())));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ps.setInt(2, serve.getService_id());
			a=ps.executeUpdate();
			closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}
}
