package hehetieba.dao;

import hehetieba.basic.Pager;
import hehetieba.domain.TieTitle;
import hehetieba.domain.Tieba;
import hehetieba.domain.User;

public interface ITieTitleDao extends IBaseDao<TieTitle> {
	/**
	 * 列出加精的帖子，按时间排序，分页
	 * @param index
	 * @param size
	 * @param tiebaId
	 * @return
	 */
	public Pager<TieTitle> listJingPin(Integer index,Integer size,Tieba tieba);
	/**
	 * 根据userId查找tietitle
	 * @param userId
	 * @return
	 */
	public Pager<TieTitle> getByUserId(User user,Integer index,Integer size);
	/**
	 * 根据title分页查找tietitle表
	 * @param title
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<TieTitle> findByTitle(String title,Integer index,Integer size);
}









