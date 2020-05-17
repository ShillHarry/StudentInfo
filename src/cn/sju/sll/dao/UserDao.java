package cn.sju.sll.dao;

import java.util.List;

import cn.sju.sll.domain.User;

public interface UserDao {
	public boolean save(User user);//�����û���Ϣ
	public User findByID(String ID);//ͨ����Ų�ѯ�û�
	public List<User> findAll();//��ѯ�����û���Ϣ
	public void update(User user);//����
	public void deleteByID(String ID);//ͨ�����ɾ��
}
