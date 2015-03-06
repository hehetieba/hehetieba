package hehetieba.service.impl;

import java.util.HashMap;
import java.util.Map;

import hehetieba.basic.Pager;
import hehetieba.dao.ITieDao;
import hehetieba.dao.ITieTitleDao;
import hehetieba.dao.ITiebaDao;
import hehetieba.dao.IUserDao;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.domain.User;
import hehetieba.service.ITieService;

public class TieService implements ITieService {
	private ITieDao iTieDao;
	private IUserDao iUserDao;
	private ITieTitleDao iTieTitleDao;
	
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

	public ITieTitleDao getiTieTitleDao() {
		return iTieTitleDao;
	}

	public void setiTieTitleDao(ITieTitleDao iTieTitleDao) {
		this.iTieTitleDao = iTieTitleDao;
	}

	/*----------------分割线---------------*/
	
	@Override
	public Tie post(Integer tieTitleId, Integer sendUserId,
			Integer beSendUserId, String body) {
		// TODO Auto-generated method stub
		//1、修改该帖子的最高楼，修改该贴的最后回贴/复人
		TieTitle tieTitle = iTieTitleDao.load(tieTitleId);
		Integer maxFloor = tieTitle.getMaxFloor();
		maxFloor++;
		tieTitle.setMaxFloor(maxFloor);
		User sendUser = iUserDao.load(sendUserId);
		User beSendUser = iUserDao.load(beSendUserId);
		tieTitle.setLastPostUserName(sendUser.getUsername());
		//2、检查是否是自己发的帖子，如果不是就提醒楼主有新消息
		if(sendUserId!=beSendUserId)
			beSendUser.setTieRead((byte)1);
		//3、new tie
		Tie tie = this.newAnDefaultTie();
		tie.setTieTitle(tieTitle);
		tie.setFloor(maxFloor);
		tie.setSendUser(sendUser);
		tie.setBeSendUser(beSendUser);
		tie.setBody(body);
		//save tie
		iTieDao.save(tie);
		
		return tie;
	}

	@Override
	public Pager<Tie> listInTiePage(Integer tieTitleId, Integer index,
			Integer size) {
		// TODO Auto-generated method stub
		TieTitle tieTitle = iTieTitleDao.load(tieTitleId);
		String hql = "from Tie t left join t.sendUser su where t.tieTitle=:tieTitle order by t.floor";
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("tieTitle", tieTitle);
		return iTieDao.find(hql, index, size, null, alias);
	}
	
	private Tie newAnDefaultTie() {
		Tie tie = new Tie();
		return tie;
	}

}
