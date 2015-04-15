package hehetieba.action;

import hehetieba.basic.Pager;
import hehetieba.dao.ITieTitleDao;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
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
//		Integer index = Integer.valueOf(request.getParameter("index"));
//		Integer size = Integer.valueOf(request.getParameter("size"));
//		Integer tieTitleId = Integer.valueOf(request.getParameter("tieTitleId"));
//
//		Pager<Tie> pager = iTieService.listInTiePage(tieTitleId, index, size);
//		TieTitle tieTitle = iTieTitleService.getTieTitleById(tieTitleId);
//		String title = tieTitle.getTitle();
//		// tie.getTieTitle().setUser(null);
//		// 输出
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("pager", pager);
//		map.put("title", title);
//		Gson gson = new GsonBuilder()
//				.setExclusionStrategies(new ExclusionStrategy() {
//					public boolean shouldSkipClass(Class<?> clazz) {
//						if (clazz == TieTitle.class || clazz == Set.class)
//							return true;
//						return false;
//					}
//
//					public boolean shouldSkipField(FieldAttributes f) {
//						if (f.getName().equals("beSendUser"))
//							return true;
//						return false;
//					}
//
//				})
//				/**
//				 * Use serializeNulls method if you want To serialize null
//				 * values By default, Gson does not serialize null values
//				 */
//				.serializeNulls().setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
//				.create();
//		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print(gson.toJson(map));
//		System.out.println(gson.toJson(map));
		
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


}
