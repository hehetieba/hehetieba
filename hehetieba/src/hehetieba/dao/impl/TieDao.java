package hehetieba.dao.impl;

import java.util.HashMap;
import java.util.Map;

import hehetieba.basic.Pager;
import hehetieba.dao.ITieDao;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.domain.User;

public class TieDao extends BaseDao<Tie> implements ITieDao {

	@Override
	public Integer deleteByTieTitle(TieTitle tieTitle) {
		// TODO Auto-generated method stub
		String hql = "delete Tie tie where tie.tieTitle=:tieTitle";
		Map<String, Object> alias = new HashMap<String,Object>();
		alias.put("tieTitle", tieTitle);
		return super.updateByHql(hql, alias);
	}

	@Override
	public Pager<Tie> findBySendUser(User sendUser,Integer index,Integer size) {
		// TODO Auto-generated method stub
//		String hql = "select new Tie(t.body,tt.title,su.username) "
//				+ "from Tie t "
//				+ "left join t.tieTitle tt "
//				+ "left join t.sendUser su "
//				+ "where t.sendUser=:sendUser";
		String hql = "select new map(t.body as body,t.createDate as createDate,"
				+ "tt.title as title,tt.id as tieTitleId,"
				+ "tb.tiebaName as tiebaName,tb.id as tiebaId) "
				+ "from Tie t "
				+ "left join t.tieTitle tt "
				+ "left join t.tieTitle.tieba tb "
				+ "where t.sendUser=:sendUser";
		Map<String, Object> alias = new HashMap<>();
		alias.put("sendUser", sendUser);
		return super.findByAlias(hql, index, size, alias);
	}

	@Override
	public Pager<Tie> findByBeSendUser(User beSendUser, Integer index,
			Integer size) {
		// TODO Auto-generated method stub
		String hql = "select new map(t.body as body,t.createDate as createDate,"
				+ "su.username as username,"
				+ "tt.title as title,tt.id as tieTitleId,"
				+ "tb.tiebaName as tiebaName,tb.id as tiebaId) "
				+ "from Tie t "
				+ "left join t.sendUser su "
				+ "left join t.tieTitle tt "
				+ "left join t.tieTitle.tieba tb "
				+ "where t.beSendUser=:beSendUser";
		Map<String, Object> alias = new HashMap<>();
		alias.put("beSendUser", beSendUser);
		return super.findByAlias(hql, index, size, alias);
	}

}
