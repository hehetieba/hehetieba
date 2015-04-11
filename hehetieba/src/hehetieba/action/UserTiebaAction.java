package hehetieba.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import hehetieba.service.IUserTiebaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

public class UserTiebaAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

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
	
	IUserTiebaService iUserTiebaService;

	public IUserTiebaService getiUserTiebaService() {
		return iUserTiebaService;
	}

	public void setiUserTiebaService(IUserTiebaService iUserTiebaService) {
		this.iUserTiebaService = iUserTiebaService;
	}
	
	// --------------------华丽的分割线-------------------------------------
	/**
	 * 检查用户是否是关注该贴吧，true表示关注，false表示没有关注
	 * @return
	 * @throws IOException
	 */
	public String checkFocus() throws IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer tiebaId = Integer.valueOf(request.getParameter("tiebaId"));
		
		boolean flag = iUserTiebaService.checkFocused(userId, tiebaId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		
		return null;
	}
	
	/**
	 * 检查用户是否是吧主，true表示是吧主，false表示不是吧主
	 * @return
	 * @throws IOException
	 */
	public String checkBaZhu() throws IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer tiebaId = Integer.valueOf(request.getParameter("tiebaId"));
		
		boolean flag = iUserTiebaService.checkBaZhu(userId, tiebaId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		
		return null;
	}
	
	public String focus() throws IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer tiebaId = Integer.valueOf(request.getParameter("tiebaId"));
		
		iUserTiebaService.focus(userId, tiebaId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "已关注");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		
		return null;
	}

}
















