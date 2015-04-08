package hehetieba.dao.impl;

import java.util.HashMap;
import java.util.Map;

import hehetieba.dao.ITieDao;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;

public class TieDao extends BaseDao<Tie> implements ITieDao {

	@Override
	public Integer deleteByTieTitle(TieTitle tieTitle) {
		// TODO Auto-generated method stub
		String hql = "delete Tie tie where tie.tieTitle=:tieTitle";
		Map<String, Object> alias = new HashMap<String,Object>();
		alias.put("tieTitle", tieTitle);
		return super.updateByHql(hql, alias);
	}

}
