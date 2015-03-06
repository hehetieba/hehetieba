package hehetieba.service;

import java.util.List;

import hehetieba.basic.Pager;
import hehetieba.domain.Tieba;
import hehetieba.dto.TiebaDto;

public interface ITiebaService {
	/**
	 * 首页中分页且排序显示全部贴吧
	 * @return
	 */
	public Pager<Tieba> list(Integer index,Integer size);
	/**
	 * 首页中按贴吧名字分页查找贴吧
	 * @param tiebaName
	 * @return
	 */
	public Pager<Tieba> findByTiebaName(Integer index, Integer size,String tiebaName);
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
	public List<Tieba> listFavoriteTiebas(Integer userId);
	/**
	 * 返回TiebaDto
	 * @param id
	 * @return
	 */
	public TiebaDto getDtoById(Integer id);
	/**
	 * 在后台页面新建一个贴吧
	 * @param tiebaName
	 */
	public void saveTieba(String tiebaName,Integer tiebaApplyId);
	/**
	 * 在后台页面，不创建贴吧，更新tiebaApply.handleStatus为2
	 * @param tiebaName
	 * @param tiebaApplyId
	 */
	public void notSaveTieba(String tiebaName,Integer tiebaApplyId);
}
