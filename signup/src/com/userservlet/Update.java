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

import com.BO.ServiceBO;
import com.DAO.ServiceTestSet;
import com.google.gson.Gson;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource (name="oracledb")
	private DataSource datasouce;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		ServiceTestSet.datasource=this.datasouce;
		InputStreamReader reader = new InputStreamReader(request.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		String jsonString = br.readLine();
		System.out.println(jsonString);
	
		Gson gson = new Gson();
		ServiceBO serve =  gson.fromJson(jsonString, ServiceBO.class);
		int i=ServiceTestSet.updateService(serve);
//		String g=gson.toJson(i);
//		response.getWriter().print(g);
		if(i>0)
		{response.getWriter().write(gson.toJson("Updated table"));
		System.out.println("Received value "+i);
		}
		else {
			response.getWriter().write(gson.toJson("Failed  to update"));
			System.out.println("Received value "+i);
				
		}
	}

}
