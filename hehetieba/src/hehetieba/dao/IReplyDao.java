package hehetieba.dao;

import hehetieba.domain.Reply;
import hehetieba.domain.TieTitle;

public interface IReplyDao extends IBaseDao<Reply> {
	/**
	 * 根据tieTitle删除reply(tietitle跟reply是一对多的关系)
	 */
	public Integer deleteByTieTitle(TieTitle tieTitle);
}
