package com.userservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.BO.User;

import com.DAO.UserDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class UserServlet1
 */
@WebServlet("/UserServlet1")
public class UserServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="oracledb")
	public DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO.datasource = this.dataSource;
		//User emp1=new User("name","huh","huh");
		List<User> emp2=UserDAO.getUser();
		System.out.println(emp2);
		GsonBuilder gs=new GsonBuilder();
		Gson gson=gs.create();
		String jsonString=gson.toJson(emp2);
		response.getWriter().print(jsonString);
		System.out.println(emp2);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("post method");
		UserDAO.datasource=this.dataSource;
	    //Employee emp=new Employee(19,"Mandep","Modinagar",7000.0);
		
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader bf=new BufferedReader(reader);
		String jsonString=bf.readLine();
		System.out.println(jsonString);

	     Gson gson=new Gson();
	     User e =gson.fromJson(jsonString,User.class);
	     
	     if(UserDAO.validateUser(e)){
	    	 System.out.println("success");
	     }
	     
	     int i1=UserDAO.addUser(e);
	     if(i1>0){
	    	 System.out.println("added");
	    	 
	    	 
	     }
	     
	     else
	    	 response.getWriter().write(gson.toJson("{addsuccess:'ok}"));
		
		
	}
	}

