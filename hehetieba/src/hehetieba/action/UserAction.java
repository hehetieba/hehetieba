package hehetieba.action;

import hehetieba.basic.Pager;
import hehetieba.domain.User;
import hehetieba.service.IUserService;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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

	File headImg;
	
	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

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
	
	public String getUserById() throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		User user = (User)iUserService.getUserById(id);
//		System.out.println(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user", user);
		Gson gson = new GsonBuilder()
		.setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	        	if(clazz == Set.class)
	        		return true;
	            return false;
	        }
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    .serializeNulls()
	    .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		return null;
	}
	
	public String changeMessage() throws IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		String nickname = request.getParameter("nickname");
		String introduction = request.getParameter("introduction");
		Byte gender = Byte.valueOf(request.getParameter("gender"));
		String birthday = request.getParameter("birthday");;
		iUserService.changeMessage(userId, nickname, introduction, gender, birthday);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "已修改");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		
		return null;
	}
	
	public String uploadHeadImg() throws IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		String ext=request.getParameter("ext");
		iUserService.uploadHeadImg(userId, headImg, ext);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "已上传");
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		
		User user = (User)request.getSession().getAttribute("user");
		request.getSession().setAttribute("user", iUserService.getUserById(user.getId()));
		response.sendRedirect("myindex");
//		response.sendRedirect("/hehetieba/myindex");
		
		return null;
	}
	
	/**
	 * 后台根据用户的username或者nickname查找用户
	 * @return
	 * @throws IOException
	 */
	public String findByUsernameOrNickname() throws IOException {
		String name = request.getParameter("name");
		Integer index = Integer.valueOf(request.getParameter("index"));
		Integer size = Integer.valueOf(request.getParameter("size"));
		Pager<User> pager = iUserService.findByUsernameOrNickname(name, index, size);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .serializeNulls()
	    .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		
		return null;
	}
	
	/**
	 * 后台列出所有用户的一些信息
	 * @return
	 * @throws IOException
	 */
	public String findAll() throws IOException {
		Integer index = Integer.valueOf(request.getParameter("index"));
		Integer size = Integer.valueOf(request.getParameter("size"));
		Pager<User> pager = iUserService.findAll(index, size);
		
		Map<String, Object> map = new HashMap<>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .serializeNulls()
	    .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		
		return null;
	}

}
