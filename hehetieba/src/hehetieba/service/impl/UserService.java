package hehetieba.service.impl;

import hehetieba.basic.Pager;
import hehetieba.dao.IUserDao;
import hehetieba.domain.User;
import hehetieba.service.IUserService;
import hehetieba.util.UploadUtils;

import java.io.File;

public class UserService implements IUserService {
	
	private IUserDao iUserDao;
	
	public IUserDao getiUserDao() {
		return iUserDao;
	}

	public void setiUserDao(IUserDao iUserDao) {
		this.iUserDao = iUserDao;
	}

	/**
	 * 分割线
	 */
	
	@Override
	public User getUserById(Integer id) {
		User user = (User)iUserDao.get(id);
//		System.out.println(user.toString());
		return user;
	}
	
	/**
	 * true表示存在username
	 */
	@Override
	public boolean checkUsername(String username) {
		Integer cnt = iUserDao.calcUsernameCount(username);
		if(cnt>0)
			return true;
		else
			return false;
	}

	/**
	 * true表示存在nickname
	 */
	@Override
	public boolean checkNickname(String nickname) {
		Integer cnt = iUserDao.calcNicknameCount(nickname);
		if(cnt>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean register(String username,String nickname,String pwd) {
		//存在username
		if(checkUsername(username)==true)
			return false;
		//存在nickname
		if(checkNickname(nickname)==true)
			return false;
		User user = newAnDefaultUser();
		user.setUsername(username);
		user.setNickname(nickname);
		user.setPwd(pwd);
		iUserDao.save(user);
		return true;
	}
	
	public User newAnDefaultUser () {
		User user = new User();
		user.setTieRead((byte) 0);
		user.setReplyRead((byte) 0);
		user.setApplyResultRead((byte) 0);
		user.setEnabled((byte) 0);
		return user;
	}

	@Override
	public boolean login(String username, String pwd) {
		//不存在此用户
		if(checkUsername(username)==false)
			return false;
		//此用户被封号了
		if(iUserDao.checkUserEnabled(username)==false)
			return false;
		User user = iUserDao.loadByUsername(username);
		if(user!=null && user.getPwd().equals(pwd))
			return true;
		return false;
	}
	
	@Override
	public User getByUsername(String username) {
		return iUserDao.getByUsername(username);
	}
	
	/**
	 * 检查输入的旧密码是否正确
	 */
	@Override
	public boolean checkOldPwd(Integer id, String oldPwd) {
		User user = iUserDao.load(id);
		if(user.getPwd().equals(oldPwd)) {
			return true;
		}
		return false;
	}

	/**
	 * 更新密码
	 */
	@Override
	public boolean changePwd(Integer id,String oldPwd, String newPwd) {
		if(checkOldPwd(id, oldPwd)==false)
			return false;
		User user = iUserDao.load(id);
		user.setPwd(newPwd);
		iUserDao.update(user);
		return true;
	}

	/**
	 * 上传头像
	 */
	@Override
	public void uploadHeadImg(Integer userId, File file,String ext) {
		String headImg = UploadUtils.saveUploadFile(file, ext);
		User user = (User)iUserDao.load(userId);
		user.setHeadImg(headImg);
		iUserDao.update(user);
	}

	/**
	 * 修改信息
	 */
	@Override
	public void changeMessage(Integer id,String nickname,String introduction,Byte gender,String birthday) {
		User user = this.getUserById(id);
		user.setNickname(nickname);
		user.setIntroduction(introduction);
		user.setGender(gender);
		user.setBirthday(birthday);
		iUserDao.update(user);
	}

	

	@Override
	public boolean checkTieRead(Integer id) {
		User user = iUserDao.load(id);
		Byte flag = user.getTieRead();
		if(flag==1)
			return true;
		return false;
	}

	@Override
	public boolean checkReplyRead(Integer id) {
		User user = iUserDao.load(id);
		Byte flag = user.getReplyRead();
		if(flag==1)
			return true;
		return false;
	}

	@Override
	public boolean checkApplyResultRead(Integer id) {
		User user = iUserDao.load(id);
		Byte flag = user.getApplyResultRead();
		if(flag==1)
			return true;
		return false;
	}

	@Override
	public void disableUser(Integer id) {
		iUserDao.disableUser(id);
	}

	@Override
	public void enableUser(Integer id) {
		iUserDao.enableUser(id);
	}

	@Override
	public Pager<User> findByUsernameOrNickname(String name,Integer index,Integer size) {
		// TODO Auto-generated method stub
		return iUserDao.findByUsernameOrNickname(name,index,size);
	}

	@Override
	public Pager<User> findAll(Integer index, Integer size) {
		// TODO Auto-generated method stub
		return iUserDao.findAll(index, size);
	}


}
