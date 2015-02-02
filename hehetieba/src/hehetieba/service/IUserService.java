package hehetieba.service;

import java.io.File;
import java.util.List;

import hehetieba.domain.User;

public interface IUserService {
	//检查是否有这个用户
	public boolean checkUsername(String username);
	//检查是否有这个昵称
	public boolean checkNickname(String nickname);
	//增加用户
	public void save(User user);
	//登录
	public boolean login(String username,String pwd);
	//判断旧密码
	public boolean checkOldPwd(Integer id,String oldPwd);
	//修改密码
	public void changePwd(Integer id,String newPwd);
	//上传头像
	public void uploadHeadImg(Integer id,String fileName,File file);
	//修改信息
	public void changeMessage(User user);
	//查关注的贴吧
	public List listTieba(Integer id);
}
