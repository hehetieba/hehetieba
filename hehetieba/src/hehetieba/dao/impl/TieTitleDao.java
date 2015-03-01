package hehetieba.dao.impl;

import hehetieba.basic.Pager;
import hehetieba.dao.ITieTitleDao;
import hehetieba.domain.TieTitle;

public class TieTitleDao extends BaseDao<TieTitle> implements ITieTitleDao {

	@Override
	public Pager<TieTitle> listInTiebaPage(Integer index, Integer size) {
		// TODO Auto-generated method stub
		String hql = "from TieTitle tt left join fetch tt.user u order by tt.top desc,tt.lastPostTime desc";
		return super.find(hql, index, size);
	}

}
