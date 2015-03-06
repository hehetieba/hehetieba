package hehetieba.service;

import hehetieba.basic.Pager;
import hehetieba.domain.TiebaApply;

public interface ITiebaApplyService {
	/**
	 * 分页显示所有贴吧申请
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<TiebaApply> listAll(Integer index,Integer size);
	/**
	 * 分页显示已处理的贴吧申请
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<TiebaApply> listHandled(Integer index,Integer size);
	/**
	 * 分页显示未处理的贴吧申请
	 * @param index
	 * @param size
	 * @return
	 */
	public Pager<TiebaApply> listUnhandled(Integer index,Integer size);
	/**
	 * 提交(新建)一个贴吧申请
	 * @param tiebaName
	 * @return
	 */
	public boolean saveTiebaApply(String tiebaName);
}
