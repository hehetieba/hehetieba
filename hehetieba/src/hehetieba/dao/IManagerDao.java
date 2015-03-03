package hehetieba.dao;

import hehetieba.domain.Manager;

public interface IManagerDao extends IBaseDao<Manager> {
	/**
	 * 更新管理员未读消息提示
	 * @return
	 */
	public Integer updateTiabaApplyRead_All();
}
