package Auth;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Backend
 */


@WebServlet(description="HTML" , urlPatterns={"/Auth"})

public class Backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Backend() {
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
		
		if (request.getParameter("foodtype") != null || request.getParameter("location") != null)
		
		{
			
		String foodtype =  request.getParameter("foodtype").toString();
				
		String location = request.getParameter("location").toString();
		
		beans b = new beans();
		
		try 
		{
			
			ArrayList<String> match = b.search(foodtype,location);
			
			//response.setContentType("application/json");
	      
			response.getWriter().write(" what we found in our DB is  ");
			response.getWriter().write(match.toString());
		}
		
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		}
		
	}

	}
}
