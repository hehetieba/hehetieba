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
import hehetieba.service.IReplyService;
import hehetieba.service.ITieService;
import hehetieba.service.ITiebaService;

import org.junit.Test;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReplyServiceTest extends SpringInit {
	@Test
	public void testReply() {
		IReplyService iReplyService = (IReplyService)context.getBean("replyService");
		Integer tieTitleId = 1;
		Integer tieId = 2;
		Integer sendUserId = 2;
		Integer beSendUserId = 1;
		String body = "reply222";
		Reply reply = iReplyService.reply(tieTitleId, tieId, sendUserId, beSendUserId, body);
//		tie.getTieTitle().setUser(null);
		//输出 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reply", reply);
		Gson gson = new GsonBuilder()
	    .setExclusionStrategies(new ExclusionStrategy() {
	        public boolean shouldSkipClass(Class<?> clazz) {
	        	if(clazz==User.class || clazz==TieTitle.class || clazz == Tie.class)
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
	
	@Test
	public void testFindMyReply() {
		IReplyService iReplyService = (IReplyService)context.getBean("replyService");
		Integer sendUserId = 1;
		Integer index = 1;
		Integer size = 10;
		Pager<Reply> pager = iReplyService.findMyReply(sendUserId, index, size);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
		.setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
//		.serializeNulls()
	    .create();
		System.out.println(gson.toJson(map));
	}

	@Test
	public void testFindOtherSendToMeReply() {
		IReplyService iReplyService = (IReplyService)context.getBean("replyService");
		Integer beSendUserId = 1;
		Integer index = 1;
		Integer size = 20;
		Pager<Reply> pager = iReplyService.findOtherSendToMeReply(beSendUserId, index, size);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pager", pager);
		Gson gson = new GsonBuilder()
		.setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
//		.serializeNulls()
	    .create();
		System.out.println(gson.toJson(map));
	}
	
}






















