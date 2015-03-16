package hehetieba.serviceTest;

import hehetieba.basic.Pager;
import hehetieba.domain.TieTitle;
import hehetieba.domain.Tieba;
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
}
