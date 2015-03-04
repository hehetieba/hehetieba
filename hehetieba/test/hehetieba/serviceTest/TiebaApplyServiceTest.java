package hehetieba.serviceTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import hehetieba.basic.Pager;
import hehetieba.domain.Reply;
import hehetieba.domain.Tie;
import hehetieba.domain.TieTitle;
import hehetieba.domain.User;
import hehetieba.service.IReplyService;
import hehetieba.service.ITiebaApplyService;

import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TiebaApplyServiceTest extends SpringInit {
	@Test
	public void testSaveTiebaApply() {
		ITiebaApplyService iTiebaApplyService = (ITiebaApplyService)context.getBean("tiebaApplyService");
		String tiebaName = "007";
		boolean flag = iTiebaApplyService.saveTiebaApply(tiebaName);
		System.out.println(flag);
		if(flag==true)
			System.out.println("已经申请");
		else
			System.out.println("该贴吧不能被申请");
	}
	
	@Test
	public void testListInTiePage() {
		IReplyService iReplyService = (IReplyService)context.getBean("replyService");
		Integer tieId = 2;
		Integer index = 1;
		Integer size = 10;
		Pager<Reply> pager = iReplyService.listInTiePage(tieId, index, size);
//		tie.getTieTitle().setUser(null);
		//输出 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	        	if(clazz==TieTitle.class || clazz == Tie.class || clazz == Set.class)
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






















