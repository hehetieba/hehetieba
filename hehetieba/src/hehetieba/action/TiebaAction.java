package hehetieba.action;

import hehetieba.basic.Pager;
import hehetieba.domain.Tieba;
import hehetieba.service.ITiebaService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
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

public class TiebaAction extends ActionSupport implements ServletRequestAware,
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

	private ITiebaService iTiebaService;

	public ITiebaService getiTiebaService() {
		return iTiebaService;
	}

	public void setiTiebaService(ITiebaService iTiebaService) {
		this.iTiebaService = iTiebaService;
	}

	
	// --------------------华丽的分割线-------------------------------------


	public String listInIndex() throws IOException {
		Integer index = Integer.valueOf(request.getParameter("index"));
		Integer size = Integer.valueOf(request.getParameter("size"));
		
		Pager<Tieba> pager = iTiebaService.list(index, size);
//		System.out.println(pager);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {

	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }

	        /**
	          * Custom field exclusion goes here
	          */
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    /**
	      * Use serializeNulls method if you want To serialize null values 
	      * By default, Gson does not serialize null values
	      */
	    .serializeNulls()
	    .create();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		
		return null;
	}
	
	public String findByTiebaName() throws IOException {
		Integer index = Integer.valueOf(request.getParameter("index"));
		Integer size = Integer.valueOf(request.getParameter("size"));
		String tiebaName = request.getParameter("tiebaName");
		System.out.println(request.getMethod()+"-----------------");
		if("GET".equalsIgnoreCase(request.getMethod()))
			tiebaName = new String(tiebaName.getBytes("iso8859-1"),"utf-8");
		
		Pager<Tieba> pager = iTiebaService.findByTiebaName(index, size, tiebaName);
//		System.out.println(pager);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {

	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }

	        /**
	          * Custom field exclusion goes here
	          */
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    /**
	      * Use serializeNulls method if you want To serialize null values 
	      * By default, Gson does not serialize null values
	      */
	    .serializeNulls()
	    .create();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		
		return null;
	}
	
	public String listFavoriteTiebas() throws IOException {
		Integer userId = Integer.valueOf(request.getParameter("userId"));
		List<Tieba> listTiebas = iTiebaService.listFavoriteTiebas(userId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("FavoriteTiebas", listTiebas);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    .serializeNulls()
	    .create();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		return null;
	}
	
	public String getTiebaById() throws IOException {
		Integer tiebaId = Integer.valueOf(request.getParameter("tiebaId"));
		Tieba tieba = iTiebaService.getTiebaById(tiebaId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tieba", tieba);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	            return (clazz == Set.class);
	        }
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    .serializeNulls()
	    .create();
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(map));
		System.out.println(gson.toJson(map));
		return null;
	}
}
















