package hehetieba.service.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;

import hehetieba.basic.Pager;
import hehetieba.dao.ITiebaDao;
import hehetieba.domain.Tieba;
import hehetieba.domain.UserTieba;
import hehetieba.dto.TiebaDto;
import hehetieba.service.ITiebaService;

public class TiebaService implements ITiebaService {
	private ITiebaDao iTiebaDao;

	public ITiebaDao getiTiebaDao() {
		return iTiebaDao;
	}

	public void setiTiebaDao(ITiebaDao iTiebaDao) {
		this.iTiebaDao = iTiebaDao;
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
	public Tieba getById(Integer id) {
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


}
