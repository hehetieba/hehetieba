package hehetieba.dao;

import java.util.List;

import hehetieba.basic.Pager;
import hehetieba.domain.User;

public interface IUserDao extends IBaseDao<User> {
	// 检查是否有这个用户
	public boolean checkUsername(String username);

	// 检查是否有这个昵称
	public boolean checkNickname(String nickname);
	
	//根据用户名查找用户
	public User loadByUsername(String username);
	
	//后台分页模糊查找用户
	public Pager<User> findByUsername(String username);
}







