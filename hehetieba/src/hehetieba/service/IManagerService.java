package hehetieba.service;

import hehetieba.domain.Manager;

public interface IManagerService {
	/**
	 * 设置管理员有未读的贴吧申请消息
	 * @return
	 */
	public Integer updateTiabaApplyReadToHave_All();
	/**
	 * 设置管理员木有未读贴吧申请消息
	 * @return
	 */
	public Integer updateTiabaApplyReadToNon_All();
	/**
	 * 管理员登录
	 * @param username
	 * @param pwd
	 * @return
	 */
	public boolean login(String managername,String pwd);
	/**
	 * 修改管理员密码
	 * @param oldPwd
	 * @param newPwd
	 */
	public boolean changePwd(String oldPwd,String newPwd);
	/**
	 * 检查是否有贴吧申请消息
	 * @return
	 */
	public boolean checkTiebaApplyRead();
	/**
	 * 检查是否有贴吧吧主
	 * 申请消息
	 * @return
	 */
	public boolean checkTiebaOwnerApplyRead();
	/**
	 * 根据managerId获取manager
	 * @param managerId
	 * @return
	 */
	public Manager getById(Integer managerId);
}
