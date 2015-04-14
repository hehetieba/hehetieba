package hehetieba.service;

import hehetieba.domain.Tieba;
import hehetieba.domain.User;

public interface IUserTiebaService {
	/**
	 * 检查用户跟贴吧是否关注
	 * @param userId
	 * @param tiebaId
	 * @return
	 */
	public boolean checkFocused(Integer userId,Integer tiebaId);
	/**
	 * 关注贴吧
	 * @param userId
	 * @param tiebaId
	 */
	public void focus(Integer userId,Integer tiebaId);
	/**
	 * 根据userId和tiebaId查找UserTieba
	 * @return
	 */
	public boolean checkBaZhu(Integer userId,Integer tiebaId);
	/**
	 * 用户取消对某贴吧的关注
	 * @param userId
	 * @param tiebaId
	 * @return
	 */
	public Integer cancelFosus(Integer userId,Integer tiebaId);
}
