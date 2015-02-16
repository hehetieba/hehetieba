package hehetieba.dao;

import java.util.List;

import hehetieba.basic.Pager;
import hehetieba.domain.Tieba;

public interface ITiebaDao extends IBaseDao<Tieba> {
	/**
	 * 首页中，分页查找
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<Tieba> list(Integer index,Integer size);
	/**
	 * 根据userId查找关注的贴吧(返回tiebaId，tiebaName)
	 * @param userId
	 * @return
	 */
	public List listFavoriteTieba(Integer userId);
	 
}
