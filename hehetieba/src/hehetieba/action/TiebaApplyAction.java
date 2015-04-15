package hehetieba.action;

import hehetieba.basic.Pager;
import hehetieba.domain.ApplyOwnerResult;
import hehetieba.service.IApplyOwnerResultService;
import hehetieba.service.IReplyService;
import hehetieba.service.ITiebaApplyService;

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

public class TiebaApplyAction extends ActionSupport implements ServletRequestAware,
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

	
	// --------------------Service-------------------------------------

	private ITiebaApplyService iTiebaApplyService;
	
	public ITiebaApplyService getiTiebaApplyService() {
		return iTiebaApplyService;
	}
	
	public void setiTiebaApplyService(ITiebaApplyService iTiebaApplyService) {
		this.iTiebaApplyService = iTiebaApplyService;
	}

	// --------------------华丽的分割线-------------------------------------


	public String saveTiebaApply() throws IOException {
		
		String tiebaName = request.getParameter("tiebaName");
		boolean flag = iTiebaApplyService.saveTiebaApply(tiebaName);
		
		System.out.println(flag);
		Map<String, String> map = new HashMap<String,String>();
		if(flag==true)
			map.put("msg", "已经提交申请");
		else
			map.put("msg", "抱歉，该贴吧不能被申请");
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}

}
