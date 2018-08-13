package com.userservlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.BO.ServiceYear;
import com.DAO.ServiceTestSet;
import com.google.gson.Gson;

/**
 * Servlet implementation class ServletDoughnutCharts
 */
public class ServletDoughnutCharts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource (name="oracledb")
	DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDoughnutCharts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ServiceTestSet.datasource=this.dataSource;
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader bf=new BufferedReader(reader);
		String jsonString=bf.readLine();
		System.out.println(jsonString);

	     Gson gson=new Gson();
	     //String e =gson.fromJson(jsonString,String.class);
	     //int year=Integer.parseInt(e);
	     List<ServiceYear> returnlist=new LinkedList<>();
	     returnlist=ServiceTestSet.getyearlybudget(2010);
	     
	    	 response.getWriter().write(gson.toJson(returnlist));
	    	 
	   
	}

}
