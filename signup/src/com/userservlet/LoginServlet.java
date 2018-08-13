package com.userservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


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


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="oracledb")
	public DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*UserDAO.datasource = this.dataSource;
		//User emp1=new User("name","huh","huh");
		System.out.println("do get");
		List<User> emp2=UserDAO.getUser();
		System.out.println(emp2);
		GsonBuilder gs=new GsonBuilder();
		Gson gson=gs.create();
		String jsonString=gson.toJson(emp2);
		response.getWriter().print(jsonString);
		System.out.println(emp2);*/
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
	    	 response.getWriter().write(gson.toJson(true));
	    	 
	     }
	     
	    
	     else {
	    	 System.out.println("Invalid credentials");
	    	 response.getWriter().write(gson.toJson(false));
	     }
		
	}
	}

