package hehetieba.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import hehetieba.service.IUserService;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {
	/**
	 * 各种参数
	 */
//	String username ;
//	String nickname ;
	
	HttpServletRequest request = null;
	HttpServletResponse response = null;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	@Override
	public void setServletResponse(HttpServletResponse reponse) {
		this.response = reponse;
	}
	
	private IUserService iUserService;

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}
	
	//--------------------华丽的分割线-------------------------------------

	public String checkUsername() throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String username = request.getParameter("username");
		iUserService.checkUsername(username);
		map.put("flag", "true");
		
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		
		return null;
	}

	public String register() {
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		System.out.println("username:"+username);
		System.out.println("nickname:"+nickname);
		System.out.println("nickname:"+pwd);
		boolean flag = iUserService.register(username, nickname, pwd);
		if(flag==true)
			System.out.println("注册成功");
		else
			System.out.println("注册失败");
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
