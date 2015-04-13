package hehetieba.dao.impl;

import java.util.HashMap;
import java.util.Map;

import hehetieba.basic.Pager;
import hehetieba.dao.IReplyDao;
import hehetieba.domain.Reply;
import hehetieba.domain.TieTitle;
import hehetieba.domain.User;

public class ReplyDao extends BaseDao<Reply> implements IReplyDao {

	@Override
	public Integer deleteByTieTitle(TieTitle tieTitle) {
		// TODO Auto-generated method stub
		String hql = "delete Reply reply where reply.tieTitle=:tieTitle";
		Map<String, Object> alias = new HashMap<String,Object>();
		alias.put("tieTitle", tieTitle);
		return super.updateByHql(hql, alias);
	}

	@Override
	public Pager<Reply> findBySendUser(User sendUser, Integer index,
			Integer size) {
		// TODO Auto-generated method stub
		String hql = "select new map(r.body as body,r.createDate as createDate,"
				+ "tt.title as title,tt.id as tieTitleId,"
				+ "tb.tiebaName as tiebaName,tb.id as tiebaId) "
				+ "from Reply r "
				+ "left join r.tieTitle tt "
				+ "left join r.tieTitle.tieba tb "
				+ "where r.sendUser=:sendUser "
				+ "order by r.createDate desc";
		Map<String, Object> alias = new HashMap<>();
		alias.put("sendUser", sendUser);
		return super.findByAlias(hql, index, size, alias);
	}

	@Override
	public Pager<Reply> findByBeSendUser(User beSendUser, Integer index,
			Integer size) {
		// TODO Auto-generated method stub
		String hql = "select new map(r.body as body,r.createDate as createDate,"
				+ "su.username as username,"
				+ "tt.title as title,tt.id as tieTitleId,"
				+ "tb.tiebaName as tiebaName,tb.id as tiebaId) "
				+ "from Reply r "
				+ "left join r.sendUser su "
				+ "left join r.tieTitle tt "
				+ "left join r.tieTitle.tieba tb "
				+ "where r.beSendUser=:beSendUser";
		Map<String, Object> alias = new HashMap<>();
		alias.put("beSendUser", beSendUser);
		return super.findByAlias(hql, index, size, alias);
	}

}
