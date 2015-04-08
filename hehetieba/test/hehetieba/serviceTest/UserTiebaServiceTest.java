package hehetieba.serviceTest;

import hehetieba.domain.User;
import hehetieba.domain.UserTieba;
import hehetieba.service.IUserTiebaService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserTiebaServiceTest extends SpringInit {
	
	@Test
	public void testCheckFocus() {
		IUserTiebaService iUserTiebaService = (IUserTiebaService)context.getBean("userTiebaService");
		Integer userId = 1;
		Integer tiebaId = 1; 
		boolean flag = iUserTiebaService.checkFocused(userId, tiebaId);
//		System.out.println(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		/*Gson gson = new GsonBuilder()
		.setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	        	if(clazz == Set.class)
	        		return true;
	            return false;
	        }
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    .serializeNulls()
	    .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();*/
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testCheckBaZhu() {
		IUserTiebaService iUserTiebaService = (IUserTiebaService)context.getBean("userTiebaService");
		Integer userId = 1;
		Integer tiebaId = 1; 
		boolean flag = iUserTiebaService.checkBaZhu(userId, tiebaId);
//		System.out.println(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", flag);
		/*Gson gson = new GsonBuilder()
		.setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	        	if(clazz == Set.class)
	        		return true;
	            return false;
	        }
	        public boolean shouldSkipField(FieldAttributes f) {
	            return false;
	        }

	     })
	    .serializeNulls()
	    .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();*/
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
}













