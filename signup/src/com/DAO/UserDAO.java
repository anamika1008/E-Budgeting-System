package com.DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.BO.User;
import com.BO.Chart;
public class UserDAO {
public static DataSource datasource;
 
	
	
	private static Connection getConnection() {
	
		
		Connection con=null;
		
		try {
			
			//Class.forName("oracle.jdbc.OracleDriver");
			con = datasource.getConnection();
			System.out.println(con);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static int addUser(User emp) {
		//write code to perform insert operation
		
         Connection con=null;
     	PreparedStatement ps=null;
		String sql = "INSERT INTO us VALUES(?,?,?)";
		int result = 0;
		try {
			
			con = getConnection();
			System.out.println(con);
		    ps = con.prepareStatement(sql);
			ps.setString(1, emp.getName());
			
			ps.setString(2,emp.getPass());
			ps.setString(3,emp.getEmail());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con);
		}
		return result;
	}
	public static List<User> getUser(){
//		List<Employee> elist=new ArrayList<>();
		
		Connection con=null;
		String sql = "SELECT name,pass,email from us";
		//int result = 0;
		List<User> empList = new ArrayList<>();
		System.out.println(con);
		try {
			
			
			
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			
		   
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String name = rs.getString("name");
				String pass = rs.getString("pass");
				String mail=rs.getString("email");
				User e = new User(name,pass,mail);
				empList.add(e);
			}
			rs.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			closeConnection(con);
		}
		
		return empList;
	}
	public static List<Chart> getChart(){

		Connection con=null;
		String sql = "select extract(YEAR FROM dateEx) as year,SUM(budget) as sum from Services group by extract(YEAR FROM dateEx) order by extract(YEAR FROM dateEx)";
		List<Chart> empList = new ArrayList<>();
		try {
			
			con = getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int i=1;
			while(rs.next()) {
				
				Chart e = new Chart(i++,rs.getString("year"),Double.parseDouble(rs.getString("sum")));
				empList.add(e);
			}
			rs.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}finally {
			closeConnection(con);
		}
		
		return empList;
	}
	
	public static boolean validateUser(User uss){
		boolean a=false;
		Connection con=getConnection();
		String sql="SELECT * from us where email=?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(sql);
		
		st.setString(1, uss.getEmail());
		ResultSet rs=st.executeQuery();
		
		//con.close();
		if(rs.next()) {
		if(rs.getString("pass").equals(uss.getPass()))
			a= true;
		}
		else 
			a= false;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	
	
	private static void closeConnection(Connection con) {
		
		try {
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
}