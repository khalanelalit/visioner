package com;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;


/**
 * Servlet implementation class epreg
 */

public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
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
		Connection con=DbConnection.connect();
		
		int gid=0;
		PreparedStatement st;
		
		
		try {
			String Fname=(request.getParameter("Name"));
			String Lname=(request.getParameter("lName"));
			String Email=(request.getParameter("email"));
			String Address=(request.getParameter("pass"));
			String add=(request.getParameter("number"));
			String City=(request.getParameter("add"));
			 int zip =Integer.parseInt(request.getParameter("code"));
			
			
			st=con.prepareStatement("insert into Address values(?,?,?,?,?,?,?,?)");
			st.setInt(1,gid);
			st.setString(2,Fname);
			st.setString(3,Lname);
			st.setString(4,Email);
			st.setString(5,Address);
			st.setString(6,add);
			st.setString(7,City);
			st.setInt(8,zip);
		
			
			int i =st.executeUpdate();
			if(i>0)
			{ 
			response.sendRedirect("payoperation.html");
			}
			else 
			{
				response.sendRedirect("add.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
