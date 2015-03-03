package hehetieba.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import hehetieba.basic.Pager;
import hehetieba.domain.TieTitle;
import hehetieba.domain.Tieba;
import hehetieba.service.ITieTitleService;
import hehetieba.service.ITiebaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class TieTitleAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

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

	private ITieTitleService iTieTitleService;

	public ITieTitleService getiTieTitleService() {
		return iTieTitleService;
	}

	public void setiTieTitleService(ITieTitleService iTieTitleService) {
		this.iTieTitleService = iTieTitleService;
	}

	// --------------------华丽的分割线-------------------------------------

	public String listInTiebaPage() throws IOException {
		Integer index = Integer.valueOf(request.getParameter("index"));
		Integer size = Integer.valueOf(request.getParameter("size"));
		Integer tiebaId = Integer.valueOf(request.getParameter("tiebaId"));

		Pager<TieTitle> pager = iTieTitleService.listInTiebaPage(index, size, tiebaId);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new ExclusionStrategy() {

					public boolean shouldSkipClass(Class<?> clazz) {
						if (clazz == Tieba.class || clazz == Set.class)
							return true;
						return false;
					}

					/**
					 * Custom field exclusion goes here
					 */
					public boolean shouldSkipField(FieldAttributes f) {
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

}
