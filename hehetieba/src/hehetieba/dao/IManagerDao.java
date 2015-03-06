package hehetieba.dao;

import hehetieba.domain.Manager;

public interface IManagerDao extends IBaseDao<Manager> {
	/**
	 * 提示管理员有未读的贴吧申请消息
	 * @return
	 */
	public Integer updateTiabaApplyReadToHave_All();
	/**
	 * 设置管理员木有未读贴吧申请消息
	 * @return
	 */
	public Integer updateTiabaApplyReadToNon_All();
	/**
	 * 提示管理员有未读的吧主申请消息
	 * @return
	 */
	public Integer updateTiabaOwnerApplyReadToHave_All();
	/**
	 * 设置管理员木有未读吧主申请消息
	 * @return
	 */
	public Integer updateTiabaOwnerApplyReadToNon_All();
}
