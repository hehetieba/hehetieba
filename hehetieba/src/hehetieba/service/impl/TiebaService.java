package hehetieba.service.impl;

import java.util.List;

import hehetieba.basic.Pager;
import hehetieba.dao.ITiebaDao;
import hehetieba.domain.Tieba;
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
		// TODO Auto-generated method stub
		Pager<Tieba> pager = iTiebaDao.list(index, size);
		return pager;
	}

	@Override
	public Pager<Tieba> findByTiebaName(String tiebaName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tieba getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List listFavoriteTieba(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}


}
