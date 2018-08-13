package com.userservlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.BO.ServiceBO;
import com.DAO.ServiceTestSet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ConnectLogin
 */
@WebServlet("/ConnectLogin")
public class ConnectLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource (name="oracledb")
	private DataSource datasouce;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //get list of yearly expenses
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServiceTestSet.datasource=this.datasouce;
		List list= ServiceTestSet.getYearAvg();
		GsonBuilder gs=new GsonBuilder();
		Gson gson=gs.create();
		String jsonString=gson.toJson(list);
		System.out.println(jsonString);
		response.getWriter().print(jsonString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//add service entry into table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServiceTestSet.datasource=this.datasouce;
		InputStreamReader reader = new InputStreamReader(request.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		String jsonString = br.readLine();
		System.out.println(jsonString);
		Gson gson = new Gson();

		ServiceBO serve =  gson.fromJson(jsonString, ServiceBO.class);
		int i=0;
		try {
			i = ServiceTestSet.addServices(serve);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		String g=gson.toJson(i);
//		response.getWriter().print(g);
		if(i>0)
		{response.getWriter().write(gson.toJson("Added"));
		System.out.println("Received value "+i);
		}
		else {
			response.getWriter().write(gson.toJson("Failed"));
			System.out.println("Received value "+i);
				
		}
		
	}
	
	
}
