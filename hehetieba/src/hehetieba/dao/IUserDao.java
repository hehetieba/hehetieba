package hehetieba.dao;

import hehetieba.domain.User;

public interface IUserDao extends IBaseDao<User> {
	// 检查是否有这个用户
	public boolean checkUsername(String username);

	// 检查是否有这个昵称
	public boolean checkNickname(String nickname);
}
