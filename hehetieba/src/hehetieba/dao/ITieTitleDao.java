package hehetieba.dao;

import hehetieba.basic.Pager;
import hehetieba.domain.TieTitle;

public interface ITieTitleDao extends IBaseDao<TieTitle> {
	/**
	 * 贴吧页面中，按顶置、lastPostTime排序分页
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<TieTitle> listInTiebaPage(Integer index,Integer size);
}









