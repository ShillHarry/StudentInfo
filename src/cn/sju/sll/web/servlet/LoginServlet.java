package cn.sju.sll.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.sju.sll.domain.User;
import cn.sju.sll.utils.DbUtils;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String sql = "SELECT * FROM admin";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		connection = DbUtils.getConnection();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(connection != null) {
			try {
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				boolean exists = false;
				while (resultSet.next()) {
					if (username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password"))) {
						exists = true;
						break;
					}else {
						exists = false;
					}
				}
				if(exists) {
					request.getSession().setAttribute("loginuser", username);
					response.sendRedirect(request.getContextPath()+"/index.jsp");
				}else {
					request.getSession().setAttribute("loginuser", null);
					response.sendRedirect("login.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.close(connection, preparedStatement, resultSet);
			}
		}

		
	}

}
