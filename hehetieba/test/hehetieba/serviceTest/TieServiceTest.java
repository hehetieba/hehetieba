package hehetieba.serviceTest;

import hehetieba.basic.Pager;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.domain.User;
import hehetieba.service.ITieService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TieServiceTest extends SpringInit {
	@Test
	public void testPost() {
		ITieService iTieService = (ITieService)context.getBean("tieService");
		Integer tieTitleId = 1;
		Integer sendUserId = 2;
		Integer beSendUserId = 1;
		String body = "中文";
		Tie tie = iTieService.post(tieTitleId, sendUserId, beSendUserId, body);
//		tie.getTieTitle().setUser(null);
		//输出 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tie", tie);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	        	if(clazz==User.class || clazz==TieTitle.class || clazz == Set.class)
	        		return true;
	            return false;
	        }
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
	public void listInTiePage() {
		ITieService iTieService = (ITieService)context.getBean("tieService");
		Integer tieTitleId = 1;
		Integer index = 1;
		Integer size = 10;
		String body = "中文";
		Pager<Tie> pager = iTieService.listInTiePage(tieTitleId, index, size);
//		tie.getTieTitle().setUser(null);
		//输出 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	        	if( clazz==TieTitle.class || clazz == Set.class)
	        		return true;
	            return false;
	        }
	        public boolean shouldSkipField(FieldAttributes f) {
	        	if(f.getName().equals("beSendUser"))
	        		return true;
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
	
	
}






















