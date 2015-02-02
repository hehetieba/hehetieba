package hehetieba.service.impl;

import java.io.File;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.If;

import hehetieba.dao.IUserDao;
import hehetieba.domain.User;
import hehetieba.service.IUserService;

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
	public void uploadHeadImg(Integer id, String fileName, File file) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 修改信息
	 */
	@Override
	public void changeMessage(User user) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 查关注的贴吧
	 */
	@Override
	public List listTieba(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}
