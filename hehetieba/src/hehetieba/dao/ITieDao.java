package hehetieba.dao;

import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;

public interface ITieDao extends IBaseDao<Tie> {
	/**
	 * 根据tieTitle删除tie(tietitle跟tie是一对多的关系)
	 */
	public Integer deleteByTieTitle(TieTitle tieTitle);
}
