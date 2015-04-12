package hehetieba.action;

import hehetieba.basic.Pager;
import hehetieba.domain.ApplyOwnerResult;
import hehetieba.domain.Reply;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.service.IApplyOwnerResultService;
import hehetieba.service.IReplyService;

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

public class ApplyOwnerResultAction extends ActionSupport implements ServletRequestAware,
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

	private IReplyService iReplyService;

	public IReplyService getiReplyService() {
		return iReplyService;
	}

	public void setiReplyService(IReplyService iReplyService) {
		this.iReplyService = iReplyService;
	}
	
	// --------------------Service-------------------------------------
	
	IApplyOwnerResultService iApplyOwnerResultService;

	public IApplyOwnerResultService getiApplyOwnerResultService() {
		return iApplyOwnerResultService;
	}

	public void setiApplyOwnerResultService(
			IApplyOwnerResultService iApplyOwnerResultService) {
		this.iApplyOwnerResultService = iApplyOwnerResultService;
	}

	// --------------------华丽的分割线-------------------------------------


	public String listAll() throws IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));;
		Integer index = Integer.valueOf(request.getParameter("index"));;
		Integer size = Integer.valueOf(request.getParameter("size"));;
		Pager<ApplyOwnerResult> pager = iApplyOwnerResultService.listAll(userId, index, size);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new Gson();

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}

}
