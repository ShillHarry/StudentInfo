package cn.sju.sll.utils;

import java.sql.*;

public class DbUtils {
	private DbUtils() {	}
	//���������������ݿ�Ĺ�����
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "123456");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	//�ͷ���Դ������
	public static void close(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//��Ը��µ��ͷ�
	public static void close(Connection connection,Statement statement) {
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		close(connection);
	}
	//��Բ�ѯ���ͷ�
	public static void close(Connection connection,Statement statement,ResultSet resultSet) {
		if(resultSet !=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(connection, statement);
	}
}
