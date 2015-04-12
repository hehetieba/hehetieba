package hehetieba.dao;

import hehetieba.basic.Pager;
import hehetieba.domain.Reply;
import hehetieba.domain.TieTitle;
import hehetieba.domain.User;

public interface IReplyDao extends IBaseDao<Reply> {
	/**
	 * 根据tieTitle删除reply(tietitle跟reply是一对多的关系)
	 */
	public Integer deleteByTieTitle(TieTitle tieTitle);
	/**
	 * 根据sendUser字段查找Reply,但是也只是查找部分字段,没用的字段就不查了
	 * @param sendUser
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<Reply> findBySendUser(User sendUser,Integer index,Integer size);
	/**
	 * 根据beSendUser字段查找Reply,但是也只是查找部分字段,没用的字段就不查了
	 * @param beSendUser
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<Reply> findByBeSendUser(User beSendUser,Integer index,Integer size);
}
