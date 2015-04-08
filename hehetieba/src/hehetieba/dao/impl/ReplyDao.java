package hehetieba.dao.impl;

import java.util.HashMap;
import java.util.Map;

import hehetieba.dao.IReplyDao;
import hehetieba.domain.Reply;
import hehetieba.domain.TieTitle;

public class ReplyDao extends BaseDao<Reply> implements IReplyDao {

	@Override
	public Integer deleteByTieTitle(TieTitle tieTitle) {
		// TODO Auto-generated method stub
		String hql = "delete Reply reply where reply.tieTitle=:tieTitle";
		Map<String, Object> alias = new HashMap<String,Object>();
		alias.put("tieTitle", tieTitle);
		return super.updateByHql(hql, alias);
	}

}
