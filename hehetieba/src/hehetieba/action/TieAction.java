package hehetieba.action;

import hehetieba.basic.Pager;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.service.ITieService;

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

public class TieAction extends ActionSupport implements ServletRequestAware,
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

	private ITieService iTieService;

	public ITieService getiTieService() {
		return iTieService;
	}

	public void setiTieService(ITieService iTieService) {
		this.iTieService = iTieService;
	}

	// --------------------华丽的分割线-------------------------------------

	public String listInTiePage() throws IOException {
		Integer index = Integer.valueOf(request.getParameter("index"));
		Integer size = Integer.valueOf(request.getParameter("size"));
		Integer tieTitleId = Integer.valueOf(request.getParameter("tieTitleId"));

		Pager<Tie> pager = iTieService.listInTiePage(tieTitleId, index, size);
		// tie.getTieTitle().setUser(null);
		// 输出
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new ExclusionStrategy() {
					public boolean shouldSkipClass(Class<?> clazz) {
						if (clazz == TieTitle.class || clazz == Set.class)
							return true;
						return false;
					}

					public boolean shouldSkipField(FieldAttributes f) {
						if (f.getName().equals("beSendUser"))
							return true;
						return false;
					}

				})
				/**
				 * Use serializeNulls method if you want To serialize null
				 * values By default, Gson does not serialize null values
				 */
				.serializeNulls().setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
				.create();
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}

	public String post() throws IOException {
		Integer tieTitleId = Integer.valueOf(request.getParameter("tieTitleId"));
		Integer sendUserId = Integer.valueOf(request.getParameter("sendUserId"));
		Integer beSendUserId = Integer.valueOf(request.getParameter("beSendUserId"));
		String body = request.getParameter("body");

		iTieService.post(tieTitleId, sendUserId, beSendUserId, body);

		return null;
	}

}
