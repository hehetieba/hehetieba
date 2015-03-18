package hehetieba.service.impl;

import hehetieba.basic.Pager;
import hehetieba.dao.ITieDao;
import hehetieba.dao.ITieTitleDao;
import hehetieba.dao.ITiebaDao;
import hehetieba.dao.IUserDao;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.domain.Tieba;
import hehetieba.domain.User;
import hehetieba.service.ITieTitleService;

import java.util.HashMap;
import java.util.Map;

public class TieTitleService implements ITieTitleService {
	ITieTitleDao iTieTitleDao;
	IUserDao iUserDao;
	ITiebaDao iTiebaDao;
	ITieDao iTieDao;

	public ITieTitleDao getiTieTitleDao() {
		return iTieTitleDao;
	}

	public void setiTieTitleDao(ITieTitleDao iTieTitleDao) {
		this.iTieTitleDao = iTieTitleDao;
	}
	
	public IUserDao getiUserDao() {
		return iUserDao;
	}

	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	public ITiebaDao getiTiebaDao() {
		return iTiebaDao;
	}

	public void setiTiebaDao(ITiebaDao iTiebaDao) {
		this.iTiebaDao = iTiebaDao;
	}

	public ITieDao getiTieDao() {
		return iTieDao;
	}

	public void setiTieDao(ITieDao iTieDao) {
		this.iTieDao = iTieDao;
	}

	/*--华丽分割线--*/
	@Override
	public Pager<TieTitle> listInTiebaPage(Integer index, Integer size,Integer tiebaId) {
		Tieba tieba = iTiebaDao.load(tiebaId);
		String hql = "from TieTitle tt left join fetch tt.user u "
				+ "where tt.tieba=:tieba order by tt.top desc,tt.lastPostTime desc";
		Map<String, Object> alias = new HashMap<String, Object>();
		alias.put("tieba", tieba);
		return iTieTitleDao.find(hql, index, size, null, alias);
	}

	@Override
	public Pager<TieTitle> listJingPin(Integer index, Integer size,
			Integer tiebaId) {
		// TODO Auto-generated method stub
		Tieba tieba = iTiebaDao.load(tiebaId);
		return iTieTitleDao.listJingPin(index, size, tieba);
	}

	@Override
	public boolean faTie(Integer userId,Integer tiebaId,String title,String body) {
		// TODO Auto-generated method stub
		User user = iUserDao.load(userId);
		//先save TieTitle
		TieTitle tieTitle = this.newAnDefaultTieTitle();
		tieTitle.setUser(user);
		tieTitle.setTieba(iTiebaDao.load(tiebaId));
		tieTitle.setTitle(title);
		tieTitle.setLastPostUserName(user.getUsername());
//		tieTitle.setLastPostTime(new Date());
		iTieTitleDao.save(tieTitle);
		//在save Tie
		Integer floor = tieTitle.getMaxFloor();
//		floor++;
//		tieTitle.setMaxFloor(floor);	//tieTitle是持久化状态，应该会update、的确update了，但是时间也被update为null了
		Tie tie = newAnDefaultTie();
		tie.setTieTitle(tieTitle);
		tie.setSendUser(user);
		tie.setBeSendUser(user);
		tie.setFloor(floor);
		tie.setBody(body);
		iTieDao.save(tie);
		return false;
	}

	@Override
	public boolean setTop(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	public TieTitle newAnDefaultTieTitle() {
		TieTitle tieTitle = new TieTitle();
		tieTitle.setTop((byte)0);
		tieTitle.setJiajing((byte)0);
		tieTitle.setMaxFloor(1);
		return tieTitle;
	}
	
	public Tie newAnDefaultTie() {
		Tie tie = new Tie();
		return tie;
	}

	@Override
	public TieTitle getTieTitleById(Integer tieTitleId) {
		// TODO Auto-generated method stub
		TieTitle tieTitle = iTieTitleDao.get(tieTitleId);
		return tieTitle;
	}

	
}
