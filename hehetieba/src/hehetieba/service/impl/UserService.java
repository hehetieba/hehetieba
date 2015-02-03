package hehetieba.service.impl;

import java.io.File;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;

import hehetieba.dao.IUserDao;
import hehetieba.domain.User;
import hehetieba.service.IUserService;
import hehetieba.util.UploadUtils;

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
	public User loadUser(Integer id) {
		User user = (User)iUserDao.get(id);
//		System.out.println(user.toString());
		return user;
	}
	
	@Override
	public boolean checkUsername(String username) {
		return iUserDao.checkUsername(username);
	}

	@Override
	public boolean checkNickname(String nickname) {
		return iUserDao.checkNickname(nickname);
	}

	@Override
	public void save(User user) {
		iUserDao.save(user);
	}

	@Override
	public boolean login(String username, String pwd) {
		//不存在此用户
		if(iUserDao.checkUsername(username)==false)
			return false;
		//此用户被封号了
		if(iUserDao.checkUserEnabled(username)==false)
			return false;
		User user = iUserDao.loadByUsername(username);
		if(user!=null && user.getPwd().equals(pwd))
			return true;
		return false;
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
	public void changePwd(Integer id, String newPwd) {
		User user = iUserDao.load(id);
		user.setPwd(newPwd);
		iUserDao.update(user);
	}

	/**
	 * 上传头像
	 */
	@Override
	public void uploadHeadImg(Integer id, File file,String ext) {
		String headImg = UploadUtils.saveUploadFile(file, ext);
		User user = (User)iUserDao.load(id);
		user.setHeadImg(headImg);
		iUserDao.update(user);
	}

	/**
	 * 修改信息
	 */
	@Override
	public void changeMessage(User user) {
		iUserDao.update(user);
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
	public boolean checkTieRead(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkReplyRead(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkAllpyResultRead(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}





}
