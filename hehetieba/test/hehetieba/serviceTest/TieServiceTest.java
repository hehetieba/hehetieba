package hehetieba.serviceTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hehetieba.basic.Pager;
import hehetieba.domain.Reply;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.domain.Tieba;
import hehetieba.domain.User;
import hehetieba.domain.UserTieba;
import hehetieba.dto.TiebaDto;
import hehetieba.service.ITieService;
import hehetieba.service.ITiebaService;

import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TieServiceTest extends SpringInit {
	@Test
	public void testpost() {
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
	        	if(clazz==TieTitle.class || clazz == Set.class)
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
	
}






















