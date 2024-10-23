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
public class comreg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comreg() {
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
		int cid=0;
		PreparedStatement st;
		
		
		try {
			String Name=(request.getParameter("name"));
			String Email=(request.getParameter("email"));
			String pass=(request.getParameter("pass"));
			String Phone=(request.getParameter("number"));
			String Address=(request.getParameter("add"));
			
			
			st=con.prepareStatement("insert into company values(?,?,?,?,?,?,?)");
			st.setInt(1,cid);
			st.setString(2,Name);
			st.setString(3,Email);
			st.setString(4, pass);
			st.setString(5,Phone);
			st.setString(6,Address);
			st.setString(7,"pending");
			
			
			
			
			int i =st.executeUpdate();
			if(i>0)
			{ 
			response.sendRedirect("index.html");
			}
			else 
			{
				response.sendRedirect("comreg.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
