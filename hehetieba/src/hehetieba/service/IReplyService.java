package hehetieba.service;

import hehetieba.basic.Pager;
import hehetieba.domain.Reply;

public interface IReplyService {
	/**
	 * 帖子页面，回复别人
	 * @return
	 */
	public Reply reply(Integer tieTitleId,Integer tieId,Integer sendUserId,Integer beSendUserId,String body);
	/**
	 * 帖子页面，在帖子下显示回复
	 * @param tieId
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<Reply> listInTiePage(Integer tieId,Integer index,Integer size);
	/**
	 * 个人中心中，用户查找自己的回复
	 * @param sendUserId
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<Reply> findMyReply(Integer sendUserId,Integer index,Integer size);
	/**
	 * 个人中心中，用户查找别人回复自己的回复
	 * @param sendUserId
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<Reply> findOtherSendToMeReply(Integer beSendUserId,Integer index,Integer size);
}
