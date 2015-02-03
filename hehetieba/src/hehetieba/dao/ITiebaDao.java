package hehetieba.dao;

import java.util.List;

import hehetieba.domain.Tieba;

public interface ITiebaDao extends IBaseDao<Tieba> {
	/**
	 * 根据userId查找关注的贴吧(返回tiebaId，tiebaName)
	 */
	public List listFavoriteTieba(Integer userId);
}
