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

import hehetieba.domain.User;
import hehetieba.service.IUserService;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	/**
	 * 各种参数
	 */
	// String username ;
	// String nickname ;

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

	private IUserService iUserService;

	public IUserService getiUserService() {
		return iUserService;
	}

	public void setiUserService(IUserService iUserService) {
		this.iUserService = iUserService;
	}

	// --------------------华丽的分割线-------------------------------------

	/**
	 * 检查Username是否存在
	 * @return
	 * @throws IOException
	 */
	public String checkUsername() throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String username = request.getParameter("username");
		Boolean flag = iUserService.checkUsername(username);
		map.put("flag", flag);

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}

	/**
	 * 检查Nickname是否存在
	 * @return
	 * @throws IOException
	 */
	public String CheckNickname() throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String nickname = request.getParameter("nickname");
		Boolean flag = iUserService.checkNickname(nickname);
		map.put("flag", flag);

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;

	}

	/**
	 * 点击注册按钮
	 * @return
	 * @throws IOException
	 */
	public String register() throws IOException {
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		// System.out.println("username:" + username);
		// System.out.println("nickname:" + nickname);
		// System.out.println("nickname:" + pwd);
		boolean flag = iUserService.register(username, nickname, pwd);
		if (flag == true)
			System.out.println("注册成功");
		else
			System.out.println("注册失败");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		return null;
	}

	/**
	 * 点击登录按钮
	 * @return
	 * @throws IOException
	 */
	public String login() throws IOException {
		boolean flag = false;
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		System.out.println("username:" + username);
		System.out.println("pwd:" + pwd);
		flag = iUserService.login(username, pwd);
		if (flag == false)
			System.out.println("登录失败");
		else {
			System.out.println("登录成功");
			User user = iUserService.getByUsername(username);
			request.getSession().setAttribute("user", user);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}
	
	public String logout() {
		request.getSession().removeAttribute("user");
		return null;
	}

	/**
	 * 检查是否有回贴
	 * @return
	 * @throws IOException
	 */
	public String checkTieRead() throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Boolean flag = iUserService.checkTieRead(id);
		if (flag == true)
			System.out.println("有未读回贴");
		else
			System.out.println("木有未读回贴");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}

	/**
	 * 检查是否有回复
	 * @return
	 * @throws IOException
	 */
	public String checkReplyRead() throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Boolean flag = iUserService.checkTieRead(id);
		if (flag == true)
			System.out.println("有未读回复");
		else
			System.out.println("木有未读回复");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}

	/**
	 * 检查贴吧吧主申请反馈
	 * @return 
	 * @throws IOException
	 */
	public String checkApplyResultRead() throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Boolean flag = iUserService.checkTieRead(id);
		if (flag == true)
			System.out.println("有未读吧主申请反馈");
		else
			System.out.println("木有未读吧主申请反馈");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}
	
	

}
