package hehetieba.service;

import hehetieba.basic.Pager;
import hehetieba.domain.Tie;

public interface ITieService{
	/**
	 * 帖子页面，回帖
	 * @return
	 */
	public Tie post(Integer tieTitleId,Integer sendUserId,Integer beSendUserId,String body);
	/**
	 * 在帖子页面，分页显示所有贴
	 * @return
	 */
	public Pager<Tie> listInTiePage(Integer tieTitleId,Integer index,Integer size);
}
