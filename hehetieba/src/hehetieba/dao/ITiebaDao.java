package hehetieba.dao;

import java.util.List;

import hehetieba.basic.Pager;
import hehetieba.domain.Tieba;
import hehetieba.dto.TiebaDto;

public interface ITiebaDao extends IBaseDao<Tieba> {
	/**
	 * 首页中，分页
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
	public List listFavoriteTiebas(Integer userId);
	/**
	 * 分页查找tiebaName
	 * @param index
	 * @param size
	 * @param tiebaName
	 * @return
	 */
	public Pager<Tieba> findByUserName(Integer index, Integer size,String tiebaName);
	/**
	 * 获取TiebaDto
	 * @param id
	 * @return
	 */
	public TiebaDto getDtoById(Integer id);
}
