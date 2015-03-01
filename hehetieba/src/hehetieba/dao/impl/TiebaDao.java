package hehetieba.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hehetieba.basic.Pager;
import hehetieba.dao.ITiebaDao;
import hehetieba.domain.Tieba;
import hehetieba.dto.TiebaDto;

public class TiebaDao extends BaseDao<Tieba> implements ITiebaDao  {

	@Override
	public Pager<Tieba> list(Integer index, Integer size) {
		String hql="from Tieba t order by t.memberCount desc";
		Pager<Tieba> pager=super.find(hql, index, size);
		return pager;
	}

	@Override
	public List<Tieba> listFavoriteTiebas(Integer userId) {
		// TODO Auto-generated method stub
		String hql = "from Tieba t where t.id in (SELECT ut.tieba.id "
												+ "FROM UserTieba ut "
												+ "WHERE ut.user.id = :userId AND ut.enabled=1)";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		return super.list(hql,null,map);
	}

	@Override
	public Pager<Tieba> findByUserName(Integer index, Integer size,
			String tiebaName) {
//		tiebaName = new String ("%"+tiebaName+"%");
		String hql="from Tieba t where t.tiebaName like :tiebaName order by t.memberCount desc";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("tiebaName","%"+tiebaName+"%");
		Pager<Tieba> pager=super.find(hql,index,size,null,map);
		return pager;
	}

	@Override
	public TiebaDto getDtoById(Integer id) {
		String hql = "select "
				+ "new hehetieba.dto.TiebaDto("
				+ "t.id,"
				+ "t.tiebaName,"
				+ "t.headImg,"
				+ "t.bgImg,"
				+ "t.intruduction,"
				+ "t.enabled,"
				+ "t.memberCount,"
				+ "t.tieCount)"
				+ "from Tieba t where t.id=id";
		TiebaDto tiebaDto = (TiebaDto) getSession().createQuery(hql).setMaxResults(1).uniqueResult();
		if(tiebaDto!=null)
			return tiebaDto;
		return null;
	}


}
