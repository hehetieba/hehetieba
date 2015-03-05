package hehetieba.dao;

import hehetieba.domain.Tieba;
import hehetieba.domain.User;
import hehetieba.domain.UserTieba;

public interface IUserTiebaDao extends IBaseDao<UserTieba> {
	/**
	 * 检查用户跟贴吧是否关注
	 * @param userId
	 * @param tiebaId
	 * @return
	 */
	public Integer checkFocused(User user,Tieba tieba);
}
