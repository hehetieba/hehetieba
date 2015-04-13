package hehetieba.action;

import hehetieba.basic.Pager;
import hehetieba.domain.TieTitle;
import hehetieba.domain.Tieba;
import hehetieba.service.ITieTitleService;

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

		Pager<TieTitle> pager = iTieTitleService.listInTiebaPage(index, size,
				tiebaId);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new ExclusionStrategy() {
					public boolean shouldSkipClass(Class<?> clazz) {
						if (clazz == Tieba.class || clazz == Set.class)
							return true;
						return false;
					}

					public boolean shouldSkipField(FieldAttributes f) {
						return false;
					}

				}).serializeNulls().setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
				.create();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}
	
	public String listJingPin() throws IOException {
		Integer index = Integer.valueOf(request.getParameter("index"));
		Integer size = Integer.valueOf(request.getParameter("size"));
		Integer tiebaId = Integer.valueOf(request.getParameter("tiebaId"));

		Pager<TieTitle> pager = iTieTitleService.listJingPin(index, size, tiebaId);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
				.setExclusionStrategies(new ExclusionStrategy() {
					public boolean shouldSkipClass(Class<?> clazz) {
						if (clazz == Tieba.class || clazz == Set.class)
							return true;
						return false;
					}

					public boolean shouldSkipField(FieldAttributes f) {
						return false;
					}

				}).serializeNulls().setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
				.create();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));

		return null;
	}

	public String faTie() throws IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		Integer tiebaId = Integer.valueOf(request.getParameter("tiebaId"));
		String title = request.getParameter("title");
		String body = request.getParameter("body");

		iTieTitleService.faTie(userId, tiebaId, title, body);

		return null;
	}
	
	/**
	 * 根据tieTitle的id顶置
	 * @return
	 * @throws IOException
	 */
	public String setTop() throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		iTieTitleService.setTop(id);
		
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "已顶置");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println("已顶置");
		return null;
	}
	
	/**
	 * 根据tieTitle的id取消顶置
	 * @return
	 * @throws IOException
	 */
	public String cancelSetTop() throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		iTieTitleService.cancelSetTop(id);
		
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "已取消顶置");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println("已取消顶置");
		return null;
	}
	
	/**
	 * 根据tieTitle的id加精
	 * @return
	 * @throws IOException
	 */
	public String jiajing() throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		iTieTitleService.jiajing(id);
		
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "已加精华");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println("已加精华");
		return null;
	}
	/**
	 * 根据tieTitle的id取消加精
	 * @return
	 * @throws IOException
	 */
	public String cancelJiajing() throws IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		iTieTitleService.cancelJiajing(id);
		
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "已取消精华");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println("已取消精华");
		return null;
	}
	
	/**
	 * 根据tieTitleId删除tieTitle，并且同时删除对应的tie和reply
	 * @return
	 * @throws IOException
	 */
	public String delete() throws IOException {
		Integer tieTitleId = Integer.valueOf(request.getParameter("tieTitleId"));
		iTieTitleService.deleteByTieTitleId(tieTitleId);
		
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("msg", "删除完毕");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println("删除完毕");
		return null;
	}
	
	public String findUserTieTitle() throws IOException {
		Integer userId = Integer.valueOf(request.getParameter("userID"));
		Integer index = Integer.valueOf(request.getParameter("index"));
		Integer size = Integer.valueOf(request.getParameter("size"));
		Pager<TieTitle> pager = iTieTitleService.findUserTieTitle(userId, index, size);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
		.setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }

	        public boolean shouldSkipField(FieldAttributes f) {
	        	String field = f.getName();
	        	if("user".equals(field) || "tieba".equals(field) || "top".equals(field) || "jiajing".equals(field) || "maxFloor".equals(field))
	        		return true;
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

}
