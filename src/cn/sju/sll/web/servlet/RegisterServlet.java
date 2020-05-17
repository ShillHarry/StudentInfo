package cn.sju.sll.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sju.sll.utils.DbUtils;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO admin(username,password) VALUES(?,?)";
		connection = DbUtils.getConnection();
		if(connection !=null) {
			try {
				preparedStatement = connection.prepareStatement(sql);
				System.out.println(request.getParameter("username"));
				System.out.println(request.getParameter("password"));
				preparedStatement.setString(1, request.getParameter("username"));
				preparedStatement.setString(2, request.getParameter("password"));
				preparedStatement.executeUpdate();
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.close(connection, preparedStatement);
			}
		}
	
	}

}
