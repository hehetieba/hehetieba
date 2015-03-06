package hehetieba.dao;

import hehetieba.basic.Pager;
import hehetieba.domain.TiebaOwnerApply;

public interface ITiebaOwnerApplyDao extends IBaseDao<TiebaOwnerApply> {
	/**
	 * 检查该用户是否已经提交了申请，并且是未处理的申请
	 * @param userId
	 * @param tiebaId
	 * @return
	 */
	public Integer checkIsApply(Integer userId,Integer tiebaId);
	/**
	 * 分页显示所有吧主申请
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<TiebaOwnerApply> listAll(Integer index,Integer size);
	/**
	 * 分页显示已处理的吧主申请
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<TiebaOwnerApply> listHandled(Integer index,Integer size);
	/**
	 * 分页显示未处理的吧主申请
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<TiebaOwnerApply> listUnhandled(Integer index,Integer size);
}
