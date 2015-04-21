package hehetieba.action;

import hehetieba.service.IManagerService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	HttpServletRequest request = null;
	HttpServletResponse response = null;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse reponse) {
		this.response = reponse;
	}

	private IManagerService iManagerService;

	public IManagerService getiManagerService() {
		return iManagerService;
	}

	public void setiManagerService(IManagerService iManagerService) {
		this.iManagerService = iManagerService;
	}

	// --------------------华丽的分割线-------------------------------------


	public String login() throws IOException {
		String managername = request.getParameter("managername");
		String pwd = request.getParameter("pwd");
		boolean flag = iManagerService.login(managername, pwd);
		
		System.out.println(flag);
		Map<String, Object> map = new HashMap<String,Object>();
		if(flag==true) {
			request.getSession().setAttribute("manager", iManagerService.getById(1));
			response.sendRedirect("userhoutai");
			map.put("msg", "登陆成功");
		}
		else
			map.put("msg", "账号或者密码错误");
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		return null;
	}
	
	public String logout() throws IOException {
		request.getSession().removeAttribute("manager");
		return null;
	}
	
	public String changePwd() throws IOException {
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		boolean flag = iManagerService.changePwd(oldPwd, newPwd);
		
		System.out.println(flag);
		Map<String, Object> map = new HashMap<String,Object>();
		if(flag==true)
			map.put("msg", "修改成功");
		else
			map.put("msg", "修改失败");
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		return null;
	}
	
	public String checkTiebaApplyRead() throws IOException {
		boolean flag = iManagerService.checkTiebaApplyRead();
		
		System.out.println(flag);
		Map<String, Object> map = new HashMap<String,Object>();
		if(flag==true)
			map.put("msg", "有贴吧申请消息");
		else
			map.put("msg", "没有贴吧申请消息");
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		return null;
	}
	
	public String checkTiebaOwnerApplyRead() throws IOException {
		boolean flag = iManagerService.checkTiebaOwnerApplyRead();
		
		System.out.println(flag);
		Map<String, Object> map = new HashMap<String,Object>();
		if(flag==true)
			map.put("msg", "有贴吧吧主申请消息");
		else
			map.put("msg", "没有贴吧吧主申请消息");
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		return null;
	}


}
