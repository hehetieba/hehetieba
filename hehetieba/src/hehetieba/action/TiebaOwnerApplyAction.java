package hehetieba.action;

import hehetieba.basic.Pager;
import hehetieba.dao.ITieTitleDao;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.domain.TiebaOwnerApply;
import hehetieba.service.ITieService;
import hehetieba.service.ITieTitleService;
import hehetieba.service.ITiebaOwnerApplyService;

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

public class TiebaOwnerApplyAction extends ActionSupport implements ServletRequestAware,
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

	private ITiebaOwnerApplyService iTiebaOwnerApplyService;

	public ITiebaOwnerApplyService getiTiebaOwnerApplyService() {
		return iTiebaOwnerApplyService;
	}

	public void setiTiebaOwnerApplyService(
			ITiebaOwnerApplyService iTiebaOwnerApplyService) {
		this.iTiebaOwnerApplyService = iTiebaOwnerApplyService;
	}
	
	// --------------------华丽的分割线-------------------------------------


	public String applyTiebaOwner() throws IOException {
		
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer tiebaId = Integer.valueOf(request.getParameter("tiebaId"));
		String username = request.getParameter("username");
		String tiebaName = request.getParameter("tiebaName");
		Integer result = iTiebaOwnerApplyService.applyTiebaOwner(userId, tiebaId, username, tiebaName);
		
		System.out.println(result);
		Map<String, String> map = new HashMap<String,String>();
		if(result==0)
			map.put("message", "请先关注该贴吧");
		else if(result==1)
			map.put("message", "你已经提交过申请了，请耐心等待管理员处理");
		else
			map.put("message", "已经成功提交申请，请耐心等待管理员处理");
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}
	
	public String listAll() throws IOException {
		Integer page = Integer.valueOf(request.getParameter("page"));
		Integer rows = Integer.valueOf(request.getParameter("rows"));
		Pager<TiebaOwnerApply> pager = iTiebaOwnerApplyService.listAll(page, rows);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("rows", pager.getDatas());
		map.put("page", pager.getIndex());
		map.put("total", pager.getTotalRecord());
		Gson gson = new GsonBuilder()
		.setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}
	
	public String agree() throws IOException {
		Integer tiebaOwnerApplyId = Integer.valueOf(request.getParameter("tiebaOwnerApplyId"));
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer tiebaId = Integer.valueOf(request.getParameter("tiebaId"));
		String tiebaName = request.getParameter("tiebaName");
		iTiebaOwnerApplyService.agree(tiebaOwnerApplyId, userId, tiebaId, tiebaName);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("message","已经同意该用户为吧主");
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}
	
	public String disAgree() throws IOException {
		Integer tiebaOwnerApplyId = Integer.valueOf(request.getParameter("tiebaOwnerApplyId"));
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer tiebaId = Integer.valueOf(request.getParameter("tiebaId"));
		String tiebaName = request.getParameter("tiebaName");
		iTiebaOwnerApplyService.disAgree(tiebaOwnerApplyId, userId, tiebaId, tiebaName);
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("message","已经拒绝该用户为吧主");
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}


}
