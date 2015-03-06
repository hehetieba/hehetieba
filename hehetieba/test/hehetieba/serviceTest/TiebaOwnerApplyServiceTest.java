package hehetieba.serviceTest;

import hehetieba.basic.Pager;
import hehetieba.domain.TiebaOwnerApply;
import hehetieba.service.ITiebaApplyService;
import hehetieba.service.ITiebaOwnerApplyService;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TiebaOwnerApplyServiceTest extends SpringInit {
	@Test
	public void testApplyTiebaOwner() {
		ITiebaOwnerApplyService iTiebaOwnerApplyService = (ITiebaOwnerApplyService)context.getBean("tiebaOwnerApplyService");
		Integer userId = 1;
		Integer tiebaId = 1;
		String username = "zhangsan";
		String tiebaName = "hehe";
		Integer result = iTiebaOwnerApplyService.applyTiebaOwner(userId, tiebaId, username, tiebaName);
		System.out.println(result);
		Map<String, String> map = new HashMap<String,String>();
		if(result==0)
			map.put("message", "请先关注该贴吧");
		else if(result==1)
			map.put("message", "你已经提交过申请了，请耐心等待管理员处理");
		else
			map.put("message", "已经成功提交申请，请耐心等待管理员处理");
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testListAll() {
		ITiebaOwnerApplyService iTiebaOwnerApplyService = (ITiebaOwnerApplyService)context.getBean("tiebaOwnerApplyService");
		Integer index = 1;
		Integer size = 10;
		Pager<TiebaOwnerApply> pager = iTiebaOwnerApplyService.listAll(index, size);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("pager",pager);
		Gson gson = new GsonBuilder()
		.setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testListHandled() {
		ITiebaOwnerApplyService iTiebaOwnerApplyService = (ITiebaOwnerApplyService)context.getBean("tiebaOwnerApplyService");
		Integer index = 1;
		Integer size = 10;
		Pager<TiebaOwnerApply> pager = iTiebaOwnerApplyService.listHandled(index, size);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("pager",pager);
		Gson gson = new GsonBuilder()
		.setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testListUnhandled() {
		ITiebaOwnerApplyService iTiebaOwnerApplyService = (ITiebaOwnerApplyService)context.getBean("tiebaOwnerApplyService");
		Integer index = 1;
		Integer size = 10;
		Pager<TiebaOwnerApply> pager = iTiebaOwnerApplyService.listUnhandled(index, size);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("pager",pager);
		Gson gson = new GsonBuilder()
		.setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
	    .create();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testAgree() {
		ITiebaOwnerApplyService iTiebaOwnerApplyService = (ITiebaOwnerApplyService)context.getBean("tiebaOwnerApplyService");
		Integer tiebaOwnerApplyId = 1;
		Integer userId = 1;
		Integer tiebaId = 1;
		String tiebaName = "hehe";
		iTiebaOwnerApplyService.agree(tiebaOwnerApplyId, userId, tiebaId, tiebaName);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("message","已经同意该用户为吧主");
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
	@Test
	public void testDisAgree() {
		ITiebaOwnerApplyService iTiebaOwnerApplyService = (ITiebaOwnerApplyService)context.getBean("tiebaOwnerApplyService");
		Integer tiebaOwnerApplyId = 1;
		Integer userId = 1;
		Integer tiebaId = 1;
		String tiebaName = "hehe";
		iTiebaOwnerApplyService.disAgree(tiebaOwnerApplyId, userId, tiebaId, tiebaName);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("message","已经拒绝该用户为吧主");
		Gson gson = new Gson();
		System.out.println(gson.toJson(map));
	}
	
}






















