package hehetieba.service;

import hehetieba.basic.Pager;
import hehetieba.domain.TiebaOwnerApply;

public interface ITiebaOwnerApplyService {
	/**
	 * 提交吧主申请
	 * @return
	 */
	public Integer applyTiebaOwner(Integer userId,Integer tiebaId,String username,String tiebaName);
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
