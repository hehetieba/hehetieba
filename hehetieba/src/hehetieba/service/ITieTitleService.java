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
	public Pager<TieTitle> listInTiebaPage(Integer index,Integer size,Integer tiebaId);
	/**
	 * 列出加精的帖子，按时间排序，分页
	 * @param index
	 * @param size
	 * @param tiebaId
	 * @return
	 */
	public Pager<TieTitle> listJingPin(Integer index,Integer size,Integer tiebaId);
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
	/**
	 * 设置tieTitle取消顶置
	 * @param tieId
	 * @return
	 */
	public boolean cancelSetTop(Integer id);
	/**
	 * 对tieTitle加精
	 * @param id
	 * @return
	 */
	public boolean jiajing(Integer id);
	/**
	 * 对tieTitle取消加精
	 * @param id
	 * @return
	 */
	public boolean cancelJiajing(Integer id);
	/**
	 * 根据tieTitleId获取TieTitle
	 * @param tieTitleId
	 * @return
	 */
	public TieTitle getTieTitleById(Integer tieTitleId);
	/**
	 * 根据tieTitleId删除tieTitle，并且同时删除对应的tie和reply
	 * @param tieTitleId
	 * @return
	 */
	public Integer deleteByTieTitleId(Integer tieTitleId);
}
