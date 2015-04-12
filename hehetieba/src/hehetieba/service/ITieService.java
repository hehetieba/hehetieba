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
	/**
	 * 个人中心中，用户查找自己回的帖
	 * @param sendUserId
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<Tie> findMyTie(Integer sendUserId,Integer index,Integer size);
	/**
	 * 个人中心，用户查找别人回自己的贴
	 * @param beSendUserId
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<Tie> findOtherSendToMeTie(Integer beSendUserId,Integer index,Integer size);
}
