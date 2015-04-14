package hehetieba.serviceTest;

import hehetieba.basic.Pager;
import hehetieba.domain.TieTitle;
import hehetieba.domain.Tieba;
import hehetieba.domain.User;
import hehetieba.service.ITieTitleService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TieTitleServiceTest extends SpringInit {
	@Test
	public void testListInTiebaPage() {
		ITieTitleService iTieTitleService = (ITieTitleService)context.getBean("tieTitleService");
		Integer index = 1;
		Integer size = 10;
		Integer tiebaId = 1;
		Pager<TieTitle> pager = iTieTitleService.listInTiebaPage(index, size,tiebaId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	        	if(clazz==Tieba.class || clazz == Set.class)
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
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testFaTie() {
		ITieTitleService iTieTitleService = (ITieTitleService)context.getBean("tieTitleService");
		Integer userId = 1;
		Integer tiebaId = 1;
		String title = "title...";
		String body = "body...";
		
		iTieTitleService.faTie(userId, tiebaId, title, body);
	}
	
	@Test
	public void testListJingPin() {
		ITieTitleService iTieTitleService = (ITieTitleService)context.getBean("tieTitleService");
		Integer index = 1;
		Integer size = 10;
		Integer tiebaId = 1;
		Pager<TieTitle> pager = iTieTitleService.listJingPin(index, size, tiebaId);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	        	if(clazz==Tieba.class || clazz == Set.class)
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
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testGetTieTitleById() {
		ITieTitleService iTieTitleService = (ITieTitleService)context.getBean("tieTitleService");
		Integer tieTitleId = 1;
		TieTitle tieTitle = iTieTitleService.getTieTitleById(tieTitleId);
		String title = tieTitle.getTitle();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", title);
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testSetTop() {
		ITieTitleService iTieTitleService = (ITieTitleService)context.getBean("tieTitleService");
		Integer id = 1;
		iTieTitleService.setTop(id);

		System.out.println("已顶置");
	}
	
	@Test
	public void testJiajing() {
		ITieTitleService iTieTitleService = (ITieTitleService)context.getBean("tieTitleService");
		Integer id = 1;
		iTieTitleService.jiajing(id);

		System.out.println("已加精华");
	}
	
	@Test
	public void testDeleteByTieTitleId() {
		ITieTitleService iTieTitleService = (ITieTitleService)context.getBean("tieTitleService");
		Integer tieTitleId = 2;
		iTieTitleService.deleteByTieTitleId(tieTitleId);

		System.out.println("执行完毕");
	}
	
	@Test
	public void testFindUserTieTitle() {
		ITieTitleService iTieTitleService = (ITieTitleService)context.getBean("tieTitleService");
		Integer userId = 1;
		Integer index = 1;
		Integer size = 11;
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
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testSearchByTitle() {
		ITieTitleService iTieTitleService = (ITieTitleService)context.getBean("tieTitleService");
		String title = "title";
		Integer index = 1;
		Integer size = 11;
		Pager<TieTitle> pager = iTieTitleService.searchByTitle(title, index, size);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
		.serializeNulls()
		.setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
		.create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testFindAll() {
		ITieTitleService iTieTitleService = (ITieTitleService)context.getBean("tieTitleService");
		Integer index = 1;
		Integer size = 11;
		Pager<TieTitle> pager = iTieTitleService.findAll(index, size);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
		.serializeNulls()
		.setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
		.create();
		System.out.println(gson.toJson(map));
	}
	
}
















