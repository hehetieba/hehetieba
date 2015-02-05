package hehetieba.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import hehetieba.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware {
	/**
	 * 各种参数
	 */
//	String username ;
//	String nickname ;
	
	HttpServletRequest request = null;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	
	private IUserService iUserService;

	public IUserService getiUserService() {
		return iUserService;
	}


	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}


	public String register() {
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		System.out.println("username:"+username);
		System.out.println("nickname:"+nickname);
		return null;
	}
	
	public String login() {
		boolean flag=false;
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		System.out.println("username:"+username);
		System.out.println("pwd:"+pwd);
		flag = iUserService.login(username, pwd);
		if(flag==false)
			System.out.println("登录失败");
		else
			System.out.println("登录成功");
		return null;
	}



}
