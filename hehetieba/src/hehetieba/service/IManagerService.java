package hehetieba.service;

public interface IManagerService {
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
}
