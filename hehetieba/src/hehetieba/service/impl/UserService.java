package hehetieba.service.impl;

import java.io.File;
import java.util.List;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNickname(String nickname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkLogin(String username, String pwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePwd(Integer id, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void uploadHeadImg(Integer id, String fileName, File file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeMessage(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List listTieba(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	



}
