package hehetieba.service;

import java.util.List;

import hehetieba.basic.Pager;
import hehetieba.domain.Tieba;

public interface ITiebaService {
	/**
	 * 首页中分页且排序显示全部贴吧
	 * @return
	 */
	public Pager list(Integer index,Integer size);
	/**
	 * 首页中按贴吧名字分页查找贴吧
	 * @param tiebaName
	 * @return
	 */
	public Pager<Tieba> findByTiebaName(String tiebaName);
	/**
	 * 根据tiebaId查tieba
	 * @param id
	 * @return
	 */
	public Tieba getById(Integer id);
	/**
	 * 返回爱逛的吧
	 * @param userId
	 * @return
	 */
	public List listFavoriteTieba(Integer userId);
}
