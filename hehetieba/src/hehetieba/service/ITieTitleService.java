package hehetieba.service;

import hehetieba.basic.Pager;
import hehetieba.domain.TieTitle;

public interface ITieTitleService {
	/**
	 * 贴吧页面中，按顶置、lastPostTime排序分页
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<TieTitle> listInTiebaPage(Integer index,Integer size);
	/**
	 * 发帖，包括Tie的操作
	 * @return
	 */
	public boolean faTie(Integer userId,Integer tiebaId,String title,String body);
	/**
	 * 设置tieTitle顶置
	 * @param tieId
	 * @return
	 */
	public boolean setTop(Integer id);
}
