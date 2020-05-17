package cn.sju.sll.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import cn.sju.sll.dao.UserDao;
import cn.sju.sll.domain.User;
import cn.sju.sll.utils.DbUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean save(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO student(ID,Name,Sex,Age,department,PhoneNumber,dorm,Birthday) VALUES(?,?,?,?,?,?,?,?)";
		boolean result = false;
		connection = DbUtils.getConnection();
		if(connection !=null) {
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, user.getID());
				preparedStatement.setString(2, user.getName());
				preparedStatement.setBoolean(3, user.getSex());
				preparedStatement.setInt(4, user.getAge());
				preparedStatement.setString(5, user.getDepartment());
				preparedStatement.setString(6, user.getPhoneNumber());
				preparedStatement.setString(7, user.getDorm());
				preparedStatement.setDate(8, new java.sql.Date(user.getBirthday().getTime()));
				int n = preparedStatement.executeUpdate();
				if(n>0) {
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.close(connection, preparedStatement);
			}
		}
		return result;
	}

	@Override
	public User findByID(String ID) {
		String sql = "SELECT * FROM student WHERE ID=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		connection = DbUtils.getConnection();
		if(connection != null) {
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, ID);
				resultSet = preparedStatement.executeQuery();//查询操作，返回结果集
				if(resultSet.next()) {
					user = new User();
					user.setID(resultSet.getString("ID"));
					user.setName(resultSet.getString("Name"));
					user.setSex(resultSet.getBoolean("Sex"));
					user.setBirthday(resultSet.getDate("Birthday"));
					user.setAge(resultSet.getInt("Age"));
					user.setPhoneNumber(resultSet.getString("PhoneNumber"));
					user.setDepartment(resultSet.getString("department"));
					user.setDorm(resultSet.getString("dorm"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.close(connection, preparedStatement, resultSet);
			}
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM student";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> list = new ArrayList<User>();
		connection = DbUtils.getConnection();
		if(connection !=null) {
			try {
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				User user = null;
				while (resultSet.next()) {
					user = new User();
					user.setID(resultSet.getString("ID"));
					user.setName(resultSet.getString("Name"));
					user.setSex(resultSet.getBoolean("Sex"));
					user.setBirthday(resultSet.getDate("Birthday"));
					user.setAge(resultSet.getInt("Age"));
					user.setPhoneNumber(resultSet.getString("PhoneNumber"));
					user.setDepartment(resultSet.getString("department"));
					user.setDorm(resultSet.getString("dorm"));
					list.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.close(connection, preparedStatement, resultSet);
			}

		}
		return list;
	}

	@Override
	public void update(User user) {
		String sql = "UPDATE student SET Name=?,Sex=?,Age=?,department=?,PhoneNumber=?,dorm=?,Birthday=? WHERE ID=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DbUtils.getConnection();
		if(connection != null) {
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, user.getName());
				preparedStatement.setBoolean(2, user.getSex());
				preparedStatement.setInt(3, user.getAge());
				preparedStatement.setString(4, user.getDepartment());
				preparedStatement.setString(5, user.getPhoneNumber());
				preparedStatement.setString(6, user.getDorm());
				preparedStatement.setDate(7, new java.sql.Date(user.getBirthday().getTime()));
				preparedStatement.setString(8, user.getID());
				int n = preparedStatement.executeUpdate();
				if(n>0) {
					System.out.println("更新用户信息成功");
				}else {
					System.out.println("更新用户信息失败");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.close(connection, preparedStatement);
			}
			
		}
	}

	@Override
	public void deleteByID(String ID) {
		String sql = "DELETE FROM student WHERE ID=?";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		connection = DbUtils.getConnection();
		if(connection != null) {
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, ID);
				int n = preparedStatement.executeUpdate();
				if(n>0) {
					System.out.println("删除用户成功");
				}else {
					System.out.println("删除用户失败");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DbUtils.close(connection,preparedStatement);
			}
			
		}
	}

}
