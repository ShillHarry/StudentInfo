package cn.sju.sll.dao;

import java.util.List;

import cn.sju.sll.domain.User;

public interface UserDao {
	public boolean save(User user);//插入用户信息
	public User findByID(String ID);//通过编号查询用户
	public List<User> findAll();//查询所有用户信息
	public void update(User user);//更新
	public void deleteByID(String ID);//通过编号删除
}
