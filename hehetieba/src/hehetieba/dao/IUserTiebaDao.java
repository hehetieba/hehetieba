package hehetieba.dao;

import hehetieba.domain.Tieba;
import hehetieba.domain.User;
import hehetieba.domain.UserTieba;

public interface IUserTiebaDao extends IBaseDao<UserTieba> {
	/**
	 * 检查用户跟贴吧是否关注
	 * @param user
	 * @param tieba
	 * @return >0表示用户有关注
	 */
	public Integer checkFocused(User user,Tieba tieba);
	/**
	 * 根据user和tieba计算UserTitba表中对应的数量
	 * @param user
	 * @param tieba
	 * @return >0表示用户曾经关注过
	 */
	public Integer calCountByUser_Tieba(User user,Tieba tieba);
	/**
	 * 根据User,Tieba得到UserTieba
	 * @param userId
	 * @param tiebaId
	 * @return
	 */
	public UserTieba loadByUser_Tieba(User user,Tieba tieba);
	/**
	 * 更新UserTieba的enabled
	 * @param user
	 * @param tieba
	 * @return
	 */
	public Integer updateEnableToZero(User user,Tieba tieba);
	
}
