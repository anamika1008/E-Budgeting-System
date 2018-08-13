package userservlet;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.BO.ServiceBO;
import com.BO.Chart;
import com.DAO.ServiceTestSet;
import com.DAO.UserDAO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ServeBarGraph
 */
@WebServlet("/ServeBarGraph")
public class ServeBarGraph extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource (name="oracledb")
	private DataSource dataSource;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeBarGraph() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO.datasource = this.dataSource;
		List<Chart> chartData = UserDAO.getChart();
		GsonBuilder gs=new GsonBuilder();
		Gson gson=gs.create();
		String jsonString=gson.toJson(chartData);
		response.setContentType("application/json");
		response.getWriter().print(jsonString);
		System.out.println(chartData);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ServiceTestSet.datasource=this.dataSource;
	    //Employee emp=new Employee(19,"Mandep","Modinagar",7000.0);
		
		InputStreamReader reader=new InputStreamReader(request.getInputStream());
		BufferedReader bf=new BufferedReader(reader);
		String jsonString=bf.readLine();
		System.out.println(jsonString);

	     Gson gson=new Gson();
	     //
	     ServiceBO e =gson.fromJson(jsonString,ServiceBO.class);
	     java.util.List<Double> returnlist=new LinkedList<>();
	     returnlist=ServiceTestSet.getYearAvg();
	     
	    	 response.getWriter().write(gson.toJson(returnlist));
	    	 
	   
	}

}
