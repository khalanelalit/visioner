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

public class pay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pay() {
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
			String card=(request.getParameter("payment_method"));
			String upi=(request.getParameter("UPI"));
			String card_name=(request.getParameter("card_number"));
			String Name=(request.getParameter("card_holder"));
			
			
			 String ExDate =(request.getParameter("expiry_date"));
			 int CVV =Integer.parseInt(request.getParameter("cvv"));
			 int Amount =Integer.parseInt(request.getParameter("amount"));
				
			
			
			st=con.prepareStatement("insert into payment values(?,?,?,?,?,?,?,?,?)");
			st.setInt(1,gid);
			st.setString(2,card);
			st.setString(3,upi);
			st.setString(4,card_name);
			st.setString(5,Name);
			st.setString(6,ExDate);
			st.setInt(7,CVV);
			st.setInt(8,Amount);
			st.setString(9,"pending");
		
			
			int i =st.executeUpdate();
			if(i>0)
			{ 
			response.sendRedirect("pins.html");
			}
			else 
			{
				response.sendRedirect("payment.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
