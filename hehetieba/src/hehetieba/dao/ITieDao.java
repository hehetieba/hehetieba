package hehetieba.dao;

import hehetieba.basic.Pager;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.domain.User;

public interface ITieDao extends IBaseDao<Tie> {
	/**
	 * 根据tieTitle删除tie(tietitle跟tie是一对多的关系)
	 */
	public Integer deleteByTieTitle(TieTitle tieTitle);
	/**
	 * 根据sendUser字段查找
	 * @param sendUserId
	 * @return
	 */
	public Pager<Tie> findBySendUser(User sendUser,Integer index,Integer size);
	/**
	 * 根据beSendUser字段查找
	 * @param beSendUser
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<Tie> findByBeSendUser(User beSendUser,Integer index,Integer size);
}
