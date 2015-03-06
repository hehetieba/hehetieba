package hehetieba.service;

public interface IUserTiebaService {
	/**
	 * 检查用户跟贴吧是否关注
	 * @param userId
	 * @param tiebaId
	 * @return
	 */
	public boolean checkFocused(Integer userId,Integer tiebaId);
}
