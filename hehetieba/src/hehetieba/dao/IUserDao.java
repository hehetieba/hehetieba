package hehetieba.dao;

import java.util.List;

import hehetieba.basic.Pager;
import hehetieba.domain.User;

public interface IUserDao extends IBaseDao<User> {
	/**
	 *  检查是否有这个用户
	 * @param username
	 * @return
	 */
	public Integer calcUsernameCount(String username);

	/**
	 *  检查是否有这个昵称
	 * @param nickname
	 * @return
	 */
	public Integer calcNicknameCount(String nickname);
	
	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	public User loadByUsername(String username);
	
	public User getByUsername(String username);
	
	
	/**
	 * 检查用户是否激活状态
	 * @param username
	 * @return true：表示激活
	 */
	public boolean checkUserEnabled(String username);
	/**
	 * 检查用户是否激活状态
	 * @param id
	 * @return true：表示激活
	 */
	public boolean checkUserEnabled(Integer id);
	/**
	 * 根据userId封号
	 * @param id
	 */
	public void disableUser(Integer id);
	/**
	 * 解封用户
	 * @param id
	 */
	public void enableUser(Integer id);
	
	/**
	 * 检查未读回帖
	 * @param id
	 * @return true：有未读回帖
	 */
	public boolean checkTieRead(Integer id);
	
	/**
	 * 检查未读回复
	 * @param id
	 * @return true：有未读回复
	 */
	public boolean checkReplyRead(Integer id);
	
	/**
	 * 检查吧主申请反馈
	 * @param id
	 * @return true：有未读反馈
	 */
	public boolean checkAllpyResultRead(Integer id);
	/**
	 * 后台分页模糊查找用户,根据username(用户名)或nickname(昵称)查找用户信息
	 * @param name
	 * @return
	 */
	public Pager<User> findByUsernameOrNickname(String name,Integer index,Integer size);
	/**
	 * 后台列出所有用户
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<User> findAll(Integer index,Integer size);
}







