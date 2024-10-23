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
@MultipartConfig(maxFileSize = 16177215)
public class complent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public complent() {
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
		InputStream inputStream = null;
		Part filePart = null;
		int id=0;
		PreparedStatement st;
		
	
		try {
			String Name=(request.getParameter("name"));
			String Email=(request.getParameter("Email"));
			
			String number=(request.getParameter("number"));
			String Message=(request.getParameter("message"));
		
			
			st=con.prepareStatement("insert into complent values(?,?,?,?,?,?)");
			st.setInt(1,id);
			st.setString(2,Name);
			st.setString(3,Email);
		
			st.setString(4,number);
			
			st.setString(5,Message);
			
			st.setString(6,"pending");
			int i =st.executeUpdate();
			if(i>0)
			{ 
			response.sendRedirect("th.html");
			}
			else 
			{
				response.sendRedirect("index.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
