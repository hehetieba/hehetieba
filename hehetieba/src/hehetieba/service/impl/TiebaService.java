package hehetieba.service.impl;

import hehetieba.basic.Pager;
import hehetieba.dao.ITiebaApplyDao;
import hehetieba.dao.ITiebaDao;
import hehetieba.domain.Tieba;
import hehetieba.domain.TiebaApply;
import hehetieba.dto.TiebaDto;
import hehetieba.service.ITiebaService;

import java.util.List;

public class TiebaService implements ITiebaService {
	private ITiebaDao iTiebaDao;
	private ITiebaApplyDao iTiebaApplyDao;

	public ITiebaDao getiTiebaDao() {
		return iTiebaDao;
	}

	public void setiTiebaDao(ITiebaDao iTiebaDao) {
		this.iTiebaDao = iTiebaDao;
	}

	public ITiebaApplyDao getiTiebaApplyDao() {
		return iTiebaApplyDao;
	}

	public void setiTiebaApplyDao(ITiebaApplyDao iTiebaApplyDao) {
		this.iTiebaApplyDao = iTiebaApplyDao;
	}

	@Override
	public Pager<Tieba> list(Integer index, Integer size) {
		Pager<Tieba> pager = iTiebaDao.list(index, size);
		return pager;
	}

	@Override
	public Pager<Tieba> findByTiebaName(Integer index, Integer size,String tiebaName) {
		Pager<Tieba> pager = iTiebaDao.findByUserName(index, size,tiebaName);
		return pager;
	}

	@Override
	public Tieba getTiebaById(Integer id) {
		Tieba tieba = iTiebaDao.get(id);
//		Hibernate.initialize(tieba.getTieTitles());
//		Hibernate.initialize(tieba.getUserTiebas());
		if(tieba!=null)
			return tieba;
		return null;
	}

	@Override
	public List<Tieba> listFavoriteTiebas(Integer userId) {
		// TODO Auto-generated method stub
		return iTiebaDao.listFavoriteTiebas(userId);
	}

	@Override
	public TiebaDto getDtoById(Integer id) {
		return iTiebaDao.getDtoById(id);
	}

	@Override
	public void saveTieba(String tiebaName,Integer tiebaApplyId) {
		// TODO Auto-generated method stub
		//1、新建一个贴吧
		Tieba tieba = this.newAnDefaultTieba();
		tieba.setTiebaName(tiebaName);
		iTiebaDao.save(tieba);
		//2、更新tiebaApply.handStatus状态
		TiebaApply tiebaApply = iTiebaApplyDao.load(tiebaApplyId);
		tiebaApply.setHandleStatus((byte)1);
		iTiebaApplyDao.update(tiebaApply);
	}
	
	@Override
	public void notSaveTieba(String tiebaName, Integer tiebaApplyId) {
		// TODO Auto-generated method stub
		TiebaApply tiebaApply = iTiebaApplyDao.load(tiebaApplyId);
		tiebaApply.setHandleStatus((byte)2);
		iTiebaApplyDao.update(tiebaApply);
	}

	private Tieba newAnDefaultTieba() {
		Tieba tieba = new Tieba();
		tieba.setBgImg(null);
		tieba.setHeadImg(null);
		tieba.setEnabled((byte)1);
		tieba.setIntruduction(null);
		return tieba;
	}

	
	
}
