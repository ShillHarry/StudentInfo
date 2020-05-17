package cn.sju.sll.test;

import java.util.*;

import org.junit.Test;

import cn.sju.sll.dao.UserDao;
import cn.sju.sll.dao.impl.UserDaoImpl;
import cn.sju.sll.domain.User;

public class UserTest {
	@Test
	public void testInsert() {
		User user = new User();
		user.setID("10000");
		user.setName("张三");
		user.setSex(true);
		user.setBirthday(new Date());
		user.setAge(20);
		user.setPhoneNumber("13700000000");
		UserDao userDao = new UserDaoImpl();
		System.out.println(userDao.save(user));
	}
	
	@Test
	public void testFindByID() {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findByID("10000");
		System.out.println(user);
	}
	
	@Test
	public void testfindAll() {
		UserDao userDao = new UserDaoImpl();
		List<User> users = userDao.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testUpdate() {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findByID("10000");
		System.out.println("更新前的用户信息" + user);
		user.setName("李四");
		user.setSex(false);
		user.setAge(21);
		userDao.update(user);
		user = userDao.findByID("10000");
		System.out.println("更新后的用户信息" + user);
	
	}
	
	@Test
	public void testdeleteByID() {
		UserDao userDao = new UserDaoImpl();
		userDao.deleteByID("10000");
	}
}
