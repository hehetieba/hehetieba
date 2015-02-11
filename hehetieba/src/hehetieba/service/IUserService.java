package hehetieba.service;

import java.io.File;
import java.util.List;

import javax.swing.text.DefaultEditorKit.BeepAction;

import hehetieba.domain.User;

public interface IUserService {
	
	/**
	 * 返回User信息
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	/**
	 * 检查是否有这个用户
	 * @param username
	 * @return
	 */
	public boolean checkUsername(String username);
	/**
	 * 检查是否有这个昵称
	 * @param nickname
	 * @return
	 */
	public boolean checkNickname(String nickname);
	/**
	 * 注册用户
	 * @param user
	 */
	public boolean register(String username,String nickname,String pwd);
	/**
	 * 登录按钮按下
	 * @param username
	 * @param pwd
	 * @return
	 */
	public boolean login(String username,String pwd);
	/**
	 * 判断旧密码
	 * @param id
	 * @param oldPwd
	 * @return
	 */
	public boolean checkOldPwd(Integer id,String oldPwd);
	/**
	 * 修改密码
	 * @param id
	 * @param newPwd
	 */
	public boolean changePwd(Integer id,String oldPwd,String newPwd);
	/**
	 * 上传头像
	 * @param id
	 * @param file
	 * @param ext
	 */
	public void uploadHeadImg(Integer id,File file,String ext);
	/**
	 * 修改信息
	 * @param user
	 */
	public void changeMessage(Integer id,String nickname,String introduction,Byte gender,String birthday);
	
	
	/**
	 * 检查未读回帖
	 * @param id
	 * @return true：有未读回帖
	 */
	public boolean checkTieRead(Integer id);
	
	/**
	 * 检查未读回复
	 * @param id
	 * @return true：有未读回复
	 */
	public boolean checkReplyRead(Integer id);
	
	/**
	 * 检查吧主申请反馈
	 * @param id
	 * @return true：有未读反馈
	 */
	public boolean checkApplyResultRead(Integer id);
	
	/**
	 * 根据userId封号
	 * @param id
	 */
	public void disableUser(Integer id);
	/**
	 * 解封用户
	 * @param id
	 */
	public void enableUser(Integer id);
	
}














