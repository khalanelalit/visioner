package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login2
 */
public class comlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comlogin () {
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
		
		int i=0;
		String email,pass;
		 email=request.getParameter("username");
		 pass=request.getParameter("password");
		 try {
			 Connection con=DbConnection.connect();
			PreparedStatement stmt=con.prepareStatement("select * from  sup where Email=? and Password=?");
			stmt.setString(1,email);
			stmt.setString(2, pass);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				//userinfo.get(Account);
				//System.out.println("successfully login");
				User.setcid(rs.getInt("cid"));
						response.sendRedirect("operation1.html");
		
			}
			else
			{
				response.sendRedirect("Login2.html");
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
