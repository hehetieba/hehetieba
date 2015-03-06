package hehetieba.service.impl;

import java.util.HashMap;
import java.util.Map;

import hehetieba.basic.Pager;
import hehetieba.dao.IReplyDao;
import hehetieba.dao.ITieDao;
import hehetieba.dao.ITieTitleDao;
import hehetieba.dao.IUserDao;
import hehetieba.domain.Reply;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.domain.User;
import hehetieba.service.IReplyService;

public class ReplyService implements IReplyService {
	private IReplyDao iReplyDao;
	private ITieTitleDao iTieTitleDao;
	private ITieDao iTieDao;
	private IUserDao iUserDao;
	
	public IReplyDao getiReplyDao() {
		return iReplyDao;
	}

	public void setiReplyDao(IReplyDao iReplyDao) {
		this.iReplyDao = iReplyDao;
	}

	public ITieTitleDao getiTieTitleDao() {
		return iTieTitleDao;
	}

	public void setiTieTitleDao(ITieTitleDao iTieTitleDao) {
		this.iTieTitleDao = iTieTitleDao;
	}

	public ITieDao getiTieDao() {
		return iTieDao;
	}

	public void setiTieDao(ITieDao iTieDao) {
		this.iTieDao = iTieDao;
	}

	public IUserDao getiUserDao() {
		return iUserDao;
	}

	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	// ------------华丽分割线------------
	@Override
	public Reply reply(Integer tieTitleId, Integer tieId, Integer sendUserId,
			Integer beSendUserId, String body) {
		// TODO Auto-generated method stub
		//准备好参数
		TieTitle tieTitle = iTieTitleDao.load(tieTitleId);
		Tie tie = iTieDao.load(tieId);
		User sendUser = iUserDao.load(sendUserId);
		User beSendUser = iUserDao.load(beSendUserId);
		//1、更新最后回复人
		tieTitle.setLastPostUserName(sendUser.getUsername());
		//2、检查是否回复自己，不是就提醒被回复人有新消息
		if(sendUserId!=beSendUserId)
			beSendUser.setReplyRead((byte)1);
		//3、设置reply，回复
		Reply reply = newAnDefaultReply();
		reply.setTieTitle(tieTitle);
		reply.setTie(tie);
		reply.setSendUser(sendUser);
		reply.setBeSendUser(beSendUser);
		reply.setBody(body);
		iReplyDao.save(reply);
		return reply;
	}
	

	@Override
	public Pager<Reply> listInTiePage(Integer tieId, Integer index, Integer size) {
		// TODO Auto-generated method stub
		Tie tie = iTieDao.load(tieId);
		String hql = "from Reply r left join r.sendUser su"
				+ " where r.tie=:tie "
				+ "order by r.createDate desc";
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("tie", tie);
		Pager<Reply> pagre = iReplyDao.find(hql, index, size, null, alias);
		return pagre;
	}
	
	private Reply newAnDefaultReply(){ 
		Reply reply = new Reply();
		return reply;
	}

}
